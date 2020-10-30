package com.xyz.springboot.demo1.message.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author xuanyz
 * @title: BasePageMsg
 * @projectName springBoot-mybatisPlus-knife4j
 * @date 2020/10/13 14:15
 * @description: TODO
 * @ModifyRecord： 修改日期: 修改内容
 */
@Data
public class BasePageMsg {

    @NotBlank
    @ApiModelProperty(required = true, notes = "当前页", example = "1")
    private Integer current;

    @NotBlank
    @ApiModelProperty(required = true, notes = "每页显示条数", example = "10")
    private Integer pageSize;

}
