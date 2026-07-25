import java.util.Scanner;

public class Marks {

static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students (n): ");
        int n = sc.nextInt();
        int[][] marks = new int[n][3];

        boolean running = true;
        // add: Enter all 3 marks for one student
        // update: change subject mark of one student
        // average_s: shows the mark the student got in each subject separately
        // average: adds up all 3 marks and divides by 3
        // total: adds up all 3 marks and shows the sum
        // grades: prints a table showing all student's grade

        while (running) {
            System.out.print("\nEnter command: ");
            String command = sc.next();

            if (command.equals("add")) {
                System.out.print("Enter student ID: ");
                int studentID = sc.nextInt();
                int row = studentID - 1;

                System.out.print("Enter Mathematics mark: ");
                marks[row][0] = sc.nextInt();
                System.out.print("Enter Chemistry mark: ");
                marks[row][1] = sc.nextInt();
                System.out.print("Enter Physics mark: ");
                marks[row][2] = sc.nextInt();

                System.out.println("Marks saved for Student " + studentID);
            }

            else if (command.equals("update")) {
                System.out.print("Enter student ID: ");
                int studentID = sc.nextInt();
                System.out.print("Enter subject ID (1=Maths, 2=Chemistry, 3=Physics): ");
                int subjectID = sc.nextInt();

                int row = studentID - 1;
                int column = subjectID - 1; 

                System.out.print("Enter new mark: ");
                marks[row][column] = sc.nextInt();

                System.out.println("Mark updated for Student " + studentID);
            }

            else if (command.equals("average_s")) {
                System.out.print("Enter student ID: ");
                int studentID = sc.nextInt();
                int row = studentID - 1;

                System.out.println("Mathematics: " + marks[row][0]);
                System.out.println("Chemistry: " + marks[row][1]);
                System.out.println("Physics: " + marks[row][2]);
            }

            else if (command.equals("average")) {
                System.out.print("Enter student ID: ");
                int studentID = sc.nextInt();
                int row = studentID - 1;
                int total = marks[row][0] + marks[row][1] + marks[row][2];
                double average = total / 3.0;

                System.out.println("Average mark: " + average);
            }

            else if (command.equals("total")) {
                System.out.print("Enter student ID: ");
                int studentID = sc.nextInt();
                int row = studentID - 1;
                int total = marks[row][0] + marks[row][1] + marks[row][2];

                System.out.println("Total mark: " + total);
            }

            
            else if (command.equals("grades")) {
                System.out.println("Student\tMathematics\tChemistry\tPhysics");

                for (int row = 0; row < n; row++) {
                    int studentID = row + 1;
                    String mathsGrade = getGrade(marks[row][0]);
                    String chemistryGrade = getGrade(marks[row][1]);
                    String physicsGrade = getGrade(marks[row][2]);

                    System.out.println(studentID + "\t" + mathsGrade + "\t\t" + chemistryGrade + "\t\t" + physicsGrade);
                }
            }

            else if (command.equals("exit")) {
                running = false;
            }

            else {
                System.out.println("Unknown command. Try: add, update, average_s, average, total, grades, exit");
            }
        }

        sc.close();
    }

    static String getGrade(int mark) {
        if (mark >= 90) {
            return "Grade A";
        } else if (mark >= 80) {
            return "Grade B";
        } else if (mark >= 70) {
            return "Grade C";
        } else if (mark >= 60) {
            return "Grade D";
        } else {
            return "Fail";
        }
    }
}