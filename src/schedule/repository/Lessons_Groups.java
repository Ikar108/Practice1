package schedule.repository;

import java.sql.SQLException;

public class Lessons_Groups extends BaseTable implements TableOperations{
    public Lessons_Groups() throws SQLException {
        super("Lessons_Groups");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE Lessons_Groups\n" +
                "(\n" +
                "  LessonsId bigint NOT NULL,\n" +
                "  Group_id bigint NOT NULL,\n" +
                "  ID bigint NOT NULL,\n" +
                "  CONSTRAINT PK_Lessons_Groups PRIMARY KEY (ID)\n" +
                ");","Создана таблица" + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE Lessons_Groups ADD CONSTRAINT FK_Lessons_Groups_Lesson_id\n" +
                "  FOREIGN KEY (LessonsId) REFERENCES Lessons (Lesson_id);\n" +
                "\n" +
                "ALTER TABLE Lessons_Groups ADD CONSTRAINT FK_Lessons_Groups_PK_id\n" +
                "  FOREIGN KEY (Group_id) REFERENCES Groups (PK_id);","Созданы связи для " + tableName);
    }
}
