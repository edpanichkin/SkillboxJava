import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) {
//сказка

        //100 слов наверно нет смысла, все лишнее убирается

        String tales = "Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of Are you ready for this, Amy?” David asked his daughter. The girl finished tying the laces of ";
        // tale=tales.replaceAll("\\w","");
        String talesArr[] = tales.split("\\s+");

        for (int i=0; i<talesArr.length;i++){
            talesArr[i]=talesArr[i].replaceAll("\\W","");
            System.out.println(talesArr[i]);

        }

    }
}
