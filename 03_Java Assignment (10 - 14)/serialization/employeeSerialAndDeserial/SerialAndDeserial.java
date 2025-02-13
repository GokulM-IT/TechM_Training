package serialization.employeeSerialAndDeserial;

import java.io.*;

public class SerialAndDeserial {
    static void serialization() throws IOException {
        try {
            //Creating the object
            Employee employee = new Employee(211, "ravi", "example@gmail.com");
            //Creating stream and writing the object
            FileOutputStream fileOutputStream = new FileOutputStream("f.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(employee);
            outputStream.flush();
            //closing the stream
            outputStream.close();
            System.out.println("success");
        } catch (Exception error) {
            System.out.println("Error: " + error);
        }
    }

    static void deserialization() throws IOException {
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("f.txt"));
            Employee employee = (Employee) in.readObject();
            //printing the data of the serialized object
            System.out.println(employee.Eno + " " + employee.name);
            //closing the stream
            in.close();
        } catch (Exception error) {
            System.out.println("Error: " + error);
        }
    }

    public static void main(String[] args) {
        try {
            serialization();
            deserialization();
        } catch (IOException error) {
            System.out.println("Error: " + error);
        }
    }
}
