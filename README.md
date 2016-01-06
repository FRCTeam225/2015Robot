This is the java code for TechFire 225's 2015 robot, Pheonix.

Here are some notable parts of the software:
- robot.commands.drivetrain.FireDrive: This is a drivetrain control command that allows our mecanum drive to behave like a true omnidirectional drive for driving purposes. That is, FireDrive makes the robot move in all directions with the same speed, instead of the traditional behavior for mecanum: full speed forwards and 50% strafe. However, with our ever changing strategy we decided to remove FireDrive in the offseason in favor of maximum speed, so it is commented out.
- robot.commands.drivetrain.StableMode: This command uses a sine function to have the drivetrain compensate for the forward and backward motion of our arm as it moves up and down on its circular path. It ended up not being needed in our strategy so it is not tuned to work perfectly.
- robot.JedisProvider: We originally had the Raspberry Pi on Pheonix running a redis server and using the values from that to serve up our custom HTML and node.js dashboard.
- SimpleTableServer: This the custom dashboard implementation that we switched to. It uses UDP packets to communicate the values to the Pi.
- We also have some motion profiling implemented; robot.commands.drivetrain.ProfiledDriveDistance works well and accurately moves the robot a specified number of feet with a maximum acceleration and velocity in either a triangular or trapezoidal motion profile. The other "profiled" commands need work.

Thank you so much for taking interest in our code!
