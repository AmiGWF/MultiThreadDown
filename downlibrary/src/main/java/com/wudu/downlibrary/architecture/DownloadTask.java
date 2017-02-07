package com.wudu.downlibrary.architecture;


import com.wudu.downlibrary.DownloadException;

/**
 * author : wudu
 * time : 2016/10/19
 */
public interface DownloadTask extends Runnable {

    interface OnDownloadListener {
        void onDownloadConnecting();

        void onDownloadProgress(long finished, long length);

        void onDownloadCompleted();

        void onDownloadPaused();

        void onDownloadCanceled();

        void onDownloadFailed(DownloadException de);
    }

    void cancel();

    void pause();

    boolean isDownloading();

    boolean isComplete();

    boolean isPaused();

    boolean isCanceled();

    boolean isFailed();

    @Override
    void run();
}
