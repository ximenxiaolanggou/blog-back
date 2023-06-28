package center.helloworld.blog.app.auth.dto;

import lombok.Data;

@Data
public class TokenInfoDTO {

    private String tokenName;

    private String tokenValue;

    public TokenInfoDTO(String tokenName, String tokenValue) {
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
    }
}
