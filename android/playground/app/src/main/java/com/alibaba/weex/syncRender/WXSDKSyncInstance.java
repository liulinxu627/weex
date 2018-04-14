package com.alibaba.weex.syncRender;

import android.content.Context;
import android.view.View;

import com.taobao.weex.WXSDKInstance;

import java.util.List;
import java.util.Map;

/**
 * Created by linxu on 2018/4/3.
 */

public class WXSDKSyncInstance extends WXSDKInstance {
    private EventHandler mEventHandler;
    public WXSDKSyncInstance(Context context) {
        super(context);
        mEventHandler = new EventHandler();
        mEventHandler.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == null) {

                }
            }
        });
    }

    @Override
    public void fireEvent(String elementRef,final String type, final Map<String, Object> data,final Map<String, Object> domChanges){
        mEventHandler.getClickListener().onClick(null);
    }
}
