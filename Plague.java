
/**
 * Write a description of class Plague here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Plague extends Disease
{
    // Constants representing configuration information for plague.
    private static final int STEPS_BEFORE_DEATH = 14;
    private static final double CHANCE_OF_DEATH = 0.9;
    
    protected int getSTEPS_BEFORE_DEATH()
    {
        return STEPS_BEFORE_DEATH;
    }
    
    protected double getCHANCE_OF_DEATH()
    {
        return CHANCE_OF_DEATH;
    }

}
