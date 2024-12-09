import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChibiPomodoro {
    private final PomodoroCycle pomodoroCycle = new PomodoroCycle();
    private final UserManager userManager = new UserManager();
    private final List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        ChibiPomodoro pomodoro = new ChibiPomodoro();
        pomodoro.showMenu();
    }

    private void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Chibi Pomodoro Timer ===");
            System.out.println("1. Start Pomodoro Timer");
            System.out.println("2. To-Do List");
            System.out.println("3. What is Pomodoro Timer?");
            System.out.println("4. User Management");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> pomodoroCycle.startPomodoroCycle(scanner);
                case 2 -> manageToDoList(scanner);
                case 3 -> displayPomodoroInfo();
                case 4 -> userManager.manageUsers(scanner);
                case 5 -> {
                    System.out.println("Thank you for using the Chibi Pomodoro Timer! Have a productive day! 🍅");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
            
        }
    }

    // Display Pomodoro Technique information
    private void displayPomodoroInfo() {
        System.out.println("\n=== What is Pomodoro Timer? ===");
        System.out.println("The Pomodoro Technique alternates work sessions (pomodoros) with short breaks to maintain concentration and avoid burnout.");
        System.out.println("Cycle: work for 25 minutes, followed by a 5-minute break. After 4 cycles, take a longer break (15 minutes). 🍅");
    }

    // To-Do List management
    private void manageToDoList(Scanner scanner) {
        while (true) {
            System.out.println("\n=== To-Do List ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addTask(scanner);
                case 2 -> viewTasks();
                case 3 -> markTaskCompleted(scanner);
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
            
        }
    }

    // Add a task to the To-Do List
    private void addTask(Scanner scanner) {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();

        System.out.print("Enter estimated time to complete (minutes): ");
        int estimatedTime = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        tasks.add(new Task(name, estimatedTime));
        System.out.println("Task added successfully.");
    }

    // View all tasks in the To-Do List
    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\n=== To-Do List Tasks ===");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.printf("%d. %s - Estimated time: %d minutes - Status: %s\n", i + 1, task.getName(),
                              task.getEstimatedTime(), task.isCompleted() ? "Completed" : "In Progress");
        }
    }

    // Mark a task as completed
    private void markTaskCompleted(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.print("Enter task number to mark as completed: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (taskNumber < 1 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
        } else {
            tasks.get(taskNumber - 1).setCompleted(true);
            System.out.println("Task marked as completed.");
        }
    }

    // Task class for the To-Do List
    private static class Task {
        private final String name;
        private final int estimatedTime;
        private boolean completed;

        public Task(String name, int estimatedTime) {
            this.name = name;
            this.estimatedTime = estimatedTime;
            this.completed = false;
        }

        public String getName() { return name; }
        public int getEstimatedTime() { return estimatedTime; }
        public boolean isCompleted() { return completed; }
        public void setCompleted(boolean completed) { this.completed = completed; }
    }
}
