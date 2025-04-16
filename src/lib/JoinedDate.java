package lib;
public class JoinedDate {
    private int year;
    private int month;
    private int day;

    public JoinedDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public LocalDate toLocalDate() {
        return LocalDate.of(year, month, day);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }
}
