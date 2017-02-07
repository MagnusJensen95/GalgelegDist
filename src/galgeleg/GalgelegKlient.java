package galgeleg;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;




public class GalgelegKlient{
	
	static Galgeinterface spil;


  public static void main(String[] args) throws Exception  {
	  
	  System.out.println("Velkommen til Galgeleg");
	  Scanner scan = new Scanner(System.in);
	  System.out.println("Indtast Brugernavn");
	  String user = scan.next();
	  System.out.println("Indtast password!");
	  String pass = scan.next();
	  
	  boolean legitUser = false;
		Galgeinterface ba =(Galgeinterface) Naming.lookup("rmi://localhost/galgetjeneste");
		Bruger bruger = ba.hentBruger(user,  pass);
		if (bruger != null){
			legitUser = true;
		}
	
	  
	  if(legitUser){
		  System.out.println("Du er nu logget ind!");
		  
	  }
	  else{
		  System.out.println("Login fejlet");
		  
	  }
	  
	  boolean igen = true;
	  
	  while (igen){
	  try {
		 igen = spilSpillet(ba);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	  }
	  
  }
  
  public static boolean spilSpillet(Galgeinterface face) throws MalformedURLException, RemoteException, NotBoundException {
	  
	  spil = face;
	  
	  System.out.println("Nyt Spil Startet");
	  
	  Scanner scan = new Scanner(System.in);
	  spil.nulstil();
	    try {
	      spil.hentOrdFraDr();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    
	    while (!spil.erSpilletSlut()){
	    	System.out.println("Gæt et bogstav!");
	    	String bogstav = scan.next();
	    	if(bogstav.length() > 1){
	    		System.out.println("Du må kun gæte et bogstav ad gangen! Det første bogstav, du skrev bruges i stedet.");
	    		bogstav = bogstav.substring(0, 1);
	    		
	    	}
	    	
	    	
	    	spil.gætBogstav(bogstav);
	    	
	    	System.out.println("Foreløbigt ord: " + spil.getSynligtOrd());
	    	System.out.println("Brugte bogstaver: " + spil.getBrugteBogstaver());
	    	System.out.println("Du har " + (7 - spil.getAntalForkerteBogstaver()) + " gæt tilbage!");
		
	    	
	    }
	    System.out.println("Spillet er slut! \n Prøv igen Y/N?"); 
	    String nus = scan.next();
	    if (nus.equalsIgnoreCase("Y")){
	    	return true;
	    }
	    else {
	    	System.out.println("Tak for denne gang");
	    	return false;
	    	
	    }
	  
  }
  
}
