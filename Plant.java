
/**
 * Write a description of class Plant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Plant extends Entity
{
    private static final int MAX_AGE = 10;

    /**
     * Constructor for objects of class Plant
     */
    public Plant(Field field, Location location)
    {
        super(field, location);
    }
    
    protected int getMAX_AGE()
    {
        return MAX_AGE;
    }

}
