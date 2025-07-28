package com.camphotoapp.stats.controller;

import com.camphotoapp.common.model.Comment;
import com.camphotoapp.stats.repository.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CommentController {
    private final CommentRepository repository;

    public CommentController(CommentRepository repository) {
        this.repository = repository;
    }

    /**
     * TODO: remove this after debugging
     */
    @GetMapping({"/", "/index.html", "/index"})
    public String showIndex(Model model) {
        return "index";
    }

    @GetMapping({"/comments", "/comments/"})
    public String showCommentsPage(Model model) {
        List<Comment> comments = repository.findAllSortedInversely();
        model.addAttribute("comments", comments);
        return "comments"; // Maps to comments.html
    }
}