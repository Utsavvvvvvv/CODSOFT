import java.util.Scanner;

public class studentrecord {
    private static int calculateTotalMarks(int[] marks) {
        int totalMarks = 0;
        for (int i=0;i<marks.length;i++) {
            totalMarks += marks[i];
        }
        return totalMarks;
    }

    private static double calculateAveragePercentage(int totalMarks, int Subjects) {
        return (double) totalMarks / Subjects;
    }

    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    private static void displayResults(int totalMarks, int numberOfSubjects, double averagePercentage, String grade) {
        System.out.println("Total Marks: " + totalMarks + " out of " + (numberOfSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        // Array to store marks
        int[] marks = new int[numberOfSubjects];

        // Input marks for each subject
        System.out.println("Enter the marks obtained in each subject (out of 100):");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        // Calculate total marks and average percentage
        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);

        // Determine the grade
        String grade = calculateGrade(averagePercentage);

        // Display results
        displayResults(totalMarks, numberOfSubjects, averagePercentage, grade);

        scanner.close();
    }
}
