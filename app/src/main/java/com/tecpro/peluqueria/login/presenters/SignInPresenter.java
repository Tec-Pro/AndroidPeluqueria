package com.tecpro.peluqueria.login.presenters;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.tecpro.peluqueria.login.models.LoginModel;
import com.tecpro.peluqueria.login.views.SignInView;
import com.tecpro.peluqueria.profile.dto.User;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nico on 1/14/17.
 */

public class SignInPresenter extends MvpBasePresenter<SignInView> {

    private Subscription mSubcription;
    private LoginModel mLoginModel;

    @Override
    public void attachView(SignInView view) {
        super.attachView(view);
        if (mLoginModel == null) {
            mLoginModel = new LoginModel();
        }

    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance) {
            cancelSubscription();
        }
    }

    public void signin() {
        final String username = getView().getUsername();
        final String password = getView().getPassword();
        getView().showLoading();
        //debo validar campos

        //
        final User user = new User.Builder().withName(username).withPass(password).build();
        cancelSubscription();

        mSubcription = mLoginModel.signin(user)
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
                        System.out.println(user);
                        getView().showRegular();
                        getView().goToHome();
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
