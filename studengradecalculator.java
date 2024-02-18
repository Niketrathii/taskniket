import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks obtained in each subject (out of 100): ");
        int totalSubjects = 0;
        int totalMarks = 0;
        while (true) {
            System.out.print("Subject " + (totalSubjects + 1) + ": ");
            int marks;
            while (true) {
                if (sc.hasNextInt()) {
                    marks = sc.nextInt();
                    if (marks >= 0 && marks <= 100) {
                        break;
                    } else {
                        System.out.println("Please enter a valid marks between 0 and 100.");
                    }
                } else {
                    System.out.println("Please enter a valid integer for marks.");
                    sc.next();
                }
            }
            totalMarks += marks;
            totalSubjects++;
            System.out.print("Do you have more subjects? (type yes or no): ");
            String moreSubjects;
            while (true) {
                moreSubjects = sc.next().toLowerCase();
                if (moreSubjects.equals("yes") || moreSubjects.equals("no")) {
                    break;
                } else {
                    System.out.println("Please enter 'yes' or 'no'.");
                }
            }
            if (moreSubjects.equals("0")) {
                break;
            }
        }
        double averagePercentage = (double) totalMarks / totalSubjects;
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        sc.close();
    }
}