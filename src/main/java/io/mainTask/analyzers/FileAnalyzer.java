package io.mainTask.analyzers;

import io.mainTask.directoryStructureEntities.DirectoryHierarchy;
import io.mainTask.directoryStructureEntities.DirectoryHierarchyItem;

import java.io.File;

public class FileAnalyzer {
    private static int nestingLevel = 0;
    private static String fileName;
    public static DirectoryHierarchyItem analyzeLine(String line, DirectoryHierarchy directoryHierarchy){
        if(line.matches("[|][-]+\\S+]")){
            
        } else if (line.matches("[|][ ]+\\S+")) {

        }
        String parentPath = PathAnalyzer.getParentPath(directoryHierarchy, nestingLevel);
        return new DirectoryHierarchyItem(nestingLevel, new File(parentPath+fileName));
    }
}
