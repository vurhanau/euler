package euler;

public class P19_CountingSundays {

    public static void main(String[] args) {
        int[] daysInMonth = {
                31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        int[] leapDaysInMonth = {
                31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        int match = 0;
        int offset = 365 % 7 + 1;
        for (int year = 1901; year <= 2000; year++) {
            int[] days = year % 4 == 0 && year % 400 != 0 ? leapDaysInMonth : daysInMonth;
            for (int month = 0; month < days.length; month++) {
                if (offset % 7 == 0) {
                    match++;
                }

                offset += days[month];
            }
        }

        System.out.println(match);
    }
}
