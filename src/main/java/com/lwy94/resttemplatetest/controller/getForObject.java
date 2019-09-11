package com.lwy94.resttemplatetest.controller;

/**
 * @author liweiya
 * @date 2019/8/20 19:33
 */

import com.lwy94.resttemplatetest.entity.Contributor;
import com.lwy94.resttemplatetest.entity.Test1;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class getForObject {
    public static void main(String[] args) {
        getForObject getForObject = new getForObject();
        getForObject.restTemplateGetForObjectByString();
        getForObject.restTemplateGetForObjectByString1();
        getForObject.restTemplateGetForObjectByMap();
        getForObject.restTemplateGetForObject();
    }

    // https://api.github.com/repos/lwy2016/Test1
    public void restTemplateGetForObjectByString1() {
        RestTemplate restTemplate = new RestTemplate();
        // 返回多个实体类,则需要是Contributor[].class, 单个的返回不需要 []
        Test1 test1 = restTemplate.getForObject("https://api.github.com/repos/{owner}/{repo}", Test1.class,"lwy2016", "Test1");
        System.out.println(test1);
    }

    /**
     * 带参数的GET请求
     * 若返回的是一个数组，则需要写为  clazz[].class
     */
    // https://api.github.com/repos/lwy2016/Test1/contributors
    public void restTemplateGetForObjectByString() {
        RestTemplate restTemplate = new RestTemplate();
        // 返回多个实体类,则需要是Contributor[].class, 单个的返回不需要 []
        Contributor[] Contributors = restTemplate.getForObject("https://api.github.com/repos/{owner}/{repo}/contributors", Contributor[].class,"lwy2016", "Test1");
        System.out.println("https://api.github.com/repos/lwy2016/Test1/contributors");
        for (Contributor Contributor : Contributors) {
            System.out.println(Contributor.toString());
        }
    }



    /**
     * 带Map参数的GET请求
     */
    public void restTemplateGetForObjectByMap() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> map = new HashMap<>();
        map.put("owner", "fymod");
        map.put("repo", "easy-spring-cloud");
        // 返回多个实体类
        Contributor[] Contributors = restTemplate.getForObject("https://api.github.com/repos/{owner}/{repo}/contributors", Contributor[].class, map);
        for (Contributor Contributor : Contributors) {
            System.out.println(Contributor.toString());
        }
    }

    public void restTemplateGetForObject() {
        RestTemplate restTemplate = new RestTemplate();
        Contributor[] Contributors = restTemplate.getForObject("https://api.github.com/repos/xiaolai/public-speaking-with-meaning/contributors", Contributor[].class);
        for (Contributor Contributor : Contributors) {
            System.out.println(Contributor.toString());
        }
    }
}