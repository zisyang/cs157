package mashup;
import java.util.List;

import javax.jws.soap.SOAPBinding;

import javax.jws.soap.SOAPBinding.Style;
import javax.jws.WebMethod;
import javax.jws.WebService;
import weather_forecast.*;
import temperature_converter.*;
import currency_converter.*;
import local_time.*;

/**
 * this is the mash up for airport_info, currency_converter,
 * temperature_converter and weather_forecast web services
 * @author lamlu
 *
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface MashUp 
{
    @WebMethod ForecastReturn getCityForcastByZIP (String zipcode);
    
    //fromUnit : degreeCelsius or degreeFahrenheit or degreeRankine or degreeReaumur or kelvin
    //toUnit:degreeCelsius or degreeFahrenheit or degreeRankine or degreeReaumur or kelvin
    @WebMethod double convertTemperature(double temp, TemperatureUnit fromUnit, TemperatureUnit toUnit);
    
    //convert foreign currency to US dollar
    //check Currency.java for enum type
    @WebMethod double convertCurrency(Currency fromCurrency, Currency toCurrency);
    
    //get airport information by city
    @WebMethod String getAirportByCity(String city);
    
    //get local time by zip
    @WebMethod String getLocalTime(String zipCode);
    
}
