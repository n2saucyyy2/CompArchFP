import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for input method
        System.out.println("Enter 1 to read from a file, 2 to enter an instruction directly: ");
        String choice = scanner.nextLine().trim();

        String instruction = null;
        
        if (choice.equals("1")) {
            System.out.print("Enter the filename: ");
            String filename = scanner.nextLine().trim();
            
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                instruction = reader.readLine();
            } catch (IOException e) {
                System.out.println("File not found or could not be read.");
                scanner.close();
                return;
            }
        } else if (choice.equals("2")) {
            System.out.print("Enter the Simple12 instruction: ");
            instruction = scanner.nextLine().trim();
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        // Start pipeline simulation
        if (instruction != null) {
            Simple12PipelineSimulator.simulatePipeline(instruction);
        }

        scanner.close();
    }
}
