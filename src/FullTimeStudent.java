import java.util.ArrayList;

public class FullTimeStudent extends Student{
    public String TypeOfStudy = "FULL_TIME";

    @Override
    public String getTypeOfStudy() {
        return TypeOfStudy;
    }

    FullTimeStudent(Long ID, String name, String secondName) {
        super(ID, name, secondName);
    }
}
