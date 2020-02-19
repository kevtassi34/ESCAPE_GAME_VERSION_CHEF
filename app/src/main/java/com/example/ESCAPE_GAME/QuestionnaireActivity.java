package com.example.ESCAPE_GAME;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuestionnaireActivity extends Activity {
    private Button enigme1; //Bouton pour acceder a l'enigme 1
    private EditText indices; //Permet d'afficher le nombre d'indice utilise au total
    private Button enigme2; //Bouton pour acceder a l'enigme 2
    private Button enigme3; //Bouton pour acceder a l'enigme 3
    private Button enigme4; //Bouton pour acceder a l'enigme 4
    private Button enigme5; //Bouton pour acceder a l'enigme 5
    private Button enigme6; //Bouton pour acceder a l'enigme 6
    private Button enigme7; //Bouton pour acceder a l'enigme 7
    private Button enigme8; //Bouton pour acceder a l'enigme 8
    private Button enigme9; //Bouton pour acceder a l'enigme 9
    private Button enigme10; //Bouton pour acceder a l'enigme 10
    private Integer cpt; //Stock le nombre total d'indices utilises en Int
    private String compteur; //Stock le nombre total d'indices utilises en String
    private Button suivant; //Bouton pour accceder a la page des coordonnees

    private Vibrator vib; //Va gerer les vibrations des boutons

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
        setContentView(R.layout.activity_questionnaire);
        /* Activite en plein ecran */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /* Lien avec les differents layouts */
        enigme1 = findViewById(R.id.enigme1_btn);
        enigme2 = findViewById(R.id.enigme2_btn);
        enigme3 = findViewById(R.id.enigme3_btn);
        enigme4 = findViewById(R.id.enigme4_btn);
        enigme5 = findViewById(R.id.enigme5_btn);
        enigme6 = findViewById(R.id.enigme6_btn);
        enigme7 = findViewById(R.id.enigme7_btn);
        enigme8 = findViewById(R.id.enigme8_btn);
        enigme9 = findViewById(R.id.enigme9_btn);
        enigme10 = findViewById(R.id.enigme10_btn);
        indices = findViewById(R.id.indices_txt);

        indices.setEnabled(false); //Empeche l'ecriture manuelle de l'editText

        /* Gere la rotation des boutons */
        RotateAnimation rotate = new RotateAnimation(0, 20000, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(800000);
        rotate.setInterpolator(new LinearInterpolator());
        enigme1.startAnimation(rotate);
        enigme2.startAnimation(rotate);
        enigme3.startAnimation(rotate);
        enigme4.startAnimation(rotate);
        enigme5.startAnimation(rotate);
        enigme6.startAnimation(rotate);
        enigme7.startAnimation(rotate);
        enigme8.startAnimation(rotate);
        enigme9.startAnimation(rotate);
        enigme10.startAnimation(rotate);

        vib=(Vibrator)getSystemService(MainActivity.VIBRATOR_SERVICE); //Mise en place de la vibration

        cpt = 0;
        Intent intent = getIntent();
        if (intent != null){}
        Boolean str1; //Reçoit si l'indice de l'enigme 1 a ete utilise ou non
        Boolean str2; //Reçoit si l'indice de l'enigme 2 a ete utilise ou non
        Boolean str3; //Reçoit si l'indice de l'enigme 3 a ete utilise ou non
        Boolean str4; //Reçoit si l'indice de l'enigme 4 a ete utilise ou non
        Boolean str5; //Reçoit si l'indice de l'enigme 5 a ete utilise ou non
        Boolean str6; //Reçoit si l'indice de l'enigme 6 a ete utilise ou non
        Boolean str7; //Reçoit si l'indice de l'enigme 7 a ete utilise ou non
        Boolean str8; //Reçoit si l'indice de l'enigme 8 a ete utilise ou non
        Boolean str9; //Reçoit si l'indice de l'enigme 9 a ete utilise ou non
        Boolean str10; //Reçoit si l'indice de l'enigme 10 a ete utilise ou non
        if (intent.hasExtra("indices_txt")){ //Rentre dans le if si l'utilisateur a appuye sur le bouton indice de l'enigme 1
            str1 = intent.getBooleanExtra("indices_txt",false);
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("1", str1);
            editor.apply(); //Sauvegarde le fait que l'indice est utilise
            Intent EscapeActivity = new Intent(QuestionnaireActivity.this, Indice1Activity.class);
            startActivity(EscapeActivity);
            //Redirection vers la page Indice1Activity
        }
        if (intent.hasExtra("indices2_txt")){ //Rentre dans le if si l'utilisateur a appuye sur le bouton indice de l'enigme 2
            str2 = intent.getBooleanExtra("indices2_txt",false);
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("2", str2);
            editor.apply(); //Sauvegarde le fait que l'indice est utilise
            Intent EscapeActivity = new Intent(QuestionnaireActivity.this, Indice2Activity.class);
            startActivity(EscapeActivity);
            //Redirection vers la page Indice2Activity
        }
        if (intent.hasExtra("indices3_txt")){ //Rentre dans le if si l'utilisateur a appuye sur le bouton indice de l'enigme 3
            str3 = intent.getBooleanExtra("indices3_txt",false);
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("3", str3);
            editor.apply(); //Sauvegarde le fait que l'indice est utilise
            Intent EscapeActivity = new Intent(QuestionnaireActivity.this, Indice3Activity.class);
            startActivity(EscapeActivity);
            //Redirection vers la page Indice3Activity
        }
        if (intent.hasExtra("indices4_txt")){ //Rentre dans le if si l'utilisateur a appuye sur le bouton indice de l'enigme 4
            str4 = intent.getBooleanExtra("indices4_txt",false);
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("4", str4);
            editor.apply(); //Sauvegarde le fait que l'indice est utilise
            Intent EscapeActivity = new Intent(QuestionnaireActivity.this, Indice4Activity.class);
            startActivity(EscapeActivity);
            //Redirection vers la page Indice4Activity
        }
        if (intent.hasExtra("indices5_txt")){ //Rentre dans le if si l'utilisateur a appuye sur le bouton indice de l'enigme 5
            str5 = intent.getBooleanExtra("indices5_txt",false);
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("5", str5);
            editor.apply(); //Sauvegarde le fait que l'indice est utilise
            Intent EscapeActivity = new Intent(QuestionnaireActivity.this, Indice5Activity.class);
            startActivity(EscapeActivity);
            //Redirection vers la page Indice5Activity
        }
        if (intent.hasExtra("indices6_txt")){ //Rentre dans le if si l'utilisateur a appuye sur le bouton indice de l'enigme 6
            str6 = intent.getBooleanExtra("indices6_txt",false);
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("6", str6);
            editor.apply(); //Sauvegarde le fait que l'indice est utilise
            Intent EscapeActivity = new Intent(QuestionnaireActivity.this, Indice6Activity.class);
            startActivity(EscapeActivity);
            //Redirection vers la page Indice6Activity
        }
        if (intent.hasExtra("indices7_txt")){ //Rentre dans le if si l'utilisateur a appuye sur le bouton indice de l'enigme 7
            str7 = intent.getBooleanExtra("indices7_txt",false);
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("7", str7);
            editor.apply(); //Sauvegarde le fait que l'indice est utilise
            Intent EscapeActivity = new Intent(QuestionnaireActivity.this, Indice7Activity.class);
            startActivity(EscapeActivity);
            //Redirection vers la page Indice7Activity
        }
        if (intent.hasExtra("indices8_txt")){ //Rentre dans le if si l'utilisateur a appuye sur le bouton indice de l'enigme 8
            str8 = intent.getBooleanExtra("indices8_txt",false);
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("8", str8);
            editor.apply(); //Sauvegarde le fait que l'indice est utilise
            Intent EscapeActivity = new Intent(QuestionnaireActivity.this, Indice8Activity.class);
            startActivity(EscapeActivity);
            //Redirection vers la page Indice8Activity
        }
        if (intent.hasExtra("indices9_txt")){ //Rentre dans le if si l'utilisateur a appuye sur le bouton indice de l'enigme 9
            str9 = intent.getBooleanExtra("indices9_txt",false);
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("9", str9);
            editor.apply(); //Sauvegarde le fait que l'indice est utilise
            Intent EscapeActivity = new Intent(QuestionnaireActivity.this, Indice9Activity.class);
            startActivity(EscapeActivity);
            //Redirection vers la page Indice9Activity
        }
        if (intent.hasExtra("indices10_txt")){ //Rentre dans le if si l'utilisateur a appuye sur le bouton indice de l'enigme 10
            str10 = intent.getBooleanExtra("indices10_txt",false);
            SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("10", str10);
            editor.apply(); //Sauvegarde le fait que l'indice est utilise
            Intent EscapeActivity = new Intent(QuestionnaireActivity.this, Indice10Activity.class);
            startActivity(EscapeActivity);
            //Redirection vers la page Indice10Activity
        }

        suivant = findViewById(R.id.suivant_btn); //Lien avec le layout

        /*Recuperation des indices utilises */
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        Boolean cc1 = sharedPreferences.getBoolean("1", false); //Pour l'indice 1
        Boolean cc2 = sharedPreferences.getBoolean("2", false); //Pour l'indice 2
        Boolean cc3 = sharedPreferences.getBoolean("3", false); //Pour l'indice 3
        Boolean cc4 = sharedPreferences.getBoolean("4", false); //Pour l'indice 4
        Boolean cc5 = sharedPreferences.getBoolean("5", false); //Pour l'indice 5
        Boolean cc6 = sharedPreferences.getBoolean("6", false); //Pour l'indice 6
        Boolean cc7 = sharedPreferences.getBoolean("7", false); //Pour l'indice 7
        Boolean cc8 = sharedPreferences.getBoolean("8", false); //Pour l'indice 8
        Boolean cc9 = sharedPreferences.getBoolean("9", false); //Pour l'indice 9
        Boolean cc10 = sharedPreferences.getBoolean("10", false); //Pour l'indice 10

        if (cc1) { //On incremente le compteur pour chaque indice utilise
            cpt = cpt + 1;
        }
        if (cc2) {
            cpt = cpt + 1;
        }
        if (cc3) {
            cpt = cpt + 1;
        }
        if (cc4) {
            cpt = cpt + 1;
        }
        if (cc5) {
            cpt = cpt + 1;
        }
        if (cc6) {
            cpt = cpt + 1;
        }
        if (cc7) {
            cpt = cpt + 1;
        }
        if (cc8) {
            cpt = cpt + 1;
        }
        if (cc9) {
            cpt = cpt + 1;
        }
        if (cc10) {
            cpt = cpt + 1;
        }

        compteur = Integer.toString(cpt); //Conversion en string des indices utilises
        indices.setText("Nombre d'indice(s) utilisé(s) : " + compteur); //Affichage du nombre d'indices utilises

        enigme1.setOnClickListener(new View.OnClickListener() { //Lorsque l'utilisateur appuie sur le bouton de l'enigme 1
            @Override

            /* L'utilisateur à cliquer sur le bouton */

            public void onClick(View v) {
                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                vib.vibrate(10);
                Intent Enigme1Activity = new Intent(QuestionnaireActivity.this, Enigme1Activity.class);
                startActivity(Enigme1Activity);
                //Redirection vers la page Enigme1Activity
            }
        });

        enigme2.setOnClickListener(new View.OnClickListener() { //Lorsque l'utilisateur appuie sur le bouton de l'enigme 2
            @Override

            /* L'utilisateur à cliquer sur le bouton */

            public void onClick(View v) {
                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                vib.vibrate(10);
                Intent Enigme2Activity = new Intent(QuestionnaireActivity.this, Enigme2Activity.class);
                startActivity(Enigme2Activity);
                //Redirection vers la page Enigme2Activity
            }
        });

        enigme3.setOnClickListener(new View.OnClickListener() { //Lorsque l'utilisateur appuie sur le bouton de l'enigme 3
            @Override

            /* L'utilisateur à cliquer sur le bouton */

            public void onClick(View v) {
                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                vib.vibrate(10);
                Intent Enigme3Activity = new Intent(QuestionnaireActivity.this, Enigme3Activity.class);
                startActivity(Enigme3Activity);
                //Redirection vers la page Enigme3Activity
            }
        });

        enigme4.setOnClickListener(new View.OnClickListener() { //Lorsque l'utilisateur appuie sur le bouton de l'enigme 4
            @Override

            /* L'utilisateur à cliquer sur le bouton */

            public void onClick(View v) {
                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                vib.vibrate(10);
                Intent Enigme4Activity = new Intent(QuestionnaireActivity.this, Enigme4Activity.class);
                startActivity(Enigme4Activity);
                //Redirection vers la page Enigme4Activity
            }
        });

        enigme5.setOnClickListener(new View.OnClickListener() { //Lorsque l'utilisateur appuie sur le bouton de l'enigme 5
            @Override

            /* L'utilisateur à cliquer sur le bouton */

            public void onClick(View v) {
                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                //vib.vibrate(10);
                Intent Enigme5Activity = new Intent(QuestionnaireActivity.this, Enigme5Activity.class);
                startActivity(Enigme5Activity);
                //Redirection vers la page Enigme5Activity
            }
        });

        enigme6.setOnClickListener(new View.OnClickListener() { //Lorsque l'utilisateur appuie sur le bouton de l'enigme 6
            @Override

            /* L'utilisateur à cliquer sur le bouton */

            public void onClick(View v) {
                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                vib.vibrate(10);
                Intent Enigme6Activity = new Intent(QuestionnaireActivity.this, Enigme6Activity.class);
                startActivity(Enigme6Activity);
                //Redirection vers la page Enigme6Activity
            }
        });

        enigme7.setOnClickListener(new View.OnClickListener() { //Lorsque l'utilisateur appuie sur le bouton de l'enigme 7
            @Override

            /* L'utilisateur à cliquer sur le bouton */

            public void onClick(View v) {
                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                //vib.vibrate(10);
                Intent Enigme7Activity = new Intent(QuestionnaireActivity.this, Enigme7Activity.class);
                startActivity(Enigme7Activity);
                //Redirection vers la page Enigme7Activity
            }
        });

        enigme8.setOnClickListener(new View.OnClickListener() { //Lorsque l'utilisateur appuie sur le bouton de l'enigme 8
            @Override

            /* L'utilisateur à cliquer sur le bouton */

            public void onClick(View v) {
                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                vib.vibrate(10);
                Intent Enigme8Activity = new Intent(QuestionnaireActivity.this, Enigme8Activity.class);
                startActivity(Enigme8Activity);
                //Redirection vers la page Enigme8Activity
            }
        });

        enigme9.setOnClickListener(new View.OnClickListener() { //Lorsque l'utilisateur appuie sur le bouton de l'enigme 9
            @Override

            /* L'utilisateur à cliquer sur le bouton */

            public void onClick(View v) {
                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                vib.vibrate(10);
                Intent Enigme9Activity = new Intent(QuestionnaireActivity.this, Enigme9Activity.class);
                startActivity(Enigme9Activity);
                //Redirection vers la page Enigme9Activity
            }
        });

        enigme10.setOnClickListener(new View.OnClickListener() { //Lorsque l'utilisateur appuie sur le bouton de l'enigme 10
            @Override

            /* L'utilisateur à cliquer sur le bouton */

            public void onClick(View v) {
                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                vib.vibrate(10);
                Intent Enigme10Activity = new Intent(QuestionnaireActivity.this, Enigme10Activity.class);
                startActivity(Enigme10Activity);
                //Redirection vers la page Enigme10Activity
            }
        });

        suivant.setOnClickListener(new View.OnClickListener() { //Lorsque l'utilisateur a appuyer sur le bouton suivant
            @Override

            /* L'utilisateur à cliquer sur le bouton */

            public void onClick(View v) {
                /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                vib.vibrate(10);
                Intent CoordonneeActivity = new Intent(QuestionnaireActivity.this, CoordonneeActivity.class);
                startActivity(CoordonneeActivity);
                //Redirection vers la page CoordonneeActivity
            }
        });
    }

    public void onBackPressed() {} //Permet de bloquer le bouton retour du telephone
}

