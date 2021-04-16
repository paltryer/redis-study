package com.chnsys.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 用户实体
 *
 * @author wangchao
 * @version 1.0
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private String name;
    private int age;

}
