package registrationsystem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
/**
 *
 * @author Vy Hoang - 200408803
 * 
 */
public class Instructor {
    
    private String fName, lName;
    private int num1;
    private String add1, add2, add3;
    LocalDate joined, birthday;
    ArrayList<String> courses = new ArrayList<>();
    /**
     * constructor to set values for a student
     * @param fName for a student
     * @param lName for student
     * @param num1 instructors id
     * @param add1 street address
     * @param add2 town address
     * @param add3 state address
     * @param joined college hiring date
     * @param birthday DOB for the instructor
     */
    public Instructor(String fName, String lName, int num1, String add1, String add2, String add3, LocalDate joined, LocalDate birthday) {
        this.fName = fName;
        this.lName = lName;
        this.num1 = num1;
        this.add1 = add1;
        this.add2 = add2;
        this.add3 = add3;
        this.joined = joined;
        this.birthday = birthday;
        if(getAgeInYears() > 100){
            throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old");
        }
        if(yearsAtCollege() > 80){
            throw new IllegalArgumentException(joined.getYear()+"-0"+joined.getMonthValue()+"-"+joined.getDayOfMonth()+" as a hire date would mean "+fName+" started working over 80 years ago");
        }
    }

    /**
     * method to get name of instructor
     * @return full name of instructor
     */
    @Override
    public String toString() {
        return fName+" "+lName;
    }

    /**
     * method to get age of instructor
     * @return age of instructor
     */
    public int getAgeInYears() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
    
    
    public void setBirthday(LocalDate birthday) {
        int age = birthday.getYear();
            if(age > 100){
            throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old");
        }
    }

    /**
     * method to get years spent at college for a instructor
     * @return years spent at college for a instructor
     */
    public int yearsAtCollege() {
     return Period.between(joined, LocalDate.now()).getYears();
    }
    /**
     * method to change address of a instructor
     * @param add1 street
     * @param add2 town
     * @param add3 state
     */
    public void changeAddress(String add1, String add2, String add3) {
        this.add1 = add1;
        this.add2 = add2;
        this.add3 = add3;
    }

    /**
     * method to get complete address
     * @return complete address
     */
    public String getAddress() {
        return this.add1+", "+this.add2+", "+this.add3;
    }

    /**
     * method to get list of courses that this instructor can teach
     * @return list of courses this instructor can teach
     */
    public String listOfSubjectsCertifiedToTeach() {
        if(courses.size() == 0)
            return "not qualified to teach courses yet.";
        return courses.toString();
    }

    /**
     * method to add course to a instructor's abilities
     * @param course to be added to instructor's abilities
     */
    public void addCourseToAbilities(String course) {
        if(!courses.contains(course))
            courses.add(course);
    }

    public boolean canTeach(String course) {
        if(courses.contains(course))
            return true;
        return false;
            
    }
   
}
