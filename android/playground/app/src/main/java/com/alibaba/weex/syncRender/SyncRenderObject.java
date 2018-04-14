package com.alibaba.weex.syncRender;

import android.content.Context;
import android.view.View;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.RenderContainer;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;

import java.util.ArrayList;

/**
 * Created by linxu on 2018/4/2.
 */

public class SyncRenderObject {
    private WXSDKInstance mInstance;
    private Object mData;
    private ArrayList<JSONObject> mRule = new ArrayList<JSONObject>();
    private View container;
    public SyncRenderObject (Context context, JSONArray rules, Object data) {
        RenderContainer renderContainer = new RenderContainer(context);
        mInstance = new WXSDKSyncInstance(context);
        WXSDKManager.getInstance().createInstance(mInstance);
        mInstance.setRenderContainer(renderContainer);
        mInstance.setSyncRenderMode(true);
        mInstance.registerRenderListener(new IWXRenderListener() {
            @Override
            public void onViewCreated(WXSDKInstance instance, View view) {
                container = view;
            }

            @Override
            public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onException(WXSDKInstance instance, String errCode, String msg) {

            }
        });
        if (rules != null) {
            try {
                for (Object obj: rules) {
                    JSONObject json = (JSONObject) obj;
                    JSONObject jsonObject =  json.getJSONObject("createBody");
                    if (jsonObject != null) {
                        JSONArray array = jsonObject.getJSONArray("args");
                        WXSDKManager.getInstance().getWXDomManager().createBody(mInstance.getInstanceId(), (JSONObject) array.get(0), false);
                        continue;
                    }
                    JSONArray array =  json.getJSONArray("addElement");
                    if (array != null) {
                        for (Object object: array) {
                            String parentRef = ((JSONObject)object).getString("ref");
                            JSONObject dom = ((JSONObject)object).getJSONObject("dom");
                            WXSDKManager.getInstance().getWXDomManager().addDom(mInstance.getInstanceId(), parentRef, dom, false, -1);
                        }
                        continue;
                    }
                    JSONObject updateAttrs =  json.getJSONObject("updateAttrs");
                    if (updateAttrs != null) {
                        JSONArray args = updateAttrs.getJSONArray("args");
                        WXSDKManager.getInstance().getWXDomManager().updateAttrs(mInstance.getInstanceId(), args.getString(0), args.getJSONObject(1), false);
                        continue;
                    }
                    JSONObject createFinish =  json.getJSONObject("createFinish");
                    if (createFinish != null) {
                        WXSDKManager.getInstance().getWXDomManager().createFinish(mInstance.getInstanceId(), false);
                        break;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        WXSDKManager.getInstance().getWXDomManager().syncBatch();
    }

    public View getContainer() {
        return container;
    }

    public WXSDKInstance getInstance() {
        return mInstance;
    }
}
