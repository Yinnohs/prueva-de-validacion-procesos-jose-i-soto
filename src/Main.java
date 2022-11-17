import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final int PROCESS_QUANTITY = 10;
        int counter = 0;
        List<Process> proccessList = new ArrayList<>();
        for (int i = 0; i < PROCESS_QUANTITY ; i++) {
            try {
                Process  process = Runtime.getRuntime().exec("timeout 3");
                Calendar currentTime = Calendar.getInstance();
                System.out.println(
                        "iniciando procceso con PID: " + process.pid() + " a las " + currentTime.get(Calendar.HOUR)
                                + ":" + currentTime.get(Calendar.MINUTE) + ":" + currentTime.get(Calendar.SECOND)
                );
                proccessList.add(process);
                ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (counter != 10){
            for (int i = 0; i < proccessList.size() ; i++) {

                System.out.println("Terminado el proceso con PID: " + proccessList.get(i).pid());
                proccessList.remove(i);
                counter ++;
            }
        }
    }
}
