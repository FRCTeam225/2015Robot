package org.techfire.team225.robot;

import java.io.File;
import java.lang.reflect.Field;

public class PortMap {
	static boolean isCompBot;
    
	public static void init() {
		try {
			File flag = new File("/PracticeRobot");
			isCompBot = !flag.exists();
			Robot.jedis.set("isCompBot", "false");
		} catch (Exception e) {
			isCompBot = true;
		}
	}
	
	public static int get(String key) {
		try {
			if (!isCompBot) {
				Class<PracticeRobotConstants> constants = PracticeRobotConstants.class;
				Field constantField = constants.getField(key);
				PracticeRobotConstants portMap = new PracticeRobotConstants();
				return constantField.getInt(portMap);
			} else {
				Class<CompetitionRobotConstants> constants = CompetitionRobotConstants.class;
				Field constantField = constants.getField(key);
				CompetitionRobotConstants portMap = new CompetitionRobotConstants();
				return constantField.getInt(portMap);
		}
		} catch (Exception e) {
			System.out.println("Code tried to get invalid object from PortMap");
			return 0;
		}
	}
}
