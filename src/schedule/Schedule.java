package schedule;

import schedule.model.Group;
import schedule.model.Lesson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

//https://vk.com
public class Schedule {
    private final int lastingPerMinutes;
    private int lastTimeZoneGw;
    private long actualizeTime;
    private boolean relevance;
    private List<Lesson> lessons;
    //нужно придумать, как установить первый день(начало отсчёта)
    //выделить обращение к БД в отдельную функцию?
    //выделить проверку существования в отдельную функцию
    //лучше сделать функцию активации, которая устанавливает таймзону, проверяет существование БД и выгружает объекты во внутренний список
    private void actualization(){
        //TimeZone
        actualizationOfTimeZone();
        //Проверяем существование расписания или создаём его
        //Сделать! загружаем в лист расписание уже со смещением по времени
        Path schedulePath = Path.of("Schedule.txt");
        if (!Files.exists(schedulePath)){
            try {
                Files.createFile(schedulePath);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Schedule.txt creation fail");
            }
        }

    }
    public Schedule (){
        this.lastingPerMinutes = 7 * 24 * 3600;
        actualization();
    }
    //проверять часовой пояс и менять для всего расписания
    protected int actualizationOfTimeZone(){
        int change = GregorianCalendar.getInstance().getTimeZone().getRawOffset() / 3600000 - this.lastTimeZoneGw;
        this.lastTimeZoneGw = GregorianCalendar.getInstance().getTimeZone().getRawOffset() / 3600000;
        return change;
    }
    //сделал функцию, добавить во все функции
    protected void setLesson(Lesson lesson, Group...groups) throws IOException {

        //выгружаем текущее расписание
        //сделать формат start/duration + ' ' + group1/group2/.../groupn/
        List<String> schedule = Files.readAllLines(Path.of("Schedule.txt"));

        //переписывать файл каждый раз? Да.
        /*
        try {
            for (String ln : schedule) {
                int begin = Integer.getInteger(ln.substring(0, ln.indexOf('/')));
                int duration = Integer.getInteger(ln.substring(ln.indexOf('/'),ln.indexOf(' ')));
                if (begin < lesson.getStart() && begin + duration > lesson.getStart()) {
                    throw new IllegalArgumentException();
                }
                //сделать зацикливание недели
                if (begin > lesson.getStart()){
                    StringBuilder newLesson = new StringBuilder(lesson.getStart() + "/" + lesson.getDuration() + " ");
                    for (Group group : groups) newLesson.append(group.getNumber()).append("/");
                }

            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("You have lesson at this time");
        }*/

    }
    protected void removeLesson(){
        //Проверка существования расписания и Запрос Объектов из БД
        //выгрузка объектов назад
    }
    protected List<Lesson> getSchedule(){
        //Проверка существования расписания
        //Запрос объектов
        //Вернуть список?
        return null;
    }
    //написать нормальные геттеры
    //разобраться с выгрузкой и всё понятно
    protected void nextLesson(){
    }//просто проверяю по текущей дате от начала отсчёта
    protected void nextLesson(Group group){}
    protected void getGroup(Lesson lesson){}//зачем?


}
