package org.cuit.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Devil
 * @since 2022-05-20
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cl_invite")
@ApiModel(value = "Invite邀请码", description = "邀请码")
public class Invite implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "邀请码")
    private String code;

    @ApiModelProperty(value = "用户id")
    private String uid;

    @ApiModelProperty(value = "状态 0 未使用 1 使用")
    private Integer status;

    @ApiModelProperty(value = "激活时间")
    private Date activeTime;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;


}
