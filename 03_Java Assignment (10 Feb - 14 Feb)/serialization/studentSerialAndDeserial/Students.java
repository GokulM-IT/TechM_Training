package serialization.studentSerialAndDeserial;

import java.io.Serializable;

class Students implements Serializable {
    int rno;
    String name;

    Students(int rno, String name) {
        this.rno = rno;
        this.name = name;
    }
}