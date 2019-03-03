package com.ppx.ppxes.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 返回结果封装类
 *
 * @since 1.0
 *
 * @version 1.0
 *
 * @author gegf
 */
public class ResponseEntity<T> {

    private Integer code;

    private String message;

    private T data;

    private boolean more;

    public ResponseEntity(){}

    public ResponseEntity(Integer code) {
        this.code = code;
    }

    public ResponseEntity(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseEntity(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.code == StatusCode.SUCCESS.getCode();
    }

    public static <T> ResponseEntity<T> createBySuccess(){
        return new ResponseEntity<>(StatusCode.SUCCESS.getCode());
    }

    public static <T> ResponseEntity<T> createBySuccessMessage(String message){
        return new ResponseEntity<>(StatusCode.SUCCESS.getCode(), message);
    }

    public static <T> ResponseEntity<T> createBySuccess(T data){
        return new ResponseEntity<>(StatusCode.SUCCESS.getCode(), data);
    }

    public static <T> ResponseEntity<T> ofSuccess(Object object){
        return new ResponseEntity(StatusCode.SUCCESS.getCode(), object);
    }

    public static <T> ResponseEntity<T> createByErrorCodeMessage(int errorCode, String msg){
        return new ResponseEntity<>(errorCode, msg);
    }

    public static <T> ResponseEntity<T> createByErrorCodeMessage(StatusCode code){
        return new ResponseEntity<>(code.getCode(), code.getMessage());
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }
}
