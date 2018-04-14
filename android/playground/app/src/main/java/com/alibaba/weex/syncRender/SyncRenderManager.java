package com.alibaba.weex.syncRender;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;


/**
 * Created by linxu on 2018/4/2.
 */

public class SyncRenderManager {
    static String testJson = "[{\n" +
            "\t\t\"createBody\": {\n" +
            "\t\t\t\"args\": [{\n" +
            "\t\t\t\t\"attr\": {\n" +
            "\t\t\t\t\t\"@styleScope \": \"data - v - 31 a35641\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"ref\": \"_root\",\n" +
            "\t\t\t\t\"type\": \"div\"\n" +
            "\t\t\t}]\n" +
            "\t\t}\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"addElement\": [{\n" +
            "\t\t\t\t\"ref\": \"_root\",\n" +
            "\t\t\t\t\"dom\": {\n" +
            "\t\t\t\t\t\"attr\": {\n" +
            "\t\t\t\t\t\t\"@styleScope\": \"data-v-31a35641\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"ref\": \"63\",\n" +
            "\t\t\t\t\t\"style\": {\n" +
            "\t\t\t\t\t\t\"backgroundColor\": \"#EEEEEE\",\n" +
            "\t\t\t\t\t\t\"borderColor\": \"#BBBBBB\",\n" +
            "\t\t\t\t\t\t\"borderStyle\": \"solid\",\n" +
            "\t\t\t\t\t\t\"borderWidth\": \"2\",\n" +
            "\t\t\t\t\t\t\"height\": \"250\",\n" +
            "\t\t\t\t\t\t\"marginLeft\": \"250\",\n" +
            "\t\t\t\t\t\t\"marginTop\": \"250\",\n" +
            "\t\t\t\t\t\t\"width\": \"250\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"type\": \"div\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"ref\": \"63\",\n" +
            "\t\t\t\t\"dom\": {\n" +
            "\t\t\t\t\t\"attr\": {\n" +
            "\t\t\t\t\t\t\"@styleScope\": \"data-v-31a35641\"\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"ref\": \"65\",\n" +
            "\t\t\t\t\t\"type\": \"text\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t]\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"updateAttrs\": {\n" +
            "\t\t\t\"args\": [\"65\", {\n" +
            "\t\t\t\t\"value\": \" aaaa\"\n" +
            "\t\t\t}],\n" +
            "\t\t\t\"method\": \"updateAttrs\",\n" +
            "\t\t\t\"module\": \"dom\"\n" +
            "\t\t}\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"createFinish\": {\n" +
            "\t\t\t\"args\": []\n" +
            "\t\t}\n" +
            "\t}\n" +
            "]";

    public static SyncRenderObject createInstance(Context context){
        JSONArray rules = null;
        try {
            rules = JSON.parseArray(testJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new SyncRenderObject(context, rules, null);
    }
}
