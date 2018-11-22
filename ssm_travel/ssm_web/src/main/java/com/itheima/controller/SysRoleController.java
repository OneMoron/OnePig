package com.itheima.controller;

import com.itheima.domain.SysRole;
import com.itheima.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<SysRole> list = sysRoleService.findAll();
        model.addAttribute("list", list);
        return "role-list";
    }

    @RequestMapping("/save")
    public String save(SysRole sysRole) {
        sysRoleService.save(sysRole);
        return "redirect:findAll";
    }
}
