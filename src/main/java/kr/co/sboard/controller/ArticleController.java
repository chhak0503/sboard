package kr.co.sboard.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/article/list")
    public String list(){
        return "/article/list";
    }

    @GetMapping("/article/modify")
    public String modify(){
        return "/article/modify";
    }

    @GetMapping("/article/view")
    public String view(){
        return "/article/view";
    }

    @GetMapping("/article/write")
    public String write(){
        return "/article/write";
    }

    @PostMapping("/article/write")
    public String write(ArticleDTO articleDTO, HttpServletRequest request){

        String regip = request.getRemoteAddr();
        articleDTO.setRegip(regip);
        log.info("articleDTO : {}", articleDTO);
        
        // 파일 업로드 서비스 호출

        

        // 서비스 호출
        articleService.register(articleDTO);

        // 리다이렉트
        return "redirect:/article/list";
    }
}
