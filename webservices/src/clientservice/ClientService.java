package clientservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import java.net.URL;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import airport_info.AirportDetails;

import temperature_converter.*;
import mashup.*;
import weather_forecast.*;
import currency_converter.*;
import local_time.*;

// Adapted from Java Web Services: Up and Running
// by Martin Kalin
// O'Reilly, 2009

public class ClientService {
	private static final String HELP_MSG = 
			  "* -------------- Menu ----------- *\n"
			+ "* w. GetWeather&LocalTimeByZip    *\n"
			+ "* a. GetAirportByCityName         *\n"
			+ "* c. CurrencyExchange             *\n"
			+ "* q. quit                         *\n"
			+ "* ------------------------------- *\n"
			+ "Option (w, a, c, or q)? ";

	/**
	 * Main.
	 * 
	 * @param args
	 *            the server port number
	 * @throws Exception
	 *             is an error occurred
	 */
	public static void main(String args[]) throws MalformedURLException {
		URL url = new URL(String.format("http://localhost:%s/ts?wsdl", args[0]));

		// Qualified name of the service:
		// 1st arg: the service URI (reversed package name)
		// 2nd arg: the service name published in the WSDL
		QName qname = new QName("http://mashup/", "MashUpImplService");

		// Create a service factory.
		Service service = Service.create(url, qname);

		// Get the endpoint interface, the service "port".
		MashUp eif = service.getPort(MashUp.class);

		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String command = "";

		do {
			System.out.println();
			System.out.print(HELP_MSG);
			try {
				command = stdin.readLine();
			} catch (java.io.IOException ex) {
				command = "?";
			}

			if (command.equalsIgnoreCase("GetWeather&LocalTimeByZip")
					|| command.equalsIgnoreCase("w")) {

				System.out.print("Please enter Zipcode: ");

				String zip = "";

				try {
					zip = stdin.readLine();
				} catch (java.io.IOException ex) {
					zip = "?";
				}

				getweatherbyzip(eif, zip);
				
			} else if (command.equalsIgnoreCase("GetAirportByCityName")
					|| command.equalsIgnoreCase("a"))
			{

				System.out.print("Please enter US City: ");

				String city = "";

				try {
					city = stdin.readLine();
				} catch (java.io.IOException ex) {
					city = "?";
				}

				getairport(eif, city);
				
				
			} else if (command.equalsIgnoreCase("CurrencyExchange")
					|| command.equalsIgnoreCase("c"))
			{
				System.out.print("Please enter Currency: ");

				String c = "";

				try {
					c = stdin.readLine();
				} catch (java.io.IOException ex) {
					System.out.println("Invalid Format entered!");
				}
				
				System.out.print("Enter amount: ");
				
				double a = 0;
				
				try {
					a = Double.parseDouble(stdin.readLine());
				} catch (IOException e) {
					System.out.println("Invalid Value entered!");
				}
				
				currencyexchange(eif, c, a);
				
			} else 
			{
				if(!command.equalsIgnoreCase("quit") && 
						!command.equalsIgnoreCase("q"))
        		System.out.println("Invalid Option");
			}

		} while (!(command.equalsIgnoreCase("quit") || command
				.equalsIgnoreCase("q")));

        
        System.out.println("Thank you for using! See you soon!");
        
	}
	
	public static void getweatherbyzip(MashUp eif, String zip) {

		// Call the remote operations.
		ForecastReturn fr = eif.getCityForcastByZIP(zip);
		if (fr.isSuccess()) {
			System.out.println("\n"+fr.getResponseText() + ": " + fr.getCity()+", "+fr.getState());
			System.out.println("Current Local Time:" + eif.getLocalTime(zip));
			
		// some zips have the wrong days results, suspect it's the day of the week
		//	String[] day = { "Monday", "Tuesday", "Wednesday", "Thursday",
		//			"Friday", "Saturday", "Sunday" }; 

			ArrayOfForecast aof = fr.getForecastResult();
			for (Forecast f : aof.getForecast()) {
				System.out.println();
				System.out.println("  " + f.getDate()); //may using day[f.getDate().getDay() % 7]);
				System.out.println("    Description:    " + f.getDesciption());

				// get the low temp
				if (!f.getTemperatures().getMorningLow().isEmpty()
						&& f.getTemperatures().getMorningLow() != null) {
					int lowTempInF = Integer.parseInt(f.getTemperatures()
							.getMorningLow());
					int lowTempInC = Math.round((float) (eif
							.convertTemperature((double) lowTempInF,
									TemperatureUnit.DEGREE_FAHRENHEIT,
									TemperatureUnit.DEGREE_CELSIUS)));

					System.out.format("    Low temp:       %d*F    %d*C",
							lowTempInF, lowTempInC);
					System.out.println();
				}

				// get the high temp
				if (!f.getTemperatures().getDaytimeHigh().isEmpty()
						&& f.getTemperatures().getDaytimeHigh() != null) {
					int highTempInF = Integer.parseInt(f.getTemperatures()
							.getDaytimeHigh());
					int highTempInC = Math.round((float) (eif
							.convertTemperature((double) highTempInF,
									TemperatureUnit.DEGREE_FAHRENHEIT,
									TemperatureUnit.DEGREE_CELSIUS)));

					System.out.format("    High temp:      %d*F    %d*C",
							highTempInF, highTempInC);
					System.out.println();
				}
				System.out.println("    Chance of rain: "
						+ f.getProbabilityOfPrecipiation().getDaytime() + "%");
			}
		} else {
			System.out.println(fr.getResponseText());
		}

	}

	public static void currencyexchange(MashUp eif, String v, double a)
	{
		// convert the currency: use EUR euro to USD for sample
		// v = "EUR";
		try {
		double rate = eif.convertCurrency(Currency.fromValue(v.toUpperCase()), Currency.USD);
		if(v.equalsIgnoreCase("USD")) rate = 1;
		System.out.println();
		System.out.format("    Currency Rate: 1 %s = %.2f USD \n",
				v.toUpperCase(), rate);
		System.out.format(" Currency Exchanged: %.2f %s = %.2f USD\n",
				a, v.toUpperCase(), a*rate);
		System.out.format("   Sample Change: 100 %s = %.2f USD \n",
				v.toUpperCase(), 100*rate);
		System.out.format("   Sample Change: 150 %s = %.2f USD \n",
				v.toUpperCase(), 150*rate);
		System.out.format("   Sample Change: 200 %s = %.2f USD \n",
				v.toUpperCase(), 200*rate);
		System.out.format("   Sample Change: 250 %s = %.2f USD \n",
				v.toUpperCase(), 250*rate);
		System.out.format("   Sample Change: 300 %s = %.2f USD \n",
				v.toUpperCase(), 300*rate);
		System.out.format("   Sample Change: %.2f %s = 100 USD \n",
				100/rate, v.toUpperCase());
		System.out.format("   Sample Change: %.2f %s = 150 USD \n",
				150/rate, v.toUpperCase());
		System.out.format("   Sample Change: %.2f %s = 200 USD \n",
				200/rate, v.toUpperCase());
		System.out.format("   Sample Change: %.2f %s = 250 USD \n",
				250/rate, v.toUpperCase());
		System.out.format("   Sample Change: %.2f %s = 300 USD \n",
				300/rate, v.toUpperCase());
				
		} catch (Exception e){
			System.out.format("Invalid Currency: (%s)\n", v.toUpperCase());
		}
	}
	
	public static void getairport(MashUp eif, String city)
	{
		System.out.println();
		String xmlString = eif.getAirportByCity(city);

		Iterator<AirportDetails> it = AirportDetails.parsexml(xmlString)
				.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}
