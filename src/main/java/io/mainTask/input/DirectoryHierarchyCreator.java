package io.mainTask.input;

import io.mainTask.analyzers.FileAnalyzer;
import io.mainTask.analyzers.FileStructureAnalyzer;
import io.mainTask.directoryStructureEntities.DirectoryHierarchy;

import java.io.*;
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

    public void createFromFile(String filePath){
        try(FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
            while((line = bufferedReader.readLine()) != null){
                directoryHierarchy.add(FileAnalyzer.analyzeLine(line, directoryHierarchy));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
