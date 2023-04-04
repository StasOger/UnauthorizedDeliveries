package A1.Task3.service;

import A1.Task3.model.Posting;
import A1.Task3.model.User;
import A1.Task3.repository.LoginsRepository;
import A1.Task3.repository.PostingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
// ШАГ	4. Cохранить в SQL СУБД данные файла logins.csv
        loginsRepository.saveAll(userList);

        List<Posting> postingList = postingsCsvReader.getAllPosting();
        for (Posting p: postingList){
// ШАГ  3. Добавить булевое поле "авторизованная поставка" в данные из postings.csv, которое будет указывать, что User Name (postings.csv) находится в списке AppAccountName (logins.csv) и IsActive
            p.setAutowiredPost(userList.stream().anyMatch(user -> user.getAppAccountName().equals(p.getName()) && user.getIsActive()));
        }
// ШАГ	5. Сохранить в SQL СУБД данные файла postings.csv (с дополнительным полем)
        postingsRepository.saveAll(postingList);
    }

    public void deleteDatabase(){
        postingsRepository.deleteAll();
    }
}
