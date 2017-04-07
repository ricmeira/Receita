package meira.ricardo.br.receitaandroid.Utils;

import com.google.gson.Gson;

public class JsonUtils {

    static public String toJson(Object obj){
        Gson gson = new Gson();
        String jsonLogin = gson.toJson(obj);
        return jsonLogin;
    }

}
