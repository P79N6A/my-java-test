package json;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by zongchao on 18/4/10.
 */
public class ChatBean {

    /**
     * action_list : [{"action_id":"open_page_satisfy","action_type":{"act_target":"","act_target_detail":"",
     * "act_type":"satisfy","act_type_detail":""},"arg_list":[],"code_actions":[],"confidence":1,"exe_status":[],
     * "hint_list":[],"main_exe":"exe_open_page","say":""}]
     * log_id : unitweb_log_cd07f250-33d9-11e8-94cc-719fa2fed796_15563
     * msg : ok
     * qu_res : {"intent_candidates":[{"extra_info":null,"from_who":"smart_qu","func_slot":"","intent":"OPEN_PAGE",
     * "intent_confidence":100,"intent_need_clarify":false,"match_info":"打开[D:user_pagename] ",
     * "slots":[{"confidence":100,"length":8,"need_clarify":false,"normalized_word":"财务","offset":4,
     * "original_word":"财务管理","type":"user_pagename","word_type":""}]}],"lexical_analysis":[{"basic_word":["打开"],
     * "term":"打开","type":"37","weight":0.38766032457352},{"basic_word":["财务","管理"],"term":"财务管理","type":"21",
     * "weight":0.61233961582184}],"log_id":"unitweb_log_cd07f250-33d9-11e8-94cc-719fa2fed796_15563",
     * "raw_query":"打开财务管理","sentiment_analysis":{"label":1,"pval":0.949687},"status":0,"timestamp":1}
     * schema : {"bot_merged_slots":[{"begin":0,"confidence":0,"length":0,"merge_method":"update",
     * "normalized_word":"财务","original_word":"财务管理","session_offset":0,"type":"user_pagename","word_type":""}],
     * "current_qu_intent":"OPEN_PAGE","intent_confidence":100}
     * status : 0
     * msg_type : bot
     * bot_type : userbot
     */

    @JSONField(name = "log_id")
    private String logId;
    @JSONField(name = "msg")
    private String msg;
    @JSONField(name = "qu_res")
    private QuResBean quRes;
    @JSONField(name = "schema")
    private SchemaBean schema;
    @JSONField(name = "status")
    private int status;
    @JSONField(name = "msg_type")
    private String msgType;
    @JSONField(name = "bot_type")
    private String botType;
    @JSONField(name = "action_list")
    private List<ActionListBean> actionList;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public QuResBean getQuRes() {
        return quRes;
    }

    public void setQuRes(QuResBean quRes) {
        this.quRes = quRes;
    }

    public SchemaBean getSchema() {
        return schema;
    }

    public void setSchema(SchemaBean schema) {
        this.schema = schema;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getBotType() {
        return botType;
    }

    public void setBotType(String botType) {
        this.botType = botType;
    }

    public List<ActionListBean> getActionList() {
        return actionList;
    }

    public void setActionList(List<ActionListBean> actionList) {
        this.actionList = actionList;
    }

    public static class QuResBean {
        /**
         * intent_candidates : [{"extra_info":null,"from_who":"smart_qu","func_slot":"","intent":"OPEN_PAGE",
         * "intent_confidence":100,"intent_need_clarify":false,"match_info":"打开[D:user_pagename] ",
         * "slots":[{"confidence":100,"length":8,"need_clarify":false,"normalized_word":"财务","offset":4,
         * "original_word":"财务管理","type":"user_pagename","word_type":""}]}]
         * lexical_analysis : [{"basic_word":["打开"],"term":"打开","type":"37","weight":0.38766032457352},
         * {"basic_word":["财务","管理"],"term":"财务管理","type":"21","weight":0.61233961582184}]
         * log_id : unitweb_log_cd07f250-33d9-11e8-94cc-719fa2fed796_15563
         * raw_query : 打开财务管理
         * sentiment_analysis : {"label":1,"pval":0.949687}
         * status : 0
         * timestamp : 1
         */

        @JSONField(name = "log_id")
        private String logId;
        @JSONField(name = "raw_query")
        private String rawQuery;
        @JSONField(name = "sentiment_analysis")
        private SentimentAnalysisBean sentimentAnalysis;
        @JSONField(name = "status")
        private int status;
        @JSONField(name = "timestamp")
        private int timestamp;
        @JSONField(name = "intent_candidates")
        private List<IntentCandidatesBean> intentCandidates;
        @JSONField(name = "lexical_analysis")
        private List<LexicalAnalysisBean> lexicalAnalysis;

        public String getLogId() {
            return logId;
        }

        public void setLogId(String logId) {
            this.logId = logId;
        }

        public String getRawQuery() {
            return rawQuery;
        }

        public void setRawQuery(String rawQuery) {
            this.rawQuery = rawQuery;
        }

        public SentimentAnalysisBean getSentimentAnalysis() {
            return sentimentAnalysis;
        }

        public void setSentimentAnalysis(SentimentAnalysisBean sentimentAnalysis) {
            this.sentimentAnalysis = sentimentAnalysis;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public List<IntentCandidatesBean> getIntentCandidates() {
            return intentCandidates;
        }

        public void setIntentCandidates(List<IntentCandidatesBean> intentCandidates) {
            this.intentCandidates = intentCandidates;
        }

        public List<LexicalAnalysisBean> getLexicalAnalysis() {
            return lexicalAnalysis;
        }

        public void setLexicalAnalysis(List<LexicalAnalysisBean> lexicalAnalysis) {
            this.lexicalAnalysis = lexicalAnalysis;
        }

        public static class SentimentAnalysisBean {
            /**
             * label : 1
             * pval : 0.949687
             */

            @JSONField(name = "label")
            private int label;
            @JSONField(name = "pval")
            private double pval;

            public int getLabel() {
                return label;
            }

            public void setLabel(int label) {
                this.label = label;
            }

            public double getPval() {
                return pval;
            }

            public void setPval(double pval) {
                this.pval = pval;
            }
        }

        public static class IntentCandidatesBean {
            /**
             * extra_info : null
             * from_who : smart_qu
             * func_slot :
             * intent : OPEN_PAGE
             * intent_confidence : 100
             * intent_need_clarify : false
             * match_info : 打开[D:user_pagename]
             * slots : [{"confidence":100,"length":8,"need_clarify":false,"normalized_word":"财务","offset":4,
             * "original_word":"财务管理","type":"user_pagename","word_type":""}]
             */

            @JSONField(name = "extra_info")
            private Object extraInfo;
            @JSONField(name = "from_who")
            private String fromWho;
            @JSONField(name = "func_slot")
            private String funcSlot;
            @JSONField(name = "intent")
            private String intent;
            @JSONField(name = "intent_confidence")
            private int intentConfidence;
            @JSONField(name = "intent_need_clarify")
            private boolean intentNeedClarify;
            @JSONField(name = "match_info")
            private String matchInfo;
            @JSONField(name = "slots")
            private List<SlotsBean> slots;

            public Object getExtraInfo() {
                return extraInfo;
            }

            public void setExtraInfo(Object extraInfo) {
                this.extraInfo = extraInfo;
            }

            public String getFromWho() {
                return fromWho;
            }

            public void setFromWho(String fromWho) {
                this.fromWho = fromWho;
            }

            public String getFuncSlot() {
                return funcSlot;
            }

            public void setFuncSlot(String funcSlot) {
                this.funcSlot = funcSlot;
            }

            public String getIntent() {
                return intent;
            }

            public void setIntent(String intent) {
                this.intent = intent;
            }

            public int getIntentConfidence() {
                return intentConfidence;
            }

            public void setIntentConfidence(int intentConfidence) {
                this.intentConfidence = intentConfidence;
            }

            public boolean isIntentNeedClarify() {
                return intentNeedClarify;
            }

            public void setIntentNeedClarify(boolean intentNeedClarify) {
                this.intentNeedClarify = intentNeedClarify;
            }

            public String getMatchInfo() {
                return matchInfo;
            }

            public void setMatchInfo(String matchInfo) {
                this.matchInfo = matchInfo;
            }

            public List<SlotsBean> getSlots() {
                return slots;
            }

            public void setSlots(List<SlotsBean> slots) {
                this.slots = slots;
            }

            public static class SlotsBean {
                /**
                 * confidence : 100
                 * length : 8
                 * need_clarify : false
                 * normalized_word : 财务
                 * offset : 4
                 * original_word : 财务管理
                 * type : user_pagename
                 * word_type :
                 */

                @JSONField(name = "confidence")
                private int confidence;
                @JSONField(name = "length")
                private int length;
                @JSONField(name = "need_clarify")
                private boolean needClarify;
                @JSONField(name = "normalized_word")
                private String normalizedWord;
                @JSONField(name = "offset")
                private int offset;
                @JSONField(name = "original_word")
                private String originalWord;
                @JSONField(name = "type")
                private String type;
                @JSONField(name = "word_type")
                private String wordType;

                public int getConfidence() {
                    return confidence;
                }

                public void setConfidence(int confidence) {
                    this.confidence = confidence;
                }

                public int getLength() {
                    return length;
                }

                public void setLength(int length) {
                    this.length = length;
                }

                public boolean isNeedClarify() {
                    return needClarify;
                }

                public void setNeedClarify(boolean needClarify) {
                    this.needClarify = needClarify;
                }

                public String getNormalizedWord() {
                    return normalizedWord;
                }

                public void setNormalizedWord(String normalizedWord) {
                    this.normalizedWord = normalizedWord;
                }

                public int getOffset() {
                    return offset;
                }

                public void setOffset(int offset) {
                    this.offset = offset;
                }

                public String getOriginalWord() {
                    return originalWord;
                }

                public void setOriginalWord(String originalWord) {
                    this.originalWord = originalWord;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getWordType() {
                    return wordType;
                }

                public void setWordType(String wordType) {
                    this.wordType = wordType;
                }
            }
        }

        public static class LexicalAnalysisBean {
            /**
             * basic_word : ["打开"]
             * term : 打开
             * type : 37
             * weight : 0.38766032457352
             */

            @JSONField(name = "term")
            private String term;
            @JSONField(name = "type")
            private String type;
            @JSONField(name = "weight")
            private double weight;
            @JSONField(name = "basic_word")
            private List<String> basicWord;

            public String getTerm() {
                return term;
            }

            public void setTerm(String term) {
                this.term = term;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public double getWeight() {
                return weight;
            }

            public void setWeight(double weight) {
                this.weight = weight;
            }

            public List<String> getBasicWord() {
                return basicWord;
            }

            public void setBasicWord(List<String> basicWord) {
                this.basicWord = basicWord;
            }
        }
    }

    public static class SchemaBean {
        /**
         * bot_merged_slots : [{"begin":0,"confidence":0,"length":0,"merge_method":"update","normalized_word":"财务",
         * "original_word":"财务管理","session_offset":0,"type":"user_pagename","word_type":""}]
         * current_qu_intent : OPEN_PAGE
         * intent_confidence : 100
         */

        @JSONField(name = "current_qu_intent")
        private String currentQuIntent;
        @JSONField(name = "intent_confidence")
        private int intentConfidence;
        @JSONField(name = "bot_merged_slots")
        private List<BotMergedSlotsBean> botMergedSlots;

        public String getCurrentQuIntent() {
            return currentQuIntent;
        }

        public void setCurrentQuIntent(String currentQuIntent) {
            this.currentQuIntent = currentQuIntent;
        }

        public int getIntentConfidence() {
            return intentConfidence;
        }

        public void setIntentConfidence(int intentConfidence) {
            this.intentConfidence = intentConfidence;
        }

        public List<BotMergedSlotsBean> getBotMergedSlots() {
            return botMergedSlots;
        }

        public void setBotMergedSlots(List<BotMergedSlotsBean> botMergedSlots) {
            this.botMergedSlots = botMergedSlots;
        }

        public static class BotMergedSlotsBean {
            /**
             * begin : 0
             * confidence : 0
             * length : 0
             * merge_method : update
             * normalized_word : 财务
             * original_word : 财务管理
             * session_offset : 0
             * type : user_pagename
             * word_type :
             */

            @JSONField(name = "begin")
            private int begin;
            @JSONField(name = "confidence")
            private int confidence;
            @JSONField(name = "length")
            private int length;
            @JSONField(name = "merge_method")
            private String mergeMethod;
            @JSONField(name = "normalized_word")
            private String normalizedWord;
            @JSONField(name = "original_word")
            private String originalWord;
            @JSONField(name = "session_offset")
            private int sessionOffset;
            @JSONField(name = "type")
            private String type;
            @JSONField(name = "word_type")
            private String wordType;

            public int getBegin() {
                return begin;
            }

            public void setBegin(int begin) {
                this.begin = begin;
            }

            public int getConfidence() {
                return confidence;
            }

            public void setConfidence(int confidence) {
                this.confidence = confidence;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public String getMergeMethod() {
                return mergeMethod;
            }

            public void setMergeMethod(String mergeMethod) {
                this.mergeMethod = mergeMethod;
            }

            public String getNormalizedWord() {
                return normalizedWord;
            }

            public void setNormalizedWord(String normalizedWord) {
                this.normalizedWord = normalizedWord;
            }

            public String getOriginalWord() {
                return originalWord;
            }

            public void setOriginalWord(String originalWord) {
                this.originalWord = originalWord;
            }

            public int getSessionOffset() {
                return sessionOffset;
            }

            public void setSessionOffset(int sessionOffset) {
                this.sessionOffset = sessionOffset;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getWordType() {
                return wordType;
            }

            public void setWordType(String wordType) {
                this.wordType = wordType;
            }
        }
    }

    public static class ActionListBean {
        /**
         * action_id : open_page_satisfy
         * action_type : {"act_target":"","act_target_detail":"","act_type":"satisfy","act_type_detail":""}
         * arg_list : []
         * code_actions : []
         * confidence : 1
         * exe_status : []
         * hint_list : []
         * main_exe : exe_open_page
         * say :
         */

        @JSONField(name = "action_id")
        private String actionId;
        @JSONField(name = "action_type")
        private ActionTypeBean actionType;
        @JSONField(name = "confidence")
        private int confidence;
        @JSONField(name = "main_exe")
        private String mainExe;
        @JSONField(name = "say")
        private String say;
        @JSONField(name = "arg_list")
        private List<?> argList;
        @JSONField(name = "code_actions")
        private List<?> codeActions;
        @JSONField(name = "exe_status")
        private List<?> exeStatus;
        @JSONField(name = "hint_list")
        private List<?> hintList;

        public String getActionId() {
            return actionId;
        }

        public void setActionId(String actionId) {
            this.actionId = actionId;
        }

        public ActionTypeBean getActionType() {
            return actionType;
        }

        public void setActionType(ActionTypeBean actionType) {
            this.actionType = actionType;
        }

        public int getConfidence() {
            return confidence;
        }

        public void setConfidence(int confidence) {
            this.confidence = confidence;
        }

        public String getMainExe() {
            return mainExe;
        }

        public void setMainExe(String mainExe) {
            this.mainExe = mainExe;
        }

        public String getSay() {
            return say;
        }

        public void setSay(String say) {
            this.say = say;
        }

        public List<?> getArgList() {
            return argList;
        }

        public void setArgList(List<?> argList) {
            this.argList = argList;
        }

        public List<?> getCodeActions() {
            return codeActions;
        }

        public void setCodeActions(List<?> codeActions) {
            this.codeActions = codeActions;
        }

        public List<?> getExeStatus() {
            return exeStatus;
        }

        public void setExeStatus(List<?> exeStatus) {
            this.exeStatus = exeStatus;
        }

        public List<?> getHintList() {
            return hintList;
        }

        public void setHintList(List<?> hintList) {
            this.hintList = hintList;
        }

        public static class ActionTypeBean {
            /**
             * act_target :
             * act_target_detail :
             * act_type : satisfy
             * act_type_detail :
             */

            @JSONField(name = "act_target")
            private String actTarget;
            @JSONField(name = "act_target_detail")
            private String actTargetDetail;
            @JSONField(name = "act_type")
            private String actType;
            @JSONField(name = "act_type_detail")
            private String actTypeDetail;

            public String getActTarget() {
                return actTarget;
            }

            public void setActTarget(String actTarget) {
                this.actTarget = actTarget;
            }

            public String getActTargetDetail() {
                return actTargetDetail;
            }

            public void setActTargetDetail(String actTargetDetail) {
                this.actTargetDetail = actTargetDetail;
            }

            public String getActType() {
                return actType;
            }

            public void setActType(String actType) {
                this.actType = actType;
            }

            public String getActTypeDetail() {
                return actTypeDetail;
            }

            public void setActTypeDetail(String actTypeDetail) {
                this.actTypeDetail = actTypeDetail;
            }
        }
    }
}



