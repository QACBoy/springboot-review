package com.qacboy.girl.handle;

import com.qacboy.girl.domain.Result;
import com.qacboy.girl.exception.GirlException;
import com.qacboy.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 *
 * 描述：
 *      拦截异常信息，并自定义异常信息的输出格式
 * @author sam
 * @date 2018/8/24 下午1:34
 *
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger=LoggerFactory.getLogger(GirlException.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            logger.info("【 系统异常 】：{}", e);
            return ResultUtil.error(-1, "未知异常");
        }
    }
}
