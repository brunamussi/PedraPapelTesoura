package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.Random;

import static java.lang.Integer.bitCount;
import static java.lang.Integer.getInteger;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class MainActivity extends AppCompatActivity {

    int pontuacaoBot = 0;
    int pontuacaoPlayer = 0;
    private TextView scoreBot;
    private TextView scorePlayer;
    private TextView Resultado;
    public static int maxRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Resultado = findViewById(R.id.Resultado);
       scoreBot = findViewById(R.id.scoreBot);
       scorePlayer = findViewById(R.id.scorePlayer);



    }

    public void pedraSelecionado(View view) {

        this.opcaoSelecionada("pedra");
    }

    public void papelSelecionado(View view) {

        this.opcaoSelecionada("papel");
    }

    public void tesouraSelecionado(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        int numero = new Random().nextInt(3);

        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        ImageView imageResultado = findViewById(R.id.imageResultado);

        switch (opcaoApp) {
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra2);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel2);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura2);
                break;
        }

        if ( // App ganha
                        (opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                        (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
                        (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")
        ) {
            Resultado.setText("Que pena, você perdeu!");
                    if(pontuacaoBot < maxRound){
                        pontuacaoBot = pontuacaoBot + 1;
                        scoreBot.setText(String.valueOf(pontuacaoBot));
                    };


        } else if ( //usuario ganha
                        (opcaoApp == "tesoura" && opcaoSelecionada == "pedra") ||
                        (opcaoApp == "papel" && opcaoSelecionada == "tesoura") ||
                        (opcaoApp == "pedra" && opcaoSelecionada == "papel")
        ) {
            Resultado.setText("Parabéns, você venceu!");
                    if(pontuacaoPlayer < maxRound){
                        pontuacaoPlayer = pontuacaoPlayer + 1;
                        scorePlayer.setText(String.valueOf(pontuacaoPlayer));
                    };

        } else { // empate
            Resultado.setText("Deu empate, tente novamente!");
        }
    }
     public void resetButtom (View view) {
        pontuacaoBot = 0;
        pontuacaoPlayer = 0;
        scoreBot.setText(String.valueOf(pontuacaoBot));
        scorePlayer.setText(String.valueOf(pontuacaoPlayer));
     }
}
