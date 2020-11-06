package schedule.repository;

import java.sql.SQLException;

public class StudentsWhoPassedTheLesson extends BaseTable implements TableOperations {

    public StudentsWhoPassedTheLesson() throws SQLException {
        super("Statistic");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE Stuents_WhoPassedTheLesson\n" +
                "(\n" +
                "  PK_Statistic_Id bigint NOT NULL AUTO_INCREMENT,\n" +
                "  LessonId bigint,\n" +
                "  StudentId bigint,\n" +
                "  CONSTRAINT PK_Statistic PRIMARY KEY (PK_Statistic_Id)\n" +
                ");","Создана таблица" + tableName);
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE Stuents_WhoPassedTheLesson ADD CONSTRAINT FK_Statistic_Lesson_id\n" +
                "  FOREIGN KEY (LessonId) REFERENCES Lessons (Lesson_id);\n" +
                "\n" +
                "ALTER TABLE Stuents_WhoPassedTheLesson ADD CONSTRAINT FK_Statistic_PK_Students_id\n" +
                "  FOREIGN KEY (StudentId) REFERENCES Students (PK_Students_id);","Созданы связи для " + tableName);
    }
}
