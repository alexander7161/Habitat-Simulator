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
    protected int foodLevel;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();

    /**
     * 
     */
    public Predator (Field field, Location location){
        super(field, location);
        
    }
    
    /**
     * This is what the fox does most of the time: it hunts for
     * rabbits. In the process, it might breed, die of hunger,
     * or die of old age.
     * @param field The field currently occupied.
     * @param newFoxes A list to return newly born foxes.
     */
<<<<<<< HEAD
    public void act(List<Animal> newPredators, int time)
=======
    public void act(List<Entity> newPredators)
>>>>>>> Alex
    {
        incrementAge();
        incrementHunger();
        if(checkTime(time))
        {
            return;
        }
        if(isAlive()) {
            giveBirth(newPredators);            
            // Move towards a source of food if found.
            Location newLocation = findFood();
            if(newLocation == null) { 
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }
    
    protected boolean checkTime(int time)
    { 
        return false;
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
                   foodLevel += prey.getFOOD_VALUE();
                   return where;
                }
            }
        }
        return null;
    }

    /**
     * Make this fox more hungry. This could result in the fox's death.
     */
    protected void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }

    
}
