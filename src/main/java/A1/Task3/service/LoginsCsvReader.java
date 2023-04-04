package A1.Task3.service;

import A1.Task3.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoginsCsvReader {

// ШАГ 1. Прочитать файл logins.csv с локальной файловой системы
    private static final String ADDRESS_FILE = "src/main/resources/logins.csv";

    public List<User> getAllUser (){
        List<User> userList = readPostsFromCSV(ADDRESS_FILE);
        return userList;
    }

    private static List<User> readPostsFromCSV(String fileName) {
        List<User> userList = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",\t");
                User user = createUser(attributes);
                userList.add(user);
                line = br.readLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return userList;
    }

    private static User createUser(String[] metadata) {
        String application = metadata[0];
        String appAccountName = metadata[1].replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "");
        boolean isActive = Boolean.parseBoolean(metadata[2]);
        String jobTitle = metadata[3];
        String department = metadata[4];
        return new User(application, appAccountName, isActive, jobTitle, department);
    }
}
