import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class PathsLibraryExample {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Path path = Paths.get(new URI("file:///home/p10/Desktop/hello.txt"));
        System.out.println(path);
        System.out.println(Files.exists(path));
        System.out.println(Files.getLastModifiedTime(path));
        System.out.println(Files.getOwner(path));

        Path tempFile = Files.createTempFile(path.getParent(), "TestFile", ".jpg");
        System.out.println(tempFile);

        Path createDir;
        try {
            createDir = Files.createDirectories(path.getParent().resolve("TestDir"));
        } catch (FileAlreadyExistsException e) {
            createDir = path.resolve("TestDir");
        }
        Path createFile;
        try {
            createFile= Files.createFile(createDir.resolve("test.txt"));
        } catch (FileAlreadyExistsException e) {
            createFile = createDir.resolve("test.txt");
        }
        System.out.println(createFile);
        try {
            Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(createFile);
            System.out.println(permissions);
        } catch (UnsupportedOperationException e) {
            System.out.println("Unsupported operation!");
        }
    }
}
