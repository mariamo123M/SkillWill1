import java.io.*;

public class TextFileReader {
    public static void main(String[] args) {
        String fileName = "sample.txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("I love horses\n");
            writer.write("My horse's name is Lucky");
            System.out.println("First file");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Folder:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(" FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(" IOException: " + e.getMessage());
        }
    }
}