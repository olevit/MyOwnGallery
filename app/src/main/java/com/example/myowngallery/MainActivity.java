package com.example.myowngallery;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout myGallery;
    ArrayList<String> itemList = new ArrayList<String>();
    ImageView imageView;
    TextView textView;
    private int xx, yy, xx1, yy1, count, count1, xx2, yy2, count2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        myGallery = (LinearLayout) findViewById(R.id.mygallery);

        String externalStorageDirectoryPath = Environment
                .getExternalStorageDirectory().getAbsolutePath();

        //File appDirectory = new File(externalStorageDirectoryPath + "/Pictures/");
        File appDirectory = new File(externalStorageDirectoryPath + "/Android/data/com.example.omnemixsize/files/Pictures/");

        if (!appDirectory.exists()) {
            appDirectory.mkdir();
        }

        File[] files = appDirectory.listFiles();
        for (File file : files) {
            //myGallery.addView(getPhoto(file.getAbsolutePath()));
            int newIdx = itemList.size();
            itemList.add(file.getAbsolutePath());
            myGallery.addView(getImageView(newIdx));
            myGallery.addView(getTextView(newIdx));
        }
    }

    /*View getPhoto(String path) {
        Bitmap bm = decodeSampledBitmapFromUri(path, 220, 220);

        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setLayoutParams(new LinearLayout.LayoutParams(250, 250));
        layout.setGravity(Gravity.CENTER);

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(220, 220));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageBitmap(bm);

        layout.addView(imageView);
        return layout;
    }*/
    ImageView getImageView(final int i) {
        Bitmap bm = null;
        if (i < itemList.size()) {
            bm = decodeSampledBitmapFromUri(itemList.get(i), 400, 400);
        }

        imageView = new ImageView(getApplicationContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(400, 400));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageBitmap(bm);

        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*Toast.makeText(getApplicationContext(),
                        "Выбрано - " + itemList.get(i), Toast.LENGTH_LONG)
                        .show();*/
                BitmapDrawable mydrawable = (BitmapDrawable) imageView.getDrawable();
                Bitmap b = mydrawable.getBitmap();
                int width = b.getWidth() / 10;
                int height = b.getHeight() / 10;
                Bitmap b1 = Bitmap.createScaledBitmap(b, width, height,false );
                doInvert(b1);
                textView.setText("("+ xx + ", " + yy + ")  " + "count: " + count + "\n" +"("+ xx1 + ", "+ yy1 + ") " +
                        "count1: "+ count1 + "\n" + "(" + xx2 + ", " + yy2+")" + " count3: "+ count2 );
                //bitmap1 = doInvert(bitmap1);

            }
        });

        return imageView;
    }
    TextView getTextView(int i){
        TextView textView = new TextView(getApplicationContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(1000, 200));
        textView.setTextSize(16);

        //textView.setText(itemList.get(i));
        textView.setText("("+ xx + ", " + yy + ")  " + "count: " + count + "\n" +"("+ xx1 + ", "+ yy1 + ") " +
                "count1: "+ count1 + "\n" + "(" + xx2 + ", " + yy2+")" + " count3: "+ count2 );
        return textView;
    }
    public Bitmap decodeSampledBitmapFromUri(String path, int reqWidth,
                                             int reqHeight) {
        Bitmap bm = null;

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(path, options);

        return bm;
    }

    public int calculateInSampleSize(

            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float) height / (float) reqHeight);
            } else {
                inSampleSize = Math.round((float) width / (float) reqWidth);
            }
        }
        return inSampleSize;
    }
    public void doInvert(Bitmap src) {
        Bitmap bmOut = Bitmap.createBitmap(src.getWidth(), src.getHeight(), src.getConfig());
        int  R, G, B, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18,
                R19, R20, R21, R22, R23, R24, R25, R26, R27, R28, R29, R30, R31, R32, R33, R34, R35, R36, R37,
                R38, R39, R40, R41, R42, R43, R44, R45, R46, R47, R48, R49, R50, R51, R52, R53, R54, R55, R56, R57, R58, R59, B1, B2,B3, B4,B5, B6, B7,B8, B9,B10, B11,B12, B13, B14, B15,
                B16, B17,B18,B19,B20,B21, B22, B23, B24,B25,B26,B27,B28, B29, B30, B31, B32, B33, B34, B35,
                B36, B37, B38, B39, B40, B41, B42, B43, B44, B45, B46, B47, B48, B49, B50, B51, B52, B53, B54, B55, B56, B57, B58, B59, G1, G2, G3, G4, G5, G6, G7, G8, G9, G10, G11, G12,
                G13, G14, G15, G16,  G17, G18, G19, G20, G21, G22, G23,  G24, G25, G26, G27, G28, G29,
                G30, G31, G32,  G33, G34, G35, G36, G37, G38, G39,  G40, G41, G42, G43, G44, G45,  G46, G47, G48, G49, G50, G51, G52, G53, G54, G55,  G56, G57, G58, G59;
        int pixelColor, pixelColor1, pixelColor2, pixelColor3, pixelColor4, pixelColor5, pixelColor6,
                pixelColor7, pixelColor8, pixelColor9, pixelColor10, pixelColor11, pixelColor12,
                pixelColor13, pixelColor14, pixelColor15, pixelColor16, pixelColor17, pixelColor18,
                pixelColor19, pixelColor20,pixelColor21, pixelColor22, pixelColor23, pixelColor24,
                pixelColor25, pixelColor26, pixelColor27, pixelColor28, pixelColor29, pixelColor30,
                pixelColor31, pixelColor32, pixelColor33, pixelColor34, pixelColor35, pixelColor36,
                pixelColor37, pixelColor38, pixelColor39, pixelColor40, pixelColor41, pixelColor42,
                pixelColor43, pixelColor44, pixelColor45, pixelColor46, pixelColor47, pixelColor48,
                pixelColor49, pixelColor50, pixelColor51, pixelColor52, pixelColor53, pixelColor54,
                pixelColor55, pixelColor56, pixelColor57, pixelColor58, pixelColor59;
        int height = src.getHeight();
        int width = src.getWidth();
        for (int y = 10; y < height - 9; y++)
        {
            for (int x = 15; x < width - 14; x++)
            {
                // работаем с отдельным пикселем
                pixelColor = src.getPixel(x, y);
                pixelColor1 = src.getPixel(x + 1, y );
                pixelColor2 = src.getPixel(x - 2, y);
                pixelColor3 = src.getPixel(x + 2, y);
                pixelColor4 = src.getPixel( x + 3 , y);
                pixelColor5 = src.getPixel(x + 1,y + 1);
                pixelColor6 = src.getPixel(x, y - 2);
                pixelColor7 = src.getPixel(x, y + 2);
                pixelColor8 = src.getPixel(x + 2,y  + 2);
                pixelColor9 = src.getPixel(x + 3, y + 3);
                pixelColor10 = src.getPixel(x, y + 1);
                pixelColor11 = src.getPixel(x - 2 ,y + 2);
                pixelColor12 = src.getPixel(x, y + 3);
                pixelColor13 = src.getPixel(x ,y - 2);
                pixelColor14 = src.getPixel(x + 1 ,y + 2);
                pixelColor15 = src.getPixel(x ,y - 3);
                pixelColor16 = src.getPixel(x + 1 , y - 2);
                pixelColor17 = src.getPixel(x + 2,y  - 2);
                pixelColor18 = src.getPixel(x + 3,y  - 3);
                pixelColor19 = src.getPixel(x - 2, y - 2);
                pixelColor20 = src.getPixel(x - 1, y + 1);
                pixelColor21 = src.getPixel(x, y + 2);
                pixelColor22 = src.getPixel(x - 2, y - 2);
                pixelColor23 = src.getPixel(x - 3, y - 2);
                pixelColor24 = src.getPixel(x - 4, y - 2);
                pixelColor25 = src.getPixel(x - 1, y - 2);
                pixelColor26 = src.getPixel(x + 3, y - 2);
                pixelColor27 = src.getPixel(x + 4, y - 2);
                pixelColor28 = src.getPixel(x - 5, y - 2);
                pixelColor29 = src.getPixel(x - 6,y - 2);
                pixelColor30 = src.getPixel(x - 7,y - 2);
                pixelColor31 = src.getPixel(x - 8,y - 2);
                pixelColor32 = src.getPixel(x - 9 ,y - 2);
                pixelColor33 = src.getPixel(x - 10,y - 2);
                pixelColor34 = src.getPixel(x - 11,y - 2);
                pixelColor35 = src.getPixel(x - 12, y - 2);
                pixelColor36 = src.getPixel(x + 5, y - 2);
                pixelColor37 = src.getPixel(x + 6, y - 2);
                pixelColor38 = src.getPixel(x + 7, y - 2);
                pixelColor39 = src.getPixel(x + 8, y - 2);
                pixelColor40 = src.getPixel(x + 9, y - 2);
                pixelColor41 = src.getPixel(x + 10, y - 2);
                pixelColor42 = src.getPixel(x + 11, y - 2);
                pixelColor43 = src.getPixel(x + 12, y - 2);
                pixelColor44 = src.getPixel(x - 1 , y - 2);
                pixelColor45 = src.getPixel(x + 1, y - 2);
                pixelColor46 = src.getPixel(x + 2, y - 2);
                pixelColor47 = src.getPixel(x - 2, y - 1);
                pixelColor48 = src.getPixel(x - 2, y + 1);
                pixelColor49 = src.getPixel(x - 1, y + 2);
                pixelColor50 = src.getPixel(x - 2, y - 7);
                pixelColor51 = src.getPixel(x - 2, y - 6);
                pixelColor52 = src.getPixel(x - 2, y - 5);
                pixelColor53 = src.getPixel(x - 2, y - 4);
                pixelColor54 = src.getPixel(x - 2 ,y - 3);
                pixelColor55 = src.getPixel(x + 3,y + 2 );
                pixelColor56 = src.getPixel(x + 4,y + 2);
                pixelColor57 = src.getPixel(x + 5, y + 2);
                pixelColor58 = src.getPixel(x + 6, y + 2);
                pixelColor59 = src.getPixel(x + 7, y + 2);





                // сохраняем alpha-канал
                //A = Color.alpha(pixelColor);
                // инвертируем байт каждого R/G/B канала
                R = Color.red(pixelColor);
                R1 = Color.red(pixelColor1);
                R2 = Color.red(pixelColor2);
                R3 = Color.red(pixelColor3);
                R4 = Color.red(pixelColor4);
                R5 = Color.red(pixelColor5);
                R6 = Color.red(pixelColor6);
                R7 = Color.red(pixelColor7);
                R8 = Color.red(pixelColor8);
                R9 = Color.red(pixelColor9);
                R10 = Color.red(pixelColor10);
                R11 = Color.red(pixelColor11);
                R12 = Color.red(pixelColor12);
                R13 = Color.red(pixelColor13);
                R14 = Color.red(pixelColor14);
                R15 = Color.red(pixelColor15);
                R16 = Color.red(pixelColor16);
                R17 = Color.red(pixelColor17);
                R18 = Color.red(pixelColor18);
                R19 = Color.red(pixelColor19);
                R20 = Color.red(pixelColor20);
                R21 = Color.red(pixelColor21);
                R22 = Color.red(pixelColor22);
                R23 = Color.red(pixelColor23);
                R24 = Color.red(pixelColor24);
                R25 = Color.red(pixelColor25);
                R26 = Color.red(pixelColor26);
                R27 = Color.red(pixelColor27);
                R28 = Color.red(pixelColor28);
                R29 = Color.red(pixelColor29);
                R30 = Color.red(pixelColor30);
                R31 = Color.red(pixelColor31);
                R32 = Color.red(pixelColor32);
                R33 = Color.red(pixelColor33);
                R34 = Color.red(pixelColor34);
                R35 = Color.red(pixelColor35);
                R36 = Color.red(pixelColor36);
                R37 = Color.red(pixelColor37);
                R38 = Color.red(pixelColor38);
                R39 = Color.red(pixelColor39);
                R40 = Color.red(pixelColor40);
                R41 = Color.red(pixelColor41);
                R42 = Color.red(pixelColor42);
                R43 = Color.red(pixelColor43);
                R44 = Color.red(pixelColor44);
                R45 = Color.red(pixelColor45);
                R46 = Color.red(pixelColor46);
                R47 = Color.red(pixelColor47);
                R48 = Color.red(pixelColor48);
                R49 = Color.red(pixelColor49);
                R50 = Color.red(pixelColor50);
                R51 = Color.red(pixelColor51);
                R52 = Color.red(pixelColor52);
                R53 = Color.red(pixelColor53);
                R54 = Color.red(pixelColor54);
                R55 = Color.red(pixelColor55);
                R56 = Color.red(pixelColor56);
                R57 = Color.red(pixelColor57);
                R58 = Color.red(pixelColor58);
                R59 = Color.red(pixelColor59);

                G = Color.green(pixelColor);
                G1 = Color.green(pixelColor1);
                G2 = Color.green(pixelColor2);
                G3 = Color.green(pixelColor3);
                G4 = Color.green(pixelColor4);
                G5 = Color.green(pixelColor5);
                G6 = Color.green(pixelColor6);
                G7 = Color.green(pixelColor7);
                G8 = Color.green(pixelColor8);
                G9 = Color.green(pixelColor9);
                G10 = Color.green(pixelColor10);
                G11 = Color.green(pixelColor11);
                G12 = Color.green(pixelColor12);
                G13 = Color.green(pixelColor13);
                G14 = Color.green(pixelColor14);
                G15 = Color.green(pixelColor15);
                G16 = Color.green(pixelColor16);
                G17 = Color.green(pixelColor17);
                G18 = Color.green(pixelColor18);
                G19 = Color.green(pixelColor19);
                G20 = Color.green(pixelColor20);
                G21 = Color.green(pixelColor21);
                G22 = Color.green(pixelColor22);
                G23 = Color.green(pixelColor23);
                G24 = Color.green(pixelColor24);
                G25 = Color.green(pixelColor25);
                G26 = Color.green(pixelColor26);
                G27 = Color.green(pixelColor27);
                G28 = Color.green(pixelColor28);
                G29 = Color.green(pixelColor29);
                G30 = Color.green(pixelColor30);
                G31 = Color.green(pixelColor31);
                G32 = Color.green(pixelColor32);
                G33 = Color.green(pixelColor33);
                G34 = Color.green(pixelColor34);
                G35 = Color.green(pixelColor35);
                G36 = Color.green(pixelColor36);
                G37 = Color.green(pixelColor37);
                G38 = Color.green(pixelColor38);
                G39 = Color.green(pixelColor39);
                G40 = Color.green(pixelColor40);
                G41 = Color.green(pixelColor41);
                G42 = Color.green(pixelColor42);
                G43 = Color.green(pixelColor43);
                G44 = Color.green(pixelColor44);
                G45 = Color.green(pixelColor45);
                G46 = Color.green(pixelColor46);
                G47 = Color.green(pixelColor47);
                G48 = Color.green(pixelColor48);
                G49 = Color.green(pixelColor49);
                G50 = Color.green(pixelColor50);
                G51 = Color.green(pixelColor51);
                G52 = Color.green(pixelColor52);
                G53 = Color.green(pixelColor53);
                G54 = Color.green(pixelColor54);
                G55 = Color.green(pixelColor55);
                G56 = Color.green(pixelColor56);
                G57 = Color.green(pixelColor57);
                G58 = Color.green(pixelColor58);
                G59 = Color.green(pixelColor59);


                B = Color.blue(pixelColor);
                B1 = Color.blue(pixelColor1);
                B2 = Color.blue(pixelColor2);
                B3 = Color.blue(pixelColor3);
                B4 = Color.blue(pixelColor4);
                B5 = Color.blue(pixelColor5);
                B6 = Color.blue(pixelColor6);
                B7 = Color.blue(pixelColor7);
                B8 = Color.blue(pixelColor8);
                B9 = Color.blue(pixelColor9);
                B10 = Color.blue(pixelColor10);
                B11 = Color.blue(pixelColor11);
                B12 = Color.blue(pixelColor12);
                B13 = Color.blue(pixelColor13);
                B14 = Color.blue(pixelColor14);
                B15 = Color.blue(pixelColor15);
                B16 = Color.blue(pixelColor16);
                B17 = Color.blue(pixelColor17);
                B18 = Color.blue(pixelColor18);
                B19 = Color.blue(pixelColor19);
                B20 = Color.blue(pixelColor20);
                B21 = Color.blue(pixelColor21);
                B22 = Color.blue(pixelColor22);
                B23 = Color.blue(pixelColor23);
                B24 = Color.blue(pixelColor24);
                B25 = Color.blue(pixelColor25);
                B26 = Color.blue(pixelColor26);
                B27 = Color.blue(pixelColor27);
                B28 = Color.blue(pixelColor28);
                B29 = Color.blue(pixelColor29);
                B30 = Color.blue(pixelColor30);
                B31 = Color.blue(pixelColor31);
                B32 = Color.blue(pixelColor32);
                B33 = Color.blue(pixelColor33);
                B34 = Color.blue(pixelColor34);
                B35 = Color.blue(pixelColor35);
                B36 = Color.blue(pixelColor36);
                B37 = Color.blue(pixelColor37);
                B38 = Color.blue(pixelColor38);
                B39 = Color.blue(pixelColor39);
                B40 = Color.blue(pixelColor40);
                B41 = Color.blue(pixelColor41);
                B42 = Color.blue(pixelColor42);
                B43 = Color.blue(pixelColor43);
                B44 = Color.blue(pixelColor44);
                B45 = Color.blue(pixelColor45);
                B46 = Color.blue(pixelColor46);
                B47 = Color.blue(pixelColor47);
                B48 = Color.blue(pixelColor48);
                B49 = Color.blue(pixelColor49);
                B50 = Color.blue(pixelColor50);
                B51 = Color.blue(pixelColor51);
                B52 = Color.blue(pixelColor52);
                B53 = Color.blue(pixelColor53);
                B54 = Color.blue(pixelColor54);
                B55 = Color.blue(pixelColor55);
                B56 = Color.blue(pixelColor56);
                B57 = Color.blue(pixelColor57);
                B58 = Color.blue(pixelColor58);
                B59 = Color.blue(pixelColor59);



                if((R > 147 ) && (G > 140) && (B > 135)&&
                        (R2 < 157) && (G2 < 105) && (B2 < 100) &&
                        (R6 < 157) && (G6 < 105) && (B6 < 100) &&
                        (R19 < 157) && (G19 < 105) && (B19 < 100) &&
                        (R1 > 147) && (G1 > 140) && (B1 > 135)&&
                        (R3 > 147) && (G3 > 140) && (B3 > 135)&&
                        (R4 > 147) && (G4 > 140) && (B4 > 135)&&
                        (R8 > 147) && (G8 > 140) && (B8 > 135)&&
                        (R9 > 147) && (G9 > 140) && (B9 > 135)&&
                        (R10 > 147) && (G10 > 140) && (B10 > 135)&&
                        (R7 > 147) && (G7 > 140) && (B7 > 135) &&
                        (R12 > 147) && (G12 > 140) && (B12 > 135) &&
                        (R5 > 147) && (G5 > 140) && (B5 > 135) &&
                        (R44 < 157) && (G44 < 105) && (B44 < 100)&&
                        (R45 < 157) && (G45 < 105) && (B45 < 100)&&
                        (R46 < 157) && (G46 < 105) && (B46 < 100)&&
                        (R47 < 157) && (G47 < 105) && (B47 < 100)&&
                        (R48 < 157) && (G48 < 105) && (B48 < 100)&&
                        (R11 < 157) && (G11 < 105) && (B11 < 100)) {
                    if(count == 1){
                        break;
                    }
                    xx = x;
                    yy = y;
                    count++;
                }
                else if((R > 95) && (G > 85) && (B > 80)&&
                        (R2 < 170) && (G2 < 110) && (B2 < 100) &&
                        (R7 < 170) && (G7 < 110) && (B7 < 100) &&
                        (R11 < 170) && (G11 < 110) && (B11 < 100) &&
                        (R1 > 95) && (G1 > 85) && (B1 > 80) &&
                        (R3 > 95) && (G3 > 85) && (B3 > 80) &&
                        (R4 > 95) && (G4 > 85) && (B4 > 80) &&
                        (R13 > 95) && (G13 > 85) && (B13 > 80) &&
                        (R6 > 95) && (G6 > 85) && (B6 > 80) &&
                        (R15 > 95) && (G15 > 85) && (B15 > 80) &&
                        (R16 > 95) && (G16 > 85) && (B16 > 80) &&
                        (R17 > 95) && (G17 > 85) && (B17 > 80) &&
                        (R18 > 95) && (G18 > 85) && (B18 > 80) &&
                        (R19 < 170) && (G19 < 110) && (B19 < 100) &&
                        (R47 < 170) && (G47 < 110) && (B47 < 100) &&
                        (R48 < 170) && (G48 < 110) && (B48 < 100) &&
                        (R49 < 170) && (G49 < 110) && (B49 < 100) &&
                        (R14 < 170) && (G14 < 110) && (B14 < 100) &&
                        (R8 < 170) && (G8 < 110) && (B8 < 100) &&
                        (R50 < 170) && (G50 < 110) && (B50 < 100) &&
                        (R51 < 170) && (G51 < 110) && (B51 < 100) &&
                        (R52 < 170) && (G52 < 110) && (B52 < 100) &&
                        (R53 < 170) && (G53 < 110) && (B53 < 100) &&
                        (R54 < 170) && (G54 < 110) && (B54 < 100) &&
                        (R55 < 170) && (G55 < 110) && (B55 < 100) &&
                        (R56 < 170) && (G56 < 110) && (B56 < 100) &&
                        (R57 < 170) && (G57 < 110) && (B57 < 100) &&
                        (R58 < 170) && (G58 < 110) && (B58 < 100) &&
                        (R59 < 170) && (G59 < 110) && (B59 < 100)){
                    if(count1 == 1){
                        break;
                    }
                    xx1 = x;
                    yy1 = y;
                    count1++;
                }

                else if ((R < 128) && (G < 116) && (B < 136)&&
                        (R13 > 112) && (G13 > 91) && (B13 > 104) &&
                        (R17 > 112) && (G17 > 91) && (B17 > 104) &&
                        (R16 > 112) && (G16 > 91) && (B16 > 104) &&
                        (R22 > 112) && (G22 > 91) && (B22 > 104) &&
                        (R23 > 112) && (G23 > 91) && (B23 > 104) &&
                        (R24 > 112) && (G24 > 91) && (B24 > 104) &&
                        (R25 > 112) && (G25 > 91) && (B25 > 104) &&
                        (R26 > 112) && (G26 > 91) && (B26 > 104) &&
                        (R27 > 112) && (G27 > 91) && (B27 > 104) &&
                        (R28 > 112) && (G28 > 91) && (B28 > 104) &&
                        (R29 > 112) && (G29 > 91) && (B29 > 104) &&
                        (R30 > 112) && (G30 > 91) && (B30 > 104) &&
                        (R31 > 112) && (G31 > 91) && (B31 > 104) &&
                        (R32 > 112) && (G32 > 91) && (B32 > 104) &&
                        (R33 > 112) && (G33 > 91) && (B33 > 104) &&
                        (R34 > 112) && (G34 > 91) && (B34 > 104) &&
                        (R35 > 112) && (G35 > 91) && (B35 > 104) &&
                        (R36 > 112) && (G36 > 91) && (B36 > 104) &&
                        (R37 > 112) && (G37 > 91) && (B37 > 104) &&
                        (R38 > 112) && (G38 > 91) && (B38 > 104) &&
                        (R39 > 112) && (G39 > 91) && (B39 > 104) &&
                        (R40 > 112) && (G40 > 91) && (B40 > 104) &&
                        (R41 > 112) && (G41 > 91) && (B41 > 104) &&
                        (R42 > 112) && (G42 > 91) && (B42 > 104) &&
                        (R43 > 112) && (G43 > 91) && (B43 > 104) &&
                        (R5 < 128) && (G5 < 116) && (B5 < 136) &&
                        (R10 < 128) && (G10 < 116) && (B10 < 136) &&
                        (R20 < 128) && (G20 < 116) && (B20 < 136) &&
                        (R8 < 128) && (G8 < 116) && (B8 < 136) &&
                        (R11 < 128) && (G11 < 116) && (B11 < 136) &&
                        (R21 < 128) && (G21 < 116) && (B21 < 136))
                {
                    if (count2 == 1) {
                        break;
                    }
                    xx2 = x;
                    yy2 = y;
                    count2++;
                }
            }
        }
    }
}