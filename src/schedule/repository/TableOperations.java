package schedule.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

// Операции с таблицами
public interface TableOperations {
    void createTable() throws SQLException; // создание таблицы
    void createForeignKeys() throws SQLException; // создание связей между таблицами
    void deleteTable() throws SQLException; // удаление таблицы
    void cleanTable() throws SQLException; // очищение таблицы
    ResultSet read(Connection connection, String select) throws SQLException; // чтение из таблицы
    ResultSet readAll(Connection connection) throws SQLException; // чтение всей таблицы
    void insert(String data) throws SQLException; // вставка в таблицу
    void delete(String data) throws SQLException; // удаление из таблицы
}
