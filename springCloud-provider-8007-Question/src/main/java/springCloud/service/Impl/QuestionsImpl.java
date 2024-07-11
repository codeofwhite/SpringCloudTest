package springCloud.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springCloud.entity.Questions;
import springCloud.service.QuestionsService;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/6/30
 * @Description
 */

@Service("QuestionsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class QuestionsImpl implements QuestionsService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 设置集合名称
     */
    private static final String COLLECTION_NAME = "questions";


    @Override
    public void insertQuestion(Questions questions) {
        mongoTemplate.save(questions);
    }

    @Override
    public List<Questions> getAllQuestions() {
        return mongoTemplate.findAll(Questions.class, COLLECTION_NAME);
    }
}
