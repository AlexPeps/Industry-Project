package com.example.IndustryProject;

public interface OnProgressViewListener {
    public void onFinish();

    public void onProgressUpdate(float progress);

    void setProgress(float prog);

    int getprogress();
}
