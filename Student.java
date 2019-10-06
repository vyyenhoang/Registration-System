package registrationsystem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
/**
 *
 * @author Vy Hoang - 200408803
 * 
 */
public class Student {
    
    private String fName, lName, address1, address2, address3, str3;
    private int studentNum;
    private LocalDate birthday, enrolled;
    private boolean standing;
    ArrayList<CompletedCourse> completed;
    /**
     * constructor to set value for a student
     * @param fName first name of student
     * @param lName last name
     * @param address1 street address
     * @param address2 town
     * @param address3 state
     * @param str3 code
     * @param studentNum student number (id)
     * @param enrolled enrolled date
     * @param birthday DOB
     */
    public Student(String fName, String lName, String address1, String address2, String address3, String str3, 
            int studentNum, LocalDate enrolled, LocalDate birthday) {
        this.fName = fName;
        this.lName = lName;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.str3 = str3;
        this.studentNum = studentNum;
        this.enrolled = enrolled;
        this.birthday = birthday;
        if(getAge() > 100){
            throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
        }
        this.standing = true;
        completed = new ArrayList<>();
    }

    /**
     * method to get name and number of a student
     * @return name and number of a student
     */
    @Override
    public String toString() {
        return fName+" "+lName+", student number: "+studentNum;
    }

    /**
     * method to get DOB
     * @return DOB for a student
     */
    public LocalDate getBirthday() {
        return this.birthday;
    }

    /**
     * method to get age of a student
     * @return age
     */
    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    /**
     * method to change address of a student
     * @param address1 street
     * @param address2 town
     * @param address3 state
     */
    public void changeAddress(String address1, String address2, String address3) {
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
    }

    /**
     * method to get student's address
     * @return student's address
     */
    public String getAddress() {
        return this.address1+" "+this.address2+" "+this.address3;
    }

    /**
     * method to check if student is suspended or not
     * @return boolean true/false
     */
    public boolean inGoodStanding() {
        return this.standing;
    }

    /**
     * method to suspend a student
     */
    public void suspendStudent() {
        this.standing = false;
    }

    /**
     * get the enrolled year 
     * @return enrolled year of a student
     */
    public int getYearEnrolled() {
        return this.enrolled.getYear();
    }

    /**
     * activate the suspended student
     */
    public void reinstateStudent() {
        this.standing = true;
    }

    /**
     * set DOB for a student
     * @param birthday DOB to set
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * method to add completed course to a student's list
     * @param course completed course
     * @param grade for the course
     */
    public void addCompletedCourse(Course course, int grade) {
        CompletedCourse comp = new CompletedCourse(course, grade);
        if(grade <0 || grade > 100){
            throw new IllegalArgumentException("grade must be 0-100 inclusive");
        }
        completed.add(comp);
    }

    /**
     * method to get list of completed courses
     * @return list of completed courses
     */
    public String getCompletedCourses() {
        String res = "[";
        for (int a = 0; a < completed.size(); a++) {
            res += completed.get(a);
        }
        res += "]";
        return res;
    }
    
    /**
     * method to get student number
     * @return student number
     */
    public int getStudentNumber(){
        return this.studentNum;
    }

    /**
     * method to check if the student has complete a course
     * @param course to be checked if completed or not
     * @return true/false
     */
    public boolean hasCompleted(String course) {
        boolean valid = false;
        for (int a = 0; a < completed.size(); a++) {
            if(course.equalsIgnoreCase(completed.get(a).getCourse().id) && completed.get(a).getGrade() >= 50){
                valid = true;
            }
        }
        return valid ;
    }
    
    
}
