package dividecollection;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Fasgort
 */
public class DivideCollection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Lectura de directorio
        File dir = new File("./");

        //Lectura de ficheros
        String[] arrayFiles = dir.list();

        if (arrayFiles != null) {

            for (String fileName : arrayFiles) {

                Path filePath = FileSystems.getDefault().getPath("./", fileName);
                if (!Files.isDirectory(filePath)) {
                    
                    if (fileName.length() >= 2) {
                        
                        String newDirName = fileName.substring(0, 2);
                        File newDir = new File("./" + newDirName + "/");
                        newDir.mkdir();
                        Path newFilePath = FileSystems.getDefault().getPath("./", newDirName, "/", fileName);
                        
                        try {
                            Files.move(filePath, newFilePath);
                        } catch (Exception E) {

                        }
                        
                    }
                }

            }

        }

    }

}
