package io.mainTask.input;

import io.mainTask.analyzers.FileStructureAnalyzer;
import io.mainTask.directoryStructureEntities.DirectoryHierarchy;

import java.io.File;
import java.util.Objects;

public class DirectoryHierarchyCreator {
    private final DirectoryHierarchy directoryHierarchy;

    public DirectoryHierarchyCreator(DirectoryHierarchy directoryHierarchy) {
        this.directoryHierarchy = directoryHierarchy;
    }

    public void createFromDirectory(String directoryPath){
        File directory = new File(directoryPath);
        putFilesWithNestedLevel(directoryHierarchy, directory);
    }

    private void putFilesWithNestedLevel(DirectoryHierarchy directoryHierarchy, File directory){
        for(File file: Objects.requireNonNull(directory.listFiles())){
            directoryHierarchy.add(FileStructureAnalyzer.getDirectoryHierarchyItem(directoryHierarchy, file));
            if(file.isDirectory()){
                putFilesWithNestedLevel(directoryHierarchy, file);
            }
        }
    }
}
