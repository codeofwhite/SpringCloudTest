package springCloud.service;

import org.springframework.stereotype.Service;
import springCloud.entity.Questions;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/6/30
 * @Description
 */
@Service
public interface QuestionsService {
    public void insertQuestion(Questions questions);

    public List<Questions> getAllQuestions();
}
