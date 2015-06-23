package app.product.demarktec.new_my_app_correccion.RecoverPassword;

import android.content.Context;

/**
 * Created by lenovo on 19/06/2015.
 */
public interface RecoverPasswordView {

    public Context getContext();

    public void showDialogSuccessSend();

    public void showDialogFailedSend();

    public void navigateToCode(String email);

    public void showDialogConfirmEmail();

    public void hideProgress();

    public void showProgress();

    public void showDialogInternetError();

    public void showDialogEmailError();

    public void showDialogError();

    public void finished();

    public void showDialogEmptyemail();

}
