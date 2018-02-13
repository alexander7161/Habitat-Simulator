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
    public void act(List<Entity> newPrey, int time)
    {
        incrementAge();
        incrementHunger();
        if(isAlive()) {
            giveBirth(newPrey);
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
    List<Location> adjacent = field.adjacentLocations(getLocation());
    Iterator<Location> it = adjacent.iterator();
    while(it.hasNext()) {
        Location where = it.next();
        Object plant = field.getPlantAt(where);
        if(plant instanceof Plant)
        {
            Plant plant = (Plant) plant;
            if(plant.isAlive()) {
               plant.setDead();
               foodLevel += plant.getFOOD_VALUE();
               return where;
            }
        }
    }
    return null;
}


    protected abstract int getFOOD_VALUE();
}
