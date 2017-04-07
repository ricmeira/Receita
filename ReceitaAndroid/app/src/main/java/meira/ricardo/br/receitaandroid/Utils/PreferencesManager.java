package meira.ricardo.br.receitaandroid.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ricardo on 06/04/17.
 */

public class PreferencesManager {
    Context context;
    SharedPreferences sPref;
    SharedPreferences.Editor editor;
    private static final String name = "receitaApp";

    public PreferencesManager(Context context){
        this.context = context;
        sPref = context.getSharedPreferences(name,0);
        editor = sPref.edit();
    }

    public void setLoginExecuted(String userId){
        editor.putBoolean("login",true);
        editor.putString("userId",userId);
        editor.commit();
    }

    public String getUserId(){
        return sPref.getString("userId", null);
    }
}
