package com.qacboy.girl.controller;

import com.qacboy.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/8/23 下午12:08
 *
 */
@RestController
@RequestMapping("/girl")
public class HelloController {


    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String hello(){
        return girlProperties.getAge()+" ------ "+girlProperties.getName();
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String girl(){
        return girlProperties.getAge()+" ------ "+girlProperties.getName();
    }

//    @GetMapping(value = "/{id}/getid")
    @GetMapping(value = "/getid/{id}")
    public Integer getId(@PathVariable(value = "id") Integer id){
        return id;
    }
    @GetMapping(value = "/getid1")
    public String getId1(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "id: "+id;
    }

}
