//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        //Sistema operativo
        String os = System.getProperty("os.name");
        String command = "";
        String directory = "";

        //crear el comando dependiendo del SO
        if(os.toLowerCase().startsWith("Linux")){
            command = "sh -c ls -l";
            directory = "/tmp";
        }
        else{
            command = "cmd/ c dir";
            directory = "c:/temp";
        }

        try {
            ProcessBuilder pBuilder = new ProcessBuilder(command.split("\\s"));
            pBuilder.directory(new File(directory));
            //creo un nuevo proceso
            Process process = pBuilder.start();
            //Stream del process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            reader.lines().forEach(System.out::println);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
