package com.loganv308;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FileOperation {

    private static Process p;

    public void checkForMounts() {
        String s;
        
        try {
            p = Runtime.getRuntime().exec("src/main/java/com/loganv308/scripts/checkMounts.sh");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
