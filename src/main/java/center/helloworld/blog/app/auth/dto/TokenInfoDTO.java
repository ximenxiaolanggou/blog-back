package center.helloworld.blog.app.auth.dto;

import lombok.Data;

@Data
public class TokenInfoDTO {

    private String tokeName;

    private String tokenValue;

    public TokenInfoDTO(String tokeName, String tokenValue) {
        this.tokeName = tokeName;
        this.tokenValue = tokenValue;
    }
}
