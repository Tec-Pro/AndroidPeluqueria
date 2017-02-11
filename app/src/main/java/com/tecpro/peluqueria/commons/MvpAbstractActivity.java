package com.tecpro.peluqueria.commons;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.tecpro.peluqueria.R;
import com.tecpro.peluqueria.profile.presenters.MyProfilePresenter;
import com.tecpro.peluqueria.profile.views.MyProfileView;

/**
 * Created by nico on 1/15/17.
 */

public abstract class MvpAbstractActivity<V extends MvpViewTP, P extends MvpPresenter<V>>
        extends MvpViewStateActivity<V, P> implements MvpViewTP {

    private ViewGroup mContainer;
    private View errorView;
    private View loadingView;
    protected CoordinatorLayout coordinatorLayoutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContentView(int layoutResId) {
        setContentView(getLayoutInflater().inflate(layoutResId, null));
    }

    @Override
    public void setContentView(View view) {
        setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(R.layout.abstract_activity);
        coordinatorLayoutContainer = (CoordinatorLayout) findViewById(R.id.coordinator_layout);
        mContainer = (ViewGroup) findViewById(R.id.content_frame);

        if (params == null) {
            mContainer.addView(view);
        } else {
            mContainer.addView(view, params);
        }
        errorView = findViewById(R.id.errorView);
        loadingView = findViewById(R.id.loadingView);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override public RestorableViewState createViewState() {
        return new AbstractViewState();
    }

    @Override
    public void onNewViewStateInstance() {
        showRegular();
    }

    @Override public AbstractViewState getViewState() {
        return (AbstractViewState) super.getViewState();
    }

    @Override
    public void showRegular() {
        Log.d("REGULAR", "show regular");
        getViewState().setShowRegular();
        loadingView.setVisibility(View.GONE);
        mContainer.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);


    }

    @Override
    public void showError() {
        Log.d("ERROr", "show error");
        getViewState().setShowError();
        loadingView.setVisibility(View.GONE);
        mContainer.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        Log.d("LOADING", "show loading");
        getViewState().setShowLoading();
        loadingView.setVisibility(View.VISIBLE);
        mContainer.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);

    }
}
