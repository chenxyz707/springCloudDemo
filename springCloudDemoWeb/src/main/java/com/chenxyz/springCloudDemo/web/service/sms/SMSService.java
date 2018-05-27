package com.chenxyz.springCloudDemo.web.service.sms;

import com.chenxyz.springCloudDemo.web.entity.SMSEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chenxyz on 2018/5/27.
 */
@FeignClient(name = "sms-service")
public interface SMSService {

    @RequestMapping(value="sms", method = RequestMethod.POST)
    String add(@RequestBody SMSEntity entity);

    @RequestMapping(value = "sms", method = RequestMethod.GET)
    String queryAll();

    @RequestMapping(value = "sms/{id}", method = RequestMethod.GET)
    SMSEntity getById(@PathVariable("id") String id);

    @RequestMapping(value = "sms/{id}", method = RequestMethod.PUT)
    String update(@PathVariable("id") String id, @RequestBody SMSEntity entity);

    @RequestMapping(value = "sms/{id}", method = RequestMethod.DELETE)
    String delete(@PathVariable("id") String id);
}
