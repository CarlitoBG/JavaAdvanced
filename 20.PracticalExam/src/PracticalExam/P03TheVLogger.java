package PracticalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P03TheVLogger {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, VLogger> vLogger = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!"Statistics".equals(input)) {
            String[] inputParams = input.split("\\s+");

            String user = inputParams[0];
            String command = inputParams[1];

            switch (command) {
                case "joined":
                    vLogger.putIfAbsent(user, new VLogger(user));
                    break;
                case "followed":
                    String vloggerFollowedBy = inputParams[2];

                    if (vloggerFollowedBy.equals(user)) {
                        break;
                    }

                    if (vLogger.containsKey(vloggerFollowedBy) && vLogger.containsKey(user)) {

                        boolean isAlreadyFollowedByUser = vLogger.get(vloggerFollowedBy).followers.contains(user);

                        if (!isAlreadyFollowedByUser) {
                            vLogger.get(vloggerFollowedBy).followers.add(user);
                            vLogger.get(user).following++;
                        }
                    }
            }

            input = reader.readLine();
        }

        LinkedList<VLogger> sortedVloggers = new LinkedList<>();

        vLogger.values()
                .stream()
                .sorted((v1, v2) -> {
                    if (v1.followers.size() != v2.followers.size()) {
                        return Integer.compare(v2.followers.size(), v1.followers.size());
                    }
                    return Integer.compare(v1.following, v2.following);
                })
                .forEach(sortedVloggers::add);

        System.out.println(String.format("The V-Logger has a total of %d vloggers in its logs.", vLogger.size()));

        boolean isFirst = true;
        int counter = 0;

        for (VLogger vlogger : sortedVloggers) {
            counter++;
            System.out.println(String.format("%d. %s : %d followers, %d following",
                    counter, vlogger.userName, vlogger.followers.size(), vlogger.following));

            if (isFirst) {
                vlogger.followers.forEach(f -> System.out.println(String.format("*  %s", f)));
                isFirst = false;
            }
        }
    }

    static class VLogger {
        String userName;
        TreeSet<String> followers;
        int following;

        VLogger(String userName) {
            this.userName = userName;
            this.followers = new TreeSet<>();
            this.following = 0;
        }
    }
}