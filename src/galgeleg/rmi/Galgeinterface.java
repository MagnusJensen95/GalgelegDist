package galgeleg.rmi;

import java.io.IOException;
import java.util.ArrayList;

import brugerautorisation.data.Bruger;

public interface Galgeinterface extends java.rmi.Remote {
	
	ArrayList<String> getBrugteBogstaver() throws java.rmi.RemoteException;
	String getSynligtOrd() throws java.rmi.RemoteException;
	String getOrdet() throws java.rmi.RemoteException;
	int getAntalForkerteBogstaver() throws java.rmi.RemoteException;
	boolean erSidsteBogstavKorrekt() throws java.rmi.RemoteException;
	boolean erSpilletVundet() throws java.rmi.RemoteException;
	boolean erSpilletTabt() throws java.rmi.RemoteException;
	boolean erSpilletSlut() throws java.rmi.RemoteException;
	
	void nulstil() throws java.rmi.RemoteException;
	void opdaterSynligtOrd() throws java.rmi.RemoteException;
	void gætBogstav(String s) throws java.rmi.RemoteException;
	void logStatus() throws java.rmi.RemoteException;
	String hentUrl(String s) throws java.rmi.RemoteException, IOException; 
	void hentOrdFraDr() throws java.rmi.RemoteException, Exception;
	Bruger hentBruger(String user, String pass) throws Exception;

}
