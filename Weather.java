import java.util.List;
import java.util.Random;
import java.util.Iterator;
/**
 * Write a description of class Weather here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Weather
{
    // instance variables - replace the example below with your own
    
    
    private static final double FOG_PROPABILITY = 0.1;
    private static final double RAIN_PROPABILITY = 0.7;
    private static final Random rand = Randomizer.getRandom();
    
    private boolean rain;
    private boolean fog;
    

    /**
     * Constructor for objects of class Weather
     */
    public Weather()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void step()
    {
        rain= false;
        fog = false;
        
        if(rand.nextDouble() <= FOG_PROPABILITY) {
            fog = true;
        }
        if(rand.nextDouble() <= RAIN_PROPABILITY) {
            rain = true;
        }
    }
       
    public String getWeather()
    {
        if(fog && rain)
        {
            return "Fog & Rain";
        }
        else if(fog)
        {
            return "Fog";
        }
        else if (rain)
        {
            return "Rain";
        }
        else {
            return "";
        }
    }
    
    public boolean getRaining()
    {
        return rain;
    }
    
    public boolean getFog()
    {
        return fog;
    }
    
}

