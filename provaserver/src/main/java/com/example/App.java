package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server in ascolto sulla porta 3000");
        Socket s = ss.accept();
        System.out.println("Client connesso");

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String str = br.readLine();
        System.out.println("Client: " + str);

        InputStreamReader in2 = new InputStreamReader(s.getInputStream());
        BufferedReader br2 = new BufferedReader(in2);
        String altezza = br2.readLine();
        float altezzaInMetri = Float.valueOf(altezza);

        InputStreamReader in3 = new InputStreamReader(s.getInputStream());
        BufferedReader br3 = new BufferedReader(in3);
        String peso = br3.readLine();
        float pesoInKg = Float.valueOf(peso);
        

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("Il tuo BMI e': " + pesoInKg / (altezzaInMetri * altezzaInMetri));
        pr.flush();
        s.close();
        ss.close();

    }
}
