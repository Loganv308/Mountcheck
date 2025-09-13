package com.loganv308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// This class will be used to identify qbittorrent, then stop temporarily. 
public class Container {

    Container() {

    }

    // Checks whether or not the container is running
    // docker inspect -f '{{.State.Status}}' qbittorrent
    public ContainerStatus checkContainerStatus(String containerName) {

        String[] s = {"/bin/sh", "-c", "docker inspect -f '{{.State.Status}}' ", containerName};

        StringBuilder output = new StringBuilder();

        Process p = null;

        try {
            // Execution of runtime command
            p = Runtime.getRuntime().exec(s);
            
            // Read standard output
            BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            String line;

            while ((line = stdOut.readLine()) != null) {
                output.append(line);
                System.out.println("STDOUT: " + line); // print live output
            }

            while ((line = stdErr.readLine()) != null) {
                System.out.println("STDERR: " + line); // print errors if any
            }

            // Wait for process to finish and then destroy
            p.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return ContainerStatus.UNKNOWN;
        } finally {
            if(p != null) {
                p.destroy();
            }
        }

        // Check the output
        String status = output.toString().trim().toLowerCase();

        System.out.println("STATUS: " + output + ".");
        if (status.equals("running")) {
            return ContainerStatus.RUNNING;
        } else {
            return ContainerStatus.EXITED;
        }
    }
}
