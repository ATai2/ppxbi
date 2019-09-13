package com.ppx.ppxgateway.service;

public interface Bucket<V> {
    /***
     * 收到一个请求，返回是否处理
     * @param item 请求
     * @return 可以处理返回true；如果无法处理，返回false
     */
    boolean receive(V item);
}
