import java.util.List;
import java.util.Random;
import java.util.Iterator;

/**
 * Abstract class Actor - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Actor
{
    // Whether the animal is alive or not.
    private boolean alive;
    
    public Actor()
    {
        alive = true;
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


  /**
* Make this animal act - that is: make it do
* whatever it wants/needs to do.
* @param newAnimals A list to receive newly born animals.
*/
abstract public void act(List<Actor> newActors);




}
