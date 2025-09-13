package com.loganv308;

public class Media {
    private String filePath; // Filepath to the file itself
    private String destination; // Destination where the file should go (Same path once it's mounted)
    private MediaType mediaType; // TVShow, Movie, Etc

    public Media(String destination, String filePath, MediaType mediaType) {
        this.destination = destination;
        this.filePath = filePath;
        this.mediaType = mediaType;
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

    public MediaType getFileType() {
        return mediaType;
    }
    
    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Media{");
        sb.append("filePath=").append(filePath);
        sb.append(", destination=").append(destination);
        sb.append(", mediaType=").append(mediaType);
        sb.append('}');
        return sb.toString();
    }
}
