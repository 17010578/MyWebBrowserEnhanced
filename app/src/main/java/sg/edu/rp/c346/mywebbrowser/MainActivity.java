package sg.edu.rp.c346.mywebbrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnLoadURL;
    WebView wvMyPage;
    EditText etURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wvMyPage = findViewById(R.id.webViewMyPage);
        btnLoadURL = findViewById(R.id.buttonLoad);
        etURL = findViewById(R.id.editText);

        wvMyPage.setWebViewClient(new WebViewClient());


        btnLoadURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etURL.length()!=0) {
                    String url = etURL.getText().toString();
                    wvMyPage.loadUrl(url);
                    wvMyPage.getSettings().setJavaScriptEnabled(false);
                    wvMyPage.getSettings().setAllowFileAccess(false);
                    wvMyPage.getSettings().setBuiltInZoomControls(true);
                }
                else{
                    Toast.makeText(MainActivity.this,"Please enter link!",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
