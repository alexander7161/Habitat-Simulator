import java.util.List;
/**
 * Write a description of class Disease here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Disease extends Actor
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

    public void act(List<Actor> newActors, int time)
    {
        counter++;
    }

    public boolean getDiseaseFinished()
    {
        if(counter >= STEPS_BEFORE_DEATH)
        {
            System.out.println("disease done");
            return true;
        }
        else {
            return false;
        }
    }
}
