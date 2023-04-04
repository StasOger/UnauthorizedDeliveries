package A1.Task3.controller;

import A1.Task3.model.Posting;
import A1.Task3.repository.PostingsRepository;
import A1.Task3.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


//6. Отдавать по GET (REST API) за период (день, месяц, квартал, год) данные из базы,
// загруженные из postings.csv
// (с возможностью запроса с фильтром по полю "авторизованная поставка")


@RestController
public class PostController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private PostingsRepository postingsRepository;

    @GetMapping("/init")
    public void init(){
        applicationService.deleteDatabase();
        applicationService.initDatabase();
    }

    @GetMapping({"/getPostingsByPeriod/{date}", "/getPostingsByPeriod/{date}/{isAutowired}"})
    public ResponseEntity<List<Posting>> getPostingsByPeriod(@PathVariable String date, @PathVariable(required = false) Boolean isAutowired) throws ParseException {
//        period = dd.MM.yyyy;

        Date datePeriod=new SimpleDateFormat("dd.MM.yyyy").parse(date);
        List<Posting> postings;
        if (isAutowired == null){
            postings = postingsRepository.findPostingsByPeriod(datePeriod);
        } else {
            postings = postingsRepository.findPostingsByPeriodAndAutowired(datePeriod, isAutowired);
        }

        return new ResponseEntity<>(postings, HttpStatus.OK);
    }
}
