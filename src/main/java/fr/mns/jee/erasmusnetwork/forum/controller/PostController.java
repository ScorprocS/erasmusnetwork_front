package fr.mns.jee.erasmusnetwork.forum.controller;

import fr.mns.jee.erasmusnetwork.forum.model.Post;
import fr.mns.jee.erasmusnetwork.forum.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {

    public PostController(PostService postService) {
    }


    @GetMapping("/forum")
    public String forumPage(Model model) {
//       /* List<Post> threads = postService.getAllThreads();
//        model.addAttribute("threads", threads); */
        return "forum";
    }

    @GetMapping("/post/new")
    public String newThreadPage(Model model) {
        return "newThread";
    }

    @GetMapping("/post/{id}")
    public String threadPage(Model model) {
//       public ResponseData getPost(@PathParam("id") Long id) {
//           ResponseData responseData = new ResponseData();
//          return responseData
//   }
        return "thread";
    }
}