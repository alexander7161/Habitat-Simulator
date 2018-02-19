import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * Write a description of class Plant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Plant extends Actor implements Edible
{
    private static final int MAX_AGE = 25;
    private static final Random rand = Randomizer.getRandom();
    private static final int MAX_LITTER_SIZE = 8;
    private static final int BREEDING_AGE = 0;
    private static final double BREEDING_PROBABILITY = 0.9;

    /**
     * Constructor for objects of class Plant
     */
    public Plant(boolean randomAge, Field field, Location location)
    {
        super(field, location);
        age = 0;
        if(randomAge) {
           age = rand.nextInt(MAX_AGE);
        }
    }

        /**
     * This is what the rabbit does most of the time - it runs
     * around. Sometimes it will breed or die of old age.
     * @param newRabbits A list to return newly born rabbits.
     */
    public void act(List<Actor> newActors)
    {
        incrementAge();
        if(isAlive() && Actor.getRaining()) {
            giveBirth(newActors);
        }
    }



    /**
     * Check whether or not this fox is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newFoxes A list to return newly born foxes.
     */
    protected void giveBirth(List<Actor> newAnimals)
    {
        // New foxes are born into adjacent locations.
        // Get a list of adjacent free locations.

        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Actor young = new Plant(false, field, loc);
            newAnimals.add(young);
        }
        }

    protected int getMAX_AGE()
    {
        return MAX_AGE;
    }
    protected int getMAX_LITTER_SIZE()
    {
        return MAX_LITTER_SIZE;
    }
    protected int getBREEDING_AGE()
    {
        return BREEDING_AGE;
    }
    protected double getBREEDING_PROBABILITY()
    {
        return BREEDING_PROBABILITY;
    }
    public int getFOOD_VALUE()
    {
    return age+10;
    }

}
