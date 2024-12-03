package center.helloworld.blog.common.exception.handler;

import center.helloworld.blog.common.base.Result;
import center.helloworld.blog.common.exception.ApiException;
import cn.dev33.satoken.exception.NotLoginException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import center.helloworld.blog.common.code.ResCode;

import java.util.List;
import java.util.Set;

/**
 * @author zhishun.cai
 * @date 2021/11/25 16:05
 * @note 全局异常
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 统一处理请求参数校验(普通传参)
     *
     * @param e ConstraintViolationException
     * @return MoldingResponse
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArr = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");
            message.append(pathArr[1]).append(violation.getMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        ResCode response = ResCode.ERROR_REQUEST_PARAMS;
        response.setMessage(message.toString());
        return new Result(response);
    }

    /**
     * 统一处理请求参数校验(实体对象传参)
     *
     * @param e BindException
     * @return FebsResponse
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleBindException(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(",");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        ResCode response = ResCode.ERROR_REQUEST_PARAMS;
        response.setMessage(message.toString());
        return new Result(response);
    }


    /**
     * 参数校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException e) {
        /*
            如果存在多个参数不匹配问题只返回第一个不批参数
            如果想将所有不符合的参数都返回可用:e.getBindingResult().getFieldErrors() 进行遍历
         */
        String errMes = e.getBindingResult().getFieldError().getDefaultMessage();
        ResCode response = ResCode.ERROR_REQUEST_PARAMS;
        response.setMessage(errMes);
        return new Result(response);
    }

    /**
     * 未认证
     * @param e
     * @return
     */
    @ExceptionHandler(value = NotLoginException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result notLoginException(NotLoginException e) {
        return new Result(ResCode.ERROR_NOT_LOGIN);
    }

    @ExceptionHandler(value = ApiException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleApiException(ApiException e) {
        log.error("系统错误", e);
        return new Result(e);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return new Result(ResCode.SYSTEM_ERROR);
    }
}
