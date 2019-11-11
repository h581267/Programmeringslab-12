package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.Tekst;


public class Blogg {

	// TODO: objektvariable 
	private Innlegg[] innleggtabell;
	private int nesteLedig;

	public Blogg() {
		this.innleggtabell = new Innlegg[20];
		this.nesteLedig = 0;
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
		this.nesteLedig = 0;
	}

	public int getAntall() {
		
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		int p = -1;
        int i = 0;
        while (i < nesteLedig && p == -1) {
            if (innleggtabell[i].erLik(innlegg)) {
                p = i;
            }
            i++;
        }
        return p;
    }
	

	public boolean finnes(Innlegg innlegg) {
		if (finnInnlegg(innlegg) == -1) {
			return false;
		}
		else {
			return true;
		}
	}
	

	public boolean ledigPlass() {
		int i = 0;
		boolean ledig = false;
		
		while (i<innleggtabell.length && !ledig) {
			if(innleggtabell[i] == null) {
				ledig = true;
			}
			i++;
			
		}
		return ledig;
		
	}
	
	public boolean leggTil(Innlegg innlegg) {

		if(!finnes(innlegg)) {
			innleggtabell[nesteLedig] = innlegg;
			nesteLedig++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String s = getAntall() + "\n";
		for (int i = 0; i<nesteLedig;i++) {
			if (innleggtabell[i] != null) {
			
			s += innleggtabell[i].toString();
			}
		}
		return s;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] ny = new Innlegg[2*innleggtabell.length];
		for(int i = 0; i < innleggtabell.length; i++) {
			ny[i]=innleggtabell[i];
		}
		innleggtabell = ny;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		boolean lagtTil = false;
		
		if(innleggtabell.length-1==nesteLedig) {
			utvid();
			leggTil(innlegg);
			lagtTil = true;
		}
		return lagtTil;
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		int p = finnInnlegg(innlegg);
		
		if(p>=0) {
			nesteLedig--;
			innleggtabell[p]=innleggtabell[nesteLedig];
			innleggtabell[nesteLedig]=null;
			return true;
		}
		else {
			return false;
		}
	
	}
	
	public int[] search(String keyword) {
		
		int[] id = new int[innleggtabell.length];
		int s = 0;
		
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] instanceof Tekst) {
				if (((Tekst)innleggtabell[i]).getTekst().contains(keyword)) {
					id[i] = innleggtabell[i].getId();
					s++;
				}
			}
				 
		}
		
		int [] ny = new int [s];
		int p = 0;

		for (int i = 0; i < id.length; i++) {
			if (id[i] != 0) {
				ny[p] = id[i];
				p++;
			}
		}
		
		return id;

	}
}