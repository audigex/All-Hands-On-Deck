package admiral.weather;

import admiral.weather.Temperature;

/**
 *
 * @author jon
 */
public class Weather
{
    private Wind currentWind;
    private Temperature temperature;

    public Weather(Wind initialWind)
    {
        this.currentWind = initialWind;
        this.temperature = new Temperature();
    }
    public Weather()
    {
        this(Wind.FAIR);
    }

    public Wind getWind()
    {
        return this.currentWind;
    }

    //TODO: Allow weather/temperature to be changed
    //TODO: Add rain/snow/sunny/cloudy/fog etc - VISIBILITY?
}
