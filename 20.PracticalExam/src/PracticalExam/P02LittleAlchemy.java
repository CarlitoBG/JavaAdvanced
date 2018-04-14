package PracticalExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P02LittleAlchemy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] stonesSequence = reader.readLine().split("\\s+");

        Deque<Integer> stones = new ArrayDeque<>(); //queue
        Deque<Integer> storage = new ArrayDeque<>(); // stack

        for (String s : stonesSequence) {
            int stone = Integer.parseInt(s);
            stones.addLast(stone);
        }

        while (true){
            String[] commandParams = reader.readLine().split("\\s+");

            if ("Revision".equals(commandParams[0])){
                break;
            }

            String command = commandParams[0];
            int value  = Integer.parseInt(commandParams[2]);

            if ("Apply".equals(command)){
                for (int i = 0; i < value; i++) {
                    if (!stones.isEmpty()){
                        int currentStone = stones.poll();
                        currentStone--;

                        if (currentStone > 0){
                            stones.addLast(currentStone);
                        }else {
                            storage.addLast(currentStone);
                        }
                    }
                }
            }else if ("Air".equals(command) && !storage.isEmpty()){
                stones.addLast(value);
                storage.pop();
            }
        }

        System.out.println(stones.toString().replaceAll("[\\[\\],]", ""));
        System.out.println(storage.size());
    }
}