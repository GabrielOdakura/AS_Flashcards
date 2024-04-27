package utils;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class PersistenciaUtils {
    public static String getFileAdress() {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView());
        jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int returnValue = jfc.showOpenDialog(null);
        String pathString = null;
        if(returnValue == JFileChooser.APPROVE_OPTION) {
            File name = jfc.getSelectedFile();
            pathString = name.toPath().toString();
        }
        return pathString;
    }
}
