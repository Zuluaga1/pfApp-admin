package com.example.admin;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TCP_Sender extends AsyncTask<String,Void,Void> {
    Socket server;
    DataOutputStream dos;
    PrintWriter pw;
    @Override
    protected Void doInBackground(String... voids) {
        String message = voids[0];
        try{
            server = new Socket("192.168.1.85",10840);
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
