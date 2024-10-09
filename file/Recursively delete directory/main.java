import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Specify the directory to be deleted
        File directory = new File("nonEmptyDir");

        // Recursively delete directory and its contents
        deleteDirectory(directory);
    }

    public static void deleteDirectory(File dir) {
        // Check if directory is valid and exists
        if (dir.isDirectory()) {
            // List all files and subdirectories
            File[] files = dir.listFiles();
            if (files != null) {  // Guard against null in case of an IO error
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteDirectory(file);  // Recursively delete subdirectory
                    } else {
                        file.delete();  // Delete file
                    }
                }
            }
        }
        // Finally, delete the directory itself
        if (dir.delete()) {
            System.out.println("Deleted directory: " + dir.getName());
        } else {
            System.out.println("Failed to delete directory: " + dir.getName());
        }
    }
}