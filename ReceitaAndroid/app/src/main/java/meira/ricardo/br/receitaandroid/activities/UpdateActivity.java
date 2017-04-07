package meira.ricardo.br.receitaandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import meira.ricardo.br.receitaandroid.R;
import meira.ricardo.br.receitaandroid.model.Item;

public class UpdateActivity extends AppCompatActivity {

    EditText name,type,value;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_form);

        name =  (EditText)findViewById(R.id.item_name);
        type =  (EditText)findViewById(R.id.item_type);
        value =  (EditText)findViewById(R.id.item_value);

        if(getIntent().hasExtra("item")){
            Gson gson = new Gson();
            Item item = gson.fromJson(getIntent().getStringExtra("item"),Item.class);
            name.setText(item.getName());
            type.setText(item.getItemType());
            value.setText(item.getValue() );
        }

        submit =  (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateItem();
            }
        });
    }

    public void updateItem(){

    }

    public void deleteItem(){

    }
}
