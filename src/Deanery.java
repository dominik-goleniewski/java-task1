import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Deanery {
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();

    private static String createRaport(Student student, String roomNumber) {
        return "------------------------------------------" +
                "\n" +
                String.format("%20s", "STUDENT ") + student.getID().toString() +
                "\n" + "\n" +
                "First Name" + String.format("%10s", " ") + "|" + String.format("%3s", " ") + student.getName() + "\n" +
                "Second Name" + String.format("%9s", " ") + "|" + String.format("%3s", " ") + student.getSecondName() + "\n" + "\n" +
                "Raport generated on " + dtf.format(now) + "\n" +
                "Room number: " + roomNumber +
                "\n" +
                "------------------------------------------";
    }

    public static void serve(Student student, String roomNumber, int hour) {
        if (!(roomNumber.equals(Rooms.A123.toString())||roomNumber.equals(Rooms.B123.toString())||roomNumber.equals(Rooms.C124.toString())||roomNumber.equals(Rooms.D124.toString()))) {
            throw new RuntimeException("The room does not match any od Deanery's rooms");
        }
        if (Rooms.valueOf(roomNumber) == Rooms.A123) {
            if (student.getTypeOfStudy() == "FULL_TIME") {
                if (hour >= Rooms.A123.getRoomHour().getStartHour() && hour <= Rooms.A123.getRoomHour().getEndHour()) {
                    System.out.println(createRaport(student, roomNumber));
                }
                else {
                    throw new RuntimeException("Wrong hours to serve student!");
                }
            }
            else {
                throw new RuntimeException("Student is on a part-time type of study!");
            }
        } else if (Rooms.valueOf(roomNumber) == Rooms.B123) {
            if (student.getTypeOfStudy() == "FULL_TIME") {
                if (hour >= Rooms.B123.getRoomHour().getStartHour() && hour <= Rooms.B123.getRoomHour().getEndHour()) {
                    System.out.println(createRaport(student, roomNumber));
                } else {
                    throw new RuntimeException("Wrong hours to serve student!");
                }
            }
            else {
                throw new RuntimeException("Student is on a part-time type of study!");
            }
        } else if (Rooms.valueOf(roomNumber) == Rooms.C124) {
            if (student.getTypeOfStudy() == "PART_TIME") {
                if (hour >= Rooms.C124.getRoomHour().getStartHour() && hour <= Rooms.C124.getRoomHour().getEndHour()) {
                    System.out.println(createRaport(student, roomNumber));
                }
                else {
                    throw new RuntimeException("Wrong hours to serve student!");
                }
            }
            else {
                throw new RuntimeException("Student is on a full-time type of study!");
            }

        } else if (Rooms.valueOf(roomNumber) == Rooms.D124) {
            if(student.getTypeOfStudy() == "PART_TIME") {
                if (hour >= Rooms.D124.getRoomHour().getStartHour() && hour <= Rooms.D124.getRoomHour().getEndHour()) {
                    System.out.println(createRaport(student, roomNumber));
                }
                else {
                    throw new RuntimeException("Wrong hours to serve student!");
                }
            }
            else {
                throw new RuntimeException("Student is on a full-time type of study!");
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Student> studentList = new ArrayList<>();
        Student student1 = new PartTimeStudent(132124L, "Adam", "Bartek");
        Student student2 = new FullTimeStudent(231345L, "Czarek", "Darek");
        Student student3 = new PartTimeStudent(345245L, "Eryk", "Franek");
        Student student4 = new FullTimeStudent(443145L, "Gosia", "Halina");
        Student student5 = new PartTimeStudent(531134L, "Irena", "Joasia");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        Scanner scanner = new Scanner(System.in);
        Student tmpStudent;

        while (true) {
            System.out.println("Enter the room number:");
            String roomNumber = scanner.nextLine();
            System.out.println("Enter the hour:");
            int hour = scanner.nextInt();
            System.out.println("Enter the student ID:");
            Long studentID = scanner.nextLong();
            tmpStudent = studentList.stream()
                    .filter(student -> student.getID().equals(studentID))
                    .findFirst()
                    .get();
            serve(tmpStudent, roomNumber, hour);
            scanner.nextLine();
        }
    }
}
