package com.example.learnplan.ding;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;

/**
 * @author wangfk
 */
public class DingRobotTest {
    public static void main(String[] args) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?access_token=f28fefb46d4ef71e5322005e674314fda05aaa39cfd5415c7426403d2d4bfdc7");
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        request.setHttpMethod("POST");
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        text.setContent("我王罗昊就是这么狂！");
        request.setText(text);
        OapiRobotSendResponse response = client.execute(request);
        System.out.println(response);
    }
}
