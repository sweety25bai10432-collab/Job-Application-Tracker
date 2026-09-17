import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static boolean isUpcoming(String date) {

        try {

            LocalDate followUp =
                    LocalDate.parse(date, FORMAT);

            LocalDate today = LocalDate.now();

            return !followUp.isBefore(today);

        } catch (DateTimeParseException e) {

            return false;
        }
    }

    public static boolean isOverdue(String date) {

        try {

            LocalDate followUp =
                    LocalDate.parse(date, FORMAT);

            LocalDate today = LocalDate.now();

            return followUp.isBefore(today);

        } catch (DateTimeParseException e) {

            return false;
        }
    }
}