package main.cn.itcast.ssm.controller;

/**
 * 注解的适配器和映射器
 */

import main.cn.itcast.ssm.po.Items;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//使用@Controller标识他是一个控制器
@Controller
public class ItemsController3  {

    //查询商品列表
    //@RequestMapping实现 对annotationQueryItems方法和url进行映射，一个方法对应一个url
    //一般建议将url和方法写成一样
    @RequestMapping("/annotationQueryItems.action")
    public ModelAndView annotationQueryItems() throws Exception{



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

        Items items3 = new Items();
        items3.setName("注解的苹果手机");
        items3.setPrice(5000f);
        items3.setDetail("注解的iphone6苹果手机！");

        itemsList.add(items1);
        itemsList.add(items2);
        itemsList.add(items3);





        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",itemsList);
        //下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
        //modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");

        //使用前缀和后缀
        //上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
        modelAndView.setViewName("items/itemsList");
        return modelAndView;
    }



}
