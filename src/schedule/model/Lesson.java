package schedule.model;

//import java.util.List;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Lesson extends BaseModel {
    private Date start;
    private Time duration;
    private String name;
    private String teacher;
    private String subject;
    private String book;
    private String bookLink;
    private String homeTask;
    //private List<Group> groups;
    private boolean isOptional;
    private boolean isAlreadyPassed;

    public String toString(){
        return " /'" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(start) +
                new SimpleDateFormat(" HH:mm:ss " + name + " " + teacher + " " +
                        subject + " " + book + " " + bookLink + " " + homeTask + " " +
                        (isOptional?1:0) + " " + (isAlreadyPassed?1:0) +"/'");
    }

    public Lesson (long id, String start, String duration) throws ParseException {
        super(id);
        this.start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(start);
        this.duration = Time.valueOf(duration);
    }

    public void setTeacher(String teacher){
        this.teacher = teacher;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public void setBookLink(String bookLink) {
        this.bookLink = bookLink;
    }

    public void setHomeTask(String homeTask) {
        this.homeTask = homeTask;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getHomeTask() {
        return homeTask;
    }

    public String getBookLink() {
        return bookLink;
    }

    public String getBook() {
        return book;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public List<Group> getGroups() { return groups;}

    //public void setGroups(List<Group> groups) { this.groups = groups;}

    public boolean isOptional() {
        return isOptional;
    }

    public void setOptional(boolean optional) {
        isOptional = optional;
    }

    public boolean isAlreadyPassed() {
        return isAlreadyPassed;
    }

    public void setAlreadyPassed(boolean alreadyPassed) {
        isAlreadyPassed = alreadyPassed;
    }
}
