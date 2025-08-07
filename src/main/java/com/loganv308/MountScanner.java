package com.loganv308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MountScanner {

    private static Process p;
    private static final Pattern regPattern = Pattern.compile("//((?:\\d{1,3}\\.){3}\\d{1,3})(/\\w+)");
    private static final List<Mountpoint> mountPoints = new ArrayList<>();

    // Work on regexing the file paths to pass into another method which will remount the mounts. 
    public String checkForMounts() {
        // String array containing command to be executed by Runtime.getRuntime().exec()
        String[] s = {"/bin/sh", "-c", "mount | grep //192.168.1.69/"};

        StringBuilder output = new StringBuilder();

        try {
            // Execution of runtime command
            p = Runtime.getRuntime().exec(s);
            // Read standard output
            BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;

            System.out.println("--- Standard Output ---");
            while ((line = stdOut.readLine()) != null) {
                output.append(line).append("\n");
            }

            p.waitFor();
            System.out.println ("exit code: " + p.exitValue());
            p.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public void remount() {
        // This command will re-mount all mounts based on the /etc/fstab file
        String[] s = {"/bin/sh", "-c", "mount -a"};

        try {
            // Execution of runtime command
            p = Runtime.getRuntime().exec(s);
            // Read standard output
            BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;

            System.out.println("--- Standard Output ---");
            while ((line = stdOut.readLine()) != null) {
                System.out.println(line);
            }

            p.waitFor();
            System.out.println ("exit code: " + p.exitValue());
            p.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Mountpoint> extractMountPoints(String mountOutput) {
        Matcher matcher = regPattern.matcher(mountOutput);

        while (matcher.find()) {
            String mountSource = matcher.group(1); // Server Path 
            String serverPath = matcher.group(2); // MountSource (Network Share)

            Mountpoint mountPoint = new Mountpoint(serverPath, mountSource);
            
            mountPoints.add(mountPoint);
        }
        
        return mountPoints;
    }

    // Implement
    public List<Media> extractMedia() {
        return null;
    }
}
