package StringProcessing;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P14SumOfAllValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keysString = scanner.nextLine();
        String textString = scanner.nextLine();

        Pattern keys = Pattern.compile("^([A-Za-z_]+)(?=\\d).*(?<=\\d)([A-Za-z_]+)$");
        Matcher matcherKeys = keys.matcher(keysString);

        if (matcherKeys.find()){
            String startKey = matcherKeys.group(1);
            String endKey = matcherKeys.group(2);

            Pattern number = Pattern.compile(startKey + "(\\d*(?:\\.\\d+)?)" + endKey);
            Matcher matcherNumber = number.matcher(textString);

            double sum = 0d;
            while (matcherNumber.find()){
                sum += Double.parseDouble(matcherNumber.group(1));
            }

            if (sum != 0d){
                if (sum == (int)sum){
                    System.out.printf("<p>The total value is: <em>%d</em></p>", (int)sum);
                }else {
                    System.out.printf("<p>The total value is: <em>%.2f</em></p>", sum);
                }
            }else {
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            }
        }else{
            System.out.println("<p>A key is missing</p>");
        }
    }
}