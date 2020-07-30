package com.zr.controller;

import com.zr.po.News;
import com.zr.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
public class ArchivesController {
    @Autowired
    private NewsService newsService;

    @RequestMapping("archives")
    public String archives(Model model){
        HashMap<String, List<News>> map = newsService.archiveNews();
        Long count = newsService.countNews();
        model.addAttribute("archiveMap",map);
        model.addAttribute("newsCount",count);
        return "archives";
    }
}