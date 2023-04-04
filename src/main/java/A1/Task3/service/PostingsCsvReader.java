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
        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            // read the first line from the text file
            String line = br.readLine();
            line = br.readLine();
            // loop until all lines are read
            while (line != null) {
                String[] attributes = line.split(";");
                if (attributes.length > 1){
                    Posting posting = createPosting(attributes);
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
//        System.out.println(pstngDateString);
        Date pstngDate=new SimpleDateFormat("dd.MM.yyyy").parse(pstngDateString);
//        System.out.println(pstngDate);
        String username = metadata[9].replaceAll(" ", "").replaceAll("_", "").replaceAll("\t", "");
        return new Posting(matDoc, username, pstngDate);
    }
}

