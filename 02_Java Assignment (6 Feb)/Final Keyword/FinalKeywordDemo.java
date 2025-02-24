package finalKeyword;

public class FinalKeywordDemo {
    public static void main(String[] args) {
        FinalClass finalClass = new FinalClass();
        
        System.out.println("Accessing final variable: " + finalClass.finalVariable);
        
        finalClass.finalMethod();
    }
}