package com.example.minhaj.viewtransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private FrameLayout sceneRoot;
    private Button button1,button2;
    private Scene sceneA,sceneB;

    private boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.scene);

        //button1 = relativeLayout.findViewById(R.id.button1);
        //button2 = relativeLayout.findViewById(R.id.button2);
        sceneRoot = (FrameLayout) findViewById(R.id.rootScene);
        sceneA = Scene.getSceneForLayout(sceneRoot,R.layout.scene_a,this);
        sceneB = Scene.getSceneForLayout(sceneRoot,R.layout.scene_b,this);

        sceneA.enter();
        /*button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
                doWork("a");
            }
        });*/

    }

    public void transitionSceneB(View view){
        TransitionManager.go(sceneB);
    }

    public void transitionSceneA(View view){
        TransitionManager.go(sceneA);
    }

    private void doWork(String x){
        if (x.equals("a")){
            TransitionManager.go(sceneB);
            FrameLayout frameLayout = (FrameLayout) sceneB.getSceneRoot();
            button2 = frameLayout.findViewById(R.id.button1);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doWork("b");
                }
            });
        }else if (x.equals("b")){
            TransitionManager.go(sceneA);
            FrameLayout frameLayout = (FrameLayout) sceneA.getSceneRoot();
            button1 = frameLayout.findViewById(R.id.button1);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    doWork("a");
                }
            });
        }
    }
}
