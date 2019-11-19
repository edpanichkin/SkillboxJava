import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Loader {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(1985, 7,3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - E");

        int yearDelta = date.getYear() - dateOfBirth.getYear();
        for (int i = 0; i <= yearDelta; i++)
        {
            date = dateOfBirth.plusYears(i);
            System.out.printf("%d Years - %s %n ", i, date.format(formatter));
        }
    }
        /*Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatDate = new SimpleDateFormat(" - dd.MM.yyyy - E", Locale.ENGLISH);

        int bYear = 1985;
        int yearNow = calendar.get(Calendar.YEAR);

        for (int i = bYear; i < yearNow; i++) {
            calendar.set(i, Calendar.FEBRUARY, 03, 16, 00);
            System.out.println((i - bYear) + formatDate.format(calendar.getTime()));
        }

            if ((Calendar.getInstance().get(Calendar.MONTH)-calendar.get(Calendar.MONTH))>=0){
                System.out.println((yearNow - bYear) + formatDate.format
                        (calendar.set(Calendar.YEAR)));
            }

        }*/


        }

