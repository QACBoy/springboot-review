package com.qacboy.girl.utils;

import com.qacboy.girl.domain.Result;

/***
 *
 * 描述：
 *      用于自定义返回信息
 *
 * @author sam
 * @date 2018/8/24 上午11:08
 *
 */
public class ResultUtil {

    /**
     * 返回成功的信息
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
