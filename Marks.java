import java.util.Scanner;

public class Marks {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[][] marks = new int[n][3];

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Add student marks");
            System.out.println("2. Update student mark");
            System.out.println("3. Student Average");
            System.out.println("4. Subject Average");
            System.out.println("5. Student Total");
            System.out.println("6. Grades");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID (1-" + n + "): ");
                    int student = input.nextInt() - 1;

                    System.out.print("Mathematics: ");
                    marks[student][0] = input.nextInt();

                    System.out.print("Chemistry: ");
                    marks[student][1] = input.nextInt();

                    System.out.print("Physics: ");
                    marks[student][2] = input.nextInt();

                    System.out.println("Marks Added Successfully.");
                    break;

                case 2:

                    System.out.print("Enter Student ID: ");
                    student = input.nextInt() - 1;

                    System.out.println("Subject IDs");
                    System.out.println("1-Mathematics");
                    System.out.println("2-Chemistry");
                    System.out.println("3-Physics");

                    System.out.print("Enter Subject ID: ");
                    int subject = input.nextInt() - 1;

                    System.out.print("Enter New Mark: ");
                    marks[student][subject] = input.nextInt();

                    System.out.println("Updated Successfully.");
                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    student = input.nextInt() - 1;

                    double avg = (marks[student][0] + marks[student][1] + marks[student][2]) / 3.0;

                    System.out.println("Student Average = " + avg);

                    break;

                case 4:

                    System.out.println("Subject IDs");
                    System.out.println("1-Mathematics");
                    System.out.println("2-Chemistry");
                    System.out.println("3-Physics");

                    System.out.print("Enter Subject ID: ");
                    subject = input.nextInt() - 1;

                    int total = 0;

                    for (int i = 0; i < n; i++) {
                        total += marks[i][subject];
                    }

                    System.out.println("Subject Average = " + (total / (double) n));

                    break;

                case 5:

                    System.out.print("Enter Student ID: ");
                    student = input.nextInt() - 1;

                    total = marks[student][0] + marks[student][1] + marks[student][2];

                    System.out.println("Total Marks = " + total);

                    break;

                case 6:

                    System.out.println();
                    System.out.println("Student\tMath\tChem\tPhysics");

                    for (int i = 0; i < n; i++) {

                        System.out.print((i + 1) + "\t");

                        for (int j = 0; j < 3; j++) {
                            System.out.print(getGrade(marks[i][j]) + "\t");
                        }

                        System.out.println();
                    }

                    break;

                case 7:

                    System.out.println("Program Ended.");
                    input.close();
                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }

    public static String getGrade(int mark) {

        if (mark >= 90)
            return "A";
        else if (mark >= 80)
            return "B";
        else if (mark >= 70)
            return "C";
        else if (mark >= 60)
            return "D";
        else
            return "Fail";
    }
}