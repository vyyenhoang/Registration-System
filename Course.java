
package registrationsystem;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Vy Hoang - 200408803
 * 
 */
public class Course {

    Instructor instructor;
    String id, name, room;
    DayOfWeek day;
    LocalTime time;
    int limit;
    String prereq;
    ArrayList<Student> students;
    int counter = 0;

    /**
     * constructor method to set the values for a course
     * @param instructor teacher of course
     * @param id course id
     * @param name course name
     * @param room venue for the class to be held in
     * @param day day of the class
     * @param time tie for the class
     * @param limit maximum number of students in the class
     */
    public Course(Instructor instructor, String id, String name, String room, DayOfWeek day, LocalTime time, int limit) {
       
        this.id = id;
        this.name = name;
        this.room = room;
        this.day = day;
        this.time = time;
        this.limit = limit;
        students = new ArrayList<>();
        
        
         if(instructor.canTeach(id)){
            this.instructor = instructor;
        }
        else throw new IllegalArgumentException("Professor "+instructor+" is not qualified to teach "+id);
         
         
          if(time.getHour() < 8 || time.getHour() > 18 || (time.getHour() == 18 && time.getMinute() > 0)){
            throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
        }
    }

    /**
     * constructor method to set the values for a course
     * @param instructor teacher of course
     * @param id course id
     * @param name course name
     * @param room venue for the class to be held in
     * @param day day of the class
     * @param time tie for the class
     * @param limit maximum number of students in the class
     * @param prereq prerequisite of the course
     */
    public Course(Instructor instructor, String id, String name, String room, DayOfWeek day, LocalTime time, int limit, String prereq) {
        if(instructor.canTeach(id)){
            this.instructor = instructor;
        }
        else throw new IllegalArgumentException("Professor "+instructor+" is not qualified to teach "+id);
        this.id = id;
        this.name = name;
        this.room = room;
        this.day = day;
        if(time.getHour() < 8 || time.getHour() > 18 || (time.getHour() == 18 && time.getMinute() > 0)){
            throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
        }
        this.time = time;
        this.limit = limit;
        this.prereq = prereq;
        students = new ArrayList<>();
    }

    /**
     * method to return id and name of a course
     * @return id and name of a course
     */
    @Override
    public String toString() {
        return id+"-"+name;
    }

    /**
     * returns the room of class
     * @return room(venue) for the class
     */
    public String getRoom() {
        return this.room;
    }

    /**
     * method to return day and time of the class
     * @return day and time of the class
     */
    public String getCourseDayAndTime() {
        return day+"'s, starting at "+time;
    }

    /**
     * get instructor for a course
     * @return instructor for a course
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * method to add a new student to a course
     * @param s student object to be added
     * @return string based on the performed action 
     */
    public String addStudent(Student s) {
        if(s.inGoodStanding()){
            
                if(counter < limit){
                    
                    students.add(s);
                    counter++;
                    return "Student Added";
                }
                else
                    return "Student was not added because the course is full";
            
        }
        else return "The Student is not in good standing and cannot join the course.";
    }

    /**
     * return the students registered in the course
     * @return list of class 
     */
    public String showClassList() {
        return this.students.get(0).toString();
    }

    /**
     * method to updated class students limit
     * @param i new size of the class 
     * @return string based on the performed action
     */
    public String setClassSize(int i) {
        if(i > 40){
            this.limit = 40;
            return "Max class size = 40, it has been set to 40";
        }
        else{
            this.limit = i;
            return "Size Set";
        }
    }

    /**
     * return the total size of a class
     * @return 
     */
    public int getClassSize() {
        return this.limit;
    }

    /**
     * checks if the class is mature or not based on the average age of students
     * @return true or false, for the maturity of class
     */
    public boolean matureClass() {
        double sum = 0;
        double avg;
        for (int a = 0; a < counter; a++) {
            sum += students.get(a).getAge();
        }
        avg = sum/counter;
        if(avg > 25)
            return true;
        else
        return false;
    }

    /**
     * method to get prerequisite of this course
     * @return prerequisite of this course
     */
    public String getPrerequisite() {
        return this.prereq;
    }
    
    
    
}
