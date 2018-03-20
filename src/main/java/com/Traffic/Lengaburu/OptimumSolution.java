package com.Traffic.Lengaburu;

import java.util.HashMap;
import java.util.LinkedList;

import com.Traffic.Lengaburu.DTO.*;
import com.Traffic.Lengaburu.ruleset.*;

public class OptimumSolution {

	float totalTravelTime = 0;
	String optimumSolution = "";
	LinkedList<TrafficDTO> vehileTravellTimeData;
	ShortestPath sPath = new ShortestPath();

	// getTravellTime will get data for problem 1 and calculate the travel time for
	// all paths and vehicles and add them to traffic DTO and at last call
	// shortestPath method to get solution for best route and vehicle.
	
	String getTravellSolution(String todayWeather, float todayTrafficInOrbit1, float todayTrafficInOrbit2) {
		HashMap<String, Float> todayTrafficSpeedInOrbit = new HashMap<>();
		todayTrafficSpeedInOrbit.put("ORBIT1", todayTrafficInOrbit1);
		todayTrafficSpeedInOrbit.put("ORBIT2", todayTrafficInOrbit2);

		TrafficRuleSet trafficRuleSet = TrafficForProblem1.ruleSet.get(todayWeather);
		WeatherRuleSet weatherRuleset = trafficRuleSet.getWeatherRuleSet();
		LinkedList<VehicleRuleSet> vehileRuleSet = trafficRuleSet.getVehicleRuleSet();
		LinkedList<OrbitRuleSet> orbitRuleSet = trafficRuleSet.getOrbitRuleSet();
		vehileTravellTimeData = new LinkedList<>();

		vehileRuleSet.forEach(vehicle -> {
			orbitRuleSet.forEach(orbit -> {
				TrafficDTO trafficDTO = new TrafficDTO();
				totalTravelTime = getCraterTravellTime(vehicle, orbit, weatherRuleset)
						+ getOrbitTravellTime(vehicle, orbit, todayTrafficSpeedInOrbit);
				trafficDTO.setVehicle(vehicle.getVehileName());
				trafficDTO.setOrbit(orbit.getOrbitName());
				trafficDTO.setTravellTime(totalTravelTime);
				trafficDTO.setConnectedCity1(orbit.getOrbitConnectedCity1());
				trafficDTO.setConnectedCity2(orbit.getOrbitConnectedCity2());
				vehileTravellTimeData.add(trafficDTO);
			});
		});

		optimumSolution = sPath.shortestPath(vehileTravellTimeData);
		return optimumSolution;
	}

	// getTravellTime will get data for problem 2 and calculate the travel time for
	// all paths and vehicles and add them to traffic DTO and at last call
	// shortestPath method to get solution for best route and vehicle.
	String getTravellSolution(String todayWeather, float todayTrafficInOrbit1, float todayTrafficInOrbit2,
			float todayTrafficInOrbit3, float todayTrafficInOrbit4) {

		HashMap<String, Float> todayTrafficSpeedInOrbit = new HashMap<>();
		todayTrafficSpeedInOrbit.put("ORBIT1", todayTrafficInOrbit1);
		todayTrafficSpeedInOrbit.put("ORBIT2", todayTrafficInOrbit2);
		todayTrafficSpeedInOrbit.put("ORBIT3", todayTrafficInOrbit3);
		todayTrafficSpeedInOrbit.put("ORBIT4", todayTrafficInOrbit4);

		TrafficRuleSet trafficRuleSet = TrafficForProblem2.ruleSet.get(todayWeather);
		WeatherRuleSet weatherRuleset = trafficRuleSet.getWeatherRuleSet();
		LinkedList<VehicleRuleSet> vehileRuleSet = trafficRuleSet.getVehicleRuleSet();
		LinkedList<OrbitRuleSet> orbitRuleSet = trafficRuleSet.getOrbitRuleSet();
		vehileTravellTimeData = new LinkedList<>();

		vehileRuleSet.forEach(vehicle -> {
			orbitRuleSet.forEach(orbit -> {
				TrafficDTO trafficDTO = new TrafficDTO();
				totalTravelTime = getCraterTravellTime(vehicle, orbit, weatherRuleset)
						+ getOrbitTravellTime(vehicle, orbit, todayTrafficSpeedInOrbit);
				;
				trafficDTO.setVehicle(vehicle.getVehileName());
				trafficDTO.setOrbit(orbit.getOrbitName());
				trafficDTO.setTravellTime(totalTravelTime);
				trafficDTO.setConnectedCity1(orbit.getOrbitConnectedCity1());
				trafficDTO.setConnectedCity2(orbit.getOrbitConnectedCity2());
				vehileTravellTimeData.add(trafficDTO);
			});
		});

		optimumSolution = sPath.shortestPath(vehileTravellTimeData);
		return optimumSolution;
	}

	// getCraterTravellTime will provide time for a particular vehicle and
	// particular path to cross all carters in the given weather.
	private Float getCraterTravellTime(VehicleRuleSet vehicleRuleSet, OrbitRuleSet orbitRuleSet,
			WeatherRuleSet weatherRuleSet) {
		Float carterCrossingTime = (((float) orbitRuleSet.getOrbitCraters()
				+ ((float) orbitRuleSet.getOrbitCraters() * (float) weatherRuleSet.getCarterPercentageChange())
						/ (float) 100))
				* (float) vehicleRuleSet.getCarterCrossingTime();
		return carterCrossingTime;
	}

	// getOrbitTravellTime will provide time for a particular vehicle and particular
	// orbit to cross distance in the given weather and traffic speed.
	private Float getOrbitTravellTime(VehicleRuleSet vehileRuleSet, OrbitRuleSet orbitRuleSet,
			HashMap<String,Float> todayTrafficSpeedInOrbit) {
		Float vehileSpeed = (float)0;
		Float travellTime = (float) 0;

		if (todayTrafficSpeedInOrbit.get(orbitRuleSet.getOrbitName()) < vehileRuleSet.getSpeed()) {
			vehileSpeed = todayTrafficSpeedInOrbit.get(orbitRuleSet.getOrbitName());
		} else {
			vehileSpeed = (float) vehileRuleSet.getSpeed();
		}

		travellTime = ((float) orbitRuleSet.getOrbitDistance() / (float) vehileSpeed) * (float) 60;
		return travellTime;
	}
}
