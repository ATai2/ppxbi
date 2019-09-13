package com.ppx.common.ppxutil.demos.multithread;

import com.qcloud.cos.annotation.GuardedBy;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class Msg {
    private String content = "apple";
    @GuardedBy("this")
    private String content2 = "apple";

    public Msg(String content) {
        this.content = content;
    }
}

