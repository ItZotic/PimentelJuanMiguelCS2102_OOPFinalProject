import java.util.Scanner;

public class ChibiPomodoro {
    private static final Scanner scanner = new Scanner(System.in);
    private final PomodoroCycle pomodoroCycle = new PomodoroCycle();
    private final TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        ChibiPomodoro pomodoro = new ChibiPomodoro();
        pomodoro.showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n=== Pomodoro Timer ===");
            System.out.println("1. Start Pomodoro Timer");
            System.out.println("2. To-Do List");
            System.out.println("3. What is Pomodoro Timer?");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = getValidatedChoice(1, 4);

            switch (choice) {
                case 1 -> pomodoroCycle.startPomodoroCycle(scanner, taskManager.getTasks());
                case 2 -> manageToDoList();
                case 3 -> displayPomodoroInfo();
                case 4 -> {
                    System.out.println("Thank you for using the Pomodoro Timer! Have a productive day!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Validate user input within a range
    private int getValidatedChoice(int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
    }

    // Display Pomodoro Technique information
    private void displayPomodoroInfo() {
        System.out.println("\n=== What is Pomodoro Timer? ===");
        System.out.println("The Pomodoro Technique alternates work sessions (pomodoros) with short breaks to maintain concentration and avoid burnout.");
        System.out.println("===========================================================");
        System.out.println("Identify a task or tasks that you need to complete\n" +
                           "~ Set a timer for 25 minutes ~\n" +
                           "~ Work on a task with no distractions ~\n" +
                           "~ Take a 5-minute break ~\n" +
                           "~ Repeat the process 3 more times ~\n" +
                           "~ Take a longer 30-minute break and start again");
        System.out.println("===========================================================");
    }

    // To-Do List management
    private void manageToDoList() {
        while (true) {
            System.out.println("\n=== To-Do List ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = getValidatedChoice(1, 4);

            switch (choice) {
                case 1 -> taskManager.addTask(scanner);
                case 2 -> taskManager.viewTasks();
                case 3 -> taskManager.markTaskCompleted(scanner);
                case 4 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
