package org.techfire.team225.robot;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class GyroProvider extends Thread {
	
	private int angle;
	private int zero;
	
	public GyroProvider() {
		start();
		angle = 0;
		zero = 0;
	}
	
	public int getAngle() {
		return angle - zero;
	}
	
	public void reset() {
		zero = angle;
	}

	public void run() {
		try {
			int port = 1337;
			
			DatagramSocket dsocket = new DatagramSocket(port);
			
			while ( true )
			{
				try {
					byte[] buffer = new byte[2];
					DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
					
					dsocket.receive(packet);
					angle = ((buffer[0] & 0xff) << 8) | (buffer[1] & 0xff);
				} catch (Exception e) {
					System.out.println("Gyro packet error");
				}
			}
		} catch (Exception e) {
			System.out.println("Gyro thread error");
		}
	}
	
}
