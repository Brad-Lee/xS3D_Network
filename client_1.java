package client;

import java.io.*;
import java.net.*;

public class client {
	public static void main(String[] args){
		
		Cli c = new Cli();
		Thread t = new Thread(c);
		
		t.start();
		while(true){
			try{
				Socket socket = null;
				InputStreamReader  inputStreamReader = null;
				FileOutputStream fileOutputStream = null;
				
				OutputStream outputStream_battery = null;
				OutputStream outputStream_latitude = null;
				OutputStream outputStream_longitude = null;
				
				ObjectOutputStream objectoutputStream_battery = null;
				ObjectOutputStream objectoutputStream_latitude = null;
				ObjectOutputStream objectoutputStream_longitude = null;

				BufferedReader batteryBuff = new BufferedReader(new FileReader("/home/xs3d/battery.txt"));
				int battery = 0;
				battery = Integer.valueOf(batteryBuff.readLine());
				batteryBuff.close();
				System.out.println("battery: " + battery);
				
				BufferedReader latitudeBuff = new BufferedReader(new FileReader("/home/xs3d/latitude.txt"));
				float latitude = 0;
				latitude = Float.valueOf(latitudeBuff.readLine());
				latitudeBuff.close();
				System.out.println("latitude: " + latitude);
				
				BufferedReader longitudeBuff = new BufferedReader(new FileReader("/home/xs3d/longitude.txt"));
				float longitude = 0;
				longitude = Float.valueOf(longitudeBuff.readLine());
				longitudeBuff.close();
				System.out.println("longitude: " + longitude);

				
				try{
					socket = new Socket("192.168.2.151", 1800);
					
					outputStream_battery = socket.getOutputStream();
					objectoutputStream_battery = new ObjectOutputStream(outputStream_battery);
					objectoutputStream_battery.writeObject(battery);
					objectoutputStream_battery.flush();
					
					outputStream_latitude = socket.getOutputStream();
					objectoutputStream_latitude = new ObjectOutputStream(outputStream_latitude);
					objectoutputStream_latitude.writeObject(latitude);
					objectoutputStream_latitude.flush();
					
					outputStream_longitude = socket.getOutputStream();
					objectoutputStream_longitude = new ObjectOutputStream(outputStream_longitude);
					objectoutputStream_longitude.writeObject(longitude);
					objectoutputStream_longitude.flush();
					
					
					InputStream inputStream = socket.getInputStream();
					
					fileOutputStream = new FileOutputStream("/home/xs3d/catkin_ws/src/tum_ardrone/flightPlans/command.txt");
					byte[] dataBuff = new byte[10000];
					int length = inputStream.read(dataBuff);
					System.out.println("Receiving...");
					while(length != -1){
						System.out.print(".");
						fileOutputStream.write(dataBuff, 0, length);
						length = inputStream.read(dataBuff);
					}
					System.out.println();
					
					System.out.println("File saving success");
				}catch(UnknownHostException e){
					e.printStackTrace();
				}catch(IOException e){
					e.printStackTrace();
				}finally{
					if(fileOutputStream != null){
						try{
							fileOutputStream.close();
						}catch(IOException e){
							e.printStackTrace();
						}
					}
					if(inputStreamReader != null){
						try{
							inputStreamReader.close();
						}catch(IOException e){
							e.printStackTrace();
						}
					}
					if(socket != null){
						try{
							socket.close();
						}catch(IOException e){
							e.printStackTrace();
						}
					}
				}
				t.sleep(3000);
			}catch(InterruptedException e){
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

class Cli implements Runnable{
	public void run(){
		
	}
}
