package io.mainTask.analyzers;

import io.mainTask.directoryStructureEntities.DirectoryHierarchy;
import io.mainTask.directoryStructureEntities.DirectoryHierarchyItem;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class PathAnalyzer {
    private static final int PARENT_NESTING_LEVEL = 0;

    public static String getParentPath(String fileName) {
        return new File(fileName).getParent() + File.separator;
    }

    public static String getParentPath(DirectoryHierarchy directoryHierarchy, int nestingLevel) {
        String parentPath = "";
        if (nestingLevel == PARENT_NESTING_LEVEL) {
            parentPath = directoryHierarchy.PARENT_PATH;
        } else if (nestingLevel > PARENT_NESTING_LEVEL) {
            int previousNestedLevel = nestingLevel - 1;
            List<DirectoryHierarchyItem> parentItems = directoryHierarchy.stream().
                    filter(item -> (item.getNestedLevel() == previousNestedLevel) &&
                            (item.getFile().isDirectory())).collect(Collectors.toList());
            if (!parentItems.isEmpty()) {
                int lastItemIndex = parentItems.size() - 1;
                DirectoryHierarchyItem parentDirectory = parentItems.get(lastItemIndex);
                parentPath = parentDirectory.getFile().getAbsolutePath() + File.separator;
            }
        }
        return parentPath;
    }
}
