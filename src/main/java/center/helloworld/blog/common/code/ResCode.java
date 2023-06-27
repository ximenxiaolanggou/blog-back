package center.helloworld.blog.common.code;

/**
 * @author zhishun.cai
 * @date 2021/11/25 16:02
 * @note 返回状态码
 */

public enum ResCode {

    ERROR(false, 0, "操作失败"),
    SUCCESS(true,1,"操作成功"),
    SYSTEM_ERROR(false, 2, "系统异常"),
    ERROR_REQUEST_PARAMS(false, 3, "请求参数错误"),
    ERROR_USERNAME_OR_PWD(false, 4, "用户名或密码错误"),
    ERROR_AUTH_EXPIRED(false, 5, "认证过期"),
    ERROR_NOT_LOGIN(false, 6, "未认证"),
    ERROR_USER_NOT_EXIST(false, 7, "用户不存在"),
    ERROR_USER_EXIST(false, 8, "用户已存在"),
    ERROR_USER_MOBILE(false, 9, "手机已存在"),
    ERROR_PWD(false, 10, "密码错误"),
    ERROR_OLD_PWD(false, 11, "原始密码错误"),
    ERROR_USER_STOP(false, 12, "账户已被停用"),
    // -- 邮件 --
    ERROR_EMIAL_SEND(false,20,"邮件发送失败"),
    ERROR_EMIAL_CODE_EXPIRE(false,21,"验证码已过期"),
    ERROR_EMIAL_CODE_NOT_MATCH(false,22,"验证码不匹配"),
    ERROR_EMIAL_EXIST(false,23,"邮箱号已存在"),
    // 角色
    ERROR_ROLE_EXIST(false,30,"角色名称已存在"),
    // 权限
    ERROR_PERMISSION_EXIST(false,40,"权限已存在"),
    // -- 手机 --
    ERROR_MOBILE_EXIST(false,50,"手机号已存在"),
    // IOT
    ERROR_SN_EXIST(false,60,"SN已存在"),
    ;

    private boolean flag;

    private Integer code;

    private String message;

    ResCode() {
    }

    ResCode(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
