package Task_01;

/*You are required to create a string and capitalize every alternative character. for
eg : if the input is anurag then output should be AnUrAg*/

public class CapitalizeAlternatingCharacters {
    public static void main(String[] args) {
        String input = "anurag";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(input.charAt(i)));
            } else {
                result.append(Character.toLowerCase(input.charAt(i)));
            }
        }

        System.out.println("Transformed String: " + result);
    }
}
