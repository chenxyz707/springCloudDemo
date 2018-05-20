package com.chenxyz.springCloudDemo.sms.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by chenxyz on 2018/5/20.
 */
@Entity
@Table(name = "sms")
public class SMSEntity implements Serializable {

    private static final long serialVersionUID = -2323230989374343L;

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String phoneNo;

    @Column
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
