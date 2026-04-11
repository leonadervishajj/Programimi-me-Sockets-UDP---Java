import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MesazhetNgaKlienti {
    private List<String> messages = new ArrayList<>();
    public void addMessage(String msg){    // behet ruajtja ne memorie
        messages.add(msg);
        saveToFile(msg);
    }
    public void saveToFile(String msg){
        try(FileWriter fw = new FileWriter("mesazhet.log", true)){
            fw.write(msg + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<String>getMessages(){
        return messages;
    }
}
