package meira.ricardo.br.receitaandroid.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import meira.ricardo.br.receitaandroid.R;
import meira.ricardo.br.receitaandroid.Utils.JsonUtils;
import meira.ricardo.br.receitaandroid.Utils.PreferencesManager;
import meira.ricardo.br.receitaandroid.model.Data;
import meira.ricardo.br.receitaandroid.model.Item;
import meira.ricardo.br.receitaandroid.services.RetrofitInterface;
import meira.ricardo.br.receitaandroid.services.RetrofitSingleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemsActivity extends AppCompatActivity {

    ListView list;
    private ArrayList<Item> listValues;
    ArrayAdapter<Item> adapter;
    PreferencesManager prefM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        prefM = new PreferencesManager(this);

        list = (ListView) findViewById(R.id.list_items);

        //Pega os valores da API, feita no ONCreate para nao haver repeticao de requisicao
        listValues = new ArrayList<>();
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listValues);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ItemsActivity.this,UpdateActivity.class);
                intent.putExtra("item", JsonUtils.toJson(listValues.get(position)));
                startActivity(intent);
            }
        });

        getList();
    }

    public void getList(){
        RetrofitInterface jsonPost = RetrofitSingleton.getInstance().getRetrofitInterface();

        Call<ArrayList<Item>> call = jsonPost.getListItems(prefM.getUserId());

        call.enqueue(new Callback<ArrayList<Item>>() {
            @Override
            public void onResponse(Call<ArrayList<Item>> call, Response<ArrayList<Item>> response) {
                if(response.code() == 200){
                    listValues.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Item>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


}
