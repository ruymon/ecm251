import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public static Date parse(String text) {
        text = text.trim();
        if (!text.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            throw new IllegalArgumentException("Use uma data no formato dd/MM/aaaa.");
        }

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false); // Rejects dates such as 31/02/2026.
        ParsePosition position = new ParsePosition(0);
        Date date = format.parse(text, position);
        if (date == null || position.getIndex() != text.length()) {
            throw new IllegalArgumentException("Data invalida.");
        }
        return date;
    }

    public static String format(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
}
