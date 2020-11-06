package schedule.repository;

import java.sql.SQLException;

public class CONSTANTS extends BaseTable implements TableOperations {
    public CONSTANTS() throws SQLException {
        super("Groups_Students");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE CONSTANTS\n" +
                "(\n" +
                "  LengthOfTimeInterval smallint unsigned DEFAULT 7,\n" +
                "  LessonDuration time '00:45:00',\n" +
                "  ID bigint NOT NULL AUTO_INCREMENT,\n" +
                "  CONSTRAINT PK_CONSTANTS PRIMARY KEY (ID)\n" +
                ");","Создана таблица" + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {
        //super.executeSqlStatement("","Созданы связи для " + tableName);
    }
}
