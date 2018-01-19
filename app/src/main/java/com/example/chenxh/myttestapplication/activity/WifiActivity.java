package com.example.chenxh.myttestapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.chenxh.myttestapplication.R;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.koushikdutta.async.http.server.HttpServerRequestCallback;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class WifiActivity extends AppCompatActivity {
//    http://blog.csdn.net/lmj623565791/article/details/79081656
    private AsyncHttpServer server = new AsyncHttpServer();
    private AsyncServer mAsyncServer = new AsyncServer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        findViewById(R.id.floating_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.settings.WIFI_SETTINGS");// android.provider.Settings.ACTION_SETTINGS
                startActivity(intent);
            }
        });


        server.get("/", new HttpServerRequestCallback() {
            @Override
            public void onRequest(AsyncHttpServerRequest request, AsyncHttpServerResponse response) {
                try {
                    response.send(getIndexContent());
                } catch (IOException e) {
                    e.printStackTrace();
                    response.code(500).end();
                }
            }
        });

        server.listen(mAsyncServer, 54321);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (server != null) {
            server.stop();
        }
        if (mAsyncServer != null) {
            mAsyncServer.stop();
        }
    }

    private String getIndexContent() throws IOException {
        BufferedInputStream bInputStream = null;
        try {
            bInputStream = new BufferedInputStream(getAssets().open("index.html"));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int len = 0;
            byte[] tmp = new byte[10240];
            while ((len = bInputStream.read(tmp)) > 0) {
                baos.write(tmp, 0, len);
            }
            return new String(baos.toByteArray(), "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (bInputStream != null) {
                try {
                    bInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}