package com.example.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class VerySimpleServer {
    public static void main(String[] args) throws Exception {
        //9090 port wait
        ServerSocket ss = new ServerSocket(9090);
        //wait client
        //if client connect,
        //brower 127.0.0.1:9090
        System.out.println("wait client connect");
        Socket socket = ss.accept();
        // Stream object can communicate with client
        OutputStream out = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
        InputStream in = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String firstLine = br.readLine();
        List<String> headers = new ArrayList<>();
        String line;
        //when meet blank line, ends reading
        while(!(line=br.readLine()).equals("")){
            headers.add(line);
        }
        System.out.println("firstLine: "+firstLine);
        System.out.println("=========header info========");
        for(int i=0;i<headers.size();i++){
            System.out.println(headers.get(i));
        }

//        byte[] buffer =  new byte[512];
//        int readCount = 0;
//
//        while((readCount=in.read(buffer))!=-1){
//            System.out.write(buffer,0,readCount);
//        }
//
//        System.out.println(socket.toString());

        pw.println("HTTP/1.1 200 OK"); // 상태메세지
        pw.println("name: zenibako"); // 헤더1
        pw.println("email: zenibako.lee@gmail.com"); //헤더2
        pw.println(""); //빈줄
        pw.println("<html>"); //이하 내용
        pw.println("<h1>hello</h1>");
        pw.println("</html>");
        pw.close();
        ss.close();
        System.out.println("quit server");

    }
}
