package bg.softuni.io;

import bg.softuni.staticData.SessionData;
import bg.softuni.staticData.ExceptionMessages;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class IOManager {

    public static void traverseDirectory(int depth) {
        Queue<File> subFolders = new LinkedList<>();

        String path = SessionData.currentPath;
        int initialIndentation = path.split("\\\\").length;

        File root = new File(path);

        subFolders.add(root);

        while (subFolders.size() != 0) {
            File currentFolder = subFolders.poll();
            int currentIndentation = currentFolder.toString().split("\\\\").length - initialIndentation;

            if (depth - currentIndentation < 0) {
                break;
            }

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());

            if (currentFolder.listFiles() != null) {
                for (File file : currentFolder.listFiles()) {
                    if (file.isDirectory()) {
                        subFolders.add(file);
                    } else {
                        int indexOfLastSlash = file.toString().lastIndexOf("\\");
                        for (int i = 0; i < indexOfLastSlash; i++) {
                            OutputWriter.writeMessage("-");
                        }

                        OutputWriter.writeMessageOnNewLine(file.getName());
                    }
                }
            }
        }
    }

    public static void createDirectoryInCurrentFolder(String name) {
        String path = SessionData.currentPath + "\\" + name;
        File file = new File(path);
        boolean wasDirMade = file.mkdir();
        if (!wasDirMade) {
            OutputWriter.displayException(
                    ExceptionMessages.FORBIDDEN_SYMBOLS_CONTAINED_IN_NAME);
        }
    }

    public static void changeCurrentDirRelativePath(String relativePath) {
        if (relativePath.equals("..")) {
            // go one directory up
            try {
                String currentPath = SessionData.currentPath;
                int indexOfLastSlash = currentPath.lastIndexOf("\\");
                String newPath = currentPath.substring(0, indexOfLastSlash);
                SessionData.currentPath = newPath;
            } catch (StringIndexOutOfBoundsException sioobe) {
                OutputWriter.displayException(ExceptionMessages.INVALID_DESTINATION);
            }
        } else {
            // go to a given directory
            String currentPath = SessionData.currentPath;
            currentPath += "\\" + relativePath;
            changeCurrentDirAbsolute(currentPath);
        }
    }

    public static void changeCurrentDirAbsolute(String absolutePath) {
        File file = new File(absolutePath);
        if (!file.exists()) {
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
            return;
        }

        SessionData.currentPath = absolutePath;
    }
}