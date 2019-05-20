package com.ridwan.blog.controller;

import com.ridwan.blog.model.Comment;
import com.ridwan.blog.model.Post;

import com.ridwan.blog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostsController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "posts/index";
    }

    @GetMapping("/post/create")
    public String create() {

        return "posts/create";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String savePost(@ModelAttribute("post") @Valid Post post, BindingResult result) {


        try{

            if(result.hasErrors()){

                return "/posts/create";

            }
            Post post1 = postService.createPost(post);

            log.info("This is the post Id : {}",post1.getId());

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String getPostById(@PathVariable Long id,Model model) {

        Post post = postService.getPostById(id);
        //List<Comment> comments = post.getComments();
        //Post comments = postService.getAllComments(id);

        log.info("This is the post Id : {}",post.getId());

        model.addAttribute("post",post);
        //model.addAttribute("comments",comments);

        return "posts/show";
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String saveComment(@RequestParam("postid") Long id, @ModelAttribute("comment")  @Valid Comment comment, BindingResult result) {


        log.info("I got this {} ", id);
        try{
            if(result.hasErrors()){

                return "redirect:/post/"+id;

            }
            Post post = postService.getPostById(id);

            post.addComment(comment);

            postService.createPost(post);

        }catch (Exception ex){
            log.info("Error occurred creating comment");
        }


        return "redirect:/post/"+id;
    }
    
    @GetMapping("/test")
    public String testStuff() {
    	
    	return "test";
    }

}

