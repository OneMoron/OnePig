package com.itheima.controller;

import com.itheima.domain.SysRole;
import com.itheima.domain.SysUser;
import com.itheima.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<SysUser> list = sysUserService.findAll();
        model.addAttribute("list", list);
        return "user-list";
    }

    @RequestMapping("/save")
    public String save(SysUser sysUser) {
        sysUserService.save(sysUser);
        return "redirect:findAll";
    }

    @RequestMapping("/findDetail")
    public String findDetail(Model model, String id) {
        SysUser sysUser = sysUserService.findDetail(id);
        model.addAttribute("user", sysUser);
        return "user-show";
    }

    @RequestMapping("/toAddRolePage")
    public String toAddRolePage(Model model, String id) {
        List<SysRole> roleList = sysUserService.findAddRole(id);
        model.addAttribute("uid", id);
        model.addAttribute("roleList", roleList);
        return "user-role-add";
    }

    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(String userId, String[] ids) {
        sysUserService.addRoleToUser(userId, ids);
        return "redirect:findDetail?id=" + userId;
    }

    @RequestMapping("/getName")
    public void getName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getRemoteUser();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(username);
    }
}
