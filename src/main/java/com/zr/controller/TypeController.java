package com.zr.controller;

import com.zr.po.Type;
import com.zr.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/admin/types")
public class TypeController {

    @Autowired
    private TypeService typeService;
    @RequestMapping
    public String list(@PageableDefault(size = 5,sort={"id"},direction = Sort.Direction.DESC) Pageable pageable, Model model){
        Page<Type> page = typeService.listType(pageable);
        model.addAttribute("page",page);
        return "admin/types";
    }
}