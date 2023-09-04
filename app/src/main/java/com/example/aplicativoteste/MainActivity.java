package com.example.aplicativoteste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declaracao dos elementos ids
        Button btnMensagem = findViewById(R.id.btnMensagem);
        Button btnEscreve = findViewById(R.id.btnEscreve);
        TextView txtMensagem = findViewById(R.id.txtMensagem);
        EditText fldTexto = findViewById(R.id.fldTexto);
        Button btnToast = findViewById(R.id.btnToast);
        Button btnDialog = findViewById(R.id.btnDialog);

        String Abertura = "Cria app Android com Android Studio";
        txtMensagem.setText(Abertura);
        Toast.makeText(getApplicationContext(),"abertura",Toast.LENGTH_SHORT).show();

        // botao mensagem - clicavel
        btnMensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // cria uma variavel com texto
                String Texto = "Bom dia!";
                // faz o set da variavel dentro do texto
                txtMensagem.setText(Texto);

            }
        });
      //botao captura texto e escreve na tela;
        btnEscreve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // captura o texto digitado, converte para String, deixa Maiusculo e remove espacos
                String textoEscrito = fldTexto.getText().toString().toUpperCase().trim();
                txtMensagem.setText(textoEscrito);



            }
        });
       btnToast.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String msgToast = "Notificação";
               Toast.makeText(getBaseContext(),msgToast,Toast.LENGTH_LONG).show();
           }
       });

       // botão com a ação dialog
       btnDialog.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               AlertDialog.Builder dialog = new AlertDialog.Builder(getApplicationContext());
               dialog.setMessage("Como está o clima??")
                       .setCancelable(false)
                       .setPositiveButton("chuva", new DialogInterface.OnClickListener() {

                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                             Toast.makeText(getApplicationContext(),"chuva e friagem",Toast.LENGTH_SHORT).show();
                           }
                       })
                       .setNegativeButton("sol", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               Toast.makeText(getApplicationContext(), "Sol e Quente",Toast.LENGTH_LONG).show();
                           }
                       });
           }
       });
    }
}