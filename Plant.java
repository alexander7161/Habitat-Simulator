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
    private static final int MAX_AGE = 5;
    private static final Random rand = Randomizer.getRandom();
    private static final int BREEDING_AGE = 0;

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
        if(Simulator.getWeather().toLowerCase().contains("Rain")) {
            incrementAge();
        }
    }
    
    protected void setDead()
    {
        age = 0;
    }
    
    



    protected int getMAX_AGE()
    {
        return MAX_AGE;
    }
    protected int getBREEDING_AGE()
    {
        return BREEDING_AGE;
    }
    public int getFOOD_VALUE()
    {
    return age;
    }
    

}
