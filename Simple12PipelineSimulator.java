public class Simple12PipelineSimulator {

    // Define pipeline stages and required hardware
    private static final String[][] pipelineStages = {
        {"Fetch", "Program Counter", "Memory"},
        {"Decode", "Instruction Decoder", "Control Unit"},
        {"Execute", "ALU (Arithmetic Logic Unit)"},
        {"Memory Access", "Memory"},
        {"Write Back", "Registers"}
    };

    // Simulate the pipeline for a given instruction
    public static void simulatePipeline(String instruction) {
        System.out.println("Simulating Simple12 Instruction Pipeline for: " + instruction);
        System.out.println("------------------------------------------------");

        for (String[] stage : pipelineStages) {
            String stageName = stage[0];
            System.out.print("Stage: " + stageName + "\n  Hardware needed: ");
            
            // List the hardware components for the current stage
            for (int i = 1; i < stage.length; i++) {
                System.out.print(stage[i]);
                if (i < stage.length - 1) System.out.print(", ");
            }
            System.out.println("\n  Processing instruction: " + instruction);
            
            // Simulate processing delay
            try {
                Thread.sleep(1000);  // 1 second delay for demonstration
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Simulation interrupted.");
            }
            
            System.out.println("------------------------------------------------");
        }
        
        System.out.println("Pipeline processing complete.");
    }
}
