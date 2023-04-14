import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\student\\Desktop\\Tsahin\\CT-3-B-Spring-23\\CT-3-B-Spring-23\\dataset_info.txt"));
        String str;
        int[] arr1 = {0, 0, 0, 0, 0, 0};
        int[] arr2 = {0, 0, 0, 0, 0, 0}; // freq
        HashMap<String, Integer> Imagesss = new HashMap<>();

        ArrayList<OBJECTS> arrayList = new ArrayList<>();


        try {
            int i = 1;
            while (true) {
                str = reader.readLine();
//                if (str.equals(null))
                if (str.equals(""))
                    break;
                int fre = indexOf(str);
                Imagesss.put(str, fre); //hash
                arrayList.add(new OBJECTS(str, fre));
                arr2[i - 1] = fre;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        BufferedReader reader2 = new BufferedReader(new FileReader("C:\\Users\\student\\Desktop\\Tsahin\\CT-3-B-Spring-23\\CT-3-B-Spring-23\\dataset_info.txt"));

        int k = 3;
        // high fre index
        Collections.sort(arrayList, new CMP());

        for (int i = 0; i < k; i++) {
            OBJECTS o1 = arrayList.get(i);

            while (true) {
                str = reader2.readLine();
                if (str.equals(o1.string)) {

                    //-----------------------------------------
                    String[] name = str.split(",");
                    String s = name[2];


//                    FileInputStream fis = new FileInputStream("C:\\Users\\student\\Desktop\\Tsahin\\CT-3-B-Spring-23\\CT-3-B-Spring-23\\Image\\"+s);
//                    DataInputStream dis = new DataInputStream(fis);
//
//
//                    FileOutputStream fos = new FileOutputStream("C:\\Users\\student\\Desktop\\TAS\\ttt\\Sorted");
//                    DataOutputStream dos = new DataOutputStream(fos);


                    InputStream in = new FileInputStream("C:\\Users\\student\\Desktop\\Tsahin\\CT-3-B-Spring-23\\CT-3-B-Spring-23\\Image\\"+s);
                    OutputStream out = new FileOutputStream("C:\\Users\\student\\Desktop\\TAS\\ttt\\Sorted");

                    while (true) {
                        int c = in.read();
                        if (c == -1) break;
                        out.write(c);
                    }

                    byte[] b = new byte[1024];
                    int chunks = in.available() / b.length;
                    for (int i2 = 0; i2 < chunks; i2++) {
                        in.read(b);
                        out.write(b);
                    }

                    b = new byte[in.available()];
                    in.read(b);
                    out.write(b);






                    in.close();
                    out.close();







                    //-----------------------------------------


                }

            }




        }


    }

    public static int indexOf(String s) {
        String key = "happy";
        int freq = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(0) == key.charAt(0)) {
                if (s.charAt(i + 1) == key.charAt(1) && s.charAt(i + 1 + 1) == key.charAt(1 + 1) && s.charAt(i + 1 + 1 + 1) == key.charAt(1 + 1 + 1))
                    freq++;
            }
            i += 4;
        }
        if (freq > 0)
            return freq;
        else
            return -1;
    }
}
