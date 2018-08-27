package com.qacboy.girl.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/8/23 下午1:33
 *
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {

    private String name;

    private Integer age;

    private double money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
