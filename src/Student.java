public class Student{

    private String name;
    private String secondName;
    private Long ID;
    private String TypeOfStudy;
    public Student(Long ID, String name, String secondName) {
        this.ID = ID;
        this.name = name;
        this.secondName = secondName;
    }

    public Student(){}

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public Long getID() {
        return ID;
    }

    public String getTypeOfStudy() {
        return TypeOfStudy;
    }
}
