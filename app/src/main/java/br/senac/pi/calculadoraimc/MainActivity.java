package br.senac.pi.calculadoraimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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

                txtResultado.setText(getResources().getString(R.string.txt_resultado) + " " + decimal.format(IMC));

                String situacao = "";


                if(IMC <= 18.5){
                    situacao = getResources().getString(R.string.abaixo_peso);
                } else if(IMC <= 24.9){
                    situacao = getResources().getString(R.string.peso_ideal);
                } else if(IMC <= 29.9){
                    situacao = getResources().getString(R.string.acima_peso);
                } else if(IMC <= 34.9){
                    situacao = getResources().getString(R.string.obesidade_I);
                } else if(IMC <= 39.9){
                    situacao = getResources().getString(R.string.obesidade_II);
                } else {
                    situacao = getResources().getString(R.string.obesidade_III);
                }

                txtSituacao.setText(situacao);
            }
        };
    }
}
