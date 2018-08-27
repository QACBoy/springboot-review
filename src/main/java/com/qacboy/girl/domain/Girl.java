package com.qacboy.girl.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/***
 *
 * 描述：
 *
 * @author sam
 * @date 2018/8/23 下午5:01
 *
 */
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "名字不能为空")
    private String name;

    @Min(value = 18,message = "未成年少女，禁止入内")
    private Integer age;

    private double money;

    public Girl() {
    }

    public Girl(String name, Integer age, double money) {

        this.name = name;
        this.age = age;
        this.money = money;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
