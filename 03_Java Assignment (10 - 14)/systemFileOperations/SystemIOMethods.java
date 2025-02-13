package systemFileOperations;

public class SystemIOMethods {
    static void systemPrint() {
        System.out.print("Hello, I'm print ");
    }

    static void systemPrintln() {
        System.out.println("Hello, I'm println");
    }

    void systemErr() {
        System.err.println("Hello, I'm Error");
    }

    public static void main(String[] args) {
        systemPrint();
        systemPrintln();
        SystemIOMethods sysIO = new SystemIOMethods();
        sysIO.systemErr();
    }
}
