package com.lwy94.resttemplatetest.entity;

import lombok.Data;

/**
 * @author liweiya
 * @date 2019/9/11 9:52
 */

@Data
public class Test1 {
    // 这里只想要 请求返回 的部分字段
    private Integer id;
    private String node_id;
    private String name;
    private String full_name;
}
