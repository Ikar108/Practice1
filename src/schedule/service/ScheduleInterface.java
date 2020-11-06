package schedule.service;

import schedule.repository.Lessons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ScheduleInterface {
    public static void menu(){
        System.out.println();
        System.out.println("1. Groups");
        System.out.println("2. Lessons");
        System.out.println("3. Students");
        System.out.println("4. Exit");

    }
    public static void activateByConsole(){
        Scanner scanner = new Scanner(System.in);
        String nextLine;
        menu();
        //while ((nextLine = scanner.nextLine()).equals("Exit")){}

    }
    public static void main(String[] args) throws SQLException {
        if (!ScheduleDB.getIsCreated()) {
            try {
                //создание таблиц - есть смысл делать единожды?
                ScheduleDB scheduleDB = new ScheduleDB();
                scheduleDB.createTablesAndForeignKeys();
                //ScheduleDB.setIsCreated(true);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Ошибка SQL !");
            } catch (ClassNotFoundException e) {
                System.out.println("JDBC драйвер для СУБД не найден!");
            }
        }
        activateByConsole();
        ScheduleDB s = null;
        try {
            s = new ScheduleDB();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        s.groups.insert("'M33011'");
        ResultSet rset = s.groups.readAll(ScheduleDB.getConnection());
        for(int i = 1;rset.next();i++) System.out.println(rset.getNString(1) + " " + rset.getNString(2));
        s.groups.cleanTable();

    }
}
