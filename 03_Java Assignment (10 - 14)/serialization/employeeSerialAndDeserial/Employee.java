package serialization.employeeSerialAndDeserial;

import java.io.Serializable;

public class Employee implements Serializable {
    int Eno;
    String name;
    transient String email;

    Employee(int Eno, String name, String email) {
        this.Eno = Eno;
        this.name = name;
        this.email = email;
    }
}
