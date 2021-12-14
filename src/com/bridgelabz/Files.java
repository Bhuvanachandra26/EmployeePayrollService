package com.bridgelabz;

import java.io.File;

public class Files {

    public static boolean deleteFiles(File filesToDelete) {
        File[] allFiles=filesToDelete.listFiles();
        if(allFiles !=null) {
            for(File file: allFiles)
                deleteFiles(file);
        }
        return filesToDelete.delete();
    }

}