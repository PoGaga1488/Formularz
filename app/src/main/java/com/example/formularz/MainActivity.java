package com.example.formularz;


import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextname;
    private EditText editTextnazwisko;
    private EditText editTextemail;
    private EditText editTextnumer;
    private EditText editTexthaslo;
    private EditText editTexthaslo2;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextname = findViewById(R.id.editTextText);
        editTextnazwisko = findViewById(R.id.editTextText3);
        editTextemail = findViewById(R.id.editTextText2);
        editTextnumer = findViewById(R.id.editTextPhone);
        editTexthaslo = findViewById(R.id.editTextTextPassword);
        editTexthaslo2 = findViewById(R.id.editTextTextPassword2);
        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextname.getText().toString().trim();
                String email = editTextemail.getText().toString().trim();
                String nazwisko = editTextnazwisko.getText().toString().trim();
                String numer = editTextnumer.getText().toString().trim();
                String haslo = editTexthaslo.getText().toString().trim();
                String haslop = editTexthaslo2.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wpisz imię", Toast.LENGTH_SHORT).show();
                } else if (nazwisko.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wpisz nazwisko", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wpisz email", Toast.LENGTH_SHORT).show();
                } else if (numer.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wpisz numer", Toast.LENGTH_SHORT).show();
                } else if (haslo.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Wpisz hasło", Toast.LENGTH_SHORT).show();
                } else if (numer.length() < 9) {
                    Toast.makeText(MainActivity.this, "Numer jest niepoprawny", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Niepoprawny email", Toast.LENGTH_SHORT).show();
                } else if (haslo.length() < 6) {
                    Toast.makeText(MainActivity.this, "Hasło ma mieć co najmniej 6 znaków", Toast.LENGTH_SHORT).show();
                } else if (!haslo.equals(haslop)) {
                    Toast.makeText(MainActivity.this, "Hasło nie są takie samy", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Wysłano poprawnie", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}