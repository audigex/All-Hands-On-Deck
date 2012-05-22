package admiral.weather;

/**
 *
 * @author jon
 */
public class Temperature
{
    //Value - stored as Celsius (most natural to author)
    private float value;

    public Temperature()
    {
        this.value = 0;
    }
    
    public int getTemperatureCelsius()
    {
        return Math.round(this.value);        
    }
    public void setTemperatureCelsius(int degreesCelsius)
    {
        this.value = degreesCelsius;
    }

    public int getFarenheitValue()
    {
        int farenheit = (int) Math.round(1.8 * this.value + 32);
        return farenheit;
    }
    public void setFarenheitValue(int degreesFarenheit)
    {
        this.value = (degreesFarenheit - 32)/1.8f;
    }

    public int getKelvinValue()
    {
        //TODO: Check
        return Math.round(value - 270);
    }
    public void setKelvinValue(int degreesKelvin)
    {
        //TODO: Check
        this.value = degreesKelvin + 270;
    }
}
