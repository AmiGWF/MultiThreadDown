package com.wudu.downlibrary.architecture;


import com.wudu.downlibrary.DownloadException;

/**
 * author : wudu
 * time : 2016/10/19
 */
public interface DownloadResponse {

    void onStarted();

    void onConnecting();

    void onConnected(long time, long length, boolean acceptRanges);

    void onConnectFailed(DownloadException e);

    void onConnectCanceled();

    void onDownloadProgress(long finished, long length, int percent);

    void onDownloadCompleted();

    void onDownloadPaused();

    void onDownloadCanceled();

    void onDownloadFailed(DownloadException e);
}
