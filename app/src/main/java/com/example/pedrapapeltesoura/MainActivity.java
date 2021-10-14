package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pedraSelecionado (View view) {
        this.opcaoSelecionada("pedra");
    }

    public void papelSelecionado (View view) {
        this.opcaoSelecionada("papel");
    }

    public void tesouraSelecionado(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada (String opcaoSelecionada){

        int numero = new Random().nextInt(3);

        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes [numero];

        ImageView imageResultado = findViewById(R.id.imageResultado);

        switch (opcaoApp){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        TextView Resultado = findViewById(R.id.Resultado);

        if( // App ganha
                    (opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                    (opcaoApp == "papel" && opcaoSelecionada =="pedra") ||
                    (opcaoApp == "pedra" && opcaoSelecionada =="tesoura")
        ){
            Resultado.setText("Que pena, você perdeu =(");
        }
        else if ( //usuario ganha
                        (opcaoApp == "tesoura" && opcaoSelecionada == "pedra") ||
                        (opcaoApp == "papel" && opcaoSelecionada == "tesoura") ||
                        (opcaoApp == "pedra" && opcaoSelecionada == "papel")
                ){
            Resultado.setText("Parabéns, você venceu (=");

        }else { // empate
            Resultado.setText ("Deu empate, tente novamente!");
        }
    }
    }
