package com.lwy94.resttemplatetest.controller;

import com.lwy94.resttemplatetest.entity.Issue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liweiya
 * @date 2019/9/11 11:27
 */

public class postForEntity {
    public static void main(String[] args) {
        postForEntity postForEntity = new postForEntity();

    }

    public void post1() {
        RestTemplate restTemplate = new RestTemplate();
        Issue issue = new Issue();
        issue.setTitle("third33333333333");
        issue.setBody("bbbbooodyyyy3333");
// 新增一个issue,使用map
        // 我的token,就可以post新增或修改了
        String url1 = "https://api.github.com/repos/lwy2016/Test1/issues?access_token=18eedf289c5a7f8d07f3288ee9b18b4bbcee3168";
        ResponseEntity<Issue> responseEntity = restTemplate.postForEntity(url1, issue, Issue.class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
        System.out.println(responseEntity.getHeaders());
    }
}
