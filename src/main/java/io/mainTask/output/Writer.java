package io.mainTask.output;

import io.mainTask.directoryStructureEntities.DirectoryHierarchy;
import io.mainTask.directoryStructureEntities.DirectoryHierarchyItem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private String filePath;

    public Writer(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(DirectoryHierarchy directoryHierarchy){
        try(FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter writer = new BufferedWriter(fileWriter)){
            for (DirectoryHierarchyItem item: directoryHierarchy){
                writer.append(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
