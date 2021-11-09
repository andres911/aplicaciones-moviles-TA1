package facci.andresmendoza.primera_aplicacion;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView respuesta_c, respuesta_f;
    private EditText valor_c, valor_f;
    private Button button_c, button_f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("MainActivity", "Andres Gonzalo Mendoza Parraga");
        setContentView(R.layout.activity_main);
        String language = Locale.getDefault().getLanguage();
        if(language=="es") {
            setContentView(R.layout.activity_main);
        }else{
            if(language=="en"){
                setContentView(R.layout.activity_main_ingles);
            }
        }

        respuesta_c=(TextView) findViewById(R.id.respuesta_c);
        valor_c=(EditText) findViewById(R.id.valor_c);
        findViewById(R.id.button_c).setOnClickListener(this);
        respuesta_f=(TextView) findViewById(R.id.respuesta_f);
        valor_f=(EditText) findViewById(R.id.valor_f);
        findViewById(R.id.button_f).setOnClickListener(this);

    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_c:
                convertir_centigrado();
                break;
            case R.id.button_f:
                convertir_faren();
                break;
        }
    }

    public void convertir_centigrado(){
        Double valor, respuesta_centigrado = null;
        valor = Double.parseDouble(valor_c.getText().toString());
        respuesta_centigrado = (valor*1.8)+(32);
        respuesta_c.setText(respuesta_centigrado.toString());
    }

    public void convertir_faren(){
        Double valor, respuesta_fare = null;
        valor = Double.parseDouble(valor_f.getText().toString());
        respuesta_fare = (valor-32)/(1.8);
        respuesta_f.setText(respuesta_fare.toString());
    }
}