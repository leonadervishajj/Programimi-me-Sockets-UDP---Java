import java.net.*;
import java.util.*;

public class UDPServer {

    public static void main(String[] args) {

        try {
            
            String IP_ADDRESS = "0.0.0.0";
            int porti = 9876;

            int maxKliente = 3;

            DatagramSocket socket = new DatagramSocket(porti);

            byte[] buffer = new byte[1024];

            Set<String> kliente = new HashSet<>();

            System.out.println("Serveri UDP është startuar në portin " + porti);

            while (true) {

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String klientID = packet.getAddress() + ":" + packet.getPort();

                String mesazhi = new String(packet.getData(), 0, packet.getLength());

                
                if (!kliente.contains(klientID) && kliente.size() >= maxKliente) {

                    String msg = "Serveri është i mbushur!";
                    byte[] data = msg.getBytes();

                    DatagramPacket reject = new DatagramPacket(
                            data,
                            data.length,
                            packet.getAddress(),
                            packet.getPort()
                    );

                    socket.send(reject);
                    continue;
                }

                kliente.add(klientID);

                System.out.println("[" + klientID + "] " + mesazhi);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}