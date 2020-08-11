package tdc.edu.vn.drawingfun;


import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private DrawingView smileyView;
    private ImageButton currPaint, btnDo, btnCam, btnVang, btnXanhLa, btnXanhDuong, btnXanhDam, btnSave,drawBtn, eraseBtn;;
    LinearLayout paintLayout;
    ImageView img1, img2, img3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setControl();
        setEvent();
        smileyView = findViewById(R.id.SmileyView);
        paintLayout = findViewById(R.id.paint_colors);
        currPaint = (ImageButton)paintLayout.getChildAt(0);
        //currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));




    }

    public void paintClicked(View view){
        //use chosen color
        if(view!=currPaint){
            //update color
            ImageButton imgView = (ImageButton) view;
            String color = view.getTag().toString();
            smileyView.setColor(color);
            imgView.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
            currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint));
            currPaint = (ImageButton) view;
        }
    }

    private void setEvent() {
        eraseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smileyView.setErase(true);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Bạn muốn lưu hình ảnh?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        smileyView.setDrawingCacheEnabled(true);

                        String imageSaved = MediaStore.Images.Media.insertImage(getContentResolver(), smileyView.getDrawingCache(), UUID.randomUUID().toString() + ".png", "drawing");
                        if (imageSaved != null) {
                            Toast.makeText(getApplicationContext(), "Luu Thanh Cong", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Luu That Bai", Toast.LENGTH_LONG).show();
                        }
                        smileyView.destroyDrawingCache();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        btnDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smileyView.setColor("#FFFF0000");
                smileyView.setErase(false);

            }

        });

        btnCam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smileyView.setColor("#FFFF6600");
                smileyView.setErase(false);

            }
        });

        btnVang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smileyView.setColor("#FFFFCC00");
                smileyView.setErase(false);
            }
        });

        btnXanhLa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smileyView.setColor("#FF009900");
                smileyView.setErase(false);
            }
        });

        btnXanhDuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smileyView.setColor("#FF009999");
                smileyView.setErase(false);
            }
        });

        btnXanhDam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smileyView.setColor("#FF0000FF");
                smileyView.setErase(false);
            }
        });



        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smileyView.setBackgroundResource(R.drawable.unnamed);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smileyView.setBackgroundResource(R.drawable.unnamed1);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smileyView.setBackgroundResource(R.drawable.unnamed2);
            }
        });


    }

    private void setControl() {


        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        btnDo = findViewById(R.id.btnDo);
        btnVang = findViewById(R.id.btnVang);
        btnCam = findViewById(R.id.btnCam);
        btnXanhLa = findViewById(R.id.btnXanhLa);
        btnXanhDuong = findViewById(R.id.btnXanhDuong);
        btnXanhDam = findViewById(R.id.btnXanhDam);

        btnSave = findViewById(R.id.save_btn);
        eraseBtn = findViewById(R.id.erase_btn);
    }
}
