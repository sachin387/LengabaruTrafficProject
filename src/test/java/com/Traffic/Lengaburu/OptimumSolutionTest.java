package com.Traffic.Lengaburu;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.Traffic.Lengaburu.OptimumSolution;

public class OptimumSolutionTest {

	OptimumSolution solution = new OptimumSolution();
	static String todayWeather = "";
	static float todayTrafficInOrbit1 = 0;
	static float todayTrafficInOrbit2 = 0;
	static float todayTrafficInOrbit3 = 0;
	static float todayTrafficInOrbit4 = 0;
	
	@Test
	public void testGetTravellSolution_Problem1SampleInput1() {
		todayWeather = "SUNNY";
		todayTrafficInOrbit1 = 12;
		todayTrafficInOrbit2 = 10;
		assertEquals("Vehicle TukTuk to Hallitharam via ORBIT1", solution.getTravellSolution(todayWeather, todayTrafficInOrbit1, todayTrafficInOrbit2));		
	}
	
	@Test
	public void testGetTravellSolution_Problem1SampleInput2() {
		todayWeather = "WINDY";
		todayTrafficInOrbit1 = 14;
		todayTrafficInOrbit2 = 20;
		assertEquals("Vehicle SuperCar to Hallitharam via ORBIT2", solution.getTravellSolution(todayWeather, todayTrafficInOrbit1, todayTrafficInOrbit2));		
	}
	@Test
	public void testGetTravellSolution_Problem2SampleInput1() {
		todayWeather = "SUNNY";
		todayTrafficInOrbit1 = 20;
		todayTrafficInOrbit2 = 12;
		todayTrafficInOrbit3 = 15;
		todayTrafficInOrbit4 = 12;
		assertEquals("Vehicle TukTuk to  Hallitharam via ORBIT1 and RK Puram via ORBIT4", solution.getTravellSolution(todayWeather, todayTrafficInOrbit1, todayTrafficInOrbit2, todayTrafficInOrbit3, todayTrafficInOrbit4));		
	}
	
	@Test
	public void testGetTravellSolution_Problem2SampleInput2() {
		todayWeather = "WINDY";
		todayTrafficInOrbit1 = 5;
		todayTrafficInOrbit2 = 10;
		todayTrafficInOrbit3 = 20;
		todayTrafficInOrbit4 = 20;
		assertEquals("Vehicle SuperCar to  RK Puram via ORBIT3 and Hallitharam via ORBIT4", solution.getTravellSolution(todayWeather, todayTrafficInOrbit1, todayTrafficInOrbit2, todayTrafficInOrbit3, todayTrafficInOrbit4));		
	}
	
	
}
