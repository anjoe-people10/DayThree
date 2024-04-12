import java.io.*;
import java.util.Scanner;

public class DecryptCeaserScanner {
    public static void main(String[] args) throws IOException {
        int shift = 4;
        File readFromFile = new File("/home/p10/Desktop/ceaser.txt");
        StringBuffer br = new StringBuffer();
        Scanner kb = new Scanner(readFromFile);
        while (kb.hasNextLine()) {
            String line = kb.nextLine();
            for(char ch : line.toCharArray()) {
                System.out.printf("Character %s\tEncrypted to: %s%n", ch, decryptCharacter(ch, shift));
                br.append(decryptCharacter(ch, shift));
            }
        }
        System.out.println(br);
        try (BufferedWriter writeBack = new BufferedWriter(new FileWriter(new File("/home/p10/Desktop/hello.txt")))) {
            writeBack.write(br.toString());
        }
    }

    private static char decryptCharacter(char ch, int shift) {
        if (Character.isLetter(ch)) {
            char base = Character.isUpperCase(ch) ? 'A' : 'a';
            return (char) (((ch - base - shift) + 26) % 26 + base);
        } else {
            return ch;
        }
    }
}
