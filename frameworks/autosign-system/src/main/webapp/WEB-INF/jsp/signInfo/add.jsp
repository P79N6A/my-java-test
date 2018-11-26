<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="pageContent">
    <form method="post" action="/signInfo/addPost" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
        <div class="pageFormContent" layoutH="56">
            <p>
                <label>URL：</label>
                <input name="signUrl" type="text" size="30" />
            </p>
            <p>
                <label>Cookie：</label>
                <input name="cookie" type="text" size="30" />
            </p>
        </div>
        <div class="formBar">
            <ul>
                <!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
                <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
                <li>
                    <div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
                </li>
            </ul>
        </div>
    </form>
</div>

