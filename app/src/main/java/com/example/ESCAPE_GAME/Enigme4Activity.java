package com.example.ESCAPE_GAME;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Enigme4Activity extends Activity {
    private TextView question; //Permet d'afficher la question de l'enigme
    private EditText reponse; //Champ où l'utilisateur peut entrer sa reponse
    private Button valider; /* Bouton qui permet de valider sa reponse de l'énigme */
    private Button indice1; //Bouton permettant d'utiliser un indice
    private String ev_reponse; //Variable qui va stocker la valeur saisie par l'utilisateur
    private TextView nbindice; //Affiche si l'utilisateur à utilise l'indice de l'enigme ou non
    private Boolean NombreIndice; //Vrai si inidice utilise; Faux si indice non utilise (Sert pour les preferences)
    private Boolean trouve; //Vrai si inidice utilise; Faux si indice non utilise (Sera envoyer dans questionnaireActivity)

    private Button retour; //Bouton permettant de revenir en arrière
    private Vibrator vib; //Va gerer la vibration des boutons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* Supression de la barre de titre */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /* Protocole de securite de l'activite */
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }
        /* Mis en place du layout de l'activite */
        setContentView(R.layout.activity_enigme4);
        /* Activite en plein ecran */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        question = findViewById(R.id.enigme4_view); //Lien avec le layout
        reponse = findViewById(R.id.reponseEnigme4_txt); //Lien avec le layout
        nbindice = findViewById(R.id.nbindice4_view); //Lien avec le layout
        valider = findViewById(R.id.validerEnigme4_btn); //Lien avec le layout
        indice1 = findViewById(R.id.indice4_btn); //Lien avec le layout
        valider.setEnabled(false); //On bloque le bouton valider tant qu'une valeur n'a pas été saisie
        indice1.setEnabled(true); //Possiblité d'appuyer sur le bouton indice

        vib=(Vibrator)getSystemService(MainActivity.VIBRATOR_SERVICE); //Mise en place de la vibration
        retour = findViewById(R.id.retour_btn); //Lien avec le layout

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        Boolean cc2 = sharedPreferences.getBoolean("4", false);//Recuperation des preferences
        /* On verifie si l'utilisateur à debloquer l'indice ou non */
        if (cc2) {
            nbindice.setText("Indice utilisé : " + "1");
        } else {
            nbindice.setText("Indice utilisé : " + "0");
        }

        reponse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            /* Lorsque le champ de saisie est modifié */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                valider.setEnabled(true); //On debloque le bouton valider
                valider.setEnabled(s.toString().length() != 0);
                ev_reponse = s.toString(); //On stock la valeur entre par l'utilisateur dans ev_reponse

            }

            /* Après que le champ de saisie ait été modifié */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        valider.setOnClickListener(new View.OnClickListener() {
            /* Si l'utilisateur clique */
            public void onClick(View v) { //Lorsque l'utilisateur appuie sur le bouton valider
                vib.vibrate(10);
                Intent intent = new Intent(Enigme4Activity.this, CoordonneeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("coordonnee5_txt", ev_reponse);
                intent.putExtras(bundle);
                startActivity(intent);
                /* On se redirige vers la page coordonneeActivity en envoyant également la réponse de l'utilisateur (ev_reponse) */
            }
        });


        indice1.setOnClickListener(new View.OnClickListener() {
            /* Si l'utilisateur clique */
            public void onClick(View v) { //Lorsque l'utilisateur appuie sur le bouton indice
                vib.vibrate(10);
                NombreIndice = true;
                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putBoolean("4", NombreIndice);
                editor.apply(); //Permet de sauvegarder dans les preferences l'utilisation d'un indice
                trouve = true;
                Intent intent = new Intent(Enigme4Activity.this, QuestionnaireActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("indices4_txt", trouve);
                intent.putExtras(bundle);
                startActivity(intent);
                /* Redirection vers la page questionnaireActivity pour stocker l'utilisation d'indice */
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            /* Si l'utilisateur clique */
            public void onClick(View v) { //Lorsque l'utilisateur appuie sur le bouton retour
                vib.vibrate(10);
                Intent intent = new Intent(Enigme4Activity.this, QuestionnaireActivity.class);
                startActivity(intent);
                //Redirection vers la page QuestionnaireActivity
            }
        });
    }

    public void onBackPressed() {} //Permet de bloquer le bouton retour du telephone

}
