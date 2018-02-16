import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * Abstract class Prey - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Prey extends Animal
{
    private static final int INITIAL_HUNGER_VALUE = 7;
    private static final Random rand = Randomizer.getRandom();


    /**
     *
     */
    public Prey (Field field, Location location){
        super(field, location);
        foodLevel = rand.nextInt( INITIAL_HUNGER_VALUE );



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
            Object newObject = field.getPlantAt(where);
            if(newObject instanceof Plant)
            {
                Plant plant = (Plant) newObject;
                if(plant.isAlive()) { 
                   //System.out.println("Plant eaten");
                   plant.setDead();
                   addFoodValue(plant.getFOOD_VALUE());
                   return getLocation();
                }
            }
        }
        return null;
}


    protected abstract int getFOOD_VALUE();
}
