package com.lwy94.resttemplatetest.controller;

import com.lwy94.resttemplatetest.entity.Contributor;
import com.lwy94.resttemplatetest.entity.Test1;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author liweiya
 * @date 2019/8/22 9:24
 */

public class getForEntity {
    public static void main(String[] args) {
        getForEntity getForEntity = new getForEntity();
        getForEntity.restTemplateGetForEntityByString1();
        getForEntity.restTemplateGetForEntityByString();
    }

    // https://api.github.com/repos/lwy2016/Test1
    public void restTemplateGetForEntityByString1() {
        RestTemplate restTemplate = new RestTemplate();
        // 返回多个实体类,则需要是Contributor[].class, 单个的返回不需要 []
        ResponseEntity<Test1> test1 = restTemplate.getForEntity("https://api.github.com/repos/{owner}/{repo}", Test1.class,"lwy2016", "Test1");
        // 得到 GET 请求的所有信息
        System.out.println(test1);

        // 得到请求状态 如 200 OK
        System.out.println(test1.getStatusCode());
        // 得到状态值 如 200
        System.out.println(test1.getStatusCodeValue());
        // 得到请求体 即 Test1 这个实体类
        System.out.println(test1.getBody());
        System.out.println(test1.getBody().getNode_id());
        // 得到请求头， 这里有很多请求消息
        System.out.println(test1.getHeaders());
        // 得到请求头里的多个消息
        System.out.println(test1.getHeaders().getDate());
        System.out.println(test1.getHeaders().getContentType());
        System.out.println(test1.getHeaders().getVary());
        System.out.println(test1.getHeaders().getCacheControl());
    }


    /**
     * 带参数的GET请求
     */
    // https://api.github.com/repos/lwy2016/Test1/contributors
    public void restTemplateGetForEntityByString() {
        RestTemplate restTemplate = new RestTemplate();
        // 返回多个实体类,则需要是Contributor[].class, 单个的返回不需要 []
        ResponseEntity<Contributor[]> entity = restTemplate.getForEntity("https://api.github.com/repos/{owner}/{repo}/contributors", Contributor[].class,"lwy2016", "Test1");
        for (Contributor Contributor : entity.getBody()) {
            System.out.println(Contributor.toString());
        }

        System.out.println(entity.getHeaders());
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getStatusCodeValue());
    }

    // getForEntity(url, class, map), getForEntity(url, class) 与上面类似
}
