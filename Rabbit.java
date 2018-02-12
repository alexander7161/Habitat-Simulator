import java.util.List;
import java.util.Random;

/**
 * A simple model of a rabbit.
 * Rabbits age, move, breed, and die.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
public class Rabbit extends Prey
{
    // Characteristics shared by all rabbits (class variables).

    // The age at which a rabbit can start to breed.
    private static final int BREEDING_AGE = 5;
    // The age to which a rabbit can live.
    private static final int MAX_AGE = 40;
    // The likelihood of a rabbit breeding.
    private static final double BREEDING_PROBABILITY = 0.7;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    
    private static final int FOOD_VALUE = 9;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    

    /**
     * Create a new rabbit. A rabbit may be created with age
     * zero (a new born) or with a random age.
     * 
     * @param randomAge If true, the rabbit will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Rabbit(boolean randomAge, Field field, Location location)
    {
        super(field, location);
        age = 0;
        if(randomAge) {
            age = rand.nextInt(MAX_AGE);
        }
    }
    
    protected int getMAX_AGE()
    {
        return MAX_AGE;
    }
    
    protected double getBREEDING_PROBABILITY()
    {
        return BREEDING_PROBABILITY;
    }
    
    protected int getMAX_LITTER_SIZE()
    {
        return MAX_LITTER_SIZE;
    }


    protected Animal getNewAnimal(boolean randomAge, Field field, Location loc)
    {
        Animal young;
        return young = new Rabbit(false, field, loc);
    }        
    

    protected int getBREEDING_AGE()
    {
        return BREEDING_AGE;
    }
    
        protected int getFOOD_VALUE()
    {
        return FOOD_VALUE;
    }
}
