package com.study.domain.post;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    void save() {
        final PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        postService.savePost(params);
    }

    @Test
    void findById() {
        final PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목");
        params.setContent("1번 게시글 내용");
        params.setWriter("테스터");
        params.setNoticeYn(false);
        final Long findId = postService.savePost(params);

        final PostResponse findById = postService.findPostById(findId);
        assertThat(findById.getId()).isEqualTo(1L);
    }

    @Test
    void update() {
        final PostRequest params = new PostRequest();
        params.setTitle("1번 게시글 제목 수정");
        params.setContent("1번 게시글 내용 수정");
        params.setWriter("테스터1");
        params.setNoticeYn(true);
        postService.updatePost(params);
        assertThat(params.getWriter()).isEqualTo("테스터1");
    }

    @Test
    void delete() {
        postService.deletePost(1L);
        final PostResponse findId = postService.findPostById(1L);
        assertThat(findId.getDeleteYn()).isEqualTo(true);
    }

    @Test
    void findAll() {
        final List<PostResponse> allPost = postService.findAllPost();
        assertThat(allPost.size() > 0).isEqualTo(true);
    }
}