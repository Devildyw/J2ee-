package org.cuit.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author Devil
 * @date 2022-05-27-13:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ForgetDTO {
    @ApiModelProperty(value = "用户名")
    private String username;

    private String email;
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "确认密码")
    private String repassword;

    @ApiModelProperty(value = "邀请码")
    private String code;
}
