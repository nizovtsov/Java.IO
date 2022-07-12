package io.mainTask.directoryStructureEntities;

import java.io.File;

public enum FileType {
    DIRECTORY, FILE;

    public static FileType getFileType(String path) {
        File file = new File(path);
        return file.isDirectory() ? DIRECTORY : FILE;
    }
}
