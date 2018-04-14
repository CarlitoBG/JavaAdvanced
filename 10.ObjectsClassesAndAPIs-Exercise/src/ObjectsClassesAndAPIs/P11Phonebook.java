package ObjectsClassesAndAPIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P11Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String entry = reader.readLine();

        Map<String, String> phoneBook = new HashMap<>();

        while (!entry.equals("search")){

            String[] entryParams = entry.split("-");
            String name = entryParams[0];
            String phoneNumber = entryParams[1];

            if (!phoneBook.containsKey(name)){
                phoneBook.put(name, phoneNumber);
            }else {
                phoneBook.put(name, phoneNumber);
            }

            entry = reader.readLine();
        }

        entry = reader.readLine();

        while (!entry.equals("stop")){

            if (!phoneBook.containsKey(entry)){
                System.out.printf("Contact %s does not exist.\n", entry);
            }else {
                System.out.printf("%s -> %s\n", entry, phoneBook.get(entry));
            }

            entry = reader.readLine();
        }
    }
}