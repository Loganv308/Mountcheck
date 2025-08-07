package com.loganv308;

public class Media {
    private String filePath; // Filepath to the file itself
    private String destination; // Destination where the file should go (Same path once it's mounted)
    private String fileType; // TVShow, Movie, Etc

    public Media(String destination, String filePath, String fileType) {
        this.destination = destination;
        this.filePath = filePath;
        this.fileType = fileType;
    }
    
    public String getFilePath() {
        return filePath;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFileType() {
        return fileType;
    }
    
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Media{");
        sb.append("filePath=").append(filePath);
        sb.append(", destination=").append(destination);
        sb.append(", fileType=").append(fileType);
        sb.append('}');
        return sb.toString();
    }
}
