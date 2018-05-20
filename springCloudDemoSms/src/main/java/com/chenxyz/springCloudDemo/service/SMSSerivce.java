package com.chenxyz.springCloudDemo.service;

import com.chenxyz.springCloudDemo.sms.entity.SMSEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by chenxyz on 2018/5/20.
 */
@RepositoryRestResource(collectionResourceRel = "sms", path = "sms")
public interface SMSSerivce extends PagingAndSortingRepository<SMSEntity, Long> {
}
