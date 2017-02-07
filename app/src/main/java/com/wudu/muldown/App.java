package com.wudu.muldown;

import android.app.Application;
import android.content.Context;

import com.wudu.downlibrary.DownloadConfiguration;
import com.wudu.downlibrary.DownloadManager;


/**
 * author : wudu
 * time : 2016/10/19
 */
public class App extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        initDownloader();
        CrashHandler.getInstance(sContext);
    }

    private void initDownloader() {
        DownloadConfiguration configuration = new DownloadConfiguration();
        configuration.setMaxThreadNum(10);
        configuration.setThreadNum(3);
        DownloadManager.getInstance().init(getApplicationContext(), configuration);
    }

    public static Context getContext() {
        return sContext;
    }


}
