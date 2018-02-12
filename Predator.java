import java.util.List;
/**
 * Abstract class Predator - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Predator extends Animal
{
    // instance variables - replace the example below with your own
    protected int foodLevel;

    /**
     * 
     */
    public Predator (Field field, Location location){
        super(field, location);
        
    }
    
        /**
     * This is what the fox does most of the time: it hunts for
     * rabbits. In the process, it might breed, die of hunger,
     * or die of old age.
     * @param field The field currently occupied.
     * @param newFoxes A list to return newly born foxes.
     */
    public void act(List<Animal> newFoxes)
    {
        incrementAge();
        incrementHunger();
        if(isAlive()) {
            giveBirth(newFoxes);            
            // Move towards a source of food if found.
            Location newLocation = findFood();
            if(newLocation == null) { 
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }

    /**
     * Make this fox more hungry. This could result in the fox's death.
     */
    protected void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }
    
    protected abstract void giveBirth(List<Animal> newFoxes);
    protected abstract Location findFood();
    
    
    
}
