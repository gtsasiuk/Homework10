package Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {
    public static void printValidPhoneNumbers(String filePath) {
        String regex1 = "^\\(\\d{3}\\) \\d{3}-\\d{4}$";
        String regex2 = "^\\d{3}-\\d{3}-\\d{4}$";

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher1 = pattern1.matcher(line);
                Matcher matcher2 = pattern2.matcher(line);

                if (matcher1.matches() || matcher2.matches()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/Task1/file.txt";
        printValidPhoneNumbers(filePath);
    }
}
