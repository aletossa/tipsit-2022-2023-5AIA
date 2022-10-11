package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Socket s = new Socket("localhost", 3000);
        PrintWriter pr = new PrintWriter(s.getOutputStream());

        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci il messaggio:");
        String stringaUtente = tastiera.readLine();
        
        pr.println(stringaUtente);
        pr.flush();

        //ALTEZZA

        BufferedReader tastieraDue = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci l'altezza:");
        String stringaUtenteDue = tastieraDue.readLine();
        
        pr.println(stringaUtenteDue);
        pr.flush();

        //PESO

        BufferedReader tastieraTre = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci il peso:");
        String stringaUtenteTre = tastieraTre.readLine();
        
        pr.println(stringaUtenteTre);
        pr.flush();

        //RISPOSTA

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(in);

        String str = br.readLine();
        System.out.println("Server: " + str);
        s.close();
    }
}
