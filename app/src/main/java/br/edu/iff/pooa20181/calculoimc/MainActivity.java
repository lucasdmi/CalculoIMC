package br.edu.iff.pooa20181.calculoimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtPeso;
    private EditText edtAltura;
    private Button btCalcular;
    private TextView tMensagem;

    private float valorIMC;
    private float peso;
    private float altura;
    private String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtPeso = (EditText) findViewById(R.id.edtPeso);
        edtAltura = (EditText) findViewById(R.id.edtAltura);

        btCalcular = (Button) findViewById(R.id.btCalcIMC);

        tMensagem = (TextView) findViewById(R.id.tMensagem);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();

                resultado = Float.toString(valorIMC);
                if (valorIMC < 17){
                    tMensagem.setText("Muito Abaixo do Peso" );

                }else{
                    if((valorIMC > 17) && (valorIMC < 18.49)){
                        tMensagem.setText("Abaixo do Peso " );

                    }
                    else{
                        if((valorIMC > 18.5)&&(valorIMC < 24.99)){
                            tMensagem.setText("Peso Normal " );

                        }
                        else{
                            if((valorIMC > 25)&&(valorIMC < 29.99)){
                                tMensagem.setText("Acima do peso: " );

                            }
                            else{
                                if((valorIMC > 30)&& (valorIMC < 34.99)){
                                    tMensagem.setText("Obesidade I " );

                                }
                                else{
                                    if((valorIMC > 35)&&(valorIMC < 39.99)){
                                        tMensagem.setText("Obesidade II" );

                                    }
                                    else{
                                        tMensagem.setText("Obesidade III " );

                                    }
                                }
                            }
                        }
                    }
                }

            }
        });



    }

    public void calcular(){

     peso = Float.parseFloat(edtPeso.getText().toString());
     altura = Float.parseFloat(edtAltura.getText().toString());
     valorIMC = peso / (altura * altura);

    }
}
