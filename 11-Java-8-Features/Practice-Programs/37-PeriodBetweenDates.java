import java.time.LocalDate;
import java.time.Period;

class PeriodBetweenDates {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2024, 1, 15);
        LocalDate end = LocalDate.of(2026, 11, 21);
        Period period = Period.between(start, end);
        System.out.println(period.getYears() + " years "
                + period.getMonths() + " months "
                + period.getDays() + " days");
    }
}
