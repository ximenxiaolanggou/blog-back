package center.helloworld.blog.app.auth.vo;

import lombok.Data;

@Data
public class LoginVO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
