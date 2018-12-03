package com.example.dmajr_nbsa.projetomobile;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Fase2Activity extends AppCompatActivity {
    private ImageView a1,b1,c1,d1,e1,f1;
    private Button bt_proximo1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase2);

        a1 = (ImageView) findViewById(R.id.img11);
        b1 = (ImageView) findViewById(R.id.img21);
        c1 = (ImageView) findViewById(R.id.img31);
        d1 = (ImageView) findViewById(R.id.img41);
        e1 = (ImageView) findViewById(R.id.img51);
        f1 = (ImageView) findViewById(R.id.img61);

        a1.setOnLongClickListener(longClickListener);
        b1.setOnLongClickListener(longClickListener);
        c1.setOnLongClickListener(longClickListener);

        d1.setOnDragListener(dragListener);
        e1.setOnDragListener(dragListener);
        f1.setOnDragListener(dragListener);

        bt_proximo1 = (Button)findViewById(R.id.btnProximo1);
    }


    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,myShadowBuilder,v,0);
            return false;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
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

                    if (view.getId() == R.id.img11 && v.getId() == R.id.img51){
                        e1.setVisibility(View.INVISIBLE);
                        Toast.makeText(Fase2Activity.this, "PARABÉNS! VOCÊ ACERTOU !!",Toast.LENGTH_SHORT).show();
                    }
                    else if (view.getId() == R.id.img21 && v.getId() == R.id.img61){
                        f1.setVisibility(View.INVISIBLE);
                        Toast.makeText(Fase2Activity.this, "PARABÉNS! VOCÊ ACERTOU !!",Toast.LENGTH_SHORT).show();
                    }
                    else if (view.getId() == R.id.img31 && v.getId() == R.id.img41){
                        d1.setVisibility(View.INVISIBLE);
                        Toast.makeText(Fase2Activity.this, "PARABÉNS! VOCÊ ACERTOU !!",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Fase2Activity.this, "Você errou! Tente Novamente!",Toast.LENGTH_SHORT).show();
                    }


                    break;
            }
            bt_proximo1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent ia = new Intent(Fase2Activity.this,FinalActivity.class);
                    startActivity(ia);
                }
            });
            return true;
        }
    };

}