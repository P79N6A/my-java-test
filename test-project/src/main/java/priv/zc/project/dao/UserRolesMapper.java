package priv.zc.project.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import priv.zc.project.model.UserRoles;
import priv.zc.project.model.UserRolesCriteria;

public interface UserRolesMapper {
    int countByExample(UserRolesCriteria example);

    int deleteByExample(UserRolesCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserRoles record);

    int insertSelective(UserRoles record);

    List<UserRoles> selectByExample(UserRolesCriteria example);

    UserRoles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserRoles record, @Param("example") UserRolesCriteria example);

    int updateByExample(@Param("record") UserRoles record, @Param("example") UserRolesCriteria example);

    int updateByPrimaryKeySelective(UserRoles record);

    int updateByPrimaryKey(UserRoles record);
}