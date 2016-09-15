package priv.zc.autosign.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import priv.zc.autosign.model.SignInfo;
import priv.zc.autosign.service.SignInfoService;
import priv.zc.autosign.vo.AjaxDoneVo;
import priv.zc.autosign.vo.ResultVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/signInfo")
public class SignInfoCtrl {
    Logger logger = LoggerFactory.getLogger(SignInfoCtrl.class);

    @Autowired
    private SignInfoService signInfoService;

    @RequestMapping("list")
    public String list(HttpServletRequest request) {
        logger.debug("进入list");
        List<SignInfo> list = signInfoService.select();
        request.setAttribute("list", list);
        return "signInfo/list";
    }

    @RequestMapping("add")
    public String add() {
        return "signInfo/add";
    }

    @RequestMapping(value = "addPost", method = RequestMethod.POST)
    @ResponseBody
    public AjaxDoneVo addPost(@ModelAttribute SignInfo signInfo) {
        int count = signInfoService.insert(signInfo);
        AjaxDoneVo vo;
        if (count == 1) {
            vo = AjaxDoneVo.success();
            vo.setForwardUrl("/signInfo/list");
            vo.setNavTabId("signInfo_list");
            vo.setCallbackType(AjaxDoneVo.CALLBACK_TYPE_CLOSE_CURRENT);
        } else {
            vo = AjaxDoneVo.error();
        }
        return vo;
    }

    @RequestMapping("update/{id}")
    public String update(HttpServletRequest request, @PathVariable Long id) {
        SignInfo signInfo = signInfoService.select(id);
        if (signInfo == null) {
            return JSON.toJSONString(AjaxDoneVo.error());
        }
        request.setAttribute("signInfo", signInfo);
        return "signInfo/update";
    }

    @RequestMapping("updatePost")
    @ResponseBody
    public AjaxDoneVo updatePost(@ModelAttribute SignInfo signInfo) {
        SignInfo update = new SignInfo();
        update.setId(signInfo.getId());
        update.setCookie(signInfo.getCookie());
        update.setSignUrl(signInfo.getSignUrl());
        AjaxDoneVo vo;
        if (signInfoService.update(signInfo)) {
            vo = AjaxDoneVo.success();
            vo.setCallbackType(AjaxDoneVo.CALLBACK_TYPE_CLOSE_CURRENT);
            vo.setNavTabId("signInfo_list");
            vo.setForwardUrl("/signInfo/list");
        } else {
            vo = AjaxDoneVo.error();
        }

        return vo;
    }

    @RequestMapping("exec/{id}")
    @ResponseBody
    public ResultVo exec(@PathVariable Long id) {
        return signInfoService.exec(id);
    }

    @RequestMapping("delete/{id}")
    @ResponseBody
    public AjaxDoneVo delete(@PathVariable Long id) {
        int count = signInfoService.delete(id);
        if (count == 1) {
            AjaxDoneVo vo = AjaxDoneVo.success();
            return vo;
        } else {
            return AjaxDoneVo.error();
        }
    }
}
