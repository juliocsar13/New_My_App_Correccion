package app.product.demarktec.new_my_app_correccion.RecoverPassword;

import org.json.JSONObject;

import app.product.demarktec.akitaxi_usuario.Validation;

/**
 * Created by lenovo on 19/06/2015.
 */
public interface RecoverPasswordInteractor {

    public void sendPhone(JSONObject jsonObject, Validation validator, OnRecoverPasswordFinishedListener listener);
}
