package com.alibaba.weex.syncRender;

import android.view.View;


/**
 * Created by linxu on 2018/4/3.
 */

public class EventHandler {
    private View.OnClickListener clickListener;

    public void setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public View.OnClickListener getClickListener() {
        return clickListener;
    }
}
