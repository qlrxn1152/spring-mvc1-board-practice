package mvcproject.post.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mvcproject.post.domain.Post;
import mvcproject.post.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public String allPostsView(Model model) {
        log.info("Finding All Posts");
        List<Post> posts = postService.findAll();

        model.addAttribute("posts", posts);

        for (Post post : posts) {
            log.info("post = {}", post);
        }

        return "posts";
    }

    @GetMapping("/posts/{postId}")
    public String postView(@PathVariable Long postId, Model model) {
        log.info("Finding PostId = {}", postId);

        Post findPost = postService.findById(postId);
        postService.viewPost(postId); // 조회수 증가

        model.addAttribute("post", findPost);

        return "post";
    }

    @GetMapping("/posts/new")
    public String newPostView(Model model) {
        log.info("[GET] Creating New Post");

        return "addPost";
    }

    @PostMapping("/posts/new")
    public String newPost(@ModelAttribute Post post, RedirectAttributes redirectAttributes) {
        log.info("[POST] Creating New Post");

        Post savedPost = postService.save(post);
        redirectAttributes.addAttribute("postId", savedPost.getPostId());

        return "redirect:/posts/{postId}";
    }

    @GetMapping("/posts/{postId}/edit")
    public String editPostView(@PathVariable Long postId, Model model) {
        log.info("[GET] Updating Post with id = {}", postId);
        Post findPost = postService.findById(postId);

        model.addAttribute("post", findPost);

        return "updatePost";
    }

    @PostMapping("/posts/{postId}/edit")
    public String editPost(@PathVariable Long postId, @ModelAttribute Post editPost, RedirectAttributes redirectAttributes) {
        log.info("[POST] Updating Post with id = {}", postId);
        postService.update(postId, editPost);

        redirectAttributes.addAttribute("postId", postId);
        redirectAttributes.addAttribute("editStatus", true);

        return "redirect:/posts/{postId}";
    }

    @PostMapping("/posts/{postId}/delete")
    public String deletePost(@PathVariable Long postId, RedirectAttributes redirectAttributes) {
        log.info("[POST] Deleting Post with id = {}", postId);

        postService.delete(postId);

        redirectAttributes.addAttribute("deleteStatus", true);

        return "redirect:/posts";
    }

    @PostConstruct
    public void init() {
        log.info("[Init POST]");

        postService.save(new Post("titleA", "contentA"));
        postService.save(new Post("titleB", "contentB"));
    }

}
