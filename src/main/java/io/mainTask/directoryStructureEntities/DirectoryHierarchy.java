package io.mainTask.directoryStructureEntities;

import java.util.LinkedList;

public class DirectoryHierarchy extends LinkedList<DirectoryHierarchyItem> {
    public final String PARENT_PATH;

    public DirectoryHierarchy(String path){
        PARENT_PATH = path;
    }
}
