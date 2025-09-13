package com.loganv308;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final MountScanner fileOperation = new MountScanner();

    public static void main(String[] args) throws Exception {
        String mounts;
        List<Mountpoint> matchMounts = new ArrayList<>();

        // Checking if mounts are present, matching, etc.  
        // -----------------------------------------------------------------------------
        while (matchMounts.isEmpty()) {

            // Check for mounts, returns regexed string of mounts. 
            mounts = fileOperation.checkForMounts();

            // Extracts mountpoints from the mounts string, puts them into Mountpoint object. 
            matchMounts = fileOperation.extractMountPoints(mounts);

            // If matchmount list is Empty, then it will attempt to remount. 
            // When the mounts are finally mounted, it will break this loop because the list isn't empty. 
            if (matchMounts.isEmpty()) {
                Thread.sleep(1000 * 5 * 60);
                
                // Attempt to remount if mounts aren't present.
                fileOperation.remount();
            }
        // -----------------------------------------------------------------------------
        }

        String containerName = "qbittorrent";

        Container cunt = new Container();

        ContainerStatus qbittorrent = cunt.checkContainerStatus(containerName);

        System.out.println(qbittorrent);
    }
}