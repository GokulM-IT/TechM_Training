package finalKeyword;

final class FinalClass {
    final int finalVariable = 100;

    public final void finalMethod() {
        System.out.println("This is a final method in the FinalClass.");
    }

    public void display() {
        System.out.println("The final variable value is: " + finalVariable);
    }
}