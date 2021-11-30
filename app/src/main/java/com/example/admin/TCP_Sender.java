package com.example.admin;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

@RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
public class TCP_Sender extends AsyncTask<String,Void,Void> {
    Socket server;
    DataOutputStream dos;
    PrintWriter pw;
    @Override
    protected Void doInBackground(String... voids) {
        String message = voids[0];
        try{
            server = new Socket("192.168.1.7",10840);
            pw = new PrintWriter(server.getOutputStream());
            pw.write(message);
            pw.flush();
            //server.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
