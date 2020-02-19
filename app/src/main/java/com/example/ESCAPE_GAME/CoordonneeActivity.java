package com.example.ESCAPE_GAME;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.nfc.tech.NfcB;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/* Page qui permet de gérer les coordonnées sur l'application */

public class CoordonneeActivity extends Activity {
    private TextView coordonnee3;  /* Valeur de la 3ème coordonnée */
    private TextView coordonnee6;  /* Valeur de la 6ème coordonnée */
    private TextView coordonnee9;  /* Valeur de la 9ème coordonnée */
    private EditText coordonnee1;  /* Valeur de la 1ère coordonnée */
    private EditText coordonnee2;  /* Valeur de la 2ème coordonnée */
    private EditText coordonnee4;  /* Valeur de la 4ème coordonnée */
    private EditText coordonnee5;  /* Valeur de la 5ème coordonnée */
    private EditText coordonnee7;  /* Valeur de la 7ème coordonnée */
    private EditText coordonnee8;  /* Valeur de la 8ème coordonnée */
    private EditText coordonnee10; /* Valeur de la 10ème coordonnée */
    private EditText coordonnee11; /* Valeur de la 11ème coordonnée */
    private EditText coordonnee12; /* Valeur de la 12ème coordonnée */
    private EditText coordonnee13; /* Valeur de la 13ème coordonnée */
    private TextView affichage;
    private TextView essai_restant;

    private Button coordonnee;
    private Button reboot;
    private Button Save;
    private Button retour;

    private String test;
    private String textFinal;
    private int nbClick; /* Permet de gérer le nombre de vérification effectué par les équipes */

    private Boolean c1; /* Permet de gérer si la valeur entrée est correcte pour la coordonnée 1 */
    private Boolean c2; /* Permet de gérer si la valeur entrée est correcte pour la coordonnée 2 */
    private Boolean c4; /* Permet de gérer si la valeur entrée est correcte pour la coordonnée 4 */
    private Boolean c5; /* Permet de gérer si la valeur entrée est correcte pour la coordonnée 5 */
    private Boolean c7; /* Permet de gérer si la valeur entrée est correcte pour la coordonnée 7 */
    private Boolean c8; /* Permet de gérer si la valeur entrée est correcte pour la coordonnée 8 */
    private Boolean c10; /* Permet de gérer si la valeur entrée est correcte pour la coordonnée 10 */
    private Boolean c11; /* Permet de gérer si la valeur entrée est correcte pour la coordonnée 11 */
    private Boolean c12; /* Permet de gérer si la valeur entrée est correcte pour la coordonnée 12 */
    private Boolean c13; /* Permet de gérer si la valeur entrée est correcte pour la coordonnée 13 */

    private Vibrator vib;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }
        setContentView(R.layout.activity_coordonnee);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        coordonnee1 = findViewById(R.id.coordonnee1_txt); /* Lien avec le layout */
        coordonnee2 = findViewById(R.id.coordonnee2_txt); /* Lien avec le layout */
        coordonnee3 = findViewById(R.id.coordonnee3_view); /* Lien avec le layout */
        coordonnee4 = findViewById(R.id.coordonnee4_txt); /* Lien avec le layout */
        coordonnee5 = findViewById(R.id.coordonnee5_txt); /* Lien avec le layout */
        coordonnee6 = findViewById(R.id.coordonnee6_view); /* Lien avec le layout */
        coordonnee7 = findViewById(R.id.coordonnee7_txt); /* Lien avec le layout */
        coordonnee8 = findViewById(R.id.coordonnee8_txt); /* Lien avec le layout */
        coordonnee9 = findViewById(R.id.coordonnee9_view); /* Lien avec le layout */
        coordonnee10 = findViewById(R.id.coordonnee10_txt); /* Lien avec le layout */
        coordonnee11 = findViewById(R.id.coordonnee11_txt); /* Lien avec le layout */
        coordonnee12 = findViewById(R.id.coordonnee12_txt); /* Lien avec le layout */
        coordonnee13 = findViewById(R.id.coordonnee13_txt); /* Lien avec le layout */
        retour = findViewById(R.id.retour_btn); /* Lien avec le layout */
        Save = findViewById(R.id.save_btn); /* Lien avec le layout */
        essai_restant = findViewById(R.id.essai_view); /* Lien avec le layout */

        coordonnee = findViewById(R.id.coordonnee_btn); /* Lien avec le layout */
        affichage = findViewById(R.id.coordonneeReponse_view); /* Lien avec le layout */

        vib=(Vibrator)getSystemService(MainActivity.VIBRATOR_SERVICE);

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        String sauver = sharedPreferences.getString("1", "");
        String sauver2 = sharedPreferences.getString("2", "");
        String sauver4 = sharedPreferences.getString("4", "");
        String sauver5 = sharedPreferences.getString("5", "");
        String sauver7 = sharedPreferences.getString("7", "");
        String sauver8 = sharedPreferences.getString("8", "");
        String sauver10 = sharedPreferences.getString("10", "");
        String sauver11 = sharedPreferences.getString("11", "");
        String sauver12 = sharedPreferences.getString("12", "");
        String sauver13 = sharedPreferences.getString("13", "");
        Integer essai = sharedPreferences.getInt("20", 0);
        Boolean cc1 = sharedPreferences.getBoolean("c1", false);
        Boolean cc2 = sharedPreferences.getBoolean("c2", false);
        Boolean cc4 = sharedPreferences.getBoolean("c4", false);
        Boolean cc5 = sharedPreferences.getBoolean("c5", false);
        Boolean cc7 = sharedPreferences.getBoolean("c7", false);
        Boolean cc8 = sharedPreferences.getBoolean("c8", false);
        Boolean cc10 = sharedPreferences.getBoolean("c10", false);
        Boolean cc11 = sharedPreferences.getBoolean("c11", false);
        Boolean cc12 = sharedPreferences.getBoolean("c12", false);
        Boolean cc13 = sharedPreferences.getBoolean("c13", false);
        nbClick = essai;
        coordonnee1.setText(sauver);
        coordonnee2.setText(sauver2);
        coordonnee4.setText(sauver4);
        coordonnee5.setText(sauver5);
        coordonnee7.setText(sauver7);
        coordonnee8.setText(sauver8);
        coordonnee10.setText(sauver10);
        coordonnee11.setText(sauver11);
        coordonnee12.setText(sauver12);
        coordonnee13.setText(sauver13);
        c1 = cc1;
        c2 = cc2;
        c4 = cc4;
        c5 = cc5;
        c7 = cc7;
        c8 = cc8;
        c10 = cc10;
        c11 = cc11;
        c12 = cc12;
        c13 = cc13;

        /* Toute la partie ci-dessus permet de récupérer les valeurs sauvegardées plus bas dans le code */

        if (nbClick == 0) {
            essai_restant.setText("Essais restant : " + (3 - nbClick));
        }
        if (nbClick == 1) {
            essai_restant.setText("Essais restant : " + (3 - nbClick));
        }
        if (nbClick == 2) {
            essai_restant.setText("Essais restant : " + (3 - nbClick));
        }
        if (nbClick == 3) {
            essai_restant.setText("Essais restant : " + (3 - nbClick));
        }



        retour.setEnabled(false); /* Bloque le bouton retour */
        coordonnee.setEnabled(false); /* Bloque le bouton de vérification */

        if (essai >= 3) { //Si le nombre essai >= 3; on bloque l'entrée de nouvelles valeurs pour les coordonnées */
            coordonnee.setEnabled(false);
            coordonnee1.setEnabled(false);
            coordonnee2.setEnabled(false);
            coordonnee4.setEnabled(false);
            coordonnee5.setEnabled(false);
            coordonnee7.setEnabled(false);
            coordonnee8.setEnabled(false);
            coordonnee10.setEnabled(false);
            coordonnee11.setEnabled(false);
            coordonnee12.setEnabled(false);
            coordonnee13.setEnabled(false);
        } else { // Si le nombre essai < 3; L'entrée de nouvelles valeurs n'est pas bloqué
            coordonnee.setEnabled(true);
            coordonnee1.setEnabled(true);
            coordonnee2.setEnabled(true);
            coordonnee4.setEnabled(true);
            coordonnee5.setEnabled(true);
            coordonnee7.setEnabled(true);
            coordonnee8.setEnabled(true);
            coordonnee10.setEnabled(true);
            coordonnee11.setEnabled(true);
            coordonnee12.setEnabled(true);
            coordonnee13.setEnabled(true);
        }

        textFinal="";

        /* Permet de récupérer les valeurs entrées sur les pages des différentes énigmes et d'automatiser le report */
        Intent intent = getIntent();
        if (intent != null){}
        String str = "";
        if (intent.hasExtra("coordonnee1_txt")){
            str = intent.getStringExtra("coordonnee1_txt");
            coordonnee1.setText(str);
            if (str.compareTo("3") ==0) {
                c1 = true;
            } else {
                c1 = false;
            }
        }

        if (intent.hasExtra("coordonnee2_txt")){
            str = intent.getStringExtra("coordonnee2_txt");
            coordonnee2.setText(str);
            if (str.compareTo("3") ==0) {
                c2 = true;
            } else {
                c2 = false;
            }
        }

        if (intent.hasExtra("coordonnee4_txt")){
            str = intent.getStringExtra("coordonnee4_txt");
            coordonnee4.setText(str);
            if (str.compareTo("6") ==0) {
                c4 = true;
            } else {
                c4 = false;
            }
        }

        if (intent.hasExtra("coordonnee5_txt")){
            str = intent.getStringExtra("coordonnee5_txt");
            coordonnee5.setText(str);
            if (str.compareTo("7") ==0) {
                c5 = true;
            } else {
                c5 = false;
            }
        }

        if (intent.hasExtra("coordonnee7_txt")){
            str = intent.getStringExtra("coordonnee7_txt");
            coordonnee7.setText(str);
            if (str.compareTo("8") ==0) {
                c7 = true;
            } else {
                c7 = false;
            }

        }

        if (intent.hasExtra("coordonnee8_txt")){
            str = intent.getStringExtra("coordonnee8_txt");
            coordonnee8.setText(str);
            if (str.compareTo("6") ==0) {
                c8 = true;
            } else {
                c8 = false;
            }

        }

        if (intent.hasExtra("coordonnee10_txt")){
            str = intent.getStringExtra("coordonnee10_txt");
            coordonnee10.setText(str);
            if (str.compareTo("3") ==0) {
                c10 = true;
            } else {
                c10 = false;
            }

        }

        if (intent.hasExtra("coordonnee11_txt")){
            str = intent.getStringExtra("coordonnee11_txt");
            coordonnee11.setText(str);
            if (str.compareTo("9") ==0) {
                c11 = true;
            } else {
                c11 = false;
            }

        }

        if (intent.hasExtra("coordonnee12_txt")){
            str = intent.getStringExtra("coordonnee12_txt");
            coordonnee12.setText(str);
            if (str.compareTo("8") ==0) {
                c12 = true;
            } else {
                c12 = false;
            }

        }

        if (intent.hasExtra("coordonnee13_txt")){
            str = intent.getStringExtra("coordonnee13_txt");
            coordonnee13.setText(str);
            if (str.compareTo("7") ==0) {
                c13 = true;
            } else {
                c13 = false;
            }

        }




        coordonnee1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            /* Lorsque le champ de saisie est modifié */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coordonnee.setEnabled(s.toString().length() != 0);
                test = s.toString();
                if (test.compareTo("3") ==0) { // On vérifie si la valeur entrée est correcte
                    c1=true;
                } else {
                    c1 = false;
                    textFinal = textFinal +"champs 1 : incorrect, ";
                }
            }
            /* Après que le champ de saisie ait été modifié */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        coordonnee2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            /* Lorsque le champ de saisie est modifié */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coordonnee.setEnabled(s.toString().length() != 0);
                test = s.toString();
                if (test.compareTo("3") ==0) { // On vérifie si la valeur entrée est correcte
                    c2=true;
                } else {
                    c2 = false;
                    textFinal = textFinal +"champs 2 : incorrect, ";
                }
            }
            /* Après que le champ de saisie ait été modifié */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        coordonnee4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            /* Lorsque le champ de saisie est modifié */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coordonnee.setEnabled(s.toString().length() != 0);
                test = s.toString();
                if (test.compareTo("6") ==0) { // On vérifie si la valeur entrée est correcte
                    c4=true;
                } else {
                    c4 = false;
                    textFinal = textFinal +"champs 4 : incorrect, ";
                }
            }
            /* Après que le champ de saisie ait été modifié */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        coordonnee5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            /* Lorsque le champ de saisie est modifié */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coordonnee.setEnabled(s.toString().length() != 0);
                test = s.toString();
                if (test.compareTo("7") ==0) { // On vérifie si la valeur entrée est correcte
                    c5=true;
                } else {
                    c5 = false;
                    textFinal = textFinal +"champs 5 : incorrect, ";
                }
            }
            /* Après que le champ de saisie ait été modifié */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        coordonnee7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            /* Lorsque le champ de saisie est modifié */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coordonnee.setEnabled(s.toString().length() != 0);
                test = s.toString();
                if (test.compareTo("8") ==0) { // On vérifie si la valeur entrée est correcte
                    c7=true;
                } else {
                    c7 = false;
                    textFinal = textFinal +"champs 7 : incorrect, ";
                }
            }
            /* Après que le champ de saisie ait été modifié */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        coordonnee8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            /* Lorsque le champ de saisie est modifié */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coordonnee.setEnabled(s.toString().length() != 0);
                test = s.toString();
                if (test.compareTo("6") ==0) { // On vérifie si la valeur entrée est correcte
                    c8=true;
                } else {
                    c8 = false;
                    textFinal = textFinal +"champs 8 : incorrect, ";
                }
            }
            /* Après que le champ de saisie ait été modifié */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        coordonnee10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            /* Lorsque le champ de saisie est modifié */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coordonnee.setEnabled(s.toString().length() != 0);
                test = s.toString();
                if (test.compareTo("3") ==0) { // On vérifie si la valeur entrée est correcte
                    c10=true;
                } else {
                    c10 = false;
                    textFinal = textFinal +"champs 10 : incorrect, ";
                }
            }
            /* Après que le champ de saisie ait été modifié */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        coordonnee11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            /* Lorsque le champ de saisie est modifié */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coordonnee.setEnabled(s.toString().length() != 0);
                test = s.toString();
                if (test.compareTo("9") ==0) { // On vérifie si la valeur entrée est correcte
                    c11=true;
                } else {
                    c11 = false;
                    textFinal = textFinal +"champs 11 : incorrect, ";
                }
            }
            /* Après que le champ de saisie ait été modifié */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        coordonnee12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            /* Lorsque le champ de saisie est modifié */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coordonnee.setEnabled(s.toString().length() != 0);
                test = s.toString();
                if (test.compareTo("8") ==0) { // On vérifie si la valeur entrée est correcte
                    c12=true;
                } else {
                    c12 = false;
                    textFinal = textFinal +"champs 12 : incorrect, ";
                }
            }
            /* Après que le champ de saisie ait été modifié */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        coordonnee13.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            /* Lorsque le champ de saisie est modifié */
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                coordonnee.setEnabled(s.toString().length() != 0);
                test = s.toString();
                if (test.compareTo("7") ==0) { // On vérifie si la valeur entrée est correcte
                    c13=true;
                } else {
                    c13 = false;
                    textFinal = textFinal +"champs 13 : incorrect, ";
                }
            }
            /* Après que le champ de saisie ait été modifié */
            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        coordonnee.setOnClickListener(new View.OnClickListener() {
            /* Si l'utilisateur clique */
            public void onClick(View v) {

                //InputMethodManager imm = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
                //mm.hideSoftInputFromWindow(codeEscape.getWindowToken(), 0);
                vib.vibrate(10);
                if (nbClick < 3) { // On incrément le nbre essai s'il est inférieur à 3
                    nbClick++;
                }

                if (nbClick >= 3){ // On bloque l'entrée de nouvelles valeurs si le nbre essai vaut 3
                    coordonnee.setEnabled(false);
                    coordonnee1.setEnabled(false);
                    coordonnee2.setEnabled(false);
                    coordonnee4.setEnabled(false);
                    coordonnee5.setEnabled(false);
                    coordonnee7.setEnabled(false);
                    coordonnee8.setEnabled(false);
                    coordonnee10.setEnabled(false);
                    coordonnee11.setEnabled(false);
                    coordonnee12.setEnabled(false);
                    coordonnee13.setEnabled(false);
                }
                if (c1 && c2 && c4 && c5 && c7 && c8 && c10 && c11 && c12 && c13) { // Vérification des coordonnées
                    affichage.setText("Bravo !! Vous pouvez à présent copier ces coordonnées sur un navigateur web");
                }
                if (!c1) { // Passage en rouge des valeurs incorrectes
                    coordonnee1.setTextColor(Color.parseColor("#FF0000"));
                }
                if (!c2) {
                    coordonnee2.setTextColor(Color.parseColor("#FF0000"));
                }
                if (!c4) {
                    coordonnee4.setTextColor(Color.parseColor("#FF0000"));
                }
                if (!c5) {
                    coordonnee5.setTextColor(Color.parseColor("#FF0000"));
                }
                if (!c7) {
                    coordonnee7.setTextColor(Color.parseColor("#FF0000"));
                }
                if (!c8) {
                    coordonnee8.setTextColor(Color.parseColor("#FF0000"));
                }
                if (!c10) {
                    coordonnee10.setTextColor(Color.parseColor("#FF0000"));
                }
                if (!c11) {
                    coordonnee11.setTextColor(Color.parseColor("#FF0000"));
                }
                if (!c12) {
                    coordonnee12.setTextColor(Color.parseColor("#FF0000"));
                }
                if (!c13) {
                    coordonnee13.setTextColor(Color.parseColor("#FF0000"));
                }
                if (c1) { // Passage en vert des valeurs correctes
                    coordonnee1.setTextColor(Color.parseColor("#57d53b"));
                }
                if (c2) {
                    coordonnee2.setTextColor(Color.parseColor("#57d53b"));
                }
                if (c4) {
                    coordonnee4.setTextColor(Color.parseColor("#57d53b"));
                }
                if (c5) {
                    coordonnee5.setTextColor(Color.parseColor("#57d53b"));
                }
                if (c7) {
                    coordonnee7.setTextColor(Color.parseColor("#57d53b"));
                }
                if (c8) {
                    coordonnee8.setTextColor(Color.parseColor("#57d53b"));
                }
                if (c10) {
                    coordonnee10.setTextColor(Color.parseColor("#57d53b"));
                }
                if (c11) {
                    coordonnee11.setTextColor(Color.parseColor("#57d53b"));
                }
                if (c12) {
                    coordonnee12.setTextColor(Color.parseColor("#57d53b"));
                }
                if (c13) {
                    coordonnee13.setTextColor(Color.parseColor("#57d53b"));
                }


                if (nbClick == 0) { // Affichage du nombre d'essai restant en fonction de nbClick
                    essai_restant.setText("Essais restant : " + (3 - nbClick));
                }
                if (nbClick == 1) {
                    essai_restant.setText("Essais restant : " + (3 - nbClick));
                }
                if (nbClick == 2) {
                    essai_restant.setText("Essais restant : " + (3 - nbClick));
                }
                if (nbClick == 3) {
                    essai_restant.setText("Essais restant : " + (3 - nbClick));
                }

                Integer essai = nbClick; // Sauvegarde de la valeur de nbClick dans les preferences
                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("20", essai);
                editor.apply();

            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            /* Si l'utilisateur clique */
            public void onClick(View v) {
                vib.vibrate(10);
                Intent retour_menu = new Intent(CoordonneeActivity.this, QuestionnaireActivity.class);
                startActivity(retour_menu); // REdirige l'utilisateur vers le menu lors du retour
            }
        });

        Save.setOnClickListener(new View.OnClickListener() { //Permet de sauvegarder les valeurs de l'utilisateurs
            /* Si l'utilisateur clique */
            public void onClick(View v) {
                vib.vibrate(10);

                retour.setEnabled(true); // Débloque le bouton retour
                if (nbClick < 3) {
                    coordonnee.setEnabled(true); // Débloque le bouton vérification si nbClick < 3
                } else {
                    coordonnee.setEnabled(false); // Bloque le bouton vérification si nbClick >= 3
                }


                String sauver = coordonnee1.getText().toString();
                String sauver2 = coordonnee2.getText().toString();
                String sauver4 = coordonnee4.getText().toString();
                String sauver5 = coordonnee5.getText().toString();
                String sauver7 = coordonnee7.getText().toString();
                String sauver8 = coordonnee8.getText().toString();
                String sauver10 = coordonnee10.getText().toString();
                String sauver11 = coordonnee11.getText().toString();
                String sauver12 = coordonnee12.getText().toString();
                String sauver13 = coordonnee13.getText().toString();

                SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("1", sauver);
                editor.putString("2", sauver2);
                editor.putString("4", sauver4);
                editor.putString("5", sauver5);
                editor.putString("7", sauver7);
                editor.putString("8", sauver8);
                editor.putString("10", sauver10);
                editor.putString("11", sauver11);
                editor.putString("12", sauver12);
                editor.putString("13", sauver13);
                editor.putBoolean("c1", c1);
                editor.putBoolean("c2", c2);
                editor.putBoolean("c4", c4);
                editor.putBoolean("c5", c5);
                editor.putBoolean("c7", c7);
                editor.putBoolean("c8", c8);
                editor.putBoolean("c10", c10);
                editor.putBoolean("c11", c11);
                editor.putBoolean("c12", c12);
                editor.putBoolean("c13", c13);
                editor.apply();

            }
        });

    }

    public void onBackPressed() {}

}
