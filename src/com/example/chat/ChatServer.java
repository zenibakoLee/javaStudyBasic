package com.example.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        // 공유객체에서 쓰레드에 안전한 리스트를 만든다.
        List<PrintWriter> outList = Collections.synchronizedList(new ArrayList<>());
        while(true){
            Socket socket = serverSocket.accept();
            System.out.println("접속: "+socket);
            ChatThread chatThread = new ChatThread(socket,outList);
            chatThread.start();
        }
        //실행 후 telnet localhost 9999로 접근
    }
}

class ChatThread extends  Thread{
    private Socket socket;
    private List<PrintWriter> outList;
    private PrintWriter out;
    private BufferedReader in;

    public ChatThread(Socket socket, List<PrintWriter> outList) throws IOException {
        this.socket = socket;
        this.outList = outList;
        //1. socket 으로부터 읽어들일 수 있는 객체를 얻는다.
        //2. socket 으로부터 쓰기위한 객체를 얻는다.
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        outList.add(out);
    }

    public void run() {
        String line = null;
        //3. client가 보낸 메세지를 읽는다.
        //4. 접속된 모든 클라이언트에게 메세지를 broadcast한다.
        while(true){
            try {

                while((line=in.readLine())!=null){
                    for(int i=0;i<outList.size();i++){ // 접속한 모든 클라이언트에게 메세지를 전송한다.
                        PrintWriter o = outList.get(i);
                        o.println(line);
                        o.flush(); //flush() 메서드를 호출하여 버퍼에 남아있는 데이터 전송
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally { // 접속이 끊어질 때
                System.out.println("run() finally block");
                try{
                    outList.remove(out);
                }catch (Exception e){
                    e.printStackTrace();
                }

                for(int i=0;i<outList.size();i++){ // 접속한 모든 클라이언트에게 메세지를 전송한다.
                    PrintWriter o = outList.get(i);
                    o.println("어떤 클라이언트가 접속을 종료했어요.");
                    o.flush(); //flush() 메서드를 호출하여 버퍼에 남아있는 데이터 전송
                }
                try{
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }


            }

        }
    }
}