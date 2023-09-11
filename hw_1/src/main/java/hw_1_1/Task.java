package hw_1_1;

import java.util.Scanner;

public class Task {
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println("введите данные:");
        String inputData = scan.nextLine();
        System.out.println("входные данные: " + inputData);

        String str=inputData.replaceAll("[^0-9]", "");

        String[] strArr = str.split("");

        int[] numArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
             }
        int sum = 0;
        for (int i : numArr) {
            sum = sum + i;
        }
        System.out.println("выходные данные: " + sum);
    }
}
