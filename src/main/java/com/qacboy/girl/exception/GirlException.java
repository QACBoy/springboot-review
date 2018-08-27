package com.qacboy.girl.exception;


import com.qacboy.girl.enums.ResultEnum;

/***
 *
 * 描述：
 *      自定义异常
 *
 * @author sam
 * @date 2018/8/24 下午1:28
 *
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
