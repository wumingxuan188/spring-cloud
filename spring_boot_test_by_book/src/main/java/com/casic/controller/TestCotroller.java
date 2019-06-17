package com.casic.controller;


import com.casic.model.ConfigBean;
import com.casic.model.TestWu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class, TestWu.class})
public class TestCotroller {

    @Autowired
    private ConfigBean configBean;
    @Autowired
    private TestWu testWu;

    //从yml文件中取值
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private  int age;
    /**
     * 测试自定义属性
     * @return
     */
    @RequestMapping("/{id}")
    public String testAttribute(@PathVariable("id") String id){
        System.err.println(id);
        return name+":"+age;
    }

    /**
     * 把属性赋给实体类
     * @return
     */
    @RequestMapping("testGetAttribute")
    public String testGetAttribute(){
        return configBean.getName()+","+configBean.getSex()+","+configBean.getUuid()+
                ","+configBean.getValue()+","+configBean.getAge()+","+configBean.getNumber();
    }

    /**
     * 测试自定义配置文件
     * @return
     */
    @RequestMapping("testConfigurationFile")
    public String testConfigurationFile(){
        return testWu.getName()+","+testWu.getAge();
    }




}
