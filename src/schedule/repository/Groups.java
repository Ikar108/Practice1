package schedule.repository;

import java.sql.SQLException;

public class Groups extends BaseTable implements TableOperations {
    public Groups() throws SQLException {
        super("Groups");
        listOfColumns = " GroupNumber ";
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE Groups\n" +
                "(\n" +
                "  PK_id bigint NOT NULL AUTO_INCREMENT,\n" +
                "  GroupNumber text NOT NULL,\n" +
                "  CONSTRAINT PK_Groups PRIMARY KEY (PK_id)\n" +
                ");", "Создана таблица" + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
