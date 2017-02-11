package com.tecpro.peluqueria.profile.presenters;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.tecpro.peluqueria.profile.dto.User;
import com.tecpro.peluqueria.profile.models.UserModel;
import com.tecpro.peluqueria.profile.views.MyProfileView;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nico on 1/14/17.
 */

public class MyProfilePresenter extends MvpBasePresenter<MyProfileView> {

    private Subscription mSubcription;
    private UserModel mUserModel;

    @Override
    public void attachView(MyProfileView view) {
        super.attachView(view);
        if (mUserModel == null) {
            mUserModel = new UserModel();
        }

    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance) {
            cancelSubscription();
        }
    }

    public void getUserProfile(String id, final boolean pullToRefresh) {
        if (isViewAttached() && !pullToRefresh) {
            getView().showLoading();
        }


        // Kind of "callback"
        cancelSubscription();

        mSubcription = mUserModel.getUser(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        getView().showError();
                    }

                    @Override
                    public void onNext(User user) {

                        getView().showData(user);
                    }
                });

    }

    /**
     * Cancels any previous callback
     */
    private void cancelSubscription() {
        if (mSubcription != null && !mSubcription.isUnsubscribed()) {
            mSubcription.unsubscribe();
        }
    }
}
