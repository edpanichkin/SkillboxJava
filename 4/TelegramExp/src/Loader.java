import org.javagram.TelegramApiBridge;
import org.javagram.response.AuthAuthorization;
import org.javagram.response.AuthCheckedPhone;
import org.javagram.response.AuthSentCode;
import org.javagram.response.object.User;
import org.javagram.response.object.UserContact;
import org.telegram.api.contacts.TLContacts;
import org.telegram.tl.TLVector;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Loader {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TelegramApiBridge bridge = new TelegramApiBridge("149.154.167.50:443", 600667, "2c450524ef646efe2541b57acf142ca3");

        System.out.println("#####   Please enter your phone number: ");
        //AuthCheckedPhone checkedPhone = bridge.authCheckPhone(reader.readLine().trim());
        //Удаление не цифр
        bridge.authSendCode(reader.readLine().replaceAll("\\D",""));

        System.out.println("#####   Enter received code: ");
        String sentCode = reader.readLine();
        System.out.println(sentCode);

        AuthAuthorization authAuthorization = bridge.authSignIn(sentCode);
        System.out.println("#####  SignIn user id is: " + authAuthorization.getUser() + ", hash " + authAuthorization.hashCode());

        ArrayList<UserContact> contacts = bridge.contactsGetContacts();
        for (UserContact item : contacts) {
            System.out.println("++++++++ Контакт: " + item + " / Телефон: "+ item.getPhone());
        }
    }
}
