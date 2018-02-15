import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * Abstract class Prey - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Prey extends Animal
{
    private static final int INITIAL_HUNGER_VALUE = 7;
    private static final Random rand = Randomizer.getRandom();


    /**
     *
     */
    public Prey (Field field, Location location){
        super(field, location);
        foodLevel = rand.nextInt( INITIAL_HUNGER_VALUE );



    }

    /**
     * This is what the rabbit does most of the time - it runs
     * around. Sometimes it will breed or die of old age.
     * @param newRabbits A list to return newly born rabbits.
     */
    public void act(List<Actor> newPrey, int time)
    {
        incrementAge();
        incrementHunger();
        randomDisease();
        if(isAlive()) {
            giveBirth(newPrey);
            spreadDisease();
            // Try to move into a free location.
            Location newLocation = findFood();
            if(newLocation == null) {
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(getLocation());
            }

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
 * Look for rabbits adjacent to the current location.
 * Only the first live rabbit is eaten.
 * @return Where food was found, or null if it wasn't.
 */
protected Location findFood()
{
    Field field = getField();
    Object object = field.getPlantAt(getLocation());
        if(object instanceof Plant)
        {
            Plant plant = (Plant) object;
            if(plant.isAlive()) {
               plant.setDead();
               addFoodValue(plant.getFOOD_VALUE());
               return getLocation();
            }
        }
    return null;
}


    protected abstract int getFOOD_VALUE();
}
