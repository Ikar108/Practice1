package schedule.repository;

import java.sql.SQLException;

public class Students extends BaseTable implements TableOperations {

    public Students() throws SQLException {
        super("Students");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE Students\n" +
                "(\n" +
                "  PK_Students_id bigint NOT NULL AUTO_INCREMENT,\n" +
                "  Name text NOT NULL,\n" +
                "  Group_id bigint,\n" +
                "  CONSTRAINT PK_Students PRIMARY KEY (PK_Students_id)\n" +
                ");","Создана таблица" + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE Students ADD CONSTRAINT FK_Students_PK_GroupNumber_id\n" +
                "  FOREIGN KEY (Group_id) REFERENCES Groups (PK_id);","Созданы связи для " + tableName);
    }
}
