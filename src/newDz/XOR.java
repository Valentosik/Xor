package newDz;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;

public class XOR {



    public static String maz1(String key, String text) {
        String result = "";
        if (key.length() < text.length()) {
            char[] key1 = key.toCharArray();
            char[] text1 = text.toCharArray();

            int m = 0;

            for (int i = 0; i < text1.length; i++) {


                if (key1[m] != text1[i]) {
                    result = result + "1";
                } else {
                    result = result + "0";
                }

                m++;

                if (m == key1.length) {
                    m = 0;
                }

            }


        }
        return result;
    }


    public static void maz1(ArrayList<String> listOFbinars, ArrayList<String> listOfKeys, int j, int k, ArrayList<String> XORBinars) {
            char[] key1 = listOFbinars.get(j).toCharArray();
            char[] text1 = listOfKeys.get(k).toCharArray();
            String result = "";

            for (int i = 0; i < text1.length; i++) {


                if (key1[i] != text1[i]) {
                    result = result + "1";
                } else {
                    result = result + "0";
                }

            }

            XORBinars.add(result);

            ArrayList<String> asd = new ArrayList<>();
            asd.add("101");
            asd.add("112");
            String ab = "112";

            if (Arrays.asList(asd).contains(ab)) {
                System.out.println("kekw");
            }


    }








    public static String binar(int a){
        int b;
        String temp = "";
        while(a !=0){
            b = a%2;
            System.out.println(b);
            temp = b + temp;
            a = a/2;
        }
        return temp;
    }


    public static void main(String[] args) {
        ArrayList<Integer> listOfBinars = new ArrayList<>();
        String s = "I go";
        char c[] = s.toCharArray();

        for (int i = 0; i < c.length; i++) {
            System.out.println((int) c[i]);
            String bin = Integer.toBinaryString((int) c[i]);

            System.out.println(bin);
        }
    }


}
