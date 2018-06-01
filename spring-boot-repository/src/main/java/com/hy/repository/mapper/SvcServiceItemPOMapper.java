package com.hy.repository.mapper;

import com.hy.repository.po.SvcServiceItemPO;
import com.hy.repository.po.SvcServiceItemPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SvcServiceItemPOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table svc_service_item
     *
     * @mbg.generated
     */
    long countByExample(SvcServiceItemPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table svc_service_item
     *
     * @mbg.generated
     */
    int deleteByExample(SvcServiceItemPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table svc_service_item
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer serviceItemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table svc_service_item
     *
     * @mbg.generated
     */
    int insert(SvcServiceItemPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table svc_service_item
     *
     * @mbg.generated
     */
    int insertSelective(SvcServiceItemPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table svc_service_item
     *
     * @mbg.generated
     */
    List<SvcServiceItemPO> selectByExample(SvcServiceItemPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table svc_service_item
     *
     * @mbg.generated
     */
    SvcServiceItemPO selectByPrimaryKey(Integer serviceItemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table svc_service_item
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SvcServiceItemPO record, @Param("example") SvcServiceItemPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table svc_service_item
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SvcServiceItemPO record, @Param("example") SvcServiceItemPOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table svc_service_item
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SvcServiceItemPO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table svc_service_item
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SvcServiceItemPO record);
}