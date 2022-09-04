package com.study.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    @Autowired
    private final PostService postService;

    @GetMapping("/")
    public String home() {
        return "redirect:/post/write.do";
    }

    // 게시글 작성 페이지
    @GetMapping("/post/write.do")
    public String openPostWrite(Model model) {
        String title = "제목",
                content = "내용",
                writer = "홍길동";

        model.addAttribute("t", title);
        model.addAttribute("c", content);
        model.addAttribute("w", writer);
        return "post/write";
    }
}
