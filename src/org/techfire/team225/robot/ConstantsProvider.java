package org.techfire.team225.robot;

import java.io.File;
import java.lang.reflect.Field;

public class ConstantsProvider {
	static boolean isCompBot;
    
	public static void init() {
		System.out.println("reading file...");
		try {
			File flag = new File("/PracticeRobot");
			isCompBot = !flag.exists();
		} catch (Exception e) {
			e.printStackTrace();
			isCompBot = true;
		}
		System.out.println("COMP BOT: "+ isCompBot);
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
			System.out.println("Request for " + key + " failed");
			e.printStackTrace();
			return 0;
		}
	}
}
