import org.apache.commons.validator.routines.EmailValidator;

import java.util.Scanner;

public class Enter {
    public static String enterEmail(){
        System.out.println("Введите email: ");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        EmailValidator validator = EmailValidator.getInstance();
        if(validator.isValid(email)){
            return email;
        } else return "";
    }


}
