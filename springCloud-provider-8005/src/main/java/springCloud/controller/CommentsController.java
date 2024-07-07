package springCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springCloud.entity.Comments;
import springCloud.entity.Questions;
import springCloud.service.CommentsService;
import springCloud.service.QuestionsService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/3
 * @Description
 */
@RestController
@RequestMapping("comments")
@CrossOrigin
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    @PostMapping("/insertComment")
    public String insertComment(@RequestBody Comments comments) {
        // 获取当前时间：
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date(calendar.getTime().getTime());
        List<Comments> list = new ArrayList<Comments>();
        Comments comments1 = new Comments();
        comments1.setComment(comments.getComment());
        comments1.setUserEmail(comments.getUserEmail());
        comments1.setCreateDate(currentDate);
        comments1.setUpdateDate(currentDate);
        comments1.setBlogId(comments.getBlogId());
        list.add(comments1);
        commentsService.insertComment(comments1);
        return "success";
    }

    @GetMapping("/getAllComments")
    public List<Comments> getAllComments(String blogId) {
        return commentsService.getAllComments(blogId);
    }
}
