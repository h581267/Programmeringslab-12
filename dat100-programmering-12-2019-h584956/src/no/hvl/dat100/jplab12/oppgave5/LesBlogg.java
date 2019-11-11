package no.hvl.dat100.jplab12.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Integer.*;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {

		Scanner lesFil = null;
		try {
		lesFil = new Scanner(new File(filnavn));
		} catch (FileNotFoundException e) {}
		
		int antall = parseInt(lesFil.nextLine());
		Blogg samling = new Blogg(antall);
		
		if (lesFil.hasNextLine()) {
            String linje = lesFil.nextLine();
        }
		
		while (lesFil.hasNextLine()) {
			String linje = lesFil.nextLine();
			if (linje.equals(TEKST)) {
				int id = parseInt(lesFil.nextLine());
				String bruker = lesFil.nextLine();
				String dato = lesFil.nextLine();
				int likes = parseInt(lesFil.nextLine());
				String tekst = lesFil.nextLine();
				
				Innlegg objekt = new Tekst(id, bruker, dato, likes, tekst);
				samling.leggTil(objekt);
			}
			else if (linje.equals(BILDE)) {
				int id = parseInt(lesFil.nextLine());
				String bruker = lesFil.nextLine();
				String dato = lesFil.nextLine();
				int likes = parseInt(lesFil.nextLine());
				String tekst = lesFil.nextLine();
				String url = lesFil.nextLine();
				
				Innlegg objekt = new Bilde(id, bruker, dato, likes, tekst, url);
				samling.leggTil(objekt);
			}
		}
		
		lesFil.close();
		
		
		return samling;
	}
}
