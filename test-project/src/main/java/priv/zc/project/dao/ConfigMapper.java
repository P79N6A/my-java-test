package priv.zc.project.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import priv.zc.project.model.Config;
import priv.zc.project.model.ConfigCriteria;

public interface ConfigMapper {
    int countByExample(ConfigCriteria example);

    int deleteByExample(ConfigCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Config record);

    int insertSelective(Config record);

    List<Config> selectByExample(ConfigCriteria example);

    Config selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Config record, @Param("example") ConfigCriteria example);

    int updateByExample(@Param("record") Config record, @Param("example") ConfigCriteria example);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);
}