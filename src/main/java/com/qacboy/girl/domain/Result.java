package com.qacboy.girl.domain;

/***
 *
 * 描述：
 *      自定义了返回信息的格式
 *
 * @author sam
 * @date 2018/8/24 上午11:03
 *
 */
public class Result<T> {

     /** 错误码 */
     private Integer code;

     /** 提示信息 */
     private String msg;

    /** 具体内容 */
    private T data;

    public Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
