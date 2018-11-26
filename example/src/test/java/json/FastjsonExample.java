package json;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by  on 18/4/9.
 */
public class FastjsonExample {
    public static void main(String[] args) {
        String str  = "{\"action_list\":[{\"action_id\":\"open_page_satisfy\",\"action_type\":{\"act_target\":\"\","
                + "\"act_target_detail\":\"\",\"act_type\":\"satisfy\",\"act_type_detail\":\"\"},\"arg_list\":[],"
                + "\"code_actions\":[],\"confidence\":1,\"exe_status\":[],\"hint_list\":[],"
                + "\"main_exe\":\"exe_open_page\",\"say\":\"\"}],"
                + "\"log_id\":\"unitweb_log_cd07f250-33d9-11e8-94cc-719fa2fed796_15563\",\"msg\":\"ok\","
                + "\"qu_res\":{\"intent_candidates\":[{\"extra_info\":null,\"from_who\":\"smart_qu\","
                + "\"func_slot\":\"\",\"intent\":\"OPEN_PAGE\",\"intent_confidence\":100,"
                + "\"intent_need_clarify\":false,\"match_info\":\"打开[D:user_pagename] \","
                + "\"slots\":[{\"confidence\":100,\"length\":8,\"need_clarify\":false,\"normalized_word\":\"财务\","
                + "\"offset\":4,\"original_word\":\"财务管理\",\"type\":\"user_pagename\",\"word_type\":\"\"}]}],"
                + "\"lexical_analysis\":[{\"basic_word\":[\"打开\"],\"term\":\"打开\",\"type\":\"37\",\"weight\":0"
                + ".38766032457352},{\"basic_word\":[\"财务\",\"管理\"],\"term\":\"财务管理\",\"type\":\"21\",\"weight\":0"
                + ".61233961582184}],\"log_id\":\"unitweb_log_cd07f250-33d9-11e8-94cc-719fa2fed796_15563\","
                + "\"raw_query\":\"打开财务管理\",\"sentiment_analysis\":{\"label\":1,\"pval\":0.949687},\"status\":0,"
                + "\"timestamp\":1},\"schema\":{\"bot_merged_slots\":[{\"begin\":0,\"confidence\":0,\"length\":0,"
                + "\"merge_method\":\"update\",\"normalized_word\":\"财务\",\"original_word\":\"财务管理\","
                + "\"session_offset\":0,\"type\":\"user_pagename\",\"word_type\":\"\"}],"
                + "\"current_qu_intent\":\"OPEN_PAGE\",\"intent_confidence\":100},\"status\":0,\"msg_type\":\"bot\","
                + "\"bot_type\":\"userbot\"}";
        ChatBean bean = JSONObject.parseObject(str, ChatBean.class);
        List<ChatBean.QuResBean.IntentCandidatesBean> list = bean.getQuRes().getIntentCandidates();
        for(ChatBean.QuResBean.IntentCandidatesBean a:list){
            System.out.println(a.getIntent());
            List<ChatBean.QuResBean.IntentCandidatesBean.SlotsBean> slots = a.getSlots();

        }
    }
}
