public class Serveri{
import java.net.*;
import java.util.*;

public class UDPServer {

    private static final int PORT = 5000;
    private static final int MAX_CLIENTS = 3;

    private static Set<String> clients = new HashSet<>();

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("UDP Server running on port " + PORT);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String msg = new String(packet.getData(), 0, packet.getLength());
                String clientAddress = packet.getAddress().toString() + ":" + packet.getPort();

                System.out.println("Message from " + clientAddress + ": " + msg);

                // kontrollo numrin e klientëve
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

                // përgjigje normale
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
}
}

