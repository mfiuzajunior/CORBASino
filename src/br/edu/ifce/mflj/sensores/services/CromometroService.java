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

import br.com.ifce.mflj.estacao.IServidorCentral;
import br.com.ifce.mflj.estacao.IServidorCentralHelper;
import br.edu.ifce.mflj.sensores.dao.CromometroDAO;

public class CromometroService implements Runnable {
	private ORB					orb;
	private Object				nameService;
	private NamingContext		namingContext;

	private IServidorCentral	servidorCentral;
	private CromometroDAO		cromometroDAO;

	public CromometroService( String[] args ){
		setUp( args );

		registrarCromometro();
		obterServidorCentral();
	}

	public CromometroDAO getCromometroDAO(){
		return this.cromometroDAO;
	}

	private void setUp(String[] args){
		cromometroDAO		= new CromometroDAO();

		try {
			orb				= ORB.init( args, null );
			nameService		= orb.resolve_initial_references( "NameService" );
			namingContext	= NamingContextExtHelper.narrow( nameService );
		}
		catch (InvalidName e) {
			e.printStackTrace();
		}
	}

	private void obterServidorCentral() {
		try {
			NameComponent	nameComponent[]		= { new NameComponent( "ServidorCentral", "ServidorCentral" ) };
			Object			referenciaServidor	= namingContext.resolve( nameComponent );

			servidorCentral	= IServidorCentralHelper.narrow( referenciaServidor );
			servidorCentral.informarSensorLigado( cromometroDAO.getCromometro().toString(), cromometroDAO.getCromometro().getEstado() );
			servidorCentral.informarLeitura( cromometroDAO.getCromometro().toString(), cromometroDAO.getCromometro().getLeitura() );
		}
		catch (NotFound e) {
			e.printStackTrace();
		}
		catch (CannotProceed e) {
			e.printStackTrace();
		}
		catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			e.printStackTrace();
		}
	}

	private void registrarCromometro() {
		try {
			Object	objPOA	= orb.resolve_initial_references( "RootPOA" );
			POA		rootPOA	= POAHelper.narrow( objPOA );

			Object			referenciaCromometro	= rootPOA.servant_to_reference( cromometroDAO );
			NameComponent	nameComponent[]			= { new NameComponent( "Cromometro", "Cromometro" ) };

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

	public void enviarLeituraAtual( String leitura ){
		servidorCentral.informarLeitura( this.cromometroDAO.getCromometro().toString(), leitura );
	}

	public void run(){
		this.orb.run();
	}
}