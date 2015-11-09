package br.senac.pi.calculadoraimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView txtResultado;
    private TextView txtSituacao;
    private EditText edtPeso;
    private EditText edtAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnCalcular).setOnClickListener(calcularIMC());

        txtResultado = (TextView) findViewById(R.id.txtResultado);
        txtSituacao = (TextView) findViewById(R.id.txtSituacao);
        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtAltura = (EditText) findViewById(R.id.edtAltura);
    }

    private View.OnClickListener calcularIMC(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                NumberFormat decimal = new DecimalFormat(".#");

                double peso = Double.parseDouble(edtPeso.getText().toString());
                double altura = Double.parseDouble(edtAltura.getText().toString());

                double IMC = peso / (altura * altura);

                txtResultado.setText(getString(R.string.txt_resultado) + " " + decimal.format(IMC));

                String situacao = "";
                String toast = "";

                if(IMC <= 18.5){
                    situacao = getString(R.string.abaixo_peso);
                    toast = getString(R.string.toast_anormal);
                } else if(IMC <= 24.9){
                    situacao = getString(R.string.peso_ideal);
                    toast = getString(R.string.toast_ideal);
                } else if(IMC <= 29.9){
                    situacao = getString(R.string.acima_peso);
                    toast = getString(R.string.toast_anormal);
                } else if(IMC <= 34.9){
                    situacao = getString(R.string.obesidade_I);
                    toast = getString(R.string.toast_anormal);
                } else if(IMC <= 39.9){
                    situacao = getString(R.string.obesidade_II);
                    toast = getString(R.string.toast_anormal);
                } else {
                    situacao = getString(R.string.obesidade_III);
                    toast = getString(R.string.toast_anormal);
                }

                txtSituacao.setText(situacao);
                Toast.makeText(MainActivity.this, toast, Toast.LENGTH_LONG).show();
            }
        };
    }
}
