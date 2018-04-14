package ExamPreparation02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02LetterExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Pattern pattern = Pattern.compile("(?<symbols>\\D*)(?<num>\\d+)");

        Matcher matcher = pattern.matcher(input);

        int result = 0;

        while (matcher.find()){
            int number = Integer.parseInt(matcher.group("num"));

            if (matcher.group("symbols").length() % 2 == 0){
                result += number;
            }else {
                result -= number;
            }
        }

        System.out.println(result);
    }
}