import java.util.List;
import java.util.Iterator;
import java.util.Random;

/**
 * Abstract class Prey - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Prey extends Animal implements Edible
{
    private static final int INITIAL_HUNGER_VALUE = 6;
    private static final Random rand = Randomizer.getRandom();


    /**
     *
     */
    public Prey (Field field, Location location){
        super(field, location);
        foodLevel = rand.nextInt( INITIAL_HUNGER_VALUE );



    }
    

    protected Edible getEdible(Field field, Location where)
    {
      Object animal = field.getPlantAt(where);
      Edible plant = null;
      if(animal instanceof Plant)
          {
              plant = (Plant) animal;
          }
          return plant;
    }


    public abstract int getFOOD_VALUE();
}
