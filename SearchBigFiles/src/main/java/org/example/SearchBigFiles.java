package org.example;

import java.io.File;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class SearchBigFiles extends RecursiveTask<TreeMap> {
    private static String[] sizeNames = {"б", "кб", "мб", "гб"};
    private double minSize;
    private String path;

    public SearchBigFiles(String path, double minSize) {
        this.path = path;
        this.minSize = minSize;
    }

    @Override
    protected TreeMap<Long, String> compute() {
        TreeMap<Long, String> listFiles = new TreeMap<>();
        List<SearchBigFiles> taskList = new ArrayList<>();
        File file = new File(path);
        File[] files = file.listFiles();

        for (File f : files) {
            if (f.isDirectory()) {
                SearchBigFiles task = new SearchBigFiles(f.getAbsolutePath(), minSize);
                task.fork();
                taskList.add(task);
            } else if (f.length() >= minSize) {
                listFiles.put(f.length(), getSizeNames(f.length()) + " " + f.getPath());
            }
        }

        for (SearchBigFiles task : taskList) {
            listFiles.putAll(task.join());
        }
        return listFiles;
    }

    public static String getSizeNames(long length) {
        int power = (int) (Math.log(length) / Math.log(1024));
        return sizeNames[power];
    }
}