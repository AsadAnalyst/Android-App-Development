package com.example.bsaia.IntentExamples;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bsaia.R;

public class OpenCameraExample extends AppCompatActivity {
    //mage view o bind krne k liye
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_open_camera_example);

        imageView=findViewById(R.id.imgopencamera);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Open_Camera(View view) {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //activity k bd ika result bhi le kr ana ha wapis
        //se camera open kiya then click kr k wapis ana
        startActivityForResult(intent,101);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //@Nullable iska matlb ha k ye fun khali wapis bhi a skta ha
        super.onActivityResult(requestCode, resultCode, data);
        //mage bitmap ma artorehogi
        if(requestCode==101 && resultCode==RESULT_OK)
        {
            Bitmap bitmap= (Bitmap) data.getExtras().get(("data"));
            imageView.setImageBitmap(bitmap);
        }
    }
}