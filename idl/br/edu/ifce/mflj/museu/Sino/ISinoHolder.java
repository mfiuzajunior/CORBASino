package br.edu.ifce.mflj.museu.Sino;

/**
* br/edu/ifce/mflj/museu/Sino/ISinoHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Sino.idl
* Tuesday, May 3, 2016 7:20:45 AM BRT
*/

public final class ISinoHolder implements org.omg.CORBA.portable.Streamable
{
  public br.edu.ifce.mflj.museu.Sino.ISino value = null;

  public ISinoHolder ()
  {
  }

  public ISinoHolder (br.edu.ifce.mflj.museu.Sino.ISino initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = br.edu.ifce.mflj.museu.Sino.ISinoHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    br.edu.ifce.mflj.museu.Sino.ISinoHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return br.edu.ifce.mflj.museu.Sino.ISinoHelper.type ();
  }

}
