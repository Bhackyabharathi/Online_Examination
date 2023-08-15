import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public void updateProfile(String newUseBHrname, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
    }
}

class MCQs {
    private String question;
    private String[] options;
    private int correctAnswer;

    public MCQs(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean checkAnswer(int selectedOption) {
        return selectedOption == correctAnswer;
    }
}

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User registration
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = new User(username, password);

        // User login
        System.out.print("Enter your username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter your password: ");
        String enteredPassword = scanner.nextLine();
        if (user.authenticate(enteredPassword)) {
            System.out.println("Login successful!");

            // Update profile and password
            System.out.print("Enter new username: ");
            String newUsername = scanner.nextLine();
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            user.updateProfile(newUsername, newPassword);
            System.out.println("Profile and password updated!");

            // MCQs
            String mcqQuestion = "What is the capital of France?";
            String[] mcqOptions = {"Paris", "London", "Berlin", "Madrid"};
            int correctMCQAnswer = 1;
            MCQs mcq = new MCQs(mcqQuestion, mcqOptions, correctMCQAnswer);
            mcq.displayQuestion();
            System.out.print("Enter your answer (1-4): ");
            int selectedMCQOption = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (mcq.checkAnswer(selectedMCQOption)) {
                System.out.println("Correct answer!");
            } else {
                System.out.println("Incorrect answer.");
            }

            // Timer and auto-submit
            int timerDurationInSeconds = 30; // Example timer duration
            System.out.println("You have " + timerDurationInSeconds + " seconds to answer.");
            long startTime = System.currentTimeMillis();
            while (true) {
                long currentTime = System.currentTimeMillis();
                if (currentTime - startTime >= timerDurationInSeconds * 1000) {
                    System.out.println("Time's up! Submitting your answer.");
                    break;
                }
            }

            // Closing session and logout
            System.out.println("Session closed. Logging out.");
        } else {
            System.out.println("Login failed. Incorrect password.");
        }
    }
}