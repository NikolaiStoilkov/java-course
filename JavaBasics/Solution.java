import java.io.*;
import java.text.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Solution {
    public void main(String[] args) {

    }

    void readEachLineOfFile() {
//        File file = new File("src/input.txt");
        FileNumber fileNumber = new FileNumber();

        try (Scanner currentFile = new Scanner(System.in)) {
            while (currentFile.hasNextLine()) {
                String fileNextLine = currentFile.nextLine();

                fileNumber.addNumbersToForwardedLine(fileNextLine);
            }
        }
    }

    static class FileNumber {
        public int lineCount = 1;

        public FileNumber() {

        }

        public void addNumbersToForwardedLine(String line) {
            System.out.println(lineCount + " " + line);
            increaseLineCounter();
        }

        void increaseLineCounter() {
            lineCount++;
        }
    }

    void holdIntegerValues() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");

                Range r = new Range(x);
                r.isInRange();

            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }
        sc.close();
    }

    class Range {
        private long range;

        public Range(long range) {
            this.range = range;
        }

        public void isInRange() {
            if (range >= Byte.MIN_VALUE && range <= Byte.MAX_VALUE) {
                System.out.println("* byte");
            }

            if (range >= Short.MIN_VALUE && range <= Short.MAX_VALUE) {
                System.out.println("* short");
            }

            if (range >= Integer.MIN_VALUE && range <= Integer.MAX_VALUE) {
                System.out.println("* int");
            }

            if (range >= Long.MIN_VALUE && range <= Long.MAX_VALUE) {
                System.out.println("* long");
            }
        }
    }

    void mathQueries() {
        // query formula (a + 2^n-1 * b)

        Scanner scanner = new Scanner(System.in);
        LinkedList<int[]> queryValues = new LinkedList<>();

        int queriesCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < queriesCount; i++) {
            String input = scanner.nextLine();

            int a = parseInt(input.split(" ")[0]);
            int b = parseInt(input.split(" ")[1]);
            int n = parseInt(input.split(" ")[2]);

            queryValues.add(
                    new int[]{a, b, n}
            );

        }

        scanner.close();

        LinkedList<LinkedList<Integer>> nums = new LinkedList<LinkedList<Integer>>();

        queryValues.forEach((query) -> {
            int a = query[0];
            int b = query[1];
            int n = query[2];

            LinkedList<Integer> tempList = new LinkedList<Integer>();

            for (int i = 1; i <= n; i++) {

                int tempNumb = 0;
                int initial = 1;
                for (int j = 1; j <= i; j++) {
                    tempNumb += initial * b;

                    if (initial == 1) {
                        initial++;
                    } else {
                        initial = initial * 2;
                    }
                }

                tempList.add(a + tempNumb);
            }

            nums.add(tempList);
        });

        nums.forEach((list) -> {
            list.forEach((index) -> {
                System.out.print(index + " ");
            });
            System.out.println();
        });
    }

    void javaLoops() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        bufferedReader.close();

        for (int i = 1; i <= 10; i++) {
            System.out.println(N + " x " + i + " = " + (N * i));
        }
    }

    void OutputFormatting() {
        LinkedHashMap<String, Integer> data = new LinkedHashMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String rawInput = scanner.nextLine();

            String[] splittedInput = rawInput.split(" ");

            data.put(splittedInput[0], parseInt(splittedInput[1]));
        }

        System.out.println("================================");
        data.forEach((key, value) -> {
            System.out.println(appendCharacters(key.toString()) + formatLeading(parseInt(value.toString())));
        });
        System.out.println("================================");
    }

    static String formatLeading(int value) {
        DecimalFormat df3digits = new DecimalFormat("000");

        return df3digits.format(value);
    }

    static String appendCharacters(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);

        while (stringBuilder.length() < 15) {
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    static void InputSolution() {

        Scanner scanner = new Scanner(System.in);

        int wholeNumber = scanner.nextInt();
        scanner.nextLine();

        double partNumbers = scanner.nextDouble();
        scanner.nextLine();

        String text = scanner.nextLine(); // Why is skipping here ?

        System.out.println("String: " + text);
        System.out.println("Double: " + partNumbers);
        System.out.println("Int: " + wholeNumber);
    }
}