package io.mainTask.analyzers;

import io.mainTask.directoryStructureEntities.DirectoryHierarchy;
import io.mainTask.directoryStructureEntities.DirectoryHierarchyItem;

import java.io.File;

public class FileStructureAnalyzer {
    public static DirectoryHierarchyItem getDirectoryHierarchyItem(DirectoryHierarchy directoryHierarchy, File file) {
        return new DirectoryHierarchyItem(calculateNestingLevel(directoryHierarchy, file), file);
    }

    private static Integer calculateNestingLevel(DirectoryHierarchy directoryHierarchy, File file) {
        int nestingLevel = 0;

        if (directoryHierarchy.stream().anyMatch(item -> item.getFile().equals(file.getParentFile()))) {
            nestingLevel = directoryHierarchy.stream().filter(item -> item.getFile().equals(file.getParentFile())).findFirst().get().getNestedLevel();
            nestingLevel++;
        }
        return nestingLevel;
    }
}
