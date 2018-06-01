package com.hy.service.api;

import com.hy.service.dto.SvcServiceItemDTO;

/**
 * 服务项目服务接口定义
 *
 * @author wyx
 */
public interface ServiceItemService {

    /**
     * 使用mybatis查询数据库里的数据
     *
     * @param itemId
     * @return
     */
    SvcServiceItemDTO getSvcServiceItemPO(Integer itemId);
}
