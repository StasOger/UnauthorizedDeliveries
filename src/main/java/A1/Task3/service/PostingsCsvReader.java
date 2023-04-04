package A1.Task3.service;

import A1.Task3.model.Posting;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

public class PostingsCsvReader {
    private static final String ADDRESS_FILE = "src/main/resources/postings.csv";

    public List<Posting> getAllPosting (){
        List<Posting> postingList = readPostsFromCSV(ADDRESS_FILE);
        return postingList;
    }

    private static List<Posting> readPostsFromCSV(String fileName) {
        List<Posting> postingList = new ArrayList<>();

        Path pathToFile = Paths.get(fileName);
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(";");
                if (attributes.length > 1){
                    Posting posting = createPosting(attributes);
// ШАГ №2 "Прочитать файл postings.csv с локальной файловой системы (строки со значениями в поле Mat. Doc.)"
// закомментировать строку 37 и раскомментировать строку 40
//                   Posting posting = createPostingWithMatDoc(attributes);
                    postingList.add(posting);
                }
                line = br.readLine();
            }
        }
        catch (IOException | ParseException ioe) {
            ioe.printStackTrace();
        }
        return postingList;
    }

    private static Posting createPosting(String[] metadata) throws ParseException {
        String matDoc = metadata[0];
        String pstngDateString = metadata[3].replaceAll(" ", "").replaceAll("\t", "");
        Date pstngDate=new SimpleDateFormat("dd.MM.yyyy").parse(pstngDateString);
        String username = metadata[9].replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "");
        return new Posting(matDoc, username, pstngDate);
    }

// для ШАГа №2 "Прочитать файл postings.csv с локальной файловой системы (строки со значениями в поле Mat. Doc.)"
    private static Posting createPostingWithMatDoc(String[] metadata) throws ParseException {
        String matDoc = metadata[0];
        return new Posting(matDoc);
    }


}

