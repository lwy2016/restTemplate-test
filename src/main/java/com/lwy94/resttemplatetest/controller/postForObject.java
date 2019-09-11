package com.lwy94.resttemplatetest.controller;

import com.lwy94.resttemplatetest.entity.Issue;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liweiya
 * @date 2019/8/26 19:17
 */
// https://segmentfault.com/a/1190000015144126#articleHeader3
public class postForObject {
    public static void main(String[] args) {
        postForObject postForObject = new postForObject();
        postForObject.postForObject1();
    }

    /**
     * json格式
     * {
     *   "title": "Creating issue from API",
     *   "body": "Posting a issue from Insomnia"
     * }
     */

    public void postForObject1() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> map = new HashMap<>();
        map.put("title", "title333");
        map.put("body", "孤帆远影碧空尽");
// 新增一个issue,使用map
        // 我的token,就可以post新增或修改了
        String url1 = "https://api.github.com/repos/lwy2016/Test1/issues?access_token=051a9ef9f38ea1fc84c165e170d2b77a48a4ac27";
        String result1 = restTemplate.postForObject(url1, map, String.class);
        System.out.println(result1);

//  新增一个issue， 使用实体类
        Issue issue = new Issue();
        issue.setTitle("third33333333333");
        issue.setBody("bbbbooodyyyy3333");
        String result = restTemplate.postForObject(url1, issue, String.class);
        System.out.println(result);

// 新增issue里的一个 comment
        Map<String, String> map2 = new HashMap<>();
        map2.put("body", "唯见长江天际流");

        String url2 = "https://api.github.com/repos/lwy2016/Test1/issues/2/comments?access_token=051a9ef9f38ea1fc84c165e170d2b77a48a4ac27";
        String result2 = restTemplate.postForObject(url2, map2, String.class);
        System.out.println(result2);
    }
}
