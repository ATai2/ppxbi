package com.ppx.message.adapter;

import com.alibaba.fastjson.JSONObject;

public interface MessageAdapter {
    void sendMsg(JSONObject body);
}
