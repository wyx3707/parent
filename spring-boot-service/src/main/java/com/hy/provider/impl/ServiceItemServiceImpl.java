package com.hy.provider.impl;

import com.hy.repository.mapper.SvcServiceItemPOMapper;
import com.hy.repository.po.SvcServiceItemPO;
import com.hy.service.api.ServiceItemService;
import com.hy.service.dto.SvcServiceItemDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 查询服务项目
 *
 * @author wyx
 */
@Service("serviceItemService")
@Transactional(rollbackFor = Exception.class)
public class ServiceItemServiceImpl implements ServiceItemService {

    @Autowired
    private SvcServiceItemPOMapper svcServiceItemPOMapper;

    @Override
    public SvcServiceItemDTO getSvcServiceItemPO(Integer itemId) {
        SvcServiceItemPO svcServiceItemPO = svcServiceItemPOMapper.selectByPrimaryKey(itemId);

        SvcServiceItemDTO svcServiceItemDTO=new SvcServiceItemDTO();
        BeanUtils.copyProperties(svcServiceItemPO,svcServiceItemDTO);
        return svcServiceItemDTO;
    }
}
