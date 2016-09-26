package priv.zc.autosign.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import priv.zc.autosign.model.RolePermissions;
import priv.zc.autosign.model.RolePermissionsCriteria;

public interface RolePermissionsMapper {
    long countByExample(RolePermissionsCriteria example);

    int deleteByExample(RolePermissionsCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePermissions record);

    int insertSelective(RolePermissions record);

    List<RolePermissions> selectByExample(RolePermissionsCriteria example);

    RolePermissions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePermissions record, @Param("example") RolePermissionsCriteria example);

    int updateByExample(@Param("record") RolePermissions record, @Param("example") RolePermissionsCriteria example);

    int updateByPrimaryKeySelective(RolePermissions record);

    int updateByPrimaryKey(RolePermissions record);
}