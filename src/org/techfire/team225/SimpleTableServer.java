import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.HashMap;
import java.util.Iterator;


public class SimpleTableServer extends Thread {

	
	HashMap<String,String> pairs = new HashMap<String,String>();
	int port = 2225;
	MulticastSocket socket = new MulticastSocket(port); 
	InetAddress group;
	
	public SimpleTableServer() throws Exception
	{
		group = InetAddress.getByName("225.225.225.225");
		start();
	}
	
	public void put(String key, String value)
	{
		try {
			byte[] buf = new String(key+"~"+value).trim().getBytes();
			DatagramPacket packet = new DatagramPacket(buf, buf.length, group, port);
			socket.send(packet);
		} catch (IOException e) {
			System.out.println("error sending data");
			e.printStackTrace();
		}
	}

	public String get(String key)
	{
		return pairs.get(key);
	}
	
	public void run()
	{
		try
		{
			socket.joinGroup(group);
			while ( true )
			{
				byte[] buf = new byte[256];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
			    socket.receive(packet);
			    
			    String data = new String(packet.getData());
			    String[] keyvalue = data.split("~");
			    if ( keyvalue.length == 2 )
			    	pairs.put(keyvalue[0], keyvalue[1]);
			    
			    Iterator<String> it = pairs.keySet().iterator();
			    while ( it.hasNext() )
			    {
			    	String k = it.next();
			    	String v = pairs.get(k);
			    	System.out.println(k+"="+v);
			    }
			}
		} catch (Exception e) {
			System.out.println("Server error!");
		}
	}
	}
