package com.tecpro.peluqueria.commons;

import android.os.Bundle;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

/**
 * Created by nico on 1/15/17.
 */

public class AbstractViewState<V extends MvpViewTP> implements RestorableViewState<V> {

    private final String KEY_STATE =
            " com.tecpro.peluqueria.commons.AbstractViewState.current_State";
    final int STATE_SHOW_REGULAR = 0;
    final int STATE_SHOW_LOADING = 1;
    final int STATE_SHOW_ERROR = 2;
    private int currentState = 0;

    int state = STATE_SHOW_REGULAR;

    public void setShowRegular() {
        state = STATE_SHOW_REGULAR;
    }

    public void setShowError() {
        state = STATE_SHOW_ERROR;
    }

    public void setShowLoading() {
        state = STATE_SHOW_LOADING;
    }

    @Override
    public void saveInstanceState(Bundle out) {
        out.putInt(KEY_STATE, currentState);
    }

    @Override public RestorableViewState<V> restoreInstanceState(Bundle in) {
        currentState = in.getInt(KEY_STATE);
        return this;
    }

    /**
     * Is called from Mosby to apply the view state to the view.
     * We do that by calling the methods from the View interface (like the presenter does)
     */
    @Override
    public void apply(V view, boolean retained) {

        switch (state) {
            case STATE_SHOW_LOADING:
                view.showLoading();
                break;

            case STATE_SHOW_ERROR:
                view.showError();
                break;

            case STATE_SHOW_REGULAR:
                view.showRegular();
                break;
        }
    }

}
