package br.com.ifce.mflj.estacao;


/**
* br/com/ifce/mflj/estacao/IServidorCentralHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from EstacaoCentral.idl
* Quarta-feira, 8 de Abril de 2015 08h44min42s BRT
*/

abstract public class IServidorCentralHelper
{
  private static String  _id = "IDL:br/com/ifce/mflj/estacao/IServidorCentral:1.0";

  public static void insert (org.omg.CORBA.Any a, br.com.ifce.mflj.estacao.IServidorCentral that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static br.com.ifce.mflj.estacao.IServidorCentral extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (br.com.ifce.mflj.estacao.IServidorCentralHelper.id (), "IServidorCentral");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static br.com.ifce.mflj.estacao.IServidorCentral read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_IServidorCentralStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, br.com.ifce.mflj.estacao.IServidorCentral value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static br.com.ifce.mflj.estacao.IServidorCentral narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof br.com.ifce.mflj.estacao.IServidorCentral)
      return (br.com.ifce.mflj.estacao.IServidorCentral)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      br.com.ifce.mflj.estacao._IServidorCentralStub stub = new br.com.ifce.mflj.estacao._IServidorCentralStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static br.com.ifce.mflj.estacao.IServidorCentral unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof br.com.ifce.mflj.estacao.IServidorCentral)
      return (br.com.ifce.mflj.estacao.IServidorCentral)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      br.com.ifce.mflj.estacao._IServidorCentralStub stub = new br.com.ifce.mflj.estacao._IServidorCentralStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
