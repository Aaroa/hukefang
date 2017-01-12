package com.yunwei.easyDear.function.mainFuncations.homeFuncation;

import com.yunwei.easyDear.function.mainFuncations.homeFuncation.data.HomeDataSource;
import com.yunwei.easyDear.function.mainFuncations.homeFuncation.data.HomeRemoteRepo;

/**
 * Created by LJH on 2017/1/4.
 */

public class HomePresenter implements HomeContract.Presenter, HomeDataSource.RequestScrollImageUrlCallBack {

    private HomeRemoteRepo mRemoteRepo;
    private HomeContract.HomeView mHomeView;

    public HomePresenter(HomeRemoteRepo homeRemoteRepo, HomeContract.HomeView homeView) {
        mRemoteRepo = homeRemoteRepo;
        mHomeView = homeView;
    }

    @Override
    public void requestScrollImageUrls() {
        mRemoteRepo.requestScrollImageUrls(this);
    }

    @Override
    public void getScrollImageUrlSuccess(String urls) {
        mHomeView.initImageUrl(urls);
    }
}