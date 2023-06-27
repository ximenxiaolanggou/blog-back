package center.helloworld.blog.app.auth.dto;

import lombok.Data;

import java.util.List;

@Data
public class AuthUserDTO {

    private String username;

    private List<String> permissions;

    private String mobile;

    private String mail;
}
