// Generate a random number within a specified range, such as 1 to 100.

// 2. Prompt the user to enter their guess for the generated number.

// 3. Compare the user's guess with the generated number and provide feedback on whether the guess
// is correct, too high, or too low.

// 4. Repeat steps 2 and 3 until the user guesses the correct number.

// You can incorporate additional details as follows:

// 5. Limit the number of attempts the user has to guess the number.
// 6. Add the option for multiple rounds, allowing the user to play again.
// 7. Display the user's score, which can be based on the number of attempts taken or rounds won.

import java.util.*;

class task1 {
    public void gameOfRandom() {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int number = ran.nextInt(100);
        // System.out.println(number + "");

        int tattempts = 8;
        int at = 0;
        int r = 1;
        while (at < tattempts) {
            try {
                System.out.print("Guess the generated number:");
                int num = sc.nextInt();
                if (num == number) {
                    System.out.printf("you take %d number of attemps to guess number\n", r);
                    System.out.println("Congratulations!!!! \nYou guess correct number");

                    break;
                } else if (num < number) {
                    System.out.println("Too low! choose some large number.");
                    System.out.println("--------------------------------------------------------");

                    r++;

                } else {
                    System.out.println("Too high! choose some small number.");
                    System.out.println("--------------------------------------------------------");

                    r++;
                }
                at++;

                if (at == tattempts) {
                    System.out.println("You have used all attempts.smile");
                }
            } catch (Throwable e) {
                System.out.println("Exception:number should be in integers ");
                sc.next();

            }

        }

    }

    public static void main(String[] args) {
        int round = 0;

        task1 t = new task1();
        int score = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------------");
        System.out.println("                     The Number Game");
        System.out.println("--------------------------------------------------------");

        while (true) {
            t.gameOfRandom();
            score += 20;
            round++;
            try {
                System.out.println("Do you want to play another round? (yes/no)");

                String s = sc.next();

                if (!s.equalsIgnoreCase("yes")) {
                    break;
                }
            } catch (Throwable e) {
                System.out.println("Invalid input! Please enter 'yes' or 'no'.");
                sc.next();
            }
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("Your total score is:" + score);
        System.out.printf("You play %d rounds in this game !!!\n", round);
        sc.close();
        System.out.println("--------------------------------------------------------");
        System.out.println("                     Game Ends");

        System.out.println("--------------------------------------------------------");

    }
}