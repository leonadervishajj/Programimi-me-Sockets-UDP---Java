import java.net.*;
import java.util.*;

public class UDPServer{

    private static final String Server_IP = "127.0.0.1";
    private static final int SERVER_PORT = 5000;

    private static final int MAX_CLIENTS = 3;
    private static Set<String> clients = new HashSet<>();

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(SERVER_PORT, InetAddress.getbyName(Server_IP));
            System.out.println("UDP Server running on port " + SERVER_IP + ":" + SERVER_PORT);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String msg = new String(packet.getData(), 0, packet.getLength());
                String clientAddress = packet.getAddress().toString() + ":" + packet.getPort();

                System.out.println("Message from " + clientAddress + ": " + msg);

                
                if (!clients.contains(clientAddress)) {
                    if (clients.size() >= MAX_CLIENTS) {
                        String response = "Server full!";
                        sendResponse(socket, packet, response);
                        continue;
                    } else {
                        clients.add(clientAddress);
                        System.out.println("New client added: " + clientAddress);
                    }
                }

                
                String response = "Server received: " + msg;
                sendResponse(socket, packet, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendResponse(DatagramSocket socket, DatagramPacket packet, String msg) throws Exception {
        byte[] responseData = msg.getBytes();

        DatagramPacket response = new DatagramPacket(
                responseData,
                responseData.length,
                packet.getAddress(),
                packet.getPort()
        );

        socket.send(response);
    }

private static String handleRequest(String msg) {

     switch (Message.toLowerCase()) {

            case "hello":
                return "Përshëndetje nga serveri!";

            case "time":
                return new Date().toString();

            case "bye":
                return "Mirupafshim!";

            default:
                return "Kërkesë e panjohur";
        }
    }
}
