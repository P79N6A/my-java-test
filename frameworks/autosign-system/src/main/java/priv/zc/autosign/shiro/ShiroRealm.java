package priv.zc.autosign.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import priv.zc.autosign.dao.*;
import priv.zc.autosign.model.*;

import java.util.ArrayList;
import java.util.List;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRolesMapper userRolesMapper;
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    RolePermissionsMapper rolePermissionMapper;
    
    /**
     * 授权方法，调用SecurityUtils.getSubject().hasPermission() ,isPermitted()等权限相关api时被调用
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object object=principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Integer userId = (Integer) SecurityUtils.getSubject().getPrincipal();
        UserRolesCriteria userRolesCriteria = new UserRolesCriteria();
        userRolesCriteria.createCriteria().andUserIdEqualTo(userId);
        List<UserRoles> userRolesList = userRolesMapper.selectByExample(userRolesCriteria);
        List<Integer> idList = new ArrayList<>();
        for (UserRoles userRoles : userRolesList) {
            idList.add(userRoles.getRoleId());
        }
        RoleCriteria roleCriteria = new RoleCriteria();
        roleCriteria.createCriteria().andIdIn(idList);
        List<Role> roleList = roleMapper.selectByExample(roleCriteria);
        for (Role role : roleList) {
            info.addRole(role.getName());
            RolePermissionsCriteria rolePermissionsCriteria = new RolePermissionsCriteria();
            rolePermissionsCriteria.createCriteria().andRoleIdEqualTo(role.getId());
            List<RolePermissions> rolePermissionList = rolePermissionMapper.selectByExample(rolePermissionsCriteria);
            idList = new ArrayList<Integer>();
            for (RolePermissions rolePermissions : rolePermissionList) {
                idList.add(rolePermissions.getResourceId());
            }
            PermissionCriteria permissionCriteria = new PermissionCriteria();
            permissionCriteria.createCriteria().andIdIn(idList);
            List<Permission> permissionList = permissionMapper.selectByExample(permissionCriteria);
            for (Permission permission : permissionList) {
                info.addStringPermission(permission.getName());
            }
        }
        return info;
    }

    /**
     * 认证方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(userCriteria);
        if (userList == null || userList.size() == 0) {
            throw new UnknownAccountException("用户不存在或密码错误");
        }
        if (userList.size() > 1) {
            throw new AuthenticationException("账户数据出现错误");
        }
        return new SimpleAuthenticationInfo(userList.get(0).getId(), password, getName());
    }

}
