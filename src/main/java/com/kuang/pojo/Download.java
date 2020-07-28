package com.kuang.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 遇见狂神说
 * @since 2020-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ks_download")
@ApiModel(value="Download对象", description="")
public class Download implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "资源名")
    private String dname;

    @ApiModelProperty(value = "资源链接")
    private String ddesc;

    @ApiModelProperty(value = "提取码")
    private String dcode;


}
