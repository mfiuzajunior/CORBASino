package br.edu.ifce.mflj.sensores.services;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import br.edu.ifce.mflj.sensores.dao.Sino;

public class SinoService{
	private ORB					orb;
	private Object				nameService;
	private NamingContext		namingContext;
	private Sino	sino;

	public SinoService( String[] args ){
		setUp( args );
		registrarSino();

		orb.run();
		System.out.println("Sino online");
	}

	private void setUp(String[] args){
		sino = new Sino();

		try {
			orb				= ORB.init( args, null );
			nameService		= orb.resolve_initial_references( "NameService" );
			namingContext	= NamingContextExtHelper.narrow( nameService );
		}
		catch (InvalidName e) {
			e.printStackTrace();
		}
	}

	private void registrarSino() {
		try {
			Object	objPOA	= orb.resolve_initial_references( "RootPOA" );
			POA		rootPOA	= POAHelper.narrow( objPOA );

			Object			referenciaCromometro	= rootPOA.servant_to_reference( sino );
			NameComponent	nameComponent[]			= { new NameComponent( "Sino", "Sino" ) };

			namingContext.rebind( nameComponent, referenciaCromometro );
			rootPOA.the_POAManager().activate();
		}
		catch (InvalidName e) {
			e.printStackTrace();
		}
		catch (ServantNotActive e) {
			e.printStackTrace();
		}
		catch (WrongPolicy e) {
			e.printStackTrace();
		}
		catch (NotFound e) {
			e.printStackTrace();
		}
		catch (CannotProceed e) {
			e.printStackTrace();
		}
		catch (AdapterInactive e) {
			e.printStackTrace();
		}
		catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new SinoService( args );
	}
}