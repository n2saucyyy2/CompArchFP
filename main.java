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

        if (choice.equals("1")) {
            System.out.print("Enter the filename: ");
            String filename = scanner.nextLine().trim();
            
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String instruction;
                while ((instruction = reader.readLine()) != null) {
                    if (!instruction.trim().isEmpty()) {
                        // Simulate the pipeline for each instruction in the file
                        Simple12PipelineSimulator.simulatePipeline(instruction.trim());
                    }
                }
            } catch (IOException e) {
                System.out.println("File not found or could not be read.");
            }
        } else if (choice.equals("2")) {
            System.out.print("Enter the Simple12 instruction: ");
            String instruction = scanner.nextLine().trim();
            Simple12PipelineSimulator.simulatePipeline(instruction);
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
