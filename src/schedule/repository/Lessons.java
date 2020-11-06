package schedule.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lessons extends BaseTable implements TableOperations {

    public Lessons() throws SQLException {
        super("Lessons");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE Lessons\n" +
                "(\n" +
                "  Lesson_id bigint NOT NULL AUTO_INCREMENT,\n" +
                "  Start datetime NOT NULL,\n" +
                "  Duration time,\n" +
                "  Name text,\n" +
                "  Teacher text,\n" +
                "  Subject text,\n" +
                "  Book text,\n" +
                "  BookLink text,\n" +
                "  HomeTask text,\n" +
                "  IsOptional bit(1) NOT NULL DEFAULT 0 COMMENT '0 is false\\n1 is true',\n" +
                "  IsAlreadyPassed bit(1) DEFAULT 0 COMMENT '0 is false\\n1 is true',\n" +
                "  CONSTRAINT PK_Lessons PRIMARY KEY (Lesson_id)\n" +
                ");","Создана таблица" + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
