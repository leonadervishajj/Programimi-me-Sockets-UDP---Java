public class KerkesatePajisjeve {
    private static String handleRequest(String msg) {

    msg = msg.trim();


    if (msg.equalsIgnoreCase("LIST")) {
        return listFiles();
    }

    // 📖 READ FILE
    if (msg.startsWith("READ")) {
        return readFile(msg);
    }


    if (msg.startsWith("DELETE")) {
        return deleteFile(msg);
    }

    return "Unknown request";
}
}
