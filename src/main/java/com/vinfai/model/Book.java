package com.vinfai.model;

import java.io.Serializable;

/**
 * @author vinfai
 * @since 2017/5/17
 */
public class Book implements Serializable {

    public String name;

    public String sbin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSbin() {
        return sbin;
    }

    public void setSbin(String sbin) {
        this.sbin = sbin;
    }
}
