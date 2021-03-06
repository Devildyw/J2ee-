package org.cuit.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.cuit.pojo.User;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MailDTO {
    private User user;

    private String email;

    private String code;
}
