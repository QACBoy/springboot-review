package com.qacboy.girl.service;

import com.qacboy.girl.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/8/24 下午2:48
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOne() {
        Girl girl=girlService.findOne(1);
        Assert.assertEquals(new Integer(22),girl.getAge());
    }
}