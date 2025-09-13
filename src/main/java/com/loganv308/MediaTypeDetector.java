package com.loganv308;

import java.io.File;
import java.util.regex.Pattern;

// Used to detect whether or not a folder contains a show or movie
public class MediaTypeDetector {
    private static final Pattern SEASON_PATTERN = Pattern.compile(".*season\\s*\\d+.*", Pattern.CASE_INSENSITIVE);
    private static final Pattern EPISODE_PATTERN = Pattern.compile(".*(s\\d{1,2}e\\d{1,2}|\\d{1,2}x\\d{1,2}).*", Pattern.CASE_INSENSITIVE);
    private static final Pattern DATE_PATTERN = Pattern.compile(".*\\d{4}[ ._-]\\d{2}[ ._-]\\d{2}.*");
    private static final Pattern EP_KEYWORD_PATTERN = Pattern.compile(".*(episode|ep\\s?\\d+).*", Pattern.CASE_INSENSITIVE);
    private static final Pattern MOVIE_YEAR_PATTERN = Pattern.compile(".*\\(\\d{4}\\).*");

    public static MediaType detectType(String folderPath) {
        File folder = new File(folderPath);
        String name = folder.getName().toLowerCase();

        // TV Show heuristics to determine the type
        if (SEASON_PATTERN.matcher(name).matches()) return MediaType.TVSHOW;
        if (EPISODE_PATTERN.matcher(name).matches()) return MediaType.TVSHOW;
        if (DATE_PATTERN.matcher(name).matches()) return MediaType.TVSHOW;
        if (EP_KEYWORD_PATTERN.matcher(name).matches()) return MediaType.TVSHOW;

        // Check subfiles/subfolders within torrent folders. 
        if (folder.isDirectory()) {
            for (File f : folder.listFiles()) {
                String subName = f.getName().toLowerCase();
                if (SEASON_PATTERN.matcher(subName).matches()) return MediaType.TVSHOW;
                if (EPISODE_PATTERN.matcher(subName).matches()) return MediaType.TVSHOW;
                if (EP_KEYWORD_PATTERN.matcher(subName).matches()) return MediaType.TVSHOW;
            }
        }

        // Movie heuristics
        if (MOVIE_YEAR_PATTERN.matcher(name).matches()) return MediaType.MOVIE;

        // Default fallback
        return MediaType.MOVIE;
        
    }
}
