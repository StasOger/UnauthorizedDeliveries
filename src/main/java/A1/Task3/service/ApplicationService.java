package A1.Task3.service;

import A1.Task3.Task3Application;
import A1.Task3.model.Posting;
import A1.Task3.model.User;
import A1.Task3.repository.LoginsRepository;
import A1.Task3.repository.PostingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private LoginsRepository loginsRepository;
    @Autowired
    private PostingsRepository postingsRepository;

    private final LoginsCsvReader loginsCsvReader = new LoginsCsvReader();
    private final PostingsCsvReader postingsCsvReader = new PostingsCsvReader();

    public void initDatabase(){
        List<User> userList = loginsCsvReader.getAllUser();
        for (User u: userList){
            System.out.println(u);
//            loginsRepository.save(u);
        }
        loginsRepository.saveAll(userList);

        List<Posting> postingList = postingsCsvReader.getAllPosting();
        for (Posting p: postingList){
            p.setAutowiredPost(userList.stream().anyMatch(user -> user.getAppAccountName().equals(p.getName()) && user.getIsActive()));
            System.out.println(p);
//            postingsRepository.save(p);
        }
        postingsRepository.saveAll(postingList);
    }

    public void deleteDatabase(){
        postingsRepository.deleteAll();
    }
}
