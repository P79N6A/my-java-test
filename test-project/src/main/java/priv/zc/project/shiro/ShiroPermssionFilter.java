package priv.zc.project.shiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import priv.zc.project.dao.PermissionMapper;
import priv.zc.project.model.Permission;
import priv.zc.project.model.PermissionCriteria;

/**
 * 根据url过滤权限
 * 
 * @author zongchao
 *
 */
public class ShiroPermssionFilter extends AuthorizationFilter {
    private static final Log log = LogFactory.getLog(ShiroPermssionFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        Subject subject = getSubject(request, response);
        String uri = ((HttpServletRequest) request).getRequestURI();
        String permission = convertUriToPermission(uri);
        boolean isAccessAllowed = false;
        if (permission != null) {
            isAccessAllowed = subject.isPermitted(permission);
        }
        if (!isAccessAllowed)
            log.info("userId[" + subject.getPrincipal() + "] ip[" + request.getRemoteAddr() + "] uri[" + uri
                    + "] failed!");
        return isAccessAllowed;
    }

    /**
     * 将uri转换成permisionid
     * 
     * @param uri
     * @return
     */
    private String convertUriToPermission(String uri) {
        Map<String, String> uriPermissionMap = getUriPermissionMap();
        // 1.全匹配
        String permission = uriPermissionMap.get(uri);
        if (permission != null)
            log.debug(uri + "直接匹配成功");
        if (permission == null) {
            // 2.最长前缀匹配
            Set<String> set = uriPermissionMap.keySet();
            String prefixMatchedUri = null;
            int length = 0;
            for (String prefix : set) {
                if (uri.startsWith(prefix) && prefix.length() > length) {
                    prefixMatchedUri = prefix;
                }
            }
            if (prefixMatchedUri != null) {
                log.debug(uri + "前缀匹配到" + prefixMatchedUri);
                permission = uriPermissionMap.get(prefixMatchedUri);
            }
        }
        return permission;
    }

    /**
     * map<uri,permission>
     */
    private Map<String, String> uriPermissionMap;

    @Autowired
    private PermissionMapper permissionMapper;

    public synchronized void refreshPermission() {
        uriPermissionMap = selectUriPermissionFromDb();
    }

    public Map<String, String> getUriPermissionMap() {
        if (uriPermissionMap == null) {
            refreshPermission();
        }
        return uriPermissionMap;
    }

    public Map<String, String> selectUriPermissionFromDb() {
        PermissionCriteria permissionCriteria = new PermissionCriteria();
        List<Permission> permissionList = permissionMapper.selectByExample(permissionCriteria);
        Map<String, String> resultMap = new HashMap<String, String>();
        for (Permission permission : permissionList) {
            if (permission.getMenuUrl() != null) {
                resultMap.put(permission.getMenuUrl(), permission.getName());
            }
        }
        return resultMap;
    }
}
