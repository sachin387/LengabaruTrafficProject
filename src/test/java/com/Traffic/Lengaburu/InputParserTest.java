	package com.Traffic.Lengaburu;

import static org.junit.Assert.*;
import org.junit.Test;

import com.Traffic.Lengaburu.InputParser;

public class InputParserTest {

/*	@Test
	void test() {
		fail("Not yet implemented");
	}
*/
	InputParser input = new InputParser();
	String weatherUserInput;
	String orbit1Traffic;
	String orbit2Traffic;
	String orbit3Traffic;
	String orbit4Traffic;
	@Test
	public void testValidateWeatherFormat_SunnyCorrectFormat() {
		weatherUserInput = "Weather is Sunny";
		assertEquals(false, input.validateWeatherFormat(weatherUserInput));
	}
	@Test
	public void testValidateWeatherFormat_WindyCorrectFormat() {
		weatherUserInput = "Weather is Windy";
		assertEquals(false, input.validateWeatherFormat(weatherUserInput));
	}
	@Test
	public void testValidateWeatherFormat_RainyCorrectFormat() {
		weatherUserInput = "Weather is Rainy";
		assertEquals(false, input.validateWeatherFormat(weatherUserInput));
	}
	@Test
	public void testValidateWeatherFormat_IncorrectFormat() {
		weatherUserInput = "Weather is sun";
		assertNotEquals(false, input.validateWeatherFormat(weatherUserInput));
	}
	
	@Test
	public void testValidateOrbitSpeedFormat_Orbit1FloatCorrectFormat() {
		orbit1Traffic="Orbit1 traffic speed is 14.4 megamiles/hour";
		assertEquals(false, input.validateOrbitSpeedFormat(orbit1Traffic, "Orbit1"));
	}

	
	@Test
	public void testValidateOrbitSpeedFormat_Orbit2FloatCorrectFormat() {
		orbit2Traffic="Orbit2 traffic speed is 10.47 megamiles/hour";
		assertEquals(false, input.validateOrbitSpeedFormat(orbit2Traffic, "Orbit2"));
	}
	
	
	@Test
	public void testValidateOrbitSpeedFormat_Orbit3FloatCorrectFormat() {
		orbit3Traffic="Orbit3 traffic speed is 17.96 megamiles/hour";
		assertEquals(false, input.validateOrbitSpeedFormat(orbit3Traffic, "Orbit3"));
	}


	@Test
	public void testValidateOrbitSpeedFormat_Orbit4FloatCorrectFormat() {
		orbit4Traffic="Orbit4 traffic speed is 5.21 megamiles/hour";
		assertEquals(false, input.validateOrbitSpeedFormat(orbit4Traffic, "Orbit4"));
	}
	
	@Test
	public void testValidateOrbitSpeedFormat_Orbit1IntegerIncorrectFormat() {
		orbit1Traffic="Orbit1 is 14 megamiles/hour";
		assertNotEquals(false, input.validateOrbitSpeedFormat(orbit1Traffic, "Orbit1"));
	}
	
	@Test
	public void testValidateOrbitSpeedFormat_Orbit1FloatCorrectFormatIncorrectOrbit() {
		orbit1Traffic="Orbit2 traffic speed is 14.4 megamiles/hour";
		assertNotEquals(false, input.validateOrbitSpeedFormat(orbit1Traffic, "Orbit1"));
	}
	
	@Test
	public void testValidateOrbitSpeedFormat_Orbit2IntegerIncorrectFormat() {
		orbit2Traffic="Orbit2 is 14";
		assertNotEquals(false, input.validateOrbitSpeedFormat(orbit2Traffic, "Orbit2"));
	}
	
	@Test
	public void testValidateOrbitSpeedFormat_Orbit2FloatCorrectFormatIncorrectOrbit() {
		orbit2Traffic="Orbit25 traffic speed is 14.4 megamiles/hour";
		assertNotEquals(false, input.validateOrbitSpeedFormat(orbit2Traffic, "Orbit2"));
	}
	
	@Test
	public void testValidateOrbitSpeedFormat_Orbit3IntegerIncorrectFormat() {
		orbit3Traffic="Orbit3 traffic speed is 107 megamiles";
		assertNotEquals(false, input.validateOrbitSpeedFormat(orbit3Traffic, "Orbit3"));
	}
	
	@Test
	public void testValidateOrbitSpeedFormat_Orbit3FloatCorrectFormatIncorrectOrbit() {
		orbit3Traffic="Orbit30 traffic speed is 16.2 megamiles/hour";
		assertNotEquals(false, input.validateOrbitSpeedFormat(orbit3Traffic, "Orbit3"));
	}
	
	@Test
	public void testValidateOrbitSpeedFormat_Orbit4IntegerIncorrectFormat() {
		orbit4Traffic="Orbit4 traffic speed is 30 megamiles";
		assertNotEquals(false, input.validateOrbitSpeedFormat(orbit4Traffic, "Orbit4"));
	}
	
	@Test
	public void testValidateOrbitSpeedFormat_Orbit4FloatCorrectFormatIncorrectOrbit() {
		orbit4Traffic="Orbit44 traffic speed is 12.2 megamiles/hour";
		assertNotEquals(false, input.validateOrbitSpeedFormat(orbit4Traffic, "Orbit4"));
	}
	
	@Test
	public void testgetTodayWeather_SunnyCorrectFormat() {
		weatherUserInput = "Weather is Sunny";
		assertEquals("SUNNY", input.getTodayWeather(weatherUserInput));
	}
	
	@Test
	public void testgetTodayWeather_WindyCorrectFormat() {
		weatherUserInput = "Weather is Windy";
		assertEquals("WINDY", input.getTodayWeather(weatherUserInput));
	}
	
	@Test
	public void testgetTodayWeather_RainyCorrectFormat() {
		weatherUserInput = "Weather is Rainy";
		assertEquals("RAINY", input.getTodayWeather(weatherUserInput));
	}
	
	@Test
	public void testGetTodayTraffic_Orbit1FloatCorrectFormat() {
		orbit1Traffic="Orbit1 traffic speed is 14.4 megamiles/hour";
		assertEquals(14.4, input.getTodayTraffic(orbit1Traffic), 0.00001);
	}

	
	@Test
	public void testGetTodayTraffic_Orbit2FloatCorrectFormat() {
		orbit2Traffic="Orbit2 traffic speed is 10.47 megamiles/hour";
		assertEquals(10.47, input.getTodayTraffic(orbit2Traffic), 0.00001);
	}
	
	
	@Test
	public void testGetTodayTraffic_Orbit3FloatCorrectFormat() {
		orbit3Traffic="Orbit3 traffic speed is 17.96 megamiles/hour";
		assertEquals(17.96, input.getTodayTraffic(orbit3Traffic), 0.00001);
	}


	@Test
	public void testGetTodayTraffic_Orbit4FloatCorrectFormat() {
		orbit4Traffic="Orbit4 traffic speed is 5.21 megamiles/hour";
		assertEquals(5.21, input.getTodayTraffic(orbit4Traffic), 0.00001);
	}
	
}