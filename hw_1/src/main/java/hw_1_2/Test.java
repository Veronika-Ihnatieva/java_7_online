package hw_1_2;

import java.util.*;

public class Test {
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println("введите данные");
        String inputData = scan.nextLine();
        System.out.println("входные данные: " + inputData);

        String str=inputData.replaceAll("[^a-z]", "");

        String[] strArr = str.split("");

        Arrays.sort (strArr);

        Map<String, Integer> mp = new HashMap<String, Integer>();

        for (String string : strArr) {

            if(mp.containsKey(string)) {
                mp.put(string, mp.get(string) + 1);

            } else {
                mp.put(string, 1);
            }
        }

        int i = 1;
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            System.out.print( i + "." + entry.getKey() + "-" + entry.getValue() + " ");

            ++i;
        }
    }
}


