package primitiveAndReference;

enum DaysOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class EnumExample {
    public static void checkHoliday(DaysOfWeek day) {
        if (day == DaysOfWeek.SATURDAY || day == DaysOfWeek.SUNDAY) {
            System.out.println(day + " is a Holiday.");
        } else {
            System.out.println(day + " is Not a Holiday.");
        }
    }

    public static void main(String[] args) {
        checkHoliday(DaysOfWeek.MONDAY);
        checkHoliday(DaysOfWeek.SUNDAY);
    }
}
