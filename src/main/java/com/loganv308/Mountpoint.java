package com.loganv308;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mountpoint {
    
    // Path on the Server the mount is mounted too 
    private String mountPath;
    
    // What the mountPath is pointed too: //192.168.1.96/<path> 
    private String serverPath;

    public Mountpoint(String mountString, String serverString) {
        this.mountPath = mountPath;
        this.serverPath = serverPath;
    }

    public Mountpoint() {
    }

    public String getMountPath() {
        return mountPath;
    }

    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public static List<String> extractMountPoints(String mountOutput) {
        List<String> mountPoints = new ArrayList<>();

        Pattern pattern = Pattern.compile("//\\b(?:(?:2(?:[0-4][0-9]|5[0-5])|[0-1]?[0-9]?[0-9])\\.){3}(?:(?:2([0-4][0-9]|5[0-5])|[0-1]?[0-9]?[0-9]))\\b/[A-Za-z]+");
        Matcher matcher = pattern.matcher(mountOutput);

        while (matcher.find()) {
            mountPoints.add(matcher.group(0));
        }
        
        return mountPoints;
    }
}
