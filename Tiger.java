import java.util.List;
import java.util.Iterator;
import java.util.Random;
/**
 * Write a description of class Tiger here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tiger extends Predator
{
    // Characteristics shared by all Tigers (class variables).
    
    // The age at which a Tiger can start to breed.
    private static final int BREEDING_AGE = 15;
    // The age to which a Tiger can live.
    private static final int MAX_AGE = 150;
    // The likelihood of a Tiger breeding.
    private static final double BREEDING_PROBABILITY = 0.3;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 2;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a Tiger can go before it has to eat again.
    private static final int INITIAL_HUNGER_VALUE = 9;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();
    


    /**
     * Create a Tiger. A Tiger can be created as a new born (age zero
     * and not hungry) or with a random age and food level.
     * 
     * @param randomAge If true, the Tiger will have random age and hunger level.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Tiger(boolean randomAge, Field field, Location location)
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
    
    
    protected int getMAX_LITTER_SIZE()
    {
        return MAX_LITTER_SIZE;
    }
    
    protected double getBREEDING_PROBABILITY()
    {
        return BREEDING_PROBABILITY;
    }
    
    protected Animal getNewAnimal(boolean randomAge, Field field, Location loc)
    {
        Animal young;
        return young = new Tiger(false, field, loc);
    }
    
    protected boolean nightTimeSleep(int time)
    { 
        if( (0 <= time) && (time <= 6)) {
            return true;
        }
        else {
            return false;
        }
    }

}
