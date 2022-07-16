public class PartTimeStudent extends Student{
    public String TypeOfStudy = "PART_TIME";

    @Override
    public String getTypeOfStudy() {
        return TypeOfStudy;
    }

    PartTimeStudent(Long ID, String name, String secondName) {
        super(ID, name, secondName);
    }
}
