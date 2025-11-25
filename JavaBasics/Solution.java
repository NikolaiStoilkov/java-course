import java.io.*;
import java.text.*;
import java.util.*;
import static java.lang.Integer.parseInt;

import static java.util.stream.Collectors.joining;


public class Solution {

    public void main(String[] args) throws IOException {
        mathQueries();
    }

    void mathQueries() {
        // query formula (a + 2^n * b)

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