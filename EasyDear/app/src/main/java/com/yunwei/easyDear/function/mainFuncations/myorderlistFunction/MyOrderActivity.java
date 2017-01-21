package com.yunwei.easyDear.function.mainFuncations.myorderlistFunction;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.yunwei.easyDear.R;
import com.yunwei.easyDear.base.BaseActivity;
import com.yunwei.easyDear.base.DataApplication;
import com.yunwei.easyDear.common.dialog.ToastUtil;
import com.yunwei.easyDear.function.mainFuncations.myorderlistFunction.data.OrderEntity;
import com.yunwei.easyDear.view.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by LJH on 2017/1/15.
 */

public class MyOrderActivity extends BaseActivity implements OrderContract.OrderView, PullToRefreshRecyclerView.PullToRefreshRecyclerViewListener {

    private final String TAG = this.getClass().getSimpleName();

    private int defalutPageSize = 1;
    @BindView(R.id.myorder_recyclerView)
    PullToRefreshRecyclerView mRecyclerView;

    private MyOrderAdapter adapter;

    private OrderPresent orderPresent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_myorder);
        setToolbarTitle("我的订单");
        ButterKnife.bind(this);
        orderPresent = new OrderPresent(this);
        initRecyclerView();
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        adapter = new MyOrderAdapter(this);

        mRecyclerView.setRecyclerViewAdapter(adapter);
        mRecyclerView.setPullToRefreshListener(this);
        mRecyclerView.setMode(PullToRefreshRecyclerView.Mode.BOTH);
        mRecyclerView.startUpRefresh();
    }

    @Override
    public void onDownRefresh() {
        defalutPageSize = 1;
        orderPresent.reqOrderList();
    }

    @Override
    public void onPullRefresh() {
        defalutPageSize++;
        orderPresent.reqOrderList();
    }

    @Override
    public void onStartOrder() {

    }

    @Override
    public void onEndOrder() {
        mRecyclerView.closeDownRefresh();
        mRecyclerView.onLoadMoreFinish();
    }

    @Override
    public void onOrderSuccess(List<OrderEntity> list) {
        adapter.addItems(list);
    }

    @Override
    public void onOrderFailure(String error) {
        ToastUtil.showToast(this, error);
    }

    @Override
    public String getUserNo() {
        return DataApplication.getInstance().getUserInfoEntity().getUserNo();
    }

    @Override
    public int getPageSize() {
        return defalutPageSize;
    }

    @Override
    public int getPageCount() {
        return 20;
    }
}
