package com.loganv308;

public class Mountpoint {
    
    // Path on the Server the mount is mounted too 
    private String mountPath;
    
    // What the mountPath is pointed too: //192.168.1.69/<path> 
    private String serverPath;

    public Mountpoint(String mountPath, String serverPath) {
        this.mountPath = mountPath;
        this.serverPath = serverPath;
    }

    // Blank constructor to access class 
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

    @Override
    public String toString() {
        return "Mountpoint [mountPath=" + mountPath + ", serverPath=" + serverPath + "]";
    }
}
