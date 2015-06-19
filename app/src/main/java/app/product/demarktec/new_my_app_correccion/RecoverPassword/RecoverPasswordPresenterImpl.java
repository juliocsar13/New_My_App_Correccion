package app.product.demarktec.new_my_app_correccion.RecoverPassword;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import app.product.demarktec.akitaxi_usuario.Model.User;
import app.product.demarktec.akitaxi_usuario.Validation;

/**
 * Created by lenovo on 19/06/2015.
 */
public class RecoverPasswordPresenterImpl implements RecoverPasswordPresenter,OnRecoverPasswordFinishedListener{

    RecoverPasswordInteractor interactor;

    Validation validator;
    RecoverPasswordView recoverPasswordView;
    Context ctx;
    User user;
    Bundle extras;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;



    @Override
    public void onSuccessSend(String email) {

    }

    @Override
    public void onFailedSend() {

    }

    @Override
    public void onInternetError() {

    }

    @Override
    public void onEmailError() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onEmptyEmailError() {

    }

    @Override
    public void validateEmail(String email) {

    }
}
