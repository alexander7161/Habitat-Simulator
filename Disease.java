import java.util.List;
import java.util.Random;
/**
 * Write a description of class Disease here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Disease
{
    private static final int STEPS_BEFORE_DEATH = 8;
    private static final double CHANCE_OF_DEATH = 0.5;
    private int counter;
    private static final Random rand = Randomizer.getRandom();

    /**
     * Constructor for objects of class Disease
     */
    public Disease()
    {
        counter = 0;

    }

    public boolean getDiseaseFinished()
    {
        counter++;
        if(counter >= STEPS_BEFORE_DEATH)
        {
            //System.out.println("disease done");
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean getDiseaseDeath()
    {
        if(rand.nextDouble() <= CHANCE_OF_DEATH)
        {
            return true;
        }
        else {
            //System.out.println("disease survive");
            return false;
        }
    }
}
