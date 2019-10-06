package registrationsystem;

import java.time.DayOfWeek;
import java.time.LocalTime;
/**
 *
 * @author Vy Hoang - 200408803
 * 
 */
public class CourseWithLab {

    Instructor instructor;
    String id, name, room;
    DayOfWeek day;
    LocalTime time;
    int num;
    Instructor labGuy;
    String room2;
    DayOfWeek day2;
    LocalTime time2;
    String prereq;

    /**
     * constructor to set values for a course with lab
     * @param instructor for the course
     * @param id of course
     * @param name of course
     * @param room venue for the class
     * @param day day for the class
     * @param time time of class
     * @param num limit for class students
     * @param labGuy to help the instructor in the lab
     * @param room2 for the lab
     * @param day2 for the lab
     * @param time2 time for the lab
     */
    public CourseWithLab(Instructor instructor, String id, String name, String room, DayOfWeek day, LocalTime time, int num, Instructor labGuy, String room2, DayOfWeek day2, LocalTime time2) {
        if(instructor.canTeach(id) || instructor.canTeach(room2)){
            this.instructor = instructor;
        }
        else throw new IllegalArgumentException("Professor "+instructor+" is not qualified to teach "+id);
        this.id = id;
        this.name = name;
        this.room = room;
        this.day = day;
        this.time = time;
        this.num = num;
        this.labGuy = labGuy;
        if(labGuy.canTeach(id+"-LAB")){
            this.labGuy = labGuy;
        }
        else throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
        this.room2 = room2;
        this.day2 = day2;
        if(time2.getHour() < 8 || time2.getHour() > 18){
            throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        }
        this.time2 = time2;
    }

    /**
     * 
     * constructor to set values for a course with lab
     * @param instructor for the course
     * @param id of course
     * @param name of course
     * @param room venue for the class
     * @param day day for the class
     * @param time time of class
     * @param num limit for class students
     * @param labGuy to help the instructor in the lab
     * @param room2 for the lab
     * @param day2 for the lab
     * @param time2 time for the lab
     * @param prereq for the lab
     */
    public CourseWithLab(Instructor instructor, String id, String name, String room, DayOfWeek day, LocalTime time, int num, String prereq, Instructor labGuy, String room2, DayOfWeek day2, LocalTime time2) {
        if(instructor.canTeach(id) || instructor.canTeach(room2)){
            this.instructor = instructor;
        }
        else throw new IllegalArgumentException("Professor "+instructor+" is not qualified to teach "+id);
        this.id = id;
        this.name = name;
        this.room = room;
        this.day = day;
        this.time = time;
        this.num = num;
        this.labGuy = labGuy;
        if(labGuy.canTeach(id+"-LAB")){
            this.labGuy = labGuy;
        }
        else throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
        this.room2 = room2;
        this.day2 = day2;
        if(time2.getHour() < 8 || time2.getHour() > 18){
            throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        }
        this.time2 = time2;
        this.prereq = prereq;
    }

    /**
     * method to get id name of the course with lab
     * @return id and name of course
     */
    @Override
    public String toString() {
        return id+"-"+name+" with lab";
    }

    /**
     * method to get time and venue for the lab
     * @return time and venue for the lab
     */
    public String getLabClassAndTime() {
        return "room: "+room2+", "+day2+" starting at "+time2;
    }

    /**
     * method to get instructor for this class
     * @return  instructor for the class
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * gets the lab guy for the class
     * @return lab guy
     */
    public Instructor getLabTech() {
        return labGuy;
    }

    /**
     * method to get the prerequisite for the course
     * @return prerequisite for the course
     */
    public String getPrerequisite() {
        return this.prereq;
    }
    
    
}
