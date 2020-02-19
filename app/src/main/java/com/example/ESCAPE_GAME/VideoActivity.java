package com.example.ESCAPE_GAME;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class VideoActivity extends Activity {

    private Button goEscape; //Bouton qui permet d'acceder a l'application
    private TextView text; //Texte afficher a l'ecran
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
        setContentView(R.layout.activity_video);
        /* Activite en plein ecran */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        text = findViewById(R.id.question_info_view); //Lien avec le layout

        //Permet d'avoir le mode justifie
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            text.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        }

        goEscape = findViewById(R.id.go_question_btn); //Lien avec le layout
        vib = (Vibrator) getSystemService(VideoActivity.VIBRATOR_SERVICE); //Mise en place de la vibration
        goEscape.setEnabled(false); //Blocage du bouton tant que la video n'est pas finie

        VideoView videoView = this.findViewById(R.id.video_view); //Lien avec le layout

        //Lecture de la video
        Uri uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(false);
            }

        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                goEscape.setEnabled(true);
                goEscape.setOnClickListener(new View.OnClickListener() {
                    @Override

                    /* L'utilisateur à cliquer sur le bouton */

                    public void onClick(View v) {

                        /* L'utilisateur clique sur le bouton qui le redirige vers une nouvelle activité. */
                        vib.vibrate(10);
                        Intent QuestionActivity = new Intent(VideoActivity.this, QuestionnaireActivity.class);
                        startActivity(QuestionActivity);
                    }
                });
            }
        });

        Log.i("VideoActivity.java", "onCreate");
    }

    public void onBackPressed() {} //Permet de bloquer le bouton retour du telephone

}
