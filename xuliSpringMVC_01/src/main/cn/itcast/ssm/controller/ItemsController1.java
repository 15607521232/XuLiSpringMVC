package main.cn.itcast.ssm.controller;

import main.cn.itcast.ssm.po.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

public class ItemsController1  implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {

        //调用service查找数据库，查询商品列表，这里使用静态数据模拟
        List<Items> itemsList = new ArrayList<Items>();

        Items items1 = new Items();
        items1.setName("联想笔记本");
        items1.setPrice(6000f);
        items1.setDetail("ThinkPad T430 联想笔记本电脑！");

        Items items2 = new Items();
        items2.setName("苹果手机");
        items2.setPrice(5000f);
        items2.setDetail("iphone6苹果手机！");

        itemsList.add(items1);
        itemsList.add(items2);

        //返回modelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于resquests的setAttribute,在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList",itemsList);

        //指定试图
        modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");

        return modelAndView;
    }
}
