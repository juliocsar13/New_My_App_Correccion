package app.product.demarktec.new_my_app_correccion.RecoverPassword;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import app.product.demarktec.akitaxi_usuario.Config;
import app.product.demarktec.akitaxi_usuario.OkHttpRequest;
import app.product.demarktec.akitaxi_usuario.Validation;

/**
 * Created by lenovo on 19/06/2015.
 */
public class RecoverPasswordInteractorImpl implements RecoverPasswordInteractor{



    OkHttpRequest request = new OkHttpRequest(Config.GETPASSWORD);
    @Override
    public void sendPhone(final JSONObject jsonObject, Validation validator,final OnRecoverPasswordFinishedListener listener) {
        if(validator.isOnline()){

            boolean error=false;

            try {
                if (TextUtils.isEmpty(jsonObject.getString("phone"))){
                    error =true;
                    listener.onEmptyEmailError();
                }
            }catch (JSONException e){
                Log.e("JSONException", e.toString());
            }

            if(!error) {
                try {
                    request.post(jsonObject.toString(), new Callback() {
                        @Override
                        public void onFailure(Request request, IOException e) {

                            new android.os.Handler(Looper.getMainLooper()).post(new Runnable() {

                                @Override
                                public void run() {
                                    listener.onError();
                                }
                            });

                        }

                        @Override
                        public void onResponse(Response response) throws IOException {
                            final int code = response.code();

                            Log.i("SP_Code", "" + code);

                            new android.os.Handler(Looper.getMainLooper()).post(new Runnable() {

                                @Override
                                public void run() {
                                    if (code == 200)
                                        try {

                                            Log.i("SP_phone",jsonObject.getString("email"));
                                            listener.onSuccessSend(jsonObject.getString("email"));

                                        } catch (JSONException e) {
                                            Log.e("JSONException", e.toString());
                                        }
                                    else if (code == 500)
                                        listener.onEmailError();
                                    else if (code == 503)
                                        listener.onFailedSend();
                                    else
                                        listener.onFailedSend();
                                }
                            });
                        }
                    });
                } catch (IOException e) {
                    Log.e("SP_IOException", e.toString());
                }
            }
        }
        else
            listener.onInternetError();
    }

}
