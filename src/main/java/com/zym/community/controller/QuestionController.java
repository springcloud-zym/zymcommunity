package com.zym.community.controller;

import com.zym.community.dto.QuestionDTO;
import com.zym.community.mapper.QuestionMapper;
import com.zym.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author
 * @date 2020/3/16-10:00
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @GetMapping("/question/{id}")
    public String question(@PathVariable("id")Integer id, Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}