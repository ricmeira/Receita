package meira.ricardo.br.receitaandroid.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import meira.ricardo.br.receitaandroid.Constants;
import meira.ricardo.br.receitaandroid.R;
import meira.ricardo.br.receitaandroid.Utils.PreferencesManager;
import meira.ricardo.br.receitaandroid.model.Data;
import meira.ricardo.br.receitaandroid.model.User;
import meira.ricardo.br.receitaandroid.services.RetrofitInterface;
import meira.ricardo.br.receitaandroid.services.RetrofitSingleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button executeLogin;
    EditText password,email;
    PreferencesManager prefM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        password =  (EditText)findViewById(R.id.password);
        email =  (EditText)findViewById(R.id.email);

        prefM = new PreferencesManager(this);

        executeLogin =  (Button)findViewById(R.id.email_sign_in_button);
        executeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeLogin(createUserLogin());
            }
        });
    }

    public User createUserLogin(){
        return new User(password.getText().toString(),email.getText().toString());
    }

    public void executeLogin(User userLogin){
        RetrofitInterface jsonPost = RetrofitSingleton.getInstance().getRetrofitInterface();

        Call<Data> call = jsonPost.executeLogin(userLogin);

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

                if (response.code() == 200){
                    for(int i=0;i<response.headers().size();i++){
                        Log.d("resposta",response.headers().name(i));
                        Log.d("resposta2",response.headers().get(response.headers().name(i)));
                    }

                    prefM.setLoginExecuted(response.body().getData().getId());

                    Intent intent = new Intent(LoginActivity.this,ItemsActivity.class);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(LoginActivity.this,"Credencias nao autorizadas",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
