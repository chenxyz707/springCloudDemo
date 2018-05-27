package com.chenxyz.springCloudDemo.web.controller;

import com.chenxyz.springCloudDemo.web.entity.SMSEntity;
import com.chenxyz.springCloudDemo.web.service.commonFeign.CommonSMSFeignService;
import com.chenxyz.springCloudDemo.web.service.sms.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by chenxyz on 2018/5/20.
 */
@Controller
@RequestMapping("/sms")
@RefreshScope
public class SMSController {

    @Autowired
    SMSService smsService;

    @Autowired
    CommonSMSFeignService commonSMSFeignService;

    @Value("${sms.template}")
    private String smsTemplate;

    public static final String SMS_INSTANCE = "sms-service";
    public static final String SMS_PATH = "/sms";

    @RequestMapping("send")
    @ResponseBody
    public String send(@RequestBody SMSEntity entity) {
        return smsService.add(entity);
    }

    @RequestMapping("getSMSById")
    @ResponseBody
    public SMSEntity getSMSById(String id) {
        return smsService.getById(id);
    }

    @RequestMapping("queryAll")
    @ResponseBody
    public String queryAll() {
        return smsService.queryAll();
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(@RequestBody SMSEntity entity) {
        return commonSMSFeignService.updateSms(entity.getId(), entity);
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(long id) {
        return commonSMSFeignService.delete(id);
    }

    @RequestMapping("getSMSTemplate")
    @ResponseBody
    public String getSMSTemplate() {
        return smsTemplate;
    }
}
