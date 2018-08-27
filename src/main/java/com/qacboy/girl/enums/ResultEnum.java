package com.qacboy.girl.enums;

/***
 *
 * 描述：
 *      枚举提示信息，方便对提示信息的统一管理
 *
 * @author sam
 * @date 2018/8/24 下午2:20
 *
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能还在上小学吧"),
    MIDDLE_SCHOOL(101,"你可能还在上中学吧")
    ;

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultEnum(Integer code, String msg) {

        this.code = code;
        this.msg = msg;
    }
}
