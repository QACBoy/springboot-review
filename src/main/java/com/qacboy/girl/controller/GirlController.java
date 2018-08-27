package com.qacboy.girl.controller;

import com.qacboy.girl.domain.Girl;
import com.qacboy.girl.domain.Result;
import com.qacboy.girl.repository.GirlRepository;
import com.qacboy.girl.service.GirlService;
import com.qacboy.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/8/23 下午8:20
 *
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有的女生
     *
     * @return
     *
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加女生信息
     * @return
     */
    @PostMapping(value = "/girl/add")
    public Result girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return null;
//            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }
    /*public Girl girlAdd(@RequestParam(value = "id") Integer id,
                        @RequestParam(value = "name") String name,
                        @RequestParam(value = "age") Integer age,
                        @RequestParam(value = "money") double money){
        Girl girl=new Girl();
        girl.setCode(id);
        girl.setName(name);
        girl.setAge(age);
        girl.setMoney(money);
        return girlRepository.save(girl);
    }*/
//    @PostMapping(value = "/girl/add")
//    public Girl girlAdd(Girl girl){
//        return girlRepository.save(girl);
//    }
    //    @PostMapping(value = "/girl/add")
//    public Girl girlAdd(@RequestParam(value = "age") Integer age,
//                          @RequestParam(value = "cupSize") String cupSize){
//        Girl girl=new Girl(age,cupSize);
//        return girlRepository.save(girl);
//    }

    /**
     * 通过 id 删除指定的女生
     *
     * @param id
     */
    @DeleteMapping(value = "/girl/del/{id}")
    public void girlDel(@PathVariable(value = "id") Integer id){
        girlRepository.delete(id);
    }

    /**
     * 通过 id 更新女生信息
     * @param id
     * @param name
     * @param age
     * @param money
     * @return
     */
    @PutMapping(value = "/girl/update/{id}")
    public Result girlUpdate(@PathVariable(value = "id") Integer id,
                           @RequestParam(value = "name") String name,
                           @RequestParam(value = "age") Integer age,
                           @RequestParam(value = "money") double money){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setAge(age);
        girl.setMoney(money);
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 通过 id 查询女生信息
     * @param id
     * @return
     */
    @GetMapping(value = "/girl/find/{id}")
    public Girl girlFindOne(@PathVariable(value = "id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 对数据库事务操作的测试
     */
    @PostMapping("/girl/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    /**
     * 通过抛异常达到输出自定义信息的目的，更好的利用了异常信息
     * 通过 id 获取女生的年龄
     * @param id
     * @throws Exception
     */
    @GetMapping(value = "/girl/getage/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
