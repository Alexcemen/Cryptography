package cryptography.resources;

public class ConsoleColor {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    private static final String[] COLORS = {RED, GREEN, YELLOW, BLUE, PURPLE, CYAN};

    public static String getColorForThread(String threadName) {
        int index = Math.abs(threadName.hashCode()) % COLORS.length;
        return COLORS[index];
    }}
