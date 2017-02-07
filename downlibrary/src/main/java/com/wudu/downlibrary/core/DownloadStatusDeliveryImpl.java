package com.wudu.downlibrary.core;

import android.os.Handler;

import com.wudu.downlibrary.CallBack;
import com.wudu.downlibrary.DownloadException;
import com.wudu.downlibrary.architecture.DownloadStatus;
import com.wudu.downlibrary.architecture.DownloadStatusDelivery;

import java.util.concurrent.Executor;

/**
 * author : wudu
 * time : 2016/10/19
 */
public class DownloadStatusDeliveryImpl implements DownloadStatusDelivery {
    private Executor mDownloadStatusPoster;

    public DownloadStatusDeliveryImpl(final Handler handler) {
        mDownloadStatusPoster = new Executor() {
            @Override
            public void execute(Runnable command) {
                handler.post(command);
            }
        };
    }

    @Override
    public void post(DownloadStatus status) {
        mDownloadStatusPoster.execute(new DownloadStatusDeliveryRunnable(status));
    }

    private static class DownloadStatusDeliveryRunnable implements Runnable {
        private final DownloadStatus mDownloadStatus;
        private final CallBack mCallBack;

        public DownloadStatusDeliveryRunnable(DownloadStatus downloadStatus) {
            this.mDownloadStatus = downloadStatus;
            this.mCallBack = mDownloadStatus.getCallBack();
        }

        @Override
        public void run() {
            switch (mDownloadStatus.getStatus()) {
                case DownloadStatus.STATUS_CONNECTING:
                    mCallBack.onConnecting();
                    break;
                case DownloadStatus.STATUS_CONNECTED:
                    mCallBack.onConnected(mDownloadStatus.getLength(), mDownloadStatus.isAcceptRanges());
                    break;
                case DownloadStatus.STATUS_PROGRESS:
                    mCallBack.onProgress(mDownloadStatus.getFinished(), mDownloadStatus.getLength(), mDownloadStatus.getPercent());
                    break;
                case DownloadStatus.STATUS_COMPLETED:
                    mCallBack.onCompleted();
                    break;
                case DownloadStatus.STATUS_PAUSED:
                    mCallBack.onDownloadPaused();
                    break;
                case DownloadStatus.STATUS_CANCELED:
                    mCallBack.onDownloadCanceled();
                    break;
                case DownloadStatus.STATUS_FAILED:
                    mCallBack.onFailed((DownloadException) mDownloadStatus.getException());
                    break;
            }
        }
    }
}
