public class Simple12PipelineSimulator {

    // Define generic pipeline stages
    private static final String[][] genericPipelineStages = {
        {"Fetch", "Program Counter", "Memory"},
        {"Decode", "Instruction Decoder", "Control Unit"},
        {"Execute"},
        {"Memory Access"},
        {"Write Back", "Registers"}
    };

    // Determine specific hardware requirements based on instruction type
    private static String[] getHardwareForStage(String stage, String instruction) {
        String operation = instruction.split(" ")[0].toUpperCase();

        switch (stage) {
            case "Fetch":
                return new String[]{"Program Counter", "Memory"};

            case "Decode":
                return new String[]{"Instruction Decoder", "Control Unit"};

            case "Execute":
                if (operation.equals("ADD") || operation.equals("SUB")) {
                    return new String[]{"ALU (Arithmetic Logic Unit)"};
                }
                return new String[]{};

            case "Memory Access":
                if (operation.equals("LOAD") || operation.equals("STORE")) {
                    return new String[]{"Memory"};
                }
                return new String[]{};

            case "Write Back":
                if (!operation.equals("JMP")) {  // Only write back if we're not jumping
                    return new String[]{"Registers"};
                }
                return new String[]{};

            default:
                return new String[]{};
        }
    }

    // Simulate the pipeline for a given instruction
    public static void simulatePipeline(String instruction) {
        System.out.println("Simulating Simple12 Instruction Pipeline for: " + instruction);
        System.out.println("------------------------------------------------");

        for (String[] stageInfo : genericPipelineStages) {
            String stage = stageInfo[0];
            String[] requiredHardware = getHardwareForStage(stage, instruction);

            System.out.print("Stage: " + stage + "\n  Hardware needed: ");
            if (requiredHardware.length > 0) {
                for (int i = 0; i < requiredHardware.length; i++) {
                    System.out.print(requiredHardware[i]);
                    if (i < requiredHardware.length - 1) System.out.print(", ");
                }
            } else {
                System.out.print("None");
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
