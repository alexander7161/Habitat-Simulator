import java.util.List;
/**
 * Write a description of class Disease here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Disease
{
    private static final int STEPS_BEFORE_DEATH = 4;
    private int counter;

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
}
