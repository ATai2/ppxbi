package com.ppx.base.multithread;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class Msg {
    private String content = "apple";

    public Msg(String content) {
        this.content = content;
    }
}

