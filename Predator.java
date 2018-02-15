import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * Abstract class Predator - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Predator extends Animal
{
    // instance variables - replace the example below with your own
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();

    /**
     * 
     */
    public Predator (Field field, Location location){
        super(field, location);
        
    }
    
    
    
        /**
     * Look for rabbits adjacent to the current location.
     * Only the first live rabbit is eaten.
     * @return Where food was found, or null if it wasn't.
     */
    protected Location findFood()
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Prey)
            {
                Prey prey = (Prey) animal;
                if(prey.isAlive()) { 
                   prey.setDead();
                   addFoodValue(prey.getFOOD_VALUE());
                   return where;
                }
            }
        }
        return null;
    }


    
}
