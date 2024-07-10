package springCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springCloud.entity.Comments;
import springCloud.entity.Questions;
import springCloud.entity.Reply;
import springCloud.service.CommentsService;
import springCloud.service.QuestionsService;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

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

    // 添加回复到评论
    @PostMapping("/{commentId}/replies")
    public Comments addReplyToComment(@PathVariable String commentId, @RequestBody Reply reply, @RequestParam String userEmail) {
        // 检查用户是否已登录
        if (userEmail == null || userEmail.trim().isEmpty()) {
            throw new IllegalStateException("用户未登录，无法发表回复");
        }

        // 获取当前时间：
        Calendar calendar = Calendar.getInstance();
        Date currentDate = new Date(calendar.getTime().getTime());

        // 创建回复对象
        reply.setId(new Date().getTime()); // 使用当前时间戳作为ID
        reply.setUserEmail(userEmail);
        reply.setCreateDate(currentDate);
        // 添加回复到评论
        return commentsService.addReply(commentId, reply);
    }
}
