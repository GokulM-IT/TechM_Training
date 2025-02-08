package stringHandling;

public class StringProcessor {
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    public static int countOccurrences(String text, String sub) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    public static String splitAndCapitalize(String str) {
        String[] words = str.split(" ");
        StringBuilder capitalizedString = new StringBuilder();
        for (String word : words) {
            capitalizedString.append(word.substring(0, 1).toUpperCase())
                             .append(word.substring(1).toLowerCase())
                             .append(" ");
        }
        return capitalizedString.toString().trim();
    }

    public static void main(String[] args) {
        String text = "hello world, hello universe";
        System.out.println("Reversed string: " + reverseString(text));
        System.out.println("Occurrences of 'hello': " + countOccurrences(text, "hello"));
        System.out.println("Capitalized words: " + splitAndCapitalize("hello world from java"));
    }
}
