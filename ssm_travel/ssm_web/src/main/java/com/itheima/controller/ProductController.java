package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        /**
         * 参数1:最终想要转换成的类型
         * 参数2:采用具体什么格式来转换
         */
        binder.registerCustomEditor(Date.class, new PropertiesEditor() {
            @Override
            public void setAsText(@Nullable String text) throws IllegalArgumentException {
                try {
                    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(text);
                    setValue(date);
                } catch (ParseException e) {
                    throw new RuntimeException("日期转换异常");
                }
            }

        });
    }

    @RequestMapping("/findAll")
    public String findAll(Model model,
                          @RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "3") Integer pageSize) {
        List<Product> list = productService.findAll(pageNum,pageSize);
        //pageInfo是pageHelper提供的分页对象
        PageInfo<Product> pageInfo = new PageInfo<Product>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "product-list";
    }

    @RequestMapping("/save")
    public String save(Product product) {
        productService.save(product);
        return "redirect:findAll";
    }

    @RequestMapping("/toEditPage")
    public String toEditPage(String id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product-update";
    }

    @RequestMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:findAll";
    }

    @RequestMapping("/delBatch")
    public String delBatch(String[] ids) {
        productService.delBatch(ids);
        return "redirect:findAll";
    }

}
