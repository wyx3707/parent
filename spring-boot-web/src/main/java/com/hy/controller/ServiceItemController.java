package com.hy.controller;


import com.hy.service.api.ServiceItemService;
import com.hy.service.dto.SvcServiceItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 本示例主要是测试dubbo和使用spring boot和mybatis的整合
 *
 * @author wyx
 */
@RestController
@RequestMapping("service")
public class ServiceItemController {

    @Autowired
    private ServiceItemService serviceItemService;

    @RequestMapping("list")
    public SvcServiceItemDTO getList() {
        SvcServiceItemDTO svcServiceItemPO = serviceItemService.getSvcServiceItemPO(144);
        System.out.println("sss"+svcServiceItemPO.getServiceItemName());
        return svcServiceItemPO;
    }

}
