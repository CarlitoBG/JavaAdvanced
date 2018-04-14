package StreamAPI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class P14ExportToExcel {
    private static String DATA = "D:\\User\\Documents\\Programming\\04. Java Advanced\\07. Built-In Query Methods - Stream API\\StudentData.txt";
    private static final String SHEET_NAME = "Student_Data";

    public static void main(String[] args) throws IOException {
        writeInExcelFile();
    }

    private static void writeInExcelFile() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(SHEET_NAME);

        Map<Integer, Object[]> data = generateData();
        Set<Integer> keySet = data.keySet();

        int rowNum = 0;
        for (Integer key : keySet) {
            Row row = sheet.createRow(rowNum++);
            Object[] objArr = data.get(key);

            int cellNum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellNum++);

                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }

        try {
            String PATH = "D:/User/Documents/Programming/04. Java Advanced/07. Built-In Query Methods - Stream API/";
            FileOutputStream out = new FileOutputStream(new File(PATH + "Student Data.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println(SHEET_NAME + ".xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map<Integer, Object[]> generateData() throws IOException {
        Map<Integer, Object[]> data = new TreeMap<>();
        readDataInMap(data);
        return data;
    }

    private static void readDataInMap(Map<Integer, Object[]> data) throws IOException {
        Object[] columns = readColumns();

        Integer index = 1;
        data.put(index, columns);
        index++;

        try (BufferedReader reader = new BufferedReader(new FileReader(DATA))) {
            reader.readLine();

            for (String line; (line = reader.readLine()) != null; ) {

                String[] currentLine = line.split("\\s+");

                String facultyNumber = currentLine[0];
                String firstName = currentLine[1];
                String lastName = currentLine[2];
                String email = currentLine[3];
                int age = Integer.parseInt(currentLine[4]);
                int group = Integer.parseInt(currentLine[5]);
                List<Integer> grades = getGrades(Arrays.copyOfRange(currentLine, 6, 10));
                String phone = currentLine[10];

                List<Object> filledObjectList = new ArrayList<Object>() {{
                    add(facultyNumber);
                    add(firstName);
                    add(lastName);
                    add(email);
                    add(age);
                    add(group);
                }};
                filledObjectList.addAll(grades);
                filledObjectList.add(phone);

                data.put(index, filledObjectList.toArray());
                index++;
            }
        }
    }

    private static Object[] readColumns() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(DATA));

        String[] firstLine = reader.readLine().split("\t");
        reader.close();

        Object[] columns = new Object[firstLine.length];

        int index = 0;
        for (String currentElement : firstLine) {
            columns[index] = currentElement;
            index++;
        }
        return columns;
    }

    private static List<Integer> getGrades(String[] strings) {
        List<Integer> grades = new ArrayList<>();

        for (String string : strings) {
            grades.add(Integer.parseInt(string));
        }
        return grades;
    }
}