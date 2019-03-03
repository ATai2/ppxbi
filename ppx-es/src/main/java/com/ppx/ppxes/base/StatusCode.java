package com.ppx.ppxes.base;

/**
 * 返回结果状态码
 *
 * @since 1.0
 *
 * @version 1.0
 *
 * @author gegf
 */
public enum StatusCode {

    SUCCESS(200, "OK"),
    BAD_REQUEST(400, "Bad request"),
    INTERNAL_SERVER_ERROR(500, "UnKnown Internal Error"),
    NOT_VALID_PARAM(-1, "Not Valid Params"),
    NOT_SUPPORTED_OPERATION(-2, "Operation not Supported"),
    NOT_LOGIN(403, "Not Login"),
    NOT_FOUND(404, "Not Found");

    private Integer code;

    private String message;

    StatusCode(Integer code, String message){
        this.code = code;
        this.message = message;
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
}
