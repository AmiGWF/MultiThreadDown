package com.wudu.downlibrary.architecture;

/**
 * author : wudu
 * time : 2016/10/19
 */
public interface Downloader {

    interface OnDownloaderDestroyedListener {
        void onDestroyed(String key, Downloader downloader);
    }

    boolean isRunning();

    void start();

    void pause();

    void cancel();

    void onDestroy();

}
