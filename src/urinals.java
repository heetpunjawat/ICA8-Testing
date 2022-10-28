//Author - Heet Punjawat
import java.io.*;
import java.net.URL;
import java.util.*;

public class urinals {

    public static int countUrinals(String str)
    {
        if(str.replaceAll("\\s", "").length() == 0 ||
                str.replaceAll("\\s", "").length() >=21 )
            return -1;

        for(int i = 0; i < str.length()-1; i++)
        {
            if (str.charAt(i) == '1' && str.charAt(i+1) == str.charAt(i) || !Character.isDigit(str.charAt(i)))
            {
                return -1;
            }
        }

        StringBuilder stringBuilder = new StringBuilder(str);
        int count = 0;

        if(stringBuilder.charAt(1) == '0' && stringBuilder.charAt(0) == '0') {
            stringBuilder.setCharAt(0, '1');
            count = count + 1;
        }

        for(int i = 1; i< str.length() -1; i++)
        {
            if(stringBuilder.charAt(i-1) == '0' && stringBuilder.charAt(i) == '0' &&
                    stringBuilder.charAt(i+1) == '0')
            {

                stringBuilder.setCharAt(i, '1');
                count = count + 1;
            }

        }

        if(stringBuilder.charAt(stringBuilder.length()-1) == '0' && stringBuilder.charAt(stringBuilder.length()-2) == '0')
        {
            stringBuilder.setCharAt(stringBuilder.length()-1, '1');
            count = count +1;
        }

        return count;
    }

    public  String readFile() throws IOException {
        StringBuilder sb = new StringBuilder();
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL fileURL = classLoader.getResource("urinal.dat");
        if(fileURL != null)
        {
            File file = new File(fileURL.getFile());
            InputStream in = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + System.lineSeparator());
            }

        }

        return sb.toString();

    }

    public static void fileProcess() throws IOException {
        urinals urinals = new urinals();
        String ans  = urinals.readFile();
        int i = 0;
        String filename = "rule";
        File f = new File(filename + ".txt");
        while (f.exists()) {
            i += 1;
            f = new File(filename + String.valueOf(i) + ".txt");
        }
        FileWriter output;
        if (i == 0){
            output = new FileWriter(filename + ".txt");
        }
        else {
            output = new FileWriter(filename + String.valueOf(i) + ".txt");
        }
        ans += "\n";
        output.write(ans);
        output.close();
    }

    public static void main(String[] args) {
        try {
            fileProcess();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
