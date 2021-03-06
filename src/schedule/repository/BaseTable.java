package schedule.repository;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import schedule.service.ScheduleDB;

// Сервисный родительский класс, куда вынесена реализация общих действий для всех таблиц
public abstract class BaseTable implements Closeable,TableOperations {
    Connection connection;  // JDBC-соединение для работы с таблицей
    String tableName;       // Имя таблицы
    public String listOfColumns;

    BaseTable(String tableName) throws SQLException { // Для реальной таблицы передадим в конструктор её имя
        this.tableName = tableName;
        this.connection = ScheduleDB.getConnection(); // Установим соединение с СУБД для дальнейшей работы
    }

    // Закрытие
    public void close() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            System.out.println("Ошибка закрытия SQL соединения!");
        }
    }

    // Выполнить SQL команду без параметров в СУБД, по завершению выдать сообщение в консоль
    void executeSqlStatement(String sql, String description) throws SQLException {
        reopenConnection(); // переоткрываем (если оно неактивно) соединение с СУБД
        Statement statement = connection.createStatement();  // Создаем statement для выполнения sql-команд
        statement.execute(sql); // Выполняем statement - sql команду
        statement.close();      // Закрываем statement для фиксации изменений в СУБД
        if (description != null)
            System.out.println(description);
    }

    void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, null);
    }


    // Активизация соединения с СУБД, если оно не активно.
    void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = ScheduleDB.getConnection();
        }
    }

    @Override
    public ResultSet read(Connection connection, String select) throws SQLException{
        return connection.prepareStatement(select).executeQuery();
    }

    @Override
    public ResultSet readAll(Connection connection) throws SQLException {
        return connection.prepareStatement("SELECT * FROM " + tableName).executeQuery();
    }

    @Override
    public void deleteTable() throws SQLException {
        this.executeSqlStatement("DROP TABLE " + tableName);
    }

    @Override
    public void cleanTable() throws SQLException {
        this.executeSqlStatement("TRUNCATE TABLE " + tableName);
    }
    //Переделать через BaseModel?
    @Override
    public void insert(String data) throws SQLException {
        this.executeSqlStatement("INSERT into " + tableName + " (" + listOfColumns + ") " + " values (" + data + ")");
    }

    @Override
    public void delete(String data) throws SQLException {
        this.executeSqlStatement("DELETE" + tableName + " " + data + "");
    }

}
