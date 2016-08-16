package priv.zc.project.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import priv.zc.example.service.SpringContextHolder;
import priv.zc.project.shiro.ShiroPermssionFilter;

@Controller
public class AuthController {

    private static final Log log = LogFactory.getLog(AuthController.class);

    @RequiresPermissions("index")
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    
    @RequestMapping("login")
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return "redirect:/";
        }
        return "login";
    }

    @RequestMapping("error")
    public String error() {
        return "error";
    }

    @RequestMapping("403")
    public String unauthorized() {
        return "403";
    }

    @RequestMapping("logincommit")
    public String logincommit(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                subject.login(token);
            } catch (Exception e) {
                log.error(e, e);
                return "redirect:/error";
            }
        }
        return "redirect:/";
    }

    @RequestMapping("refresh")
    public void refresh() {
        ((ShiroPermssionFilter) SpringContextHolder.getBean("permissionFilter")).refreshPermission();
    }

    @RequestMapping("loginInfo")
    @ResponseBody
    public Object loginInfo() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Map<String, Object> returnMap = new LinkedHashMap<>();
        returnMap.put("host", session.getHost());
        returnMap.put("id", session.getId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        returnMap.put("lastAccessTime", sdf.format(session.getLastAccessTime()));
        returnMap.put("startTimestamp", sdf.format(session.getStartTimestamp()));
        returnMap.put("timeout", session.getTimeout());
        returnMap.put("isLogin", subject.isAuthenticated());
        returnMap.put("principal", subject.getPrincipal());
        EhCacheManager manager = SpringContextHolder.getBean("shiroCacheManager");
        CacheManager cacheManager = manager.getCacheManager();
        returnMap.put("ehcache-name", cacheManager.getName());
        List<Map<String, Object>> cacheList = new ArrayList<>();
        for (String cacheName : cacheManager.getCacheNames()) {
            Ehcache ehcache = cacheManager.getEhcache(cacheName);
            Map<String, Object> cacheMap = new LinkedHashMap<String, Object>();
            cacheMap.put("name", ehcache.getName());
            cacheMap.put("size", ehcache.getSize());
            List keys = ehcache.getKeys();
            List<Map> dataList = new ArrayList<>();
            for (Object key : keys) {
                Map map = new LinkedHashMap();
                map.put("key", key);
                map.put("value", ehcache.get(key));
                dataList.add(map);
            }
            cacheMap.put("data", dataList);
            cacheList.add(cacheMap);
        }
        returnMap.put("echcache-instance", cacheList);
        return returnMap;
    }
}
