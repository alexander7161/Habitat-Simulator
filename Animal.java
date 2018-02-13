import java.util.List;
import java.util.Random;
import java.util.Iterator;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
public abstract class Animal extends Entity
{
    
    private int gender;
    private Random rand = new Random();
    
    /**
     * Create a new animal at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Animal(Field field, Location location)
    {
        super(field, location);
        gender = rand.nextInt(2);
        
    }
    

    /**
     * Make this animal act - that is: make it do
     * whatever it wants/needs to do.
     * @param newAnimals A list to receive newly born animals.
     */
    abstract public void act(List<Animal> newAnimals,int time);

    
    protected boolean canBreedAge()
    {
        return getAge() >= getBREEDING_AGE();
    }
    
    protected abstract int getBREEDING_AGE();
    
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
    protected abstract double getBREEDING_PROBABILITY();
    protected abstract int getMAX_LITTER_SIZE();

    
    protected abstract Animal getNewAnimal(boolean randomAge, Field field, Location location);
    
    /**
     * Check whether or not this fox is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newFoxes A list to return newly born foxes.
     */
    protected void giveBirth(List<Entity> newAnimals)
    {
        // New foxes are born into adjacent locations.
        // Get a list of adjacent free locations.
        
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            Animal nextAnimal = (Animal) animal;
            if(nextAnimal!=null && this.getClass().equals(nextAnimal.getClass())) {
            
            if((this.getMale() && !nextAnimal.getMale()) || (!this.getMale() && nextAnimal.getMale()))
            {
                List<Location> free = field.getFreeAdjacentLocations(getLocation());
                int births = breed();
            for(int b = 0; b < births && free.size() > 0; b++) {
                Location loc = free.remove(0);
                Animal young = getNewAnimal(false, field, loc);
                newAnimals.add(young);
            }
            }
        }
        }
        
    }
    
    private boolean getMale()
    {
        if(gender==1)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
