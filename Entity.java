import java.util.List;
import java.util.Random;
import java.util.Iterator;

/**
 * Abstract class Entity - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Entity extends Actor
{
    
    // Whether the animal is alive or not.
    protected int age;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;

    private Random rand = new Random();

    public Entity(Field field, Location location)
    {
        
        this.field = field;
        setLocation(location);
    }
    
    

    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    protected int breed()
    {
        int births = 0;
        if(canBreedAge() && rand.nextDouble() <= getBREEDING_PROBABILITY()) {
            births = rand.nextInt(getMAX_LITTER_SIZE()) + 1;
        }
        return births;
    }

    protected boolean canBreedAge()
    {
        return age >= getBREEDING_AGE();
    }

    protected abstract double getBREEDING_PROBABILITY();
    protected abstract int getBREEDING_AGE();
    protected abstract int getMAX_LITTER_SIZE();

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }

    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

     /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }

    

       /**
     * Increase the age.
     * This could result in the rabbit's death.
     */
    protected void incrementAge()
    {
        age++;
        if(age > getMAX_AGE()) {
            setDead();
        }
    }
    
    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        super.setDead();
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    

    protected abstract int getMAX_AGE();

}
