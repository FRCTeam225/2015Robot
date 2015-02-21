package org.techfire.team225.robot;

import java.io.File;
import java.lang.reflect.Field;

public class ConstantsProvider {
	static boolean isCompBot;
    
	public static void init() {
		try {
			File flag = new File("/PracticeRobot");
			isCompBot = !flag.exists();
			//Robot.jedis.set("isCompBot", "false");
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
				System.out.println(key+" "+ constantField.getInt(portMap));
				return constantField.getInt(portMap);
			} else {
				Class<CompetitionRobotConstants> constants = CompetitionRobotConstants.class;
				Field constantField = constants.getField(key);
				CompetitionRobotConstants portMap = new CompetitionRobotConstants();
				System.out.println(key+" "+ constantField.getInt(portMap));
				return constantField.getInt(portMap);
			}
		} catch (Exception e) {
			System.out.println("Request for " + key + " failed");
			e.printStackTrace();
			return 0;
		}
	}
}
