
import java.util.*;
class StudentGradeTracker{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> students=new ArrayList<>();
        int choice;
        do {
            System.out.println("Student Grade Tracker") ;
            System.out.println("1.Add Student");
            System.out.println("2.Summary Report");
            System.out.println("3.Exit");
            System.out.println("Enter youir choice");
            choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:     System.out.println("Enter the student name:");
                    String name=sc.nextLine();
                    System.out.println("Enter the number of subjects");
                    int n=sc.nextInt();
                    ArrayList<Integer> grades=new ArrayList<>();

                    for(int i=0; i<n; i++){
                        System.out.println("Enter the grade for subject "+(i+1));
                        grades.add(sc.nextInt());
                    }
                    students.add(new Student(name,grades));
                    System.out.println("Student added successfully!");
                    System.out.println();
                    break;

                case 2:     System.out.println("Students Summary Report:");
                    System.out.println();
                    for(Student st: students){
                        System.out.println("Name: "+st.name);
                        System.out.println("Grades: "+st.grades);
                        System.out.println("Average Grade: "+st.getAverage());
                        System.out.println("Highest Grade: "+st.getHighest());
                        System.out.println("Lowest Grade: "+st.getLowest());
                        System.out.println();
                    }
                    System.out.println();

                    break;
                case 3:     System.out.println("Program Exiting......");
                    break;
                default: System.out.println("Invalod choice... Try again");

            }
        } while (choice!=3);
    }
}
class Student{
    String name;
    ArrayList<Integer> grades;
    Student(String name,ArrayList<Integer> grades){
        this.name=name;
        this.grades=grades;
    }
    double getAverage(){
        double sum=0;
        for(int grade:grades){
            sum+=grade;
        }
        return (double) sum/grades.size();
    }
    int getHighest(){
        return Collections.max(grades);
    }
    int getLowest(){
        return Collections.min(grades);
    }
}

