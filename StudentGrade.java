import java.util.Scanner;

public class GradeCalculator {

    // Function to calculate grade based on average percentage
    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B+";
        } else if (averagePercentage >= 60) {
            return "B";
        } else if (averagePercentage >= 50) {
            return "C+";
        } else if (averagePercentage >= 40) {
            return "C";
        } else {
            return "F";
        }
    }

    // Function to calculate total marks, average percentage, and grade
    public static Object[] calculateResults(double[] marks, int totalSubjects) {
        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }
        double averagePercentage = (totalMarks / (totalSubjects * 100)) * 100;
        String grade = calculateGrade(averagePercentage);

        return new Object[]{totalMarks, averagePercentage, grade};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained (out of 100) in each subject
        System.out.print("Enter the number of subjects: ");
        int totalSubjects = scanner.nextInt();
        double[] marks = new double[totalSubjects];

        for (int i = 0; i < totalSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextDouble();
        }

        // Calculate total marks, average percentage, and grade
        Object[] results = calculateResults(marks, totalSubjects);
        double totalMarks = (double) results[0];
        double averagePercentage = (double) results[1];
        String grade = (String) results[2];

        // Display the results
        System.out.println("\nResults:");
        System.out.printf("Total Marks: %.2f / %.0f\n", totalMarks, (totalSubjects * 100.0));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }
}