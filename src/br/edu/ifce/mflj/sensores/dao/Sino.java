package br.edu.ifce.mflj.sensores.dao;

import br.edu.ifce.mflj.museu.Sino.ISinoPOA;

public class Sino extends ISinoPOA {

	private int		quantidadeVisitantes;
	private boolean noite;

	@Override
	public void noite( boolean noite ){
		this.noite = noite;
	}

	@Override
	public boolean entradaDeCliente() {
		quantidadeVisitantes++;

		if( noite ){
			return false;
		}

		return true;
	}

	@Override
	public void saidaDeCliente() {
		if( --quantidadeVisitantes < 0 ){
			quantidadeVisitantes = 0;
		}
	}
}