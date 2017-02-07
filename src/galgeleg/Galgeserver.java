package galgeleg;

import java.rmi.Naming;

import brugerautorisation.server.Brugerdatabase;
import brugerautorisation.transport.soap.BrugeradminImpl;

 
 

public class Galgeserver {
	
	public static void main(String[] arg) throws Exception
	{
		// Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:
		java.rmi.registry.LocateRegistry.createRegistry(1099); // start i server-JVM

		Galgeinterface k = new GalgelogikImpl();
		//Brugerdatabase db = Brugerdatabase.getInstans();
		BrugeradminImpl impl = new BrugeradminImpl();
		//impl.db = db;
		Naming.rebind("rmi://localhost/galgetjeneste", k);
		System.out.println("Kontotjeneste registreret.");
	}

}
