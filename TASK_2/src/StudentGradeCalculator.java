import java.util.Scanner;

public class StudentGradeCalculator {
    public int numOfSubject;
    public Scanner obj1 = new Scanner(System.in);
    public int[] marks;
    public int Sum = 0;
    public double Avg;

    public StudentGradeCalculator() {
        System.out.println("Enter Number of Subjects: ");
        numOfSubject = obj1.nextInt();
        marks = new int[numOfSubject];
    }

    void inputMarks() {
        for (int i = 0; i < numOfSubject; i++) {
            System.out.print("Subject " + (i + 1) + " Marks: ");
            marks[i] = obj1.nextInt();
        }
    }

    int calTotalMarks() {
        for (int i = 0; i < numOfSubject; i++) {
            Sum += marks[i];
        }
        return Sum;
    }

    double calAveragePre() {
        Avg = (double) Sum / numOfSubject;
        return Avg;
    }

    void calGrade() {
        if (Avg >= 75) {
            System.out.println("Your Grade is A");
        } else if (Avg >= 65 && Avg < 75) {
            System.out.println("Your Grade is B");
        } else if (Avg >= 55 && Avg < 65) {
            System.out.println("Your Grade is C");
        } else if (Avg >= 45 && Avg < 55) {
            System.out.println("Your Grade is F");
        } else {
            System.out.println("Your Grade is W");
        }
    }

    public static void main(String[] args) {
        StudentGradeCalculator o1 = new StudentGradeCalculator();
        o1.inputMarks();

        System.out.println("---------------------------Display Results----------------------------");
        System.out.println("Total Marks: " + o1.calTotalMarks());
        System.out.println("Average Percentage: " + o1.calAveragePre());
        o1.calGrade();
    }
}
