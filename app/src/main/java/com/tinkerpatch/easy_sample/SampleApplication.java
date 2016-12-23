/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Shengjie Sim Sun
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.tinkerpatch.easy_sample;


import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;

public class SampleApplication extends Application {
    private static final String TAG = "Tinker.SampleApplication";

    public SampleApplication() {

    }

    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //you must install multiDex whatever tinker is installed!
        MultiDex.install(base);

        //开始检查是否有补丁，这里配置的是每隔访问3小时服务器是否有更新。
        TinkerPatch.init(TinkerPatchApplicationLike.getTinkerPatchApplicationLike())
            .reflectPatchLibrary()
            .setPatchRollbackOnScreenOff(true)
            .setPatchRestartOnSrceenOff(true);
    }
}
