package br.edu.ifce.mflj.museu.Sino;


/**
* br/edu/ifce/mflj/museu/Sino/ISinoPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Sino.idl
* Tuesday, May 3, 2016 7:20:45 AM BRT
*/

public abstract class ISinoPOA extends org.omg.PortableServer.Servant
 implements br.edu.ifce.mflj.museu.Sino.ISinoOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("noite", new java.lang.Integer (0));
    _methods.put ("entradaDeCliente", new java.lang.Integer (1));
    _methods.put ("saidaDeCliente", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // br/edu/ifce/mflj/museu/Sino/ISino/noite
       {
         boolean noite = in.read_boolean ();
         this.noite (noite);
         out = $rh.createReply();
         break;
       }

       case 1:  // br/edu/ifce/mflj/museu/Sino/ISino/entradaDeCliente
       {
         boolean $result = false;
         $result = this.entradaDeCliente ();
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // br/edu/ifce/mflj/museu/Sino/ISino/saidaDeCliente
       {
         this.saidaDeCliente ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:br/edu/ifce/mflj/museu/Sino/ISino:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ISino _this() 
  {
    return ISinoHelper.narrow(
    super._this_object());
  }

  public ISino _this(org.omg.CORBA.ORB orb) 
  {
    return ISinoHelper.narrow(
    super._this_object(orb));
  }


} // class ISinoPOA