package com.athodev;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileOutputStream fichierWRITE = ouvrirFichierEcriture("generatedIPS.txt");
        PrintStream sortie = new PrintStream(fichierWRITE);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of IPs you want to generate : ");
        int nombre = input.nextInt();
        for (int i = 0; i < nombre; i++) {
            sortie.println(genererIP());
        }

    }
    private static String genererIP() {
        String IP = "";
        int[] octets = new int[4];
        Random rng = new Random();
        for (int i = 0; i < octets.length-1; i++) {
            octets[i] = rng.nextInt(255);
        }
        octets[3] = rng.nextInt(253+2);
        for (int i = 0; i < octets.length; i++) {
            if (i != octets.length-1)
                IP += octets[i] + ".";
            else
                IP += octets[i];
        }
        return IP;
    }
    private static FileOutputStream ouvrirFichierEcriture(String nomFic) {
        FileOutputStream ficSortie = null;
        try {
            ficSortie = new FileOutputStream(nomFic);
        } catch (FileNotFoundException ex) {
            System.out.println("File couldn't be created");
        }
        return ficSortie;
    }
}
