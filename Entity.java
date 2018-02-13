
/**
 * Abstract class Entity - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Entity
{
    // Whether the animal is alive or not.
    private boolean alive;
    // Whether the animal is alive or not.
    protected int age;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;
    
    public Entity(Field field, Location location)
    {
        alive = true;
        this.field = field;
        setLocation(location);
    }
    
    protected int getAge()
    {
        return age;
    }

    
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
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
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
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    
    protected abstract int getMAX_AGE();
    
}
