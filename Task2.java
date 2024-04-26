/*Input: Take marks obtained (out of 100) in each subject.
Calculate Total Marks: Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
Grade Calculation: Assign grades based on the average percentage achieved.
Display Results: Show the total marks, average percentage, and the corresponding grade to the user*/

import java.util.*;
import java.lang.*;

class Task2 {
    Scanner scanner = new Scanner(System.in);
    int marks;
    int total;

    public void takeInput() {
        String arr[] = { "Maths", "Science", "Hindi", "English", "Social Science" };
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("enter the marks of subject  %s: ", arr[i]);
            try {
                marks = scanner.nextInt();
                if (marks < 0 || marks > 100) {
                    System.out.println("error:  enter a number between 0 to 100.");
                    return;
                }
                total += marks;
            } catch (Throwable e) {
                System.out.println(" Execption:enter number in integers");
                scanner.nextLine();
                i--;
            }

        }
        System.out.println("total marks:" + total);
        double percentge = (total / 500.0) * 100.0;
        System.out.println("Average percentage is:" + percentge + "%");
        String grade;
        if (percentge >= 95) {
            grade = "A";
        } else if (percentge >= 85) {
            grade = "B";
        } else if (percentge >= 75) {
            grade = "C";
        } else if (percentge >= 65) {
            grade = "D";
        } else {
            grade = "F";

        }
        System.out.println("grade is:" + grade);

    }

    public static void main(String[] args) {
        Task2 t = new Task2();
        t.takeInput();

    }
}
