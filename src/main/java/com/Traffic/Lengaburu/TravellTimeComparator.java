package com.Traffic.Lengaburu;

import java.util.Comparator;

import com.Traffic.Lengaburu.DTO.*;

public class TravellTimeComparator implements Comparator<TrafficDTO> {

	@Override
	public int compare(TrafficDTO o1, TrafficDTO o2) {
		// TODO Auto-generated method stub
		if (o1.getTravellTime() > o2.getTravellTime()) {
			return 1;
		} else {
			return -1;
		}
	}

}
