package io.mainTask.runner;

import io.mainTask.analyzers.PathAnalyzer;
import io.mainTask.directoryStructureEntities.DirectoryHierarchy;
import io.mainTask.directoryStructureEntities.FileType;
import io.mainTask.input.DirectoryHierarchyCreator;
import io.mainTask.output.Writer;
import io.mainTask.services.Calculator;

import java.io.File;

public class DirectoryHierarchyExecutor {
    private static final String HIERARCHY_FILE_NAME = "";

    public static void execute(String path){
        DirectoryHierarchy directoryHierarchy;
        Calculator calculator;

        switch (FileType.getFileType(path)){
            case DIRECTORY:
                directoryHierarchy = new DirectoryHierarchy(path + File.separator);
                new DirectoryHierarchyCreator(directoryHierarchy).createFromDirectory(path);
                new Writer(directoryHierarchy.PARENT_PATH + HIERARCHY_FILE_NAME).
                        writeToFile(directoryHierarchy);
                break;
            case FILE:
                directoryHierarchy = new DirectoryHierarchy((PathAnalyzer.getParentPath(path)));
                calculator = new Calculator(directoryHierarchy);
                new DirectoryHierarchyCreator(directoryHierarchy).createFromFile(path);
                System.out.println("Количество папок "+ calculator.getDirectoriesCount());
                // TODO: 7/12/22 add 2 methods
                System.out.println("Количество файлов "+calculator.getFilesCount());
                System.out.println("Среднее количество файлов в папке "+calculator.getAverageNumberOfFilesInFolder);
                System.out.println("Среднюю длинну названия файла "+calculator.getAverageLengthOfFileName);
                break;
        }
    }
}
