package lt.vtvpmc.ems.zp18_2.androidimageview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    Button btnPrevious;
    Button btnNext;
    TextView textDesc;

    int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.icon};
    String imageDesc[] = {"Vodka", "Friday", "Awesome icon"};

    //Bitmap bitmap;

    private int current_image_index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.imageView);
        btnPrevious = (Button) findViewById(R.id.btnPrevious);
        btnNext = (Button) findViewById(R.id.btnNext);
        textDesc = (TextView) findViewById(R.id.textviewDescription);

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (current_image_index - 1 >= 0) {
                        current_image_index--;
                    } else {
                        current_image_index = images.length - 1;
                    }

                    image.setImageResource(images[current_image_index]);

                    if (current_image_index < imageDesc.length) {
                        textDesc.setText(imageDesc[current_image_index]);
                    } else {
                        textDesc.setText("...");
                    }

                } catch (Exception e) {
                    textDesc.setText(e.toString());
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    current_image_index++;
                    current_image_index = current_image_index % images.length;
                    image.setImageResource(images[current_image_index]);

                    if (current_image_index < imageDesc.length) {
                        textDesc.setText(imageDesc[current_image_index]);
                    } else {
                        textDesc.setText("...");
                    }

                } catch (Exception e) {
                    textDesc.setText(e.toString());
                }
            }
        });

    }
}
