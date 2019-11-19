import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Pattern regexp = Pattern.compile("<[a-z]+>");
        Matcher m = regexp.matcher("<agggggg><b-><1> <><c><d/>");
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
