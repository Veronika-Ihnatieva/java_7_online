package hw_1_3;

import java.util.Scanner;

public class EndOfLesson {
    public static void main (String [] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("введите номер урока (число от 1 до 10): ");
        String InputData = scan.nextLine();
        System.out.println("входные данные: " + InputData);

        int a = Integer.parseInt(InputData);

        int c = 540 + a * 45 + (a - 1) * 5 + ((a - 1) / 2) * 10;

        int d = c / 60;

        int f = c % 60;

        System.out.println("выходные данные: " + d + " " + f);

    }
}
