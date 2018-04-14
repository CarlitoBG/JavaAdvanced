package ExamPreparation02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03BitRoller {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        int frozenBitPosition = Integer.parseInt(reader.readLine());
        int rollTimes = Integer.parseInt(reader.readLine());

        for (int i = 0; i < rollTimes; i++) {

            int firstBitValue = number & 1; // takes firstBitValue;

            int frozenBitValue = (number >> frozenBitPosition) & 1;
            int skipBitPosition = frozenBitPosition != 18 ? frozenBitPosition + 1 : 0;
            int skipBitValue = (number >> skipBitPosition) & 1;

            number >>= 1; // rolls right 1 time the 19-bit number;

            if (frozenBitPosition != 0){
                number |= firstBitValue << 18; // put firstBitValue on lastBitPosition;
                number &= ~(3 << frozenBitPosition - 1);  // set skipBitValue and frozenBitValue to 0;

                number |= frozenBitValue << frozenBitPosition;   // put frozenBitValue on frozenBitPosition;
                number |= skipBitValue << frozenBitPosition - 1; // put skipBitValue on skipBitPosition;
            }else {
                number &= ~(1);       // set firstBitValue to 0;
                number &= ~(1 << 18); // set lastBitValue to 0;

                number |= frozenBitValue;     // put frozenBitValue on frozenBitPosition[0];
                number |= skipBitValue << 18; // put skipBitValue on skipBitPosition[18];
            }
        }

        System.out.println(number);
    }
}