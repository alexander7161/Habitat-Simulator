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
    
    protected abstract boolean isAlive();


  /**
* Make this animal act - that is: make it do
* whatever it wants/needs to do.
* @param newAnimals A list to receive newly born animals.
*/
abstract public void act(List<Entity> newEntities, int time);




}
