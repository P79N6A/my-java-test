package priv.zc.project.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import priv.zc.project.model.SubscribeInfo;
import priv.zc.project.model.SubscribeInfoCriteria;

public interface SubscribeInfoMapper {
    int countByExample(SubscribeInfoCriteria example);

    int deleteByExample(SubscribeInfoCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(SubscribeInfo record);

    int insertSelective(SubscribeInfo record);

    List<SubscribeInfo> selectByExample(SubscribeInfoCriteria example);

    SubscribeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SubscribeInfo record, @Param("example") SubscribeInfoCriteria example);

    int updateByExample(@Param("record") SubscribeInfo record, @Param("example") SubscribeInfoCriteria example);

    int updateByPrimaryKeySelective(SubscribeInfo record);

    int updateByPrimaryKey(SubscribeInfo record);
}