package com.web.technical.assessment.server.bean.response;


import com.web.technical.assessment.server.bean.keyvalue.KeyValueBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Project server
 * User : suren_v
 * Date : 03/27/2021
 * Time : 11:25 PM
 */
public class ResponseBean {
    private boolean requestOk;
    private String errorCode;
    private String messageType; //S -> successMessage ,W -> warningMessage ,E -> errorMessage
    private String message;
    private List<KeyValueBean> data = new ArrayList<KeyValueBean>();

    public ResponseBean() {
    }

    public ResponseBean(boolean requestOk) {
        this.requestOk = requestOk;
    }

    public ResponseBean(boolean requestOk, String errorCode, String message) {
        this.requestOk = requestOk;
        this.errorCode = errorCode;
        this.message = message;
    }

    public boolean isRequestOk() {
        return requestOk;
    }

    public void setRequestOk(boolean requestOk) {
        this.requestOk = requestOk;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<KeyValueBean> getData() {
        return data;
    }

    public void setData(List<KeyValueBean> data) {
        this.data = data;
    }

    public void setData(KeyValueBean... kv) {
        for (KeyValueBean o : kv) {
            data.add(o);
        }
    }
}
