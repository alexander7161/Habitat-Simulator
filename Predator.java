import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * Abstract class Predator - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Predator extends Animal
{
    // instance variables - replace the example below with your own
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();

    /**
     * 
     */
    public Predator (Field field, Location location){
        super(field, location);
        
    }
    
    protected boolean getFood(Field field, Location where)
    {
        Object animal = field.getObjectAt(where);
        if(animal instanceof Prey)
            {
                Prey prey = (Prey) animal;
                if(prey.isAlive()) { 
                   prey.setDead();
                   addFoodValue(prey.getFOOD_VALUE());
                   return true;
                }
            }
                
        return false;

    }
    
        


    
}
