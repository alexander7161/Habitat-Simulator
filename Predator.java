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

    protected Edible getEdible(Object animal)
    {
      Edible prey = null;
      if(animal instanceof Prey)
          {
              prey = (Prey) animal;
          }
          return prey;
    }





}
