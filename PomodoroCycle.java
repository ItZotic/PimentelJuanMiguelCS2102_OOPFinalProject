import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PomodoroCycle {
    private static final int WORK_DURATION = 25;       // Work duration in minutes
    private static final int SHORT_BREAK_DURATION = 5; // Short break duration in minutes
    private static final int LONG_BREAK_DURATION = 15; // Long break duration in minutes
    private static final int POMODOROS_BEFORE_LONG_BREAK = 4;

    private int pomodorosCompleted = 0;

    public void startPomodoroCycle(Scanner scanner) {
        while (true) {
            printChibiBanner();
            System.out.println("🍅 Starting work session!");
            runTimer(WORK_DURATION, "Work");

            pomodorosCompleted++;
            displayMotivationalMessage();

            if (pomodorosCompleted % POMODOROS_BEFORE_LONG_BREAK == 0) {
                System.out.println("🌼 Long break time! 🌼");
                runTimer(LONG_BREAK_DURATION, "Long Break");
            } else {
                System.out.println("💫 Short break time! 💫");
                runTimer(SHORT_BREAK_DURATION, "Short Break");
            }

            System.out.print("\nContinue with another Pomodoro? (yes/no): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                System.out.println("\nThanks for using the Pomodoro Timer! 🌟");
                displaySessionSummary();
                break;
            }
        }
    }

    private void runTimer(int durationMinutes, String sessionType) {
        try {
            for (int i = durationMinutes; i > 0; i--) {
                System.out.printf("\r%s Time left: %d minute(s) ⏳", sessionType, i);
                TimeUnit.SECONDS.sleep(1); // For testing; adjust to TimeUnit.MINUTES for real use
            }
            System.out.println("\n⏰ Time's up for " + sessionType + "!");
        } catch (InterruptedException e) {
            System.out.println("Timer interrupted.");
        }
    }

    private void displayMotivationalMessage() {
        String[] messages = {
            "Great job! Keep going! 😊",
            "You're awesome! Keep up the great work! 🌟",
            "One step closer to your goals! 🌈",
            "You're unstoppable! 🚀",
            "Take a deep breath and let's go again! 🍃"
        };
        System.out.println("\n🌟 " + messages[pomodorosCompleted % messages.length] + " 🌟\n");
    }

    private void printChibiBanner() {
        System.out.println("\n====================");
        System.out.println("🍅 Pomodoro Timer 🍅");
        System.out.println("====================");
        System.out.println("~ Let's stay focused together! ~");
    }

    private void displaySessionSummary() {
        System.out.println("\n🌸 Summary of Completed Pomodoros 🌸");
        System.out.println("Total Pomodoros completed: " + pomodorosCompleted);
        System.out.println("Great work today! See you next time! 🐱");
    }
}
