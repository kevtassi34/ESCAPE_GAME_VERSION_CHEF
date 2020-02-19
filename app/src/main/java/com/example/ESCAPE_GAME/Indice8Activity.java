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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Indice8Activity extends Activity {
    private TextView question;
    private EditText reponse;
    private Button valider;
    private TextView commentaire;
    private String test;
    private CheckBox Box1;
    private CheckBox Box2;
    private CheckBox Box3;
    private CheckBox Box4;
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
        setContentView(R.layout.activity_indice8);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        question = findViewById(R.id.question8_view);// Pour faire le lien avec l'affichage de la question de l'indice dans le layout
        valider = findViewById(R.id.indice8_btn);//pour faire le lien avec le bouton vaider du de son fichier layout
        commentaire = findViewById(R.id.IndiceReponse8_view);//pour faire le lien avec le commentaire qui s'affiche quand tu repond a la question
        Box1 = findViewById(R.id.checkbox8_1);// pour faire le lien avec la checkbox1 de son fichier layout
        Box2 = findViewById(R.id.checkbox8_2);// pour faire le lien avec la checkbox2 de son fichier layout
        Box3 = findViewById(R.id.checkbox8_3);// pour faire le lien avec la checkbox3 de son fichier layout
        Box4 = findViewById(R.id.checkbox8_4);// pour faire le lien avec la checkbox4 de son fichier layout
        indice = findViewById(R.id.image8View);// pour faire le lien avec l'image de l'indice qui s'affiche apres avoir repondu a la question

        vib=(Vibrator)getSystemService(MainActivity.VIBRATOR_SERVICE);// permet de definir la variable vib, pour la vibration du bouton lorqu'on n'appui dessus
        retour = findViewById(R.id.retour_btn);// pour faire le lien avec le bouton retour dans son fichier layout

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);//fonction necessaire pour garder en mémoire une preference suite à une fermeture.
        Boolean cc1 = sharedPreferences.getBoolean("1", false);// variable de type sharedPreferences
        if (cc1) {
            indice.setVisibility(View.VISIBLE);// si la variable booolean cc1 est a true , l'image de l'indice s'affiche
        } else {
            indice.setVisibility(View.INVISIBLE);// sinon l'image ne s'affiche pas
        }

        Box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vib.vibrate(10);//le checkbox vibre pendant 10 milliseconde
                // si le checkbox1 est selectionnee , toutes les autres checkbox ne le sont pas
                // sinon elles sont toutes deselectionnees
                if (Box1.isChecked()) {
                    Box2.setChecked(false);
                    Box3.setChecked(false);
                    Box4.setChecked(false);
                } else {
                    Box2.setChecked(false);
                    Box3.setChecked(false);
                    Box4.setChecked(false);
                }
            }
        });
                // si le checkbox2 est selectionnee , toutes les autres checkbox ne le sont pas
                // sinon elles sont toutes deselectionnees
        Box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vib.vibrate(10);//le checkbox vibre pendant 10 milliseconde
                if (Box2.isChecked()) {
                    Box1.setChecked(false);
                    Box3.setChecked(false);
                    Box4.setChecked(false);
                } else {
                    Box1.setChecked(false);
                    Box3.setChecked(false);
                    Box4.setChecked(false);
                }
            }
        });
                // si le checkbox3 est selectionnee , toutes les autres checkbox ne le sont pas
                // sinon elles sont toutes deselectionnees
        Box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vib.vibrate(10);//le checkbox vibre pendant 10 milliseconde
                if (Box3.isChecked()) {
                    Box2.setChecked(false);
                    Box1.setChecked(false);
                    Box4.setChecked(false);
                } else {
                    Box2.setChecked(false);
                    Box1.setChecked(false);
                    Box4.setChecked(false);
                }
            }
        });
                // si le checkbox4 est selectionnee , toutes les autres checkbox ne le sont pas
                // sinon elles sont toutes deselectionnees
        Box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vib.vibrate(10);//le checkbox vibre pendant 10 milliseconde
                if (Box4.isChecked()) {
                    Box2.setChecked(false);
                    Box3.setChecked(false);
                    Box1.setChecked(false);
                } else {
                    Box2.setChecked(false);
                    Box3.setChecked(false);
                    Box1.setChecked(false);
                }
            }
        });

        valider.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vib.vibrate(10);//le checkbox vibre pendant 10 milliseconde
                // si le checkbox3 est selectionnee
                if (Box3.isChecked()) {
                    commentaire.setText("Bonne réponse !\n\nVoici votre indice :");// pour afficher le texte en cas de bonne reponse a la question posé
                    commentaire.setTextColor(Color.GREEN);// pour afficher le texte avec une couleur verte
                    valider.setEnabled(false);// le bouton valider devient desactif
                    trouve = true;
                    indice.setVisibility(View.VISIBLE);//l'image de l'indice s'affiche
                    SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("1", trouve);
                    editor.apply();// permet de sauvegarder dans les preferences (trouve = true) le faite que l'utilsateur a trouvé bon a la question posé
                    indice.setVisibility(View.VISIBLE);//l'image de l'indice s'affiche
                } else {
                    commentaire.setText("Mauvaise réponse ! Réessayer.");// pour afficher le texte en cas de mauvaise reponse a la question posé
                    commentaire.setTextColor(Color.RED);// pour afficher le texte avec une couleur rouge
                }

            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            /* Si l'utilisateur clique */
            public void onClick(View v) {
                vib.vibrate(10);//le checkbox vibre pendant 10 milliseconde
                Intent intent = new Intent(Indice8Activity.this, Enigme8Activity.class);// permet de retourner vers l'activite Enigme7Activity
                startActivity(intent);
            }
        });
    }

    public void onBackPressed() {}// pour bloquer le bouton retour du telephone

}
