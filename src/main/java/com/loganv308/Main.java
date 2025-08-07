package com.loganv308;

import java.util.List;

public class Main {

    private static final MountScanner fileOperation = new MountScanner();

    public static void main(String[] args) {

        while(true) {
            try {

                String mounts = fileOperation.checkForMounts();

                List<Mountpoint> matchMounts = fileOperation.extractMountPoints(mounts);

                if(matchMounts.isEmpty()) {
                    System.out.println("Mounts not found.");
                }

                for (Mountpoint match : matchMounts) {

                    System.out.println(match);

                }

                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}