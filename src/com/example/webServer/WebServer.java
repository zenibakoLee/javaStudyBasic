package com.example.webServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

public class WebServer  {
    public static void main(String[] args) throws ExecutionException, IOException {
        // 클라이언트가 접속할 때까지 대기할 때 필요한 객체 : ServerSocket
        ServerSocket serverSocket = new ServerSocket(10000);
        System.out.println("serverSocket instance loaded");
        try{
            while(true){
                Socket clientSocket = serverSocket.accept(); // 대기한다. 클라이언트 접속시 클라이언트와 통신하는 Socket 반환
                System.out.println("client socket loaded");

                ClientThread ct = new ClientThread(clientSocket);
                ct.start();

            }
        }finally{ //자원 누수 방지, 안정적으로 종료
            //서버 소켓(ServerSocket)과 클라이언트 소켓(Socket)을 닫는 코드
            serverSocket.close();
            System.out.println("quit server");
        }
    }

    static class ClientThread extends Thread{
        private Socket clientThreadSocket;
        public ClientThread(Socket clientSocket){
            clientThreadSocket = clientSocket;
        }
        public void run() {
            try{
                InputStream inputStream =  clientThreadSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String firstLine = br.readLine();
                String msg = null;
                if(firstLine.contains("/hello")){
                    msg = "hello";
                }else{
                    System.out.println("firstLine=> "+firstLine);
                }

                String line;
                while(!(line = br.readLine()).equals("")){
                    System.out.println(line);
                }
        /*
        br.close()를 호출하면 내부적으로 사용된 InputStreamReader와 InputStream이 닫히고,
        이에 따라 클라이언트 소켓(Socket)의 입력 스트림도 닫히게 됩니다.
        따라서 서버 소켓(ServerSocket)을 닫고 싶다면,
        serverSocket.close()를 별도로 호출해야 합니다
         */
                OutputStream outputStream = clientThreadSocket.getOutputStream();
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(outputStream));

                pw.println("HTTP/1.1 200 OK"); // 상태메세지
                pw.println("name: zenibako"); // 헤더1
                pw.println("email: zenibako.lee@gmail.com"); //헤더2
                pw.println(); //빈줄
                pw.println("<html>"); //body
                pw.println("message: "+ msg);
                pw.println("</html>");

                pw.flush();
                pw.close();

                clientThreadSocket.close();
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }

}
