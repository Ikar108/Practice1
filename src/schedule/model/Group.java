package schedule.model;

public class Group extends BaseModel{
    private String number;

    public Group(long id, String number){
        super(id);
        this.number = number;
    }

    public String toString(){
        return number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number){
        this.number = number;
    }
}
