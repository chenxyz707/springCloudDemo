package com.chenxyz.springCloudDemo.web.service.sms;

import com.chenxyz.springCloudDemo.web.entity.SMSEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * sms-service降级
 *
 * @author chenxyz
 * @version 1.0
 * @date 2018-10-10
 */
public class SMSServiceFallback implements SMSService {
    @Override
    public String add(@RequestBody SMSEntity entity) {
        return "新增短消息失败！";
    }

    @Override
    public String queryAll() {
        return "查询所有短消息失败！";
    }

    @Override
    public SMSEntity getById(@PathVariable("id") String id) {
        return new SMSEntity();
    }

    @Override
    public String update(@PathVariable("id") String id, @RequestBody SMSEntity entity) {
        return "更新短消息信息失败！";
    }

    @Override
    public String delete(@PathVariable("id") String id) {
        return "删除消息失败！";
    }

    @Override
    public String sendRgister() {
        return "发送注册码失败！";
    }
}
