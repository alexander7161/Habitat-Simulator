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
       * Look for rabbits adjacent to the current location.
         * Only the first live rabbit is eaten.
           * @return Where food was found, or null if it wasn't.
             */
            protected boolean getFood(Field field, Location where)
            {
            Object object = field.getPlantAt(where);
                if(object instanceof Plant)
            {
                Plant plant = (Plant) object;
                if(plant.isAlive()) { 
                   plant.setDead();
                   addFoodValue(plant.getFOOD_VALUE());
                   return true;
                }
            }
            return false;
}


    protected abstract int getFOOD_VALUE();
}
