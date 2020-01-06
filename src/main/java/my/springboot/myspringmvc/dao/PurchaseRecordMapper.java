package my.springboot.myspringmvc.dao;

import my.springboot.myspringmvc.pojo.PurchaseRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchaseRecord record);

    int insertSelective(PurchaseRecord record);

    PurchaseRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PurchaseRecord record);

    int updateByPrimaryKey(PurchaseRecord record);
}