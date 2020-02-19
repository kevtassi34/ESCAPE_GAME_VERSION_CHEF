package com.example.ESCAPE_GAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button escape; //Bouton permettant de se connecter a l'application
    private Button no_escape; //Bouton factice

    private EditText codeEscape; //Code necessaire a la connexion a l'application

    private TextView titre; //Aperçu du titre de l'application

    private int code; //Code d'acces a l'application

    private String codeToString; //Permet de changer le code d'acces en une chaine de caractere
    private String test; //String permettant de tester le code d'acces

    private Vibrator vib; //Va gerer la vibration des boutons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Suppression de la barre de titre */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /* Protocole de securite de l'activite */
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }
        /* Mis en place du layout de l'activite */
        setContentView(R.layout.activity_main);
        /* Activite en plein ecran */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* code d'acces et transformation */
        code = 2468;
        codeToString = codeToString.valueOf(code);

        /* Lien avec les layout */
        escape = findViewById(R.id.escape_btn);
        no_escape = findViewById(R.id.no_escape_btn);
        codeEscape = findViewById(R.id.escape_txt);
        titre = findViewById(R.id.titre_txt);

        /* Rotation des boutons */
        RotateAnimation rotate = new RotateAnimation(0, 20000, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(800000);
        rotate.setInterpolator(new LinearInterpolator());
        escape.startAnimation(rotate);
        no_escape.startAnimation(rotate);

        escape.setEnabled(false); //Blocage du bouton tant que le code n'est pas bon
        vib=(Vibrator)getSystemService(MainActivity.VIBRATOR_SERVICE); //Mise en place de la vibration

        codeEscape.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            /* Lorsque le champ de saisie est modifié */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                escape.setEnabled(s.toString().length() != 0);
                test = s.toString();
                //Test du code
                if (test.compareTo(codeToString) !=0) {
                    test = "Veuillez saisir le bon code.";
                } else if (test.compareTo(codeToString) ==0) {
                    test = "Code accepté";
                }
            }

            /* Après que le champ de saisie ait été modifié */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        no_escape.setOnClickListener(new View.OnClickListener() { //Lorsque l'utilisateur appuie sur le bouton factice

            /* Si l'utilisateur clique */
            public void onClick(View v) {

                vib.vibrate(10);

            }
        });

        escape.setOnClickListener(new View.OnClickListener() { //Lorsque l'utilisateur appuie sur le bouton pour acceder a l'application

            /* Si l'utilisateur clique */

            public void onClick(View v) {

                //InputMethodManager imm = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
                //mm.hideSoftInputFromWindow(codeEscape.getWindowToken(), 0);
                vib.vibrate(10);
                if (test.contains("accepté")) {
                    vib.vibrate(10); //Vibration du bouton
                    Intent EscapeActivity = new Intent(MainActivity.this, EscapeActivity.class);
                    startActivity(EscapeActivity);
                    //Redirection vers la page EscapeActivity
                } else {
                    codeEscape.getText().clear();
                }
            }
        });
    }

    public void onBackPressed() {} //Permet de bloquer le bouton retour du telephone

}