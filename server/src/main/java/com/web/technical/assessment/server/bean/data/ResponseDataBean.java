package com.web.technical.assessment.server.bean.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Project server
 * User : suren_v
 * Date : 03/27/2021
 * Time : 11:14 AM
 */

public class ResponseDataBean<T> {
    private long fullCount;
    private List<T> data = new ArrayList<T>();

    public long getFullCount() {
        return fullCount;
    }

    public void setFullCount(long fullCount) {
        this.fullCount = fullCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
