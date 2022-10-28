//Author - Heet Punjawat
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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string");
        String userInput = scanner.nextLine();
        System.out.println("The string is: " + userInput);



    }
}
