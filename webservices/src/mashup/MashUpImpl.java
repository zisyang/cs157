/**
 * implementation for the mashup interface
 * @author lamlu
 */
package mashup;


import javax.jws.WebMethod;
import javax.jws.WebService;
import temperature_converter.*;
import weather_forecast.*;
import currency_converter.*;
import local_time.*;

@WebService(endpointInterface = "mashup.MashUp")
public class MashUpImpl implements MashUp
{

	@Override
	@WebMethod
	public ForecastReturn getCityForcastByZIP(String zipcode) 
	{
		weather_forecast.Weather service = new weather_forecast.Weather();
		weather_forecast.WeatherSoap port = service.getWeatherSoap();
		return port.getCityForecastByZIP(zipcode);
	}

	
	@Override
	@WebMethod
	public double convertTemperature(double temp, TemperatureUnit fromUnit, TemperatureUnit toUnit) 
	{
		temperature_converter.ConvertTemperature service = new temperature_converter.ConvertTemperature();
		temperature_converter.ConvertTemperatureSoap port = service.getConvertTemperatureSoap();
		return port.convertTemp(temp, fromUnit, toUnit);
	}


	@Override
	@WebMethod
	public double convertCurrency(Currency fromCurrency, Currency toCurrency)
	{
		currency_converter.CurrencyConvertor service = new currency_converter.CurrencyConvertor();
		currency_converter.CurrencyConvertorSoap port = service.getCurrencyConvertorSoap();
		return port.conversionRate(fromCurrency, toCurrency);
	}
	
	@Override
	@WebMethod
	public String getAirportByCity(String city)
	{
		airport_info.Airport service = new airport_info.Airport();
		airport_info.AirportSoap port = service.getAirportSoap();
		return port.getAirportInformationByCityOrAirportName(city);
	}

    @WebMethod
	public String getLocalTime(String zipCode) {
    	local_time.LocalTime service = new local_time.LocalTime();
    	local_time.LocalTimeSoap port = service.getLocalTimeSoap();
    	return port.localTimeByZipCode(zipCode);
    }


}
