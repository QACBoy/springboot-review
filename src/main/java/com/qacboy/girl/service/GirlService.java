package com.qacboy.girl.service;

import com.qacboy.girl.enums.ResultEnum;
import com.qacboy.girl.exception.GirlException;
import com.qacboy.girl.repository.GirlRepository;
import com.qacboy.girl.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/8/23 下午9:13
 *
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA=new Girl("A",18,0);
        girlRepository.save(girlA);

        Girl girlB=new Girl("B",19,0);
        girlRepository.save(girlB);

    }


    public void getAge(Integer id) throws Exception{
        Girl girl=girlRepository.findOne(id);
        Integer age=girl.getAge();
        if(age <= 10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age <= 16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }else {
//            throw new GirlException(120,"你好，小姐姐");
        }
    }

    /**
     * 通过ID查询一个女生的信息
     *
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
