package Task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
    public static void main(String[] args) {
        String inputFilePath = "src/main/java/Task2/file.txt";
        String outputFilePath = "src/main/java/Task2/user.json";

        List<User> users = readUsersFromFile(inputFilePath);
        writeUsersToJsonFile(users, outputFilePath);
    }

    private static List<User> readUsersFromFile(String filePath) {
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Пропустимо перший рядок
                }
                String[] parts = line.split(" ");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                User user = new User(name, age);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    private static void writeUsersToJsonFile(List<User> users, String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            objectMapper.writeValue(fileWriter, users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}