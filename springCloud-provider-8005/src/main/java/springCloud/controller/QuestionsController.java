package springCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springCloud.entity.Questions;
import springCloud.service.QuestionsService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/6/30
 * @Description
 */
@RestController
@RequestMapping("questions")
@CrossOrigin
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;

    @PostMapping("/insertQuestion")
    public String insertQuestion(@RequestBody Questions questions){
        // 获取当前时间：
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date(calendar.getTime().getTime());
        List<Questions> list = new ArrayList<Questions>();
        Questions questions1 = new Questions();
        questions1.setQuestion(questions.getQuestion());
        questions1.setUserEmail(questions.getUserEmail());
        questions1.setCreateDate(currentDate);
        questions1.setUpdateDate(currentDate);
        list.add(questions1);
        System.out.println(questions1);
        questionsService.insertQuestion(questions1);
        return "success";
    }

    @GetMapping("/getAllQuestions")
    public List<Questions> getAllQuestions(){
        return  questionsService.getAllQuestions();
    }
}
