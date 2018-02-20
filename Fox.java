import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * A simple model of a fox.
 * Foxes age, move, eat rabbits, and die.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
public class Fox extends Predator
{
    // Characteristics shared by all foxes (class variables).

    // The age at which a fox can start to breed.
    private static final int BREEDING_AGE = 15;
    // The age to which a fox can live.
    private static final int MAX_AGE = 150;
    // The likelihood of a fox breeding.
    private static final double BREEDING_PROBABILITY = 0.4;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    private static final int INITIAL_HUNGER_VALUE = 13;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();


    /**
     * Create a fox. A fox can be created as a new born (age zero
     * and not hungry) or with a random age and food level.
     *
     * @param randomAge If true, the fox will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Fox(boolean randomAge, Field field, Location location)
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

    protected int getMAX_AGE()
    {
        return MAX_AGE;
    }

    protected int getBREEDING_AGE()
    {
        return BREEDING_AGE;
    }

    protected Animal getNewAnimal(boolean randomAge, Field field, Location loc)
    {
        Animal young;
        return young = new Fox(false, field, loc);
    }


    protected int getMAX_LITTER_SIZE()
    {
        return MAX_LITTER_SIZE;
    }

    protected double getBREEDING_PROBABILITY()
    {
        return BREEDING_PROBABILITY;
    }
    
    protected Edible getEdible(Field field, Location where)
    {
      Object animal = field.getObjectAt(where);
      Edible prey = null;
      if(animal instanceof Rabbit)
          {
              prey = (Rabbit) animal;
          }
          return prey;
    }
    
    protected boolean isFogImmune()
    {
        if(Simulator.getWeather().getFog())
        {
            return false;
        }
        else
        {
            return true;
        }
    }


}
