import java.util.List;
import java.util.Random;
import java.util.Iterator;

/**
 * A class representing shared characteristics of animals.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2016.02.29 (2)
 */
public abstract class Animal extends Entity
{
    protected int foodLevel;
    private int gender;
    private Random rand = new Random();
    private Disease disease;
    private static final double PROBABILITY_OF_INFECTION_RANDOM = 0.0001;
    private static final double PROBABILITY_OF_INFECTION_CONTACT = 0.1;

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
     * This is what the fox does most of the time: it hunts for
     * rabbits. In the process, it might breed, die of hunger,
     * or die of old age.
     * @param field The field currently occupied.
     * @param newFoxes A list to return newly born foxes.
     */
    public void act(List<Actor> newActors, int time)
    {
        incrementHealth();
        actMove(newActors);
    }

    protected void incrementHealth()
    {
        incrementAge();
        incrementHunger();
        getDiseaseFinished();
    }

    protected void actMove(List<Actor> newActors)
    {
        if(isAlive()) {
                giveBirth(newActors);

                randomDisease(newActors);
                spreadDisease(newActors);
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


    abstract protected Location findFood();

    protected void randomDisease(List<Actor> newActors)
    {
        if(!getDiseased()) {
            if (rand.nextDouble() <= PROBABILITY_OF_INFECTION_RANDOM ) {
                disease = new Disease();
                newActors.add(disease);
                //System.out.println("random disease");
            }
        }
    }

    protected boolean getDiseased()
    {
        if(disease!=null)
        {
            //System.out.println("Animal diseased");
            return true;
        }
        else {
            return false;
        }
    }

    protected void spreadDisease(List<Actor> newActors)
    {
        if(getDiseased()) {
            Field field = getField();
            List<Location> adjacent = field.adjacentLocations(getLocation());
            Iterator<Location> it = adjacent.iterator();
            while(it.hasNext()) {
                Location where = it.next();
                Object animal = field.getObjectAt(where);
                Animal nextAnimal = (Animal) animal;
                if(nextAnimal!=null && this.getClass().equals(nextAnimal.getClass())) {
                    if (rand.nextDouble() <= PROBABILITY_OF_INFECTION_CONTACT ) {
                        nextAnimal.giveDisease(newActors);
                    }
                }
            }
        }
    }

    protected void giveDisease(List<Actor> newActors)
    {
        this.disease = new Disease();
        newActors.add(disease);
        //System.out.println("disease spread");
    }

    protected abstract int getBREEDING_AGE();

    protected abstract double getBREEDING_PROBABILITY();
    protected abstract int getMAX_LITTER_SIZE();


    protected abstract Animal getNewAnimal(boolean randomAge, Field field, Location location);

    /**
     * Check whether or not this fox is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newFoxes A list to return newly born foxes.
     */
    protected void giveBirth(List<Actor> newAnimals)
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

    protected void addFoodValue(int foodValue)
    {
        foodLevel += foodValue;
    }

    protected void getDiseaseFinished()
    {
        if(getDiseased())
        {
            if(disease.getDiseaseFinished())
            {
                setDead();
                System.out.println("Disease dead");
                disease.setDead();
            }
        }
    }
}
