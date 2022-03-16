package com.hackztalk.profilepic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.File;
import java.io.OutputStream;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {


    ImageView mainimg, frame,ivfollow2;
    Button savebtn, selectbtn;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        mainimg = findViewById(R.id.mainimg);
        frame = findViewById(R.id.frame);
        savebtn = findViewById(R.id.savedbtn);
        selectbtn = findViewById(R.id.selectbtn);
        constraintLayout = findViewById(R.id.constraintLayout);
        savebtn.setEnabled(false);
        ivfollow2 = findViewById(R.id.ivfollow2);

        ivfollow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gotoUrl("https://www.instagram.com/_whyanil/");

            }
        });


        frame.setImageResource(getIntent().getIntExtra("frame", 0));

        selectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CropImage.activity()
                        .setGuidelines(CropImageView.Guidelines.ON)
                        .setAspectRatio(1, 1)
                        .start(MainActivity2.this);

            }
        });

        saver();

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                savebtn.setEnabled(true);
                selectbtn.setText("Change Image");
                Uri resultUri = result.getUri();
                mainimg.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }

    public void saver() {

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                constraintLayout.setDrawingCacheEnabled(true);
                constraintLayout.buildDrawingCache();
                constraintLayout.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
                Bitmap bitmap = constraintLayout.getDrawingCache();
                save(bitmap);

            }

            private void save(Bitmap bitmap) {


                OutputStream fos;

                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {

                        ContentResolver contentResolver = getContentResolver();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, System.currentTimeMillis());
                        contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg");
                        contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES+ File.separator+"Profile Pic");
                        Uri imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);

                        fos = contentResolver.openOutputStream(Objects.requireNonNull(imageUri));
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                        Objects.requireNonNull(fos);
                        Toast.makeText(MainActivity2.this, "Image Saved SuccessFully...", Toast.LENGTH_SHORT).show();

                    }
                }catch (Exception e){

                    Toast.makeText(MainActivity2.this, "Error :  "+e.toString(), Toast.LENGTH_SHORT).show();

                }

            }
        });


    }


    public void gotoUrl(String s){

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }


}