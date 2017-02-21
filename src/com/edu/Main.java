package com.edu;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	 //   SimpleDeadlockExample simpleDeadlockExample = new SimpleDeadlockExample();
     //   simpleDeadlockExample.doDeadLock();

        ArrayList<String> list = new ArrayList<String>();
        File file = new File("test.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                //list.add(new String(line.substring(0, 2)));
                list.add(line.substring(0, 2));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Thread.sleep(10000);


    }
}
