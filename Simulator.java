import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a rectangular field
 * containing rabbits and foxes.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
public class Simulator
{
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 240;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 160;
    // The probability that a fox will be created in any given grid position.
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    // The probability that a rabbit will be created in any given grid position.
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;
    private static final double TIGER_CREATION_PROBABILITY = 0.02; 
    private static final double SQUIRREL_CREATION_PROBABILITY = 0.08; 
    private static final double MOUSE_CREATION_PROBABILITY = 0.08; 
    private static final double PLANT_CREATION_PROBABILITY = 0.03; 

    // List of entities in the field.
    private List<Entity> entities;
    // The current state of the field.
    private Field field;
    // The current step of the simulation. Each step represents 1 hour.
    private int step;
    //the current time of the day in hours.
    private int time;
    // A graphical view of the simulation.
    private SimulatorView view;
    
    private Weather weather;
    
    
    /**
     * Construct a simulation field with default size.
     */
    public Simulator()
    {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }
    
    /**
     * Create a simulation field with the given size.
     * @param depth Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    public Simulator(int depth, int width)
    {
        if(width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }
        
        entities = new ArrayList<>();
        field = new Field(depth, width);
        
        weather = new Weather();

        // Create a view of the state of each location in the field.
        view = new SimulatorView(depth, width);
        view.setColor(Rabbit.class, Color.ORANGE);
        view.setColor(Fox.class, Color.BLUE);
        view.setColor(Tiger.class, Color.RED);
        view.setColor(Squirrel.class, Color.GREEN);
        view.setColor(Mouse.class, Color.YELLOW);

        // Setup a valid starting point.
        reset();
    }
    
    /**
     * Run the simulation from its current state for a reasonably long period,
     * (4000 steps).
     */
    public void runLongSimulation()
    {
        simulate(4000);
    }
    
    /**
     * Run the simulation from its current state for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     * @param numSteps The number of steps to run for.
     */
    public void simulate(int numSteps)
    {
        for(int step = 1; step <= numSteps && view.isViable(field); incrementStep()) {
            simulateOneStep();
            // delay(60);   // uncomment this to run more slowly
        }
    }
    
    /**
     * Run the simulation from its current state for a single step.
     * Iterate over the whole field updating the state of each
     * fox and rabbit.
     */
    public void simulateOneStep()
    {
        incrementStep();
        weather.updateWeather();

        // Provide space for newborn entities.
        List<Entity> newEntities = new ArrayList<>();        
        // Let all rabbits act.


        for(Iterator<Entity> it = entities.iterator(); it.hasNext(); ) {
            Entity entity = it.next();
            entity.act(newEntities, time);
            if(! entity.isAlive()) {
                it.remove();
            }
        }
               
        // Add the newly born foxes and rabbits to the main lists.
        entities.addAll(newEntities);

        view.showStatus(step,time, field);
    }
        
    /**
     * Reset the simulation to a starting position.
     */
    public void reset()
    {
        step = 0;
        entities.clear();
        populate();
        
        // Show the starting state in the view.
        view.showStatus(step,time, field);
    }
    
    /**
     * Randomly populate the field with foxes and rabbits.
     */
    private void populate()
    {
        Random rand = Randomizer.getRandom();
        field.clear();
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
               
                
                if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Fox fox = new Fox(true, field, location);
                    entities.add(fox);
                }
                else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Rabbit rabbit = new Rabbit(true, field, location);
                    entities.add(rabbit);
                }
                else if(rand.nextDouble() <= TIGER_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Tiger tiger = new Tiger(true, field, location);
                    entities.add(tiger);
                }
                else if(rand.nextDouble() <= SQUIRREL_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Squirrel squirrel = new Squirrel(true, field, location);
                    entities.add(squirrel);
                }
                else if(rand.nextDouble() <= MOUSE_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Mouse mouse = new Mouse(true, field, location);
                    entities.add(mouse);
                }
                // else leave the location empty.
            }
        }
    }
    
    /**
     * Pause for a given time.
     * @param millisec  The time to pause for, in milliseconds
     */
    private void delay(int millisec)
    {
        try {
            Thread.sleep(millisec);
        }
        catch (InterruptedException ie) {
            // wake up
        }
    }
    
    /**
     * Increment step for and updates the time. Each step is 1 hour.
     *
     */
    private void incrementStep()
    {
        step++;
        time = step%24;
    }
}
