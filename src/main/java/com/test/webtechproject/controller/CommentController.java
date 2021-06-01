package com.test.webtechproject.controller;


import com.test.webtechproject.data.CommentDAO;
import com.test.webtechproject.model.Comment;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CommentController {

    private final CommentDAO commentDAO;
    @Autowired
    public CommentController(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }

    @GetMapping("/comment")
    public String showComment(Model model) {
        model.addAttribute("commentList", commentDAO.findAll());
        model.addAttribute("newComment", new Comment());

        return "CommentPage";
    }


    @PostMapping("/comment")
    public String getComment(@ModelAttribute Comment newComment) {
        Comment comment = new Comment(newComment.getAuthorID(), newComment.getTimeStamp(),
                newComment.getText(), newComment.getUserID());
        commentDAO.save(comment);

        return "redirect:comment";
    }


}