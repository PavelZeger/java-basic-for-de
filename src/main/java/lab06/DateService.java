package lab06;

/**
 * @author Pavel Zeger
 */
public class DateService {

    /**
     *
     * @param date1
     * @param date2
     * @return number of days between two dates
     */
    public int differenceInDays(MyDate date1, MyDate date2){
        int day1 = date1.getDay();
        int day2 = date2.getDay();
        int month1 = date1.getMonth();
        int month2 = date2.getMonth();
        int year1 = date1.getYear();
        int year2 = date2.getYear();
        int startYearDays = date1.numOfDaysInYear() - date1.dayOfYear(month1, day1);
        int betweenYearsDays = 0;
        int endYearsDays = 0;
        if ((year2 - year1) > 1) {
            for (int i = year1; i < year2; i++) {
                MyDate date = new MyDate(i, 1, 1);
                betweenYearsDays += i * date.numOfDaysInYear();
            }
            endYearsDays = date2.dayOfYear(month2, day2);
        }
        return startYearDays + betweenYearsDays + endYearsDays;
    }

    /**
     *
     * @param from
     * @param daysToAdd
     * @return date after adding number of days
     */
    public MyDate addDays(MyDate from, int daysToAdd) {
        int day = from.getDay();
        int month = from.getMonth();
        int year = from.getYear();
        while (daysToAdd > 0) {
            if (day + daysToAdd > from.getNumberOfDays(month, from.isLeapYear())) {
                daysToAdd -= (from.getNumberOfDays(month, from.isLeapYear()) - day + 1);
                day = 1;
                month++;
                if (month > 12) {
                    year++;
                    month -= 12;
                }
            } else {
                day += daysToAdd;
                daysToAdd = 0;
            }
        }
        return new MyDate(year, month, day);
    }

}
