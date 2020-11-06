package schedule.model;

public class Student extends BaseModel {
    private String name;
    private long groupId;

    public String toString(){
        return name + " " + groupId + "";
    }

    public Student(long id, String name, long groupId){
        super(id);
        this.name = name;
        this.groupId = groupId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
}
