/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package student;

import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author SUDHANSHU SAKHALA
 */
class Student1 {

    public String name;
    public String id;
    public double assignmentOneMarks;
    public double assignmentTwoMarks;
    public double projectMark;
    public double indivisualTotalMarks;
    public String grade;

    public Student1(String name, String id, double assignmentOneMarks, double assignmentTwoMarks, double projectMark, double indivisualTotalMarks) {
        this.name = name;
        this.id = id;
        this.assignmentOneMarks = assignmentOneMarks;
        this.assignmentTwoMarks = assignmentTwoMarks;
        this.projectMark = projectMark;
        this.indivisualTotalMarks = indivisualTotalMarks;
    }

    public Student1() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the assignmentOneMarks
     */
    public double getAssignmentOneMarks() {
        return assignmentOneMarks;
    }

    /**
     * @param assignmentOneMarks the assignmentOneMarks to set
     */
    public void setAssignmentOneMarks(double assignmentOneMarks) {
        this.assignmentOneMarks = assignmentOneMarks;
    }

    /**
     * @return the assignmentTwoMarks
     */
    public double getAssignmentTwoMarks() {
        return assignmentTwoMarks;
    }

    /**
     * @param assignmentTwoMarks the assignmentTwoMarks to set
     */
    public void setAssignmentTwoMarks(double assignmentTwoMarks) {
        this.assignmentTwoMarks = assignmentTwoMarks;
    }

    /**
     * @return the projectMark
     */
    public double getProjectMark() {
        return projectMark;
    }

    /**
     * @param projectMark the projectMark to set
     */
    public void setProjectMark(double projectMark) {
        this.projectMark = projectMark;
    }

    public double calculateIndivisualTotalMarks() {

        double totalMark = getAssignmentOneMarks() + getAssignmentTwoMarks() + getProjectMark();
        return totalMark;
    }

    public String calculateGrade() {
        String grade = null;

        if (calculateIndivisualTotalMarks() <= 35 && calculateIndivisualTotalMarks() >= 0) {
            grade = "F";
        } else if (calculateIndivisualTotalMarks() <= 60 && calculateIndivisualTotalMarks() >= 36) {
            grade = "C";
        } else if (calculateIndivisualTotalMarks() <= 80 && calculateIndivisualTotalMarks() >= 61) {
            grade = "B";
        } else if (calculateIndivisualTotalMarks() <= 100 && calculateIndivisualTotalMarks() >= 81) {
            grade = "A";
        }
        return grade;
    }

    public void enterStudentRecord() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter student name:");
        setName(sc.next());
        System.out.println("Please enter student number:");
        setId(sc.next());
        System.out.println("Please enter your assignment one marks:");
        setAssignmentOneMarks(sc.nextDouble());

        while (assignmentOneMarks > 33 || assignmentOneMarks == 0) {
            System.out.println("Please enter valid marks:");
            System.out.println("Please enter your assignment one marks:");
            setAssignmentOneMarks(sc.nextDouble());
        }
        System.out.println("Please enter your assignment Two marks:");
        setAssignmentTwoMarks(sc.nextDouble());

        while (assignmentTwoMarks > 33 || assignmentTwoMarks == 0) {
            System.out.println("Please enter valid marks:");
            System.out.println("Please enter your assignment one marks:");
            setAssignmentTwoMarks(sc.nextDouble());
        }
        System.out.println("Please enter your Project marks:");
        setProjectMark(sc.nextDouble());

        while (projectMark > 33 || projectMark == 0) {
            System.out.println("Please enter valid marks:");
            System.out.println("Please enter your Project marks:");
            setProjectMark(sc.nextDouble());
        }
    }

    public void showStudentRecord() {
        System.out.println("Student name\t\tstudent number\t\tassignment one\t\tassignment two\t\tfinal project\t\t grade");
        System.out.println(getName() + "\t\t\t\t" + getId() + "\t\t\t" + getAssignmentOneMarks() + "\t\t\t" + getAssignmentTwoMarks() + "\t\t\t" + getProjectMark() + "\t\t" + calculateGrade());
//           System.out.println(name+"\t\t\t\t"+id+"\t\t\t"+assignmentOneMarks+"\t\t\t"+assignmentTwoMarks+"\t\t\t"+projectMark+"\t\t"+grade);

    }

    public void displayStatistics() {

        System.out.println(getName() + " has the maximum total marks of " + calculateIndivisualTotalMarks() + " with grade " + calculateGrade());
    }

    public void displayMinStatistics() {

        System.out.println(getName() + " has the minimum total marks of " + calculateIndivisualTotalMarks() + " with grade " + calculateGrade());
    }

}

public class Student {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice, i;

        System.out.println("enter the number of students \n");
        int no = sc.nextInt();

        Student1[] s = new Student1[no];

        for (i = 0; i < no; i++) {
            System.out.println("enter record of " + i + " student:\n");
            s[i] = new Student1();
            s[i].enterStudentRecord();
            System.out.println("\n");
        }

        do {
            // TODO code application logic here
            System.out.println("Welcome to the Grade Management System\n\n "
                    + "Please select from the following \n"
                    + "\n2.Display all student Grade\n"
                    + "3.Display Statistics\n"
                    + "4.Exit the application\n"
                    + "Enter choice==>");

            choice = sc.nextInt();

            switch (choice) {

                case 2:

                    for (i = 0; i < no; i++) {

                        s[i].showStudentRecord();

                    }

                    break;
                case 3:
                    int max = 0,
                     min = 0;
                    for (i = 0; i < no; i++) {
                        if (s[i].calculateIndivisualTotalMarks() > s[max].calculateIndivisualTotalMarks()) {
                            max = i;
                        }
                    }
                    for (i = 0; i < no; i++) {
                        if (s[i].calculateIndivisualTotalMarks() < s[min].calculateIndivisualTotalMarks()) {
                            min = i;
                        }
                    }
                    s[max].displayStatistics();
                    s[min].displayMinStatistics();

                    break;
                case 4:
                    System.out.println("enter record of ");

                    break;

                default:
                    throw new AssertionError();
            }
        } while (choice != 4);
    }
}
