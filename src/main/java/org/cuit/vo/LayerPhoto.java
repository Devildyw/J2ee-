package org.cuit.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Devil
 * @since 2022-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class LayerPhoto {

    @ApiModelProperty(value = "相册标题")
    private String title;

    @ApiModelProperty(value = "相册id")
    private int id;

    @ApiModelProperty(value = "初始显示的图片序号，默认0")
    private int start;

    @ApiModelProperty(value = "相册包含的图片，数组格式")
    private List<LayerPhotoData> data;

}
