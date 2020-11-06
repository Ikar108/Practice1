package schedule.service;

import java.sql.*;
import schedule.repository.*;

public class ScheduleDB {
    private static final String DB_URL = "jdbc:h2:/"+System.getProperty("user.dir")+"/db/sheduleDB";
    private static final String DB_Driver = "org.h2.Driver";
    // Таблицы СУБД
    Students students;
    Lessons lessons;
    Groups groups;
    StudentsWhoPassedTheLesson studentsWhoPassedTheLesson;
    CONSTANTS CONSTANTS;
    Lessons_Groups lessons_groups;
    //Флаги
    //private static boolean isCreated = false;


    // Получить новое соединение с БД
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    // Инициализация
    public ScheduleDB() throws SQLException, ClassNotFoundException {
        Class.forName(DB_Driver);
        // Инициализируем таблицы
        students = new Students();
        groups = new Groups();
        lessons = new Lessons();
        studentsWhoPassedTheLesson = new StudentsWhoPassedTheLesson();
        CONSTANTS = new CONSTANTS();
        lessons_groups = new Lessons_Groups();
    }

    public static boolean getIsCreated() {
        return true;
    }

    //public static void setIsCreated(boolean isCreated) {ScheduleDB.isCreated = isCreated; }

    // Создание всех таблиц и ключей между ними
    public void createTablesAndForeignKeys() throws SQLException {
        groups.createTable();
        lessons.createTable();
        studentsWhoPassedTheLesson.createTable();
        CONSTANTS.createTable();
        lessons_groups.createTable();
        students.createTable();
        // Создание внешних ключей (связей между таблицами)
        studentsWhoPassedTheLesson.createForeignKeys();
        students.createForeignKeys();
        lessons_groups.createForeignKeys();
    }
}
