import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CeaserCipherFile {

    final File readFile;
    final File writeFile;
    char[] textFromFile;
    char[] encryptedText;

    public CeaserCipherFile(String readPath, String writePath) {
        readFile = new File(readPath);
        writeFile = new File(writePath);
    }

    void createNewFile() throws IOException {
        writeFile.createNewFile();
    }

    boolean deleteFile() {
        return readFile.delete();
    }

    boolean readFromFile() {
        try (FileReader fileReader = new FileReader(readFile)) {
            textFromFile = new char[(int) readFile.length()];
            encryptedText = new char[(int) readFile.length()];
            int status = fileReader.read(textFromFile);
            return status >= 0;
        } catch (IOException e) {
            return false;
        }
    }

    boolean writeToFile() {
        try (FileWriter fileWriter = new FileWriter(writeFile)) {
            fileWriter.write(encryptedText);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    char encryptChar(char character, int shift) {
        char base = Character.isUpperCase(character) ? 'A' : 'a';
        return (char) ((character - base + shift) % 26 + base);
    }

    void ceaserCipher(int shift) {
        for (int i = 0; i < encryptedText.length; i++) {
            char character = textFromFile[i];
            if (Character.isLetter(character)) {
                encryptedText[i] = encryptChar(character, shift);
            } else {
                encryptedText[i] = character;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String readPath = "/home/p10/Desktop/hello.txt";
        String writePath = "/home/p10/Desktop/ceaser.txt";
        int shift = 4;
        CeaserCipherFile obj = new CeaserCipherFile(readPath, writePath);
        obj.createNewFile();
        if (obj.readFromFile()) {
            obj.ceaserCipher(shift);
            if (obj.writeToFile()) {
                if (obj.deleteFile()) {
                    System.out.println("Successful");
                } else {
                    System.out.println("Some error occurred");
                }
            } else {
                System.out.println("Some error occurred");
            }
        } else {
            System.out.println("Some error occurred");
        }
    }
}
