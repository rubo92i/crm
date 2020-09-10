package am.basic.notificator.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ChangePasswordDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String newPassword;

}
