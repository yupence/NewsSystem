package com.zr.controller;

import com.zr.po.News;
import com.zr.po.Tag;
import com.zr.po.Type;
import com.zr.service.NewsService;
import com.zr.service.TagService;
import com.zr.service.TypeService;
import org.hibernate.type.ListType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @RequestMapping
    public String index(@PageableDefault(size=5,sort ={"updateTime"},direction = Sort.Direction.DESC) Pageable pageable,
                        Model model){
        Page<News> page = newsService.findByPageable(pageable);
        List<Type> types = typeService.findTop(5);
        List<Tag> tags = tagService.findTop(5);
        model.addAttribute("tags",tags);
        model.addAttribute("types",types);
        model.addAttribute("page",page);
        return "index";
    }
}