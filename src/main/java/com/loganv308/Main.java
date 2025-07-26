package com.loganv308;

import java.util.List;

public class Main {

    private static final FileOperation fileOperation = new FileOperation();

    public static void main(String[] args) {

        while(true) {
            try {

                String mounts = fileOperation.checkForMounts();

                System.out.println(mounts);

                List<String> matchMounts = Mountpoint.extractMountPoints(mounts);

                for (String match : matchMounts) {
                    System.out.println(match);
                }

                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}