package com.chenxyz.springCloudDemo.web.service.commonFeign;

import com.chenxyz.springCloudDemo.web.entity.SMSEntity;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 这是一个普通的Feign客户端，
 * 使用这种方法可以直接调用未在同一Eureka(集群)中注册的应用或者外部接口
 * 这里使用了原生的Feign注解@RequestLine
 * Created by chenxyz on 2018/5/27.
 */
@FeignClient(name = "sms-service-common-feign", url = "http://localhost:8001", configuration = CommonFeignConfig.class)
public interface CommonSMSFeignService {

    /** 普通GET请求 */
    @RequestLine("GET /sms")
    String querySms();

    /** POST请求传递对象 */
    @RequestLine("POST /sms")
    String sendSms(SMSEntity sms);

    /** 固定一个body请求的模板，占位符代表参数 */
    @RequestLine("POST /sms")
    @Headers("Content-Type: application/json")
    // 可以是{"pohone":"10086","content":"hahha"}
    // 或者可以是<xml></xml>
    @Body("%7B\"phoneNo\": \"{phoneNo}\", \"message\": \"{message}\"%7D")
    String sendSmsTemplate(@Param("phoneNo") String phoneNo, @Param("message") String message);

    /** 获取短信内容 */
    @RequestLine("GET /sms/{id}")
    SMSEntity getSms(@Param("id") long id);


    /** 获取短信内容 */
    @Headers("Content-Type: application/json")
    @RequestLine("PUT /sms/{id}")
    String updateSms(@Param("id") long id, SMSEntity sms);


    /** 获取短信内容 */
    @RequestLine("DELETE /sms/{id}")
    String delete(@Param("id") long id);
}
