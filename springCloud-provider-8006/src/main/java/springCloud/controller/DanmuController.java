package springCloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springCloud.service.DanmuService;

import java.util.List;

/**
 * @author codeofwhite
 * @date 2024/7/3
 * @Description
 */
@RestController
@RequestMapping("/danmu")
public class DanmuController {
    @Autowired
    DanmuService danmuService;

    @PostMapping("/insertDanmu")
    public String insertDanmu(String danmu, String uemail, String blogId) {
        danmuService.insertDanmu(danmu, uemail, blogId);
        return "success";
    }

    @PostMapping("/selectDanmu")
    public List<String> selectDanmu(String blogId) {
        return danmuService.selectDanmu(blogId);
    }
}
