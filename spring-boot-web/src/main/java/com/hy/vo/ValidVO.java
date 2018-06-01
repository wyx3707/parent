package com.hy.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * 验证实例
 *
 * @author wyx
 */
@Data
public class ValidVO implements Serializable {
    /**
     * 姓名不可这空，
     * 最小2个字符，最大5个字符
     */
    @NotBlank
    @Length(min = 2, max = 5)
    private String name;

    /**
     * 最小年龄为1
     */
    @Min(value = 1)
    private int age;
}
