import java.util.List;
import java.util.Random;

/**
 * A simple model of a rabbit.
 * Rabbits age, move, breed, eat plants and die.
 *
 * @author Alexander Davis and Ans Mohamed�.
 * @version 20.2.2018
 */
public class Rabbit extends Prey
{
    // Characteristics shared by all rabbits (class variables).

    // The age at which a rabbit can start to breed.
    private static final int BREEDING_AGE = 3;
    // The age to which a rabbit can live.
    private static final int MAX_AGE = 40;
    // The likelihood of a rabbit breeding.
    private static final double BREEDING_PROBABILITY = 0.98;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    // This is the number of steps a rabbit can go before it has to eat initially.
    private static final int INITIAL_HUNGER_VALUE = 8;
    // Nutritional value when eaten.
    private static final int FOOD_VALUE = 2;
    // This is the food level which a rabbit cannnot eat after because it's full.
    private static final int MAX_FOOD_LEVEL = 16;
    
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();


    /**
     * Create a rabbit. A rabbit can be created as a new born (age zero
     * and not hungry) or with a random age and food level.
     *
     * @param randomAge If true, the rabbit will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.F
     */
    public Rabbit(boolean randomAge, Field field, Location location)
    {
        super(field, location);
        if(randomAge) {
            age = rand.nextInt(MAX_AGE);
            foodLevel = rand.nextInt( INITIAL_HUNGER_VALUE );
        }
        else {
            age = 0;
            foodLevel =  INITIAL_HUNGER_VALUE ;
        }
    }
    
    /**
     * Creates a new rabbit object.
     * @param randomAge If true, the rabbit will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     * @return animal of type rabbit.
     */
    protected Animal getNewAnimal(boolean randomAge, Field field, Location loc)
    {
        Animal young;
        return young = new Rabbit(false, field, loc);
    }

    protected int getMAX_AGE()
    {
        return MAX_AGE;
    }

    protected double getBREEDING_PROBABILITY()
    {
        return BREEDING_PROBABILITY;
    }
    
    /**
     * @return maximum food level.
     */
    protected int getMAX_FOOD_LEVEL()
    {
        return MAX_FOOD_LEVEL;
    }

    protected int getMAX_LITTER_SIZE()
    {
        return MAX_LITTER_SIZE;
    }

    protected int getBREEDING_AGE()
    {
        return BREEDING_AGE;
    }

    public int getFOOD_VALUE()
    {
        return FOOD_VALUE;
    }
}
