package com.acfaudit.document;


public class PathService {

    public static String buildPath(String fileName, Long timestamp, Long memorySize) {
        String path = fileName + "-" + timestamp + "-" + memorySize;

        return path;
    }

}
