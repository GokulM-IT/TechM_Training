package Task_01;

import java.util.*;

/*Write a java program to accept the students name and marks in subjects and find the total and average of the
marks and sort the list accordingly.*/

public class StudentGradesSorting {
    static class StudentDetails {
        String name;
        int[] marks;
        int total;
        double average;

        StudentDetails(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
            calculateTotalAndAverage();
        }

        void calculateTotalAndAverage() {
            total = 0;
            for (int mark : marks) {
                total += mark;
            }
            average = total / (double) marks.length;
        }

        @Override
        public String toString() {
            return name + " - Total: " + total + ", Average: " + average;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<StudentDetails> students = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter student's name: ");
            String name = sc.nextLine();

            System.out.print("Enter the number of subjects: ");
            int numSubjects = sc.nextInt();
            int[] marks = new int[numSubjects];
            System.out.println("Enter marks for " + numSubjects + " subjects:");
            for (int j = 0; j < numSubjects; j++) {
                marks[j] = sc.nextInt();
            }
            sc.nextLine();

            students.add(new StudentDetails(name, marks));
        }

        Collections.sort(students, Comparator.comparingDouble(s -> s.average));

        System.out.println("\nSorted list of students based on average marks:");
        for (StudentDetails student : students) {
            System.out.println(student);
        }
    }
}
