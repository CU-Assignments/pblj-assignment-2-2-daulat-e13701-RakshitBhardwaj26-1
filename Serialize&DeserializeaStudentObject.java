import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    double gpa;

    Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}

class StudentSerialization {
    public static void serialize(Student s, String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(s);
            System.out.println("Serialized Successfully");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static Student deserialize(String file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Student) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        String file = "student.ser";
        Student s = new Student(1, "Alice", 3.8);
        serialize(s, file);
        System.out.println("Deserialized: " + deserialize(file));
    }
}
