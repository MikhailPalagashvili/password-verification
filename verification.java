
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Verification {
    private static final String FILEPATH = "src\\autosignup\\data.txt";
    private static final String PASSWORD_VALIDATION_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILEPATH));
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String password = currentLine.trim();
                String isValid = isValidPassword(password) ? "a valid" : "an invalid";
                System.out.printf("\"%s\" is %s password\n", password, isValid);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static final boolean isValidPassword(String password) {
        if(password == null)
            return false;
        return password.matches(PASSWORD_VALIDATION_REGEX);
    }
}
