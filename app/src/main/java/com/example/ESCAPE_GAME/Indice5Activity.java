package com.example.ESCAPE_GAME;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Indice5Activity extends Activity {
    private TextView question;
    private EditText reponse;
    private Button valider;
    private TextView commentaire;
    private String test;
    private ImageView indice;
    private Boolean trouve;

    private Button retour;
    private Vibrator vib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }
        setContentView(R.layout.activity_indice5);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        question = findViewById(R.id.question5_view);// Pour faire le lien avec l'affichage de la question de l'indice dans le layout
        reponse = findViewById(R.id.reponse5_txt);// pour faire le lien avec le champs de reponse a l'indice dans son fichier layout
        valider = findViewById(R.id.indice5_btn);//pour faire le lien avec le bouton vaider du de son fichier layout
        commentaire = findViewById(R.id.IndiceReponse5_view);// pour faire le lien avec le commentaire qui s'affiche quand tu repond a la question
        indice = findViewById(R.id.image5View);// pour faire le lien avec l'image de l'indice qui s'affiche apres avoir repondu a la question

        vib=(Vibrator)getSystemService(MainActivity.VIBRATOR_SERVICE);// permet de definir la variable vib, pour la vibration du bouton lorqu'on n'appui dessus
        retour = findViewById(R.id.retour_btn);// pour faire le lien avec le bouton retour dans son fichier layout

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);//fonction necessaire pour garder en mémoire une preference suite à une fermeture.
        Boolean cc1 = sharedPreferences.getBoolean("1", false);// variable de type sharedPreferences
        if (cc1) {
            indice.setVisibility(View.VISIBLE);// si la variable booolean cc1 est a vrai , l'image de l'indice s'affiche
        } else {
            indice.setVisibility(View.INVISIBLE);// sinon l'image ne s'affiche pas
        }
        valider.setEnabled(false);// le bouton valide reste inactif

        reponse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            /* Lorsque le champ de saisie est modifié */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                test = s.toString();
                valider.setEnabled(true);// le bouton valider devient actif
            }
            /* Après que le champ de saisie ait été modifié */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        valider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vib.vibrate(10);// le bouton valider vibre pendant 10 milliseconde
                if (test.contains("proginov") || test.contains("Proginov") || test.contains("PROGINOV") ) {
                    commentaire.setText("Bonne réponse! Voici votre Indice:");// pour afficher le texte en cas de bonne reponse a la question posé
                    commentaire.setTextColor(Color.GREEN);// pour afficher le texte avec une couleur verte
                    valider.setEnabled(false);// le bouton valider devient desactif
                    trouve = true;
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                    SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("1", trouve);
                    editor.apply();
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                } else if (test.contains("capgemini") || test.contains("Capgemini") || test.contains("CAPGEMINI")) {
                    commentaire.setText("Bonne réponse! Voici votre Indice:");
                    commentaire.setTextColor(Color.GREEN);// pour afficher le texte avec une couleur verte
                    valider.setEnabled(false);
                    trouve = true;
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                    SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("1", trouve);
                    editor.apply();
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                } else if (test.contains("cgi") || test.contains("CGI") || test.contains("Cgi")) {
                    commentaire.setText("Bonne réponse! Voici votre Indice:");// pour afficher le texte en cas de bonne reponse a la question posé
                    commentaire.setTextColor(Color.GREEN);// pour afficher le texte avec une couleur verte
                    valider.setEnabled(false);
                    trouve = true;
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                    SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("1", trouve);
                    editor.apply();
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                } else if (test.contains("sopra") || test.contains("Sopra") || test.contains("SOPRA") || test.contains("Sopra Steria") || test.contains("sopra steria") ) {
                    commentaire.setText("Bonne réponse! Voici votre Indice:");// pour afficher le texte en cas de bonne reponse a la question posé
                    commentaire.setTextColor(Color.GREEN);// pour afficher le texte avec une couleur verte
                    valider.setEnabled(false);
                    trouve = true;
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                    SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("1", trouve);
                    editor.apply();
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                } else if (test.contains("atos") || test.contains("Atos") || test.contains("ATOS")) {
                    commentaire.setText("Bonne réponse! Voici votre Indice:");// pour afficher le texte en cas de bonne reponse a la question posé
                    commentaire.setTextColor(Color.GREEN);// pour afficher le texte avec une couleur verte
                    valider.setEnabled(false);
                    trouve = true;
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                    SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("1", trouve);
                    editor.apply();
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                } else if (test.contains("orange") || test.contains("Orange") || test.contains("ORANGE")) {
                    commentaire.setText("Bonne réponse! Voici votre Indice:");// pour afficher le texte en cas de bonne reponse a la question posé
                    commentaire.setTextColor(Color.GREEN);// pour afficher le texte avec une couleur verte
                    valider.setEnabled(false);
                    trouve = true;
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                    SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("1", trouve);
                    editor.apply();
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                } else if (test.contains("i-bp") || test.contains("I-BP") || test.contains("I-bp") || test.contains("i-BP")) {
                    commentaire.setText("Bonne réponse !\n\nVoici votre Indice :");
                    commentaire.setTextColor(Color.GREEN);// pour afficher le texte avec une couleur verte
                    valider.setEnabled(false);
                    trouve = true;
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                    SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("1", trouve);
                    editor.apply();// permet de sauvegarder dans les preferences (trouve = true) le faite que l'utilsateur a trouvé bon a la question posé
                    indice.setVisibility(View.VISIBLE);// l'image de l'indice s'affiche
                } else {
                    commentaire.setText("Mauvaise réponse ! Réessayer.");// pour afficher le texte en cas de mauvaise reponse a la question posé
                    commentaire.setTextColor(Color.RED);// pour afficher le texte avec une couleur rouge
                }
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            /* Si l'utilisateur clique */
            public void onClick(View v) {
                vib.vibrate(10);// le bouton retour vibre pendant 10 millisecondes
                Intent intent = new Intent(Indice5Activity.this, Enigme5Activity.class);// permet de retourner vers l'activite Enigme5Activity
                startActivity(intent);
            }
        });
    }

    public void onBackPressed() {}// pour bloquer le bouton retour du telephone

}
