import java.util.List;
/**
 * Write a description of class Disease here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Disease extends Actor
{
    // instance variables - replace the example below with your own
    private boolean alive;
    private static final int STEPS_BEFORE_DEATH = 4;
    private static final double PROBABILITY_OF_INFECTION = 0.2;
    private int counter;

    /**
     * Constructor for objects of class Disease
     */
    public Disease()
    {
        // initialise instance variables
        
    }
    
    public void act(List<Actor> newActors, int time)
    {
        counter++;
    }
    
    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }
    
    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
    }
    
    public boolean getDiseaseFinished()
    {
        if(counter >= STEPS_BEFORE_DEATH)
        {
            return true;
        }
        else {
            return false;
        }
    }
    
    

    public double getProbability()
    {
        return PROBABILITY_OF_INFECTION;
    }
}
