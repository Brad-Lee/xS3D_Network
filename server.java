package server;

import java.io.*;
import java.net.*;

public class server {
	public static void main(String[] args) throws IOException {

		while (true) {
			// UAV 1 part

			ServerSocket serverSocket_UAV1 = null;
			Socket socket_UAV1 = null;

			int UAV1_battery = 0;
			float UAV1_latitude = 0, UAV1_longitude = 0;

			InputStream inputStream_UAV1_battery = null;
			ObjectInputStream objectInputStream_UAV1_battery = null;
			InputStream inputStream_UAV1_latitude = null;
			ObjectInputStream objectInputStream_UAV1_latitude = null;
			InputStream inputStream_UAV1_longitude = null;
			ObjectInputStream objectInputStream_UAV1_longitude = null;

			File command_UAV1 = new File("C:/test/command_UAV1.txt");
			FileWriter fileWriterTest_UAV1 = null;

			FileInputStream fileInputStream_UAV1 = null;
			OutputStream outputStream_UAV1 = null;

			try {

				// Accept socket
				serverSocket_UAV1 = new ServerSocket(1800);
				socket_UAV1 = serverSocket_UAV1.accept();

				// Read UAV1 info from client

				inputStream_UAV1_battery = socket_UAV1.getInputStream();
				objectInputStream_UAV1_battery = new ObjectInputStream(inputStream_UAV1_battery);
				UAV1_battery = (int) objectInputStream_UAV1_battery.readObject();

				inputStream_UAV1_latitude = socket_UAV1.getInputStream();
				objectInputStream_UAV1_latitude = new ObjectInputStream(inputStream_UAV1_latitude);
				UAV1_latitude = (float) objectInputStream_UAV1_latitude.readObject();

				inputStream_UAV1_longitude = socket_UAV1.getInputStream();
				objectInputStream_UAV1_longitude = new ObjectInputStream(inputStream_UAV1_longitude);
				UAV1_longitude = (float) objectInputStream_UAV1_longitude.readObject();

				System.out.println("UAV1 battery : " + UAV1_battery);
				System.out.println("UAV1 latitude : " + UAV1_latitude);
				System.out.println("UAV1 longitude : " + UAV1_longitude);

				// Text file writing

				fileWriterTest_UAV1 = new FileWriter(command_UAV1);
				String text_UAV1 = "11.111111\n111.111111\n1.5";
				fileWriterTest_UAV1.write(text_UAV1);
				fileWriterTest_UAV1.flush();

				// Text file transfer to client 1

				outputStream_UAV1 = socket_UAV1.getOutputStream();

				fileInputStream_UAV1 = new FileInputStream("C:/test/command_UAV1.txt");

				byte[] dataBuff = new byte[10000];
				int length = fileInputStream_UAV1.read(dataBuff);
				while (length != -1) {
					outputStream_UAV1.write(dataBuff, 0, length);
					length = fileInputStream_UAV1.read(dataBuff);
				}
				System.out.println("Transfer Success");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try {
					if (inputStream_UAV1_battery != null)
						inputStream_UAV1_battery.close();
					if (objectInputStream_UAV1_battery != null)
						objectInputStream_UAV1_battery.close();
					if (inputStream_UAV1_latitude != null)
						inputStream_UAV1_latitude.close();
					if (objectInputStream_UAV1_latitude != null)
						objectInputStream_UAV1_latitude.close();
					if (inputStream_UAV1_longitude != null)
						inputStream_UAV1_longitude.close();
					if (objectInputStream_UAV1_longitude != null)
						objectInputStream_UAV1_longitude.close();
					if (fileWriterTest_UAV1 != null)
						fileWriterTest_UAV1.close();
					if (fileInputStream_UAV1 != null)
						fileInputStream_UAV1.close();
					if (outputStream_UAV1 != null)
						outputStream_UAV1.close();
					if (socket_UAV1 != null)
						socket_UAV1.close();
					if (serverSocket_UAV1 != null)
						serverSocket_UAV1.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// UAV 2 part

			ServerSocket serverSocket_UAV2 = null;
			Socket socket_UAV2 = null;

			int UAV2_battery = 0;
			float UAV2_latitude = 0, UAV2_longitude = 0;

			InputStream inputStream_UAV2_battery = null;
			ObjectInputStream objectInputStream_UAV2_battery = null;
			InputStream inputStream_UAV2_latitude = null;
			ObjectInputStream objectInputStream_UAV2_latitude = null;
			InputStream inputStream_UAV2_longitude = null;
			ObjectInputStream objectInputStream_UAV2_longitude = null;

			File command_UAV2 = new File("C:/test/command_UAV2.txt");
			FileWriter fileWriterTest_UAV2 = null;

			FileInputStream fileInputStream_UAV2 = null;
			OutputStream outputStream_UAV2 = null;

			try {

				// Accept socket
				serverSocket_UAV2 = new ServerSocket(2800);
				socket_UAV2 = serverSocket_UAV2.accept();

				// Read UAV2 info from client

				inputStream_UAV2_battery = socket_UAV2.getInputStream();
				objectInputStream_UAV2_battery = new ObjectInputStream(inputStream_UAV2_battery);
				UAV2_battery = (int) objectInputStream_UAV2_battery.readObject();

				inputStream_UAV2_latitude = socket_UAV2.getInputStream();
				objectInputStream_UAV2_latitude = new ObjectInputStream(inputStream_UAV2_latitude);
				UAV2_latitude = (float) objectInputStream_UAV2_latitude.readObject();

				inputStream_UAV2_longitude = socket_UAV2.getInputStream();
				objectInputStream_UAV2_longitude = new ObjectInputStream(inputStream_UAV2_longitude);
				UAV2_longitude = (float) objectInputStream_UAV2_longitude.readObject();

				System.out.println("UAV2 battery : " + UAV2_battery);
				System.out.println("UAV2 latitude : " + UAV2_latitude);
				System.out.println("UAV2 longitude : " + UAV2_longitude);

				// Text file writing

				fileWriterTest_UAV2 = new FileWriter(command_UAV2);
				String text_UAV2 = "22.22222\n222.222222\n1.5";
				fileWriterTest_UAV2.write(text_UAV2);
				fileWriterTest_UAV2.flush();

				// Text file transfer to client 2

				outputStream_UAV2 = socket_UAV2.getOutputStream();

				fileInputStream_UAV2 = new FileInputStream("C:/test/command_UAV2.txt");

				byte[] dataBuff = new byte[10000];
				int length = fileInputStream_UAV2.read(dataBuff);
				while (length != -1) {
					outputStream_UAV2.write(dataBuff, 0, length);
					length = fileInputStream_UAV2.read(dataBuff);
				}
				System.out.println("Transfer Success");

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try {
					if (inputStream_UAV2_battery != null)
						inputStream_UAV2_battery.close();
					if (objectInputStream_UAV2_battery != null)
						objectInputStream_UAV2_battery.close();
					if (inputStream_UAV2_latitude != null)
						inputStream_UAV2_latitude.close();
					if (objectInputStream_UAV2_latitude != null)
						objectInputStream_UAV2_latitude.close();
					if (inputStream_UAV2_longitude != null)
						inputStream_UAV2_longitude.close();
					if (objectInputStream_UAV2_longitude != null)
						objectInputStream_UAV2_longitude.close();
					if (fileWriterTest_UAV2 != null)
						fileWriterTest_UAV2.close();
					if (fileInputStream_UAV2 != null)
						fileInputStream_UAV2.close();
					if (outputStream_UAV2 != null)
						outputStream_UAV2.close();
					if (socket_UAV2 != null)
						socket_UAV2.close();
					if (serverSocket_UAV2 != null)
						serverSocket_UAV2.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}
}
