package org.techfire.team225.robot;

import java.util.HashMap;

public class Constants {
	static HashMap<String, Double> map = new HashMap<>();
	
	public static void init() {
		map.put("ARM_MIN", 2215.0);
		map.put("ARM_MAX", 3240.0);
	}
	
	public static double getConstant(String key) {
		if (map.containsKey(key)) {
			return map.get(key);
		} else {
			return 0;
		}
	}
}
