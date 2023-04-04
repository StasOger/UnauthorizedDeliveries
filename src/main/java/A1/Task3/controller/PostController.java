package A1.Task3.controller;

import A1.Task3.model.Posting;
import A1.Task3.repository.PostingsRepository;
import A1.Task3.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


//6. Отдавать по GET (REST API) за период (день, месяц, квартал, год) данные из базы, загруженные из postings.csv
// (с возможностью запроса с фильтром по полю "авторизованная поставка")

@RestController
public class PostController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private PostingsRepository postingsRepository;

    @GetMapping("/init")
//показать postings
    public void init(){
        applicationService.deleteDatabase();
        applicationService.initDatabase();
    }

    @GetMapping({"/getPostingsByDay/{date}", "/getPostingsByDay/{date}/{isAutowired}"})
//показать postings за день (date)
//пример GET запроса "/getPostingsByDay/25.07.2020"
//пример GET запроса (с возможностью запроса с фильтром по полю "авторизованная поставка"): "/getPostingsByDay/25.07.2020/false"
    public ResponseEntity<List<Posting>> getPostingsByDay(@PathVariable String date, @PathVariable(required = false) Boolean isAutowired) throws ParseException {
        init();
        Date datePeriod=new SimpleDateFormat("dd.MM.yyyy").parse(date);
        List<Posting> postings;
        if (isAutowired == null){
            postings = postingsRepository.findPostingsByDay(datePeriod);
        } else {
            postings = postingsRepository.findPostingsByDayAndAutowired(datePeriod, isAutowired);
        }

        return new ResponseEntity<>(postings, HttpStatus.OK);
    }

    @GetMapping({"/getPostingsByMonth/{month}", "/getPostingsByMonth/{month}/{isAutowired}"})
//показать postings за месяц (int)
//пример GET запроса "/getPostingsByMonth/07"
//пример GET запроса (с возможностью запроса с фильтром по полю "авторизованная поставка"): "/getPostingsByMonth/07/false"
    public ResponseEntity<List<Posting>> getPostingsByMonth(@PathVariable int month, @PathVariable(required = false) Boolean isAutowired) throws ParseException {
        init();

        List<Posting> postings;
        if (isAutowired == null){
            postings = postingsRepository.findPostingsByMonth(month);
        } else {
            postings = postingsRepository.findPostingsByMonthAndAutowired(month, isAutowired);
        }

        return new ResponseEntity<>(postings, HttpStatus.OK);
    }

    @GetMapping({"/getPostingsByQuarter/{quarter}", "/getPostingsByQuarter/{quarter}/{isAutowired}"})
//показать postings за квартал (int)
//пример GET запроса "/getPostingsByQuarter/1"
//пример GET запроса (с возможностью запроса с фильтром по полю "авторизованная поставка"): "/getPostingsByQuarter/1/false"
    public ResponseEntity<List<Posting>> getPostingsByQuarter(@PathVariable int quarter, @PathVariable(required = false) Boolean isAutowired) throws ParseException {
        init();

        List<Posting> postings;
        if (isAutowired == null){
            postings = postingsRepository.findPostingsByQuarter(quarter);
        } else {
            postings = postingsRepository.findPostingsByQuarterAndAutowired(quarter, isAutowired);
        }

        return new ResponseEntity<>(postings, HttpStatus.OK);
    }

    @GetMapping({"/getPostingsByYear/{year}", "/getPostingsByYear/{year}/{isAutowired}"})
//показать postings за год (int)
//пример GET запроса "/getPostingsByYear/2020"
//пример GET запроса (с возможностью запроса с фильтром по полю "авторизованная поставка"): "/getPostingsByYear/2020/false"
    public ResponseEntity<List<Posting>> getPostingsByYear(@PathVariable int year, @PathVariable(required = false) Boolean isAutowired) throws ParseException {
        init();

        List<Posting> postings;
        if (isAutowired == null){
            postings = postingsRepository.findPostingsByYear(year);
        } else {
            postings = postingsRepository.findPostingsByYearAndAutowired(year, isAutowired);
        }

        return new ResponseEntity<>(postings, HttpStatus.OK);
    }
}
