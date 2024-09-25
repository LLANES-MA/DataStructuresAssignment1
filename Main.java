import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Queue<String> queue = new Queue<String>();
        Stack<String> stack = new Stack<>();
        int logLevels = 0, memory = 0, count = 0;

        try {
            Scanner scanner = new Scanner(new File("C://Users//wolfg//IdeaProjects//Assignment1//src//log-data.csv"));
            while (scanner.hasNextLine()) {
                queue.add(scanner.nextLine());
            }
            while (!queue.isEmpty()) {
                String line = queue.peek();
                if (line.contains("ERROR")) {
                    stack.push(line);
                    logLevels++;
                }
                if (line.contains("WARN")) { logLevels++; }
                if (line.contains("Memory") || line.contains("memory")) { memory++; }
                if (line.contains("INFO")) { logLevels++; }
                queue.dequeue();
            }
            while (!stack.isEmpty() && count < 100) {
                count++;
                StdOut.println(stack.pop());
            }
            StdOut.println("Memory leaks: " + memory);
            StdOut.println("Log levels: " + logLevels);

            scanner.close();
        } catch (FileNotFoundException e) {
            StdOut.println(e.getMessage());
        }
    }
}