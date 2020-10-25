package newDz;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String key =  "101";
        String text = "110011011";


        // Массив оригинала
        ArrayList<String> listOfMessages = new ArrayList<>();

        // Массив оригинала в двочиной
        ArrayList<String> listOfBinars = new ArrayList<>();

        // Массив в оригинала XOR
        ArrayList<String> listOfXORBianrs = new ArrayList<>();


        // Массив Коллизий
        ArrayList<String> listOfKolliziy = new ArrayList<>();

        // Второй массив коллизий
        ArrayList<String> listOfKeyKolliziy = new ArrayList<>();



        // Вводим
        System.out.println("Введите количество строк");
        int count = Integer.parseInt(reader.readLine());

        System.out.println("Введите  ключ");
        String Key = reader.readLine();

        String  listOfXORBianrs1 = "";

        char[] mk = Key.toCharArray();
        ArrayList<String> binaryKey = new ArrayList<>();

        // Получили ключ в двоичном
        for (int i = 0; i < mk.length; i++) {
           String put = Integer.toBinaryString((int) mk[i]).length() < 7 ? "00" + Integer.toBinaryString((int) mk[i]) :
                   Integer.toBinaryString((int) mk[i]).length() < 8 ? "0" + Integer.toBinaryString((int) mk[i]) : Integer.toBinaryString((int) mk[i]);

             binaryKey.add(put);
        }


        System.out.println(binaryKey);
        System.out.println(Integer.toBinaryString(249));






        for (int i = 0; i < count; i++) {

            System.out.println("Введите " + i + 1 + " строку");

            // Читаем строку и добавляет в оригинал
            String message = reader.readLine();
            listOfMessages.add(message);


            char[] c = message.toCharArray();

            int m = 0;
            for (int j = 0; j < c.length; j++) {
                int tryToCatch = (int) c[j];

                String a = Integer.toBinaryString(tryToCatch);

//                String zxc = Integer.toBinaryString((int) c[j]).length() < 7 ? "00" + Integer.toBinaryString((int) c[j]) :
//                        Integer.toBinaryString((int) c[j]).length() < 8 ? "0" + Integer.toBinaryString((int) c[j]) : Integer.toBinaryString((int) c[j]);

                String zxc1 = a.length() < 7 ? "00" + a:
                        a.length() < 8 ? "0" + a: a;


                int bin = Integer.parseInt(zxc1);
                listOfBinars.add(zxc1);


                // Отксорить
                XOR.maz1(listOfBinars, binaryKey, j, m, listOfXORBianrs);

                if (m + 1 == binaryKey.size()) m = 0;

            }





        }



        int k = 0;
        for (int i = 0; i < listOfXORBianrs.size(); i++) {
            // Смотрим есть ли коллизии в массиве коллизий
            for (String m: listOfKolliziy) {
                if (m.equals(listOfXORBianrs.get(i))) {
                    continue;
                }
            }



//            if (listOfKolliziy.contains(listOfXORBianrs.get(i))) {
//                continue;
//            }


            boolean flag = false;
            for (int j = i + 1; j < listOfBinars.size(); j++) {
                if (listOfXORBianrs.get(j).equals(listOfXORBianrs.get(i))) {
                    flag = true;
                }
            }
            if (flag) {
                listOfKolliziy.add(listOfXORBianrs.get(i));
                listOfKeyKolliziy.add(binaryKey.get(k));

            }
            k++;

            if (k == binaryKey.size()) k = 0;


        }

        for (int i = 0; i < listOfKeyKolliziy.size(); i ++) {
            System.out.println(Integer.parseInt(listOfKeyKolliziy.get(i), 2));
            System.out.println("kekw");

        }





        System.out.println(listOfBinars);
        System.out.println(listOfXORBianrs);
        System.out.println(listOfKolliziy);
        System.out.println(listOfKeyKolliziy);

    }


}
