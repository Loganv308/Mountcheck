package com.loganv308;

public class Mountpoint {
    
    // Path on the Server the mount is mounted too 
    private String mountPath;
    
    // What the mountPath is pointed too: //192.168.1.96/<path> 
    private String serverPath;

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
}
