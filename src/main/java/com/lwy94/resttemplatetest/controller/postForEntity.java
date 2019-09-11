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
        postForEntity.post1();
    }

    public void post1() {
        RestTemplate restTemplate = new RestTemplate();
        Issue issue = new Issue();
        issue.setTitle("third33333333333");
        issue.setBody("bbbbooodyyyy3333");
// 新增一个issue,使用map
        // 我的token,就可以post新增或修改了
        String url1 = "https://api.github.com/repos/lwy2016/Test1/issues?access_token=051a9ef9f38ea1fc84c165e170d2b77a48a4ac27";
        ResponseEntity<Issue> responseEntity = restTemplate.postForEntity(url1, issue, Issue.class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
        System.out.println(responseEntity.getHeaders());
    }
}
