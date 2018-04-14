package StringProcessing;

import java.util.Scanner;

public class P02ParseURL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] params = input.split("://");

        if (params.length != 2){
            System.out.println("Invalid URL");
            return;
        }

        String protocol = params[0];
        String server = params[1].substring(0, params[1].indexOf("/"));
        String resources = params[1].substring(params[1].indexOf("/") + 1, params[1].length());

        System.out.printf("Protocol = %s\nServer = %s\nResources = %s", protocol, server, resources);
    }
}