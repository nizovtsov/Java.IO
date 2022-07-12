package io.mainTask.services;

import io.mainTask.directoryStructureEntities.DirectoryHierarchy;

public class Calculator {
    private final DirectoryHierarchy directoryHierarchy;

    public Calculator(DirectoryHierarchy directoryHierarchy) {
        this.directoryHierarchy = directoryHierarchy;
    }

    public long getDirectoriesCount() {
        return directoryHierarchy.stream().filter(item -> item.getFile().isFile()).count();
    }

    public long getFilesCount() {
        return directoryHierarchy.stream().filter(item -> item.getFile().isFile()).count();
    }


}
