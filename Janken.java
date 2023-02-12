import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choice:");
        System.out.println("1. Rock");
        System.out.println("2. Paper");
        System.out.println("3. Scissors");
        System.out.print("Your choice: ");
        int playerChoice = scanner.nextInt();
        int computerChoice = (int) (Math.random() * 3) + 1;
        System.out.println("Computer chose: " + computerChoice);
        if (playerChoice == computerChoice) {
            System.out.println("It's a draw");
        } else if (playerChoice == 1 && computerChoice == 2) {
            System.out.println("Computer wins");
        } else if (playerChoice == 1 && computerChoice == 3) {
            System.out.println("Player wins");
        } else if (playerChoice == 2 && computerChoice == 1) {
            System.out.println("Player wins");
        } else if (playerChoice == 2 && computerChoice == 3) {
            System.out.println("Computer wins");
        } else if (playerChoice == 3 && computerChoice == 1) {
            System.out.println("Computer wins");
        } else if (playerChoice == 3 && computerChoice == 2) {
            System.out.println("Player wins");
        } else {
            System.out.println("Invalid choice");
        }
    }
}
