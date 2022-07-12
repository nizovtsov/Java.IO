package io.mainTask.directoryStructureEntities;

import java.io.File;

public class DirectoryHierarchyItem {
    private final Integer NestedLevel;
    private final File File;

    public DirectoryHierarchyItem(Integer nestedLevel, File file) {
        NestedLevel = nestedLevel;
        File = file;
    }

    public Integer getNestedLevel() {
        return NestedLevel;
    }

    public java.io.File getFile() {
        return File;
    }

    @Override
    public String toString() {
        String GENERAL_INDENT = "|";
        String FILE_INDENT = "       ";
        String DIRECTORY_INDENT = "-----";
        StringBuilder directoryContent = new StringBuilder(GENERAL_INDENT);
        String indent = File.isDirectory() ? DIRECTORY_INDENT : FILE_INDENT;
        directoryContent.append(indent.repeat(Math.max(0, NestedLevel + 1)));
        directoryContent.append(File.getName());
        return directoryContent.toString();
    }
}
