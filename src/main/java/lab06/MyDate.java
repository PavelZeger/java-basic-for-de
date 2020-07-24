package lab06;

import java.util.Objects;

/**
 * @author Pavel Zeger
 */
public class MyDate {

    private int day;
    private int month;
    private int year;

    public MyDate(int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate() {
        this.year = 1900;
        this.month = 1;
        this.day = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return day == myDate.day &&
                month == myDate.month &&
                year == myDate.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        String date = String.format("%s-%s-%s",
                year,
                month < 10 ? "0" + month : month,
                day);
        return date;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isLeapYear() {
        if (year % 4 != 0) {
            return false;
        } else if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public int numOfDaysInYear() {
        if (isLeapYear()) {
            return 366;
        } else {
            return 365;
        }
    }

    public int getNumberOfDays(int month, boolean isLeapYear) {
        int num = 0;
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                num = 31; break;
            case 2: num = isLeapYear ? 29 : 28; break;
            case 4:
            case 6:
            case 9:
            case 11:
                num = 30; break;
        }
        return num;
    }

    public int dayOfYear(int month, int day) {
        int dayOfYear = 0;
        for (int i = 0; i < month; i++) {
            dayOfYear += getNumberOfDays(i, isLeapYear());
        }
        return dayOfYear + day;
    }
}
