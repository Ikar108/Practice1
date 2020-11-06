package schedule;

import schedule.model.Group;
import schedule.model.Lesson;

public class IScheduleStatistic extends Schedule {
    //оконный или консольный(текстовый) интерфейс для взаимодействия с пользователем
    public void activate(){}

    //разработать логику работы
    private void checkAttendance(Lesson lesson){}

    private void getAttendance(String students, int period){}

    private void getAttendance(int day, int period){}

    private void getAttendance(Lesson lesson, int period){}

    private void getAttendance(Group group, int period){}

    private void skipLesson(){}

}
