package registrationsystem;
/**
 *
 * @author Vy Hoang - 200408803
 * 
 */
public class CompletedCourse {
    
    private Course course;
    private int grade;

    /**
     * Constructor to set values
     * @param course completed course
     * @param grade grade for the completed course
     */
    public CompletedCourse(Course course, int grade) {
        this.course = course;
        this.grade = grade;
    }

    /**
     * method to get the completed course
     * @return completed course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * method to set the completed course
     * @param course to be set as completed
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * method to get the grade for completed course
     * @return grade for completed course
     */
    public int getGrade() {
        return grade;
    }

    /**
     * method to set the grade for completed course
     * @param grade for completed course
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * method to get the completed course's information as a string
     * @return completed course's information as a string
     */
    @Override
    public String toString() {
        return course.id+"-"+course.name + " grade=" + grade;
    }
    
}
