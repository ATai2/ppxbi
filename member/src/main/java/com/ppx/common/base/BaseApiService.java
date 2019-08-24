package com.ppx.common.base;

public class BaseApiService {
    public ResponseBase setError(String msg) {
        ResponseBase responseBase = new ResponseBase();
        responseBase.setCode(RESPONSE.ERROR);
        responseBase.setMessage(msg);
        return responseBase;
    }

    public ResponseBase setResultSuccess(Object data) {
        ResponseBase responseBase = new ResponseBase();
        responseBase.setCode(RESPONSE.SUCCESS);
        responseBase.setData(data);
        return responseBase;
    }
    public ResponseBase setResultSuccess(String msg) {
        ResponseBase responseBase = new ResponseBase();
        responseBase.setCode(RESPONSE.SUCCESS);
        responseBase.setMessage(msg);
        return responseBase;
    }
}
