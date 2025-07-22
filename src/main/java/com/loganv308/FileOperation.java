package com.loganv308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileOperation {

    private static Process p;

    // Work on regexing the file paths to pass into another method which will remount the mounts. 
    public void checkForMounts() {
        // String array containing command to be executed by Runtime.getRuntime().exec()
        String[] s = {"/bin/sh", "-c", "mount | grep //192.168.1.69/"};
        try {
            // Execution of runtime command
            p = Runtime.getRuntime().exec(s);
            // Read standard output
            BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
            // Read standard error
            BufferedReader stdErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String line;

            System.out.println("--- Standard Output ---");
            while ((line = stdOut.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("--- Standard Error ---");
            while ((line = stdErr.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();
            System.out.println ("exit code: " + p.exitValue());
            p.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void remount() {
        // This command will re-mount all mounts based on the /etc/fstab file
        String[] s = {"/bin/sh", "-c", "mount -a"};

        try {
            // Execution of runtime command
            p = Runtime.getRuntime().exec(s);
            // Read standard output
            BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
            // Read standard error
            BufferedReader stdErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String line;

            System.out.println("--- Standard Output ---");
            while ((line = stdOut.readLine()) != null) {
                System.out.println(line);
            }

            System.out.println("--- Standard Error ---");
            while ((line = stdErr.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();
            System.out.println ("exit code: " + p.exitValue());
            p.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
