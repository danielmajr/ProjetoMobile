package com.example.dmajr_nbsa.projetomobile;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.app.Activity;

public class Fase1Activity extends AppCompatActivity{
    private ImageView a, b, c, d, e, f;
    private Button bt_proximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase1);

        a = (ImageView) findViewById(R.id.img1);
        b = (ImageView) findViewById(R.id.img2);
        c = (ImageView) findViewById(R.id.img3);
        d = (ImageView) findViewById(R.id.img4);
        e = (ImageView) findViewById(R.id.img5);
        f = (ImageView) findViewById(R.id.img6);

        a.setOnLongClickListener(longClickListener);
        b.setOnLongClickListener(longClickListener);
        c.setOnLongClickListener(longClickListener);

        d.setOnDragListener(dragListener);
        e.setOnDragListener(dragListener);
        f.setOnDragListener(dragListener);

        bt_proximo = (Button)findViewById(R.id.btnProximo);
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new DragShadowBuilder(v);
            v.startDrag(data,myShadowBuilder,v,0);
            return false;
        }
    };

    OnDragListener dragListener = new OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent){
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    break;

                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.img1 && v.getId() == R.id.img5){
                        e.setVisibility(View.INVISIBLE);
                        Toast.makeText(Fase1Activity.this, "PARABÉNS! VOCÊ ACERTOU !!",Toast.LENGTH_SHORT).show();
                    }
                    else if (view.getId() == R.id.img2 && v.getId() == R.id.img6){
                        f.setVisibility(View.INVISIBLE);
                        Toast.makeText(Fase1Activity.this, "PARABÉNS! VOCÊ ACERTOU !!",Toast.LENGTH_SHORT).show();
                    }
                    else if (view.getId() == R.id.img3 && v.getId() == R.id.img4){
                        d.setVisibility(View.INVISIBLE);
                        Toast.makeText(Fase1Activity.this, "PARABÉNS! VOCÊ ACERTOU !!",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Fase1Activity.this, "Você errou! Tente Novamente!",Toast.LENGTH_SHORT).show();
                    }


                    break;
            }
            bt_proximo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Fase1Activity.this, "PARABÉNS, VOCÊ PASSOU DE FASE!!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Fase1Activity.this,Fase2Activity.class);
                    startActivity(intent);
                }
            });
            return true;
        }
    };

}