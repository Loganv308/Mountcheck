package com.loganv308;

public class Main {

    private static final FileOperation fileOperation = new FileOperation();

    public static void main(String[] args) {

        while(true) {
            try {

                fileOperation.checkForMounts();

                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}