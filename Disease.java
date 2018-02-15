import java.util.List;
/**
 * Write a description of class Disease here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Disease
{
    // instance variables - replace the example below with your own
    private boolean disease;
    private static final double PROBABILITY_OF_INFECTION = 0.2;

    /**
     * Constructor for objects of class Disease
     */
    public Disease()
    {
        // initialise instance variables
        
    }
    
    public void setDiseased()
    {
        disease = true;
    }
    
    public boolean isDiseased()
    {
        return disease;
    }
}
