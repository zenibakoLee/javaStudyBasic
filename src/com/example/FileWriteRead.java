package com.example;

import java.io.*;

public class FileWriteRead {
    public static void main(String[] args) throws IOException {
        String customPath = "/tmp/hello.txt";
        Writer out = new FileWriter(customPath);
        out.write((int)'가');  // 3byte
        out.write((int)'나'); // 3byte
        out.write((int)'A'); // 1byte
        out.close();
        Reader in = new FileReader(customPath);
        int ch = -1;
        while((ch=in.read())!=-1){
            System.out.println(ch);
            System.out.println((char)ch);
        }
        in.close();
    }
}
