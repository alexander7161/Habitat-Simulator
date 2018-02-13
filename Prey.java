import java.util.List;
/**
 * Abstract class Prey - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Prey extends Animal 
{

    /**
     * 
     */
    public Prey (Field field, Location location){
        super(field, location);
        
    }
    
    /**
     * This is what the rabbit does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     * @param newRabbits A list to return newly born rabbits.
     */
    public void act(List<Entity> newPrey)
    {
        incrementAge();
        if(isAlive()) {
            giveBirth(newPrey);            
            // Try to move into a free location.
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }
    
    protected abstract int getFOOD_VALUE();
}
