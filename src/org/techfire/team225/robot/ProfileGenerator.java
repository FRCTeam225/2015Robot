package org.techfire.team225.robot;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ProfileGenerator {

    static double toPrecision(double n, double p) {
        if (n==0) return 0;

        double e = Math.floor(Math.log10(Math.abs(n)));
        double f = Math.round(Math.exp((Math.abs(e-p+1))*Math.log(10)));

        if (e-p+1<0) {
            return Math.round(n*f)/f;
        }

        return Math.round(n/f)*f;
    }

    static class PathPoint {
        double t = 0;
        double acc=0;
        double vel=0;
        double pos=0;

        public String toString()
        {
            return t+","+pos+","+vel+","+acc;
        }
    }

    public void calculate(String filename) throws IOException {
        ArrayList<PathPoint> points = new ArrayList<PathPoint>();
	    double target = 22;
        double maxAccel= 10;
        double vcruise = 18;

        double t = 0;

        double tToCruise = vcruise/maxAccel;
        double dRamping = (0.5)*maxAccel*Math.pow(tToCruise,2);
        double dCruising = target-(dRamping*2);

        if (dCruising < 0) {
            // I am overshooting target by accelerating to vcruise
            tToCruise = Math.sqrt(2 * maxAccel * (target / 2) - 1) / maxAccel;
            if (tToCruise < 0)
                tToCruise = -tToCruise;
            dCruising = 0;
            dRamping = target/2;
            vcruise = maxAccel * tToCruise; // how fast do we get to?
        }
        PathPoint last = null;
        for (t = t; t <= tToCruise; t += 0.01) {
            t = toPrecision(t, 3);
            PathPoint point = new PathPoint();

            point.t = t;
            point.vel = maxAccel * t;
            point.pos = (0.5) * maxAccel * Math.pow(t, 2);

            point.acc = maxAccel;
            points.add(point);
            last = point;
        }
        double tCruising = dCruising / vcruise;

        System.out.println(dRamping);

        for (double i = 0; i < tCruising; i += 0.01) {
            PathPoint point = new PathPoint();

            point.t = t;
            point.pos = dRamping + (vcruise * i);
            point.vel = vcruise;
            point.acc = 0;
            t += 0.01;
            t = toPrecision(t, 3);
            points.add(point);
        }

        for (double i = 0; i < tToCruise; i += 0.01) {
            PathPoint point = new PathPoint();

            point.t = t;
            point.pos = (dCruising + dRamping) + (vcruise * i) + (0.5) * -maxAccel * Math.pow(i, 2);
            point.vel = vcruise + ((-maxAccel) * i);
            point.acc = -maxAccel;
            t += 0.01;
            t = toPrecision(t, 3);
            points.add(point);
        }


        FileWriter writer = new FileWriter(filename);
        Iterator<PathPoint> it = points.iterator();
        while (it.hasNext())
        {
            PathPoint p = it.next();
            writer.write(p+"\n");
        }
        writer.close();

    }
}
