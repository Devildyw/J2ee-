package org.cuit.DTO;

import lombok.Data;
import org.cuit.pojo.User;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Data
public class MailDTO {
    private User user;

    private String email;

    private String code;
}
