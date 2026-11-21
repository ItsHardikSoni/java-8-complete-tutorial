import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class DateFormatter {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2026, 11, 21);
        String formatted = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(formatted);
    }
}
