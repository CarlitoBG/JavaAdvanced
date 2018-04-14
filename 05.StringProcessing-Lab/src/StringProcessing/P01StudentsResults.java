package StringProcessing;

import java.util.Scanner;

public class P01StudentsResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" - ");
        String[] grades = input[1].split(", ");
        String studentName = input[0];
        double javaAdvGrade = Double.parseDouble(grades[0]);
        double javaOOPGrade = Double.parseDouble(grades[1]);
        double advOOPGrade = Double.parseDouble(grades[2]);

        double average = (javaAdvGrade + javaOOPGrade + advOOPGrade) / 3;

        System.out.println(
                String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));

        System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
                studentName, javaAdvGrade, javaOOPGrade, advOOPGrade, average));
    }
}