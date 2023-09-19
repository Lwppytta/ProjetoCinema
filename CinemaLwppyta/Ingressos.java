package CinemaLwppyta;

import java.util.List;

public abstract class Ingressos {

	private float preçoBase;
	private float preçoIngresso;
	private String nomeFilme;
	private String horario;
	private String tipoIngresso1;
	private String tipoIngresso2;

	public Ingressos(float preçoBase, float preçoIngresso, String nomeFilme, String horario, String tipoIngresso1,
			String tipoIngresso2) {
		super();
		this.preçoBase = preçoBase;
		this.preçoIngresso = preçoIngresso;
		this.nomeFilme = nomeFilme;
		this.horario = horario;
		this.tipoIngresso1 = tipoIngresso1;
		this.tipoIngresso2 = tipoIngresso2;
	}

	public Ingressos() {
		super();
	}
	
	public void ImprimirRevisao(List<Controle> revi) {
		for (Controle ler : revi) {
			System.out.println("Filme: "+ler.getNomeFilme()+"   "+ ler.getTipoIngresso1());
			System.out.println("Tipo: "+ler.getTipoIngresso2()+"  R$" + ler.getPreçoIngresso());
			System.out.println("Horário: "+ler.getHorario());
			System.out.println("............................\n");
		}
	}

	public void Imprimir(List<Controle> lista) {
		System.out.println("       ▄▀▄     ▄▀▄\r\n"
		                 + "      ▄█░░▀▀▀▀▀░░█▄\r\n"
	                     + "  ▄▄  █░░░░░░░░░░░█  ▄▄\r\n"
		                 + " █▄▄█ █░░▀░░┬░░▀░░█ █▄▄█\r\n"
		                 + "█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
		for (Controle ler : lista) {
			System.out.println("   "+ ler.getNomeFilme()+"\n"
			                 + "  "+ ler.getTipoIngresso1() + "  "+ler.getTipoIngresso2()+"  R$" + ler.getPreçoIngresso()+"\n"
			                 + "      "+ ler.getHorario()+"\n"
			                 + "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀");
		}
	}

	public float getPreçoBase() {
		return preçoBase;
	}

	public void setPreçoBase(float preçoBase) {
		this.preçoBase = preçoBase;
	}

	public float getPreçoIngresso() {
		return preçoIngresso;
	}

	public void setPreçoIngresso(float preçoIngresso) {
		this.preçoIngresso = preçoIngresso;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getTipoIngresso1() {
		return tipoIngresso1;
	}

	public void setTipoIngresso1(String tipoIngresso1) {
		this.tipoIngresso1 = tipoIngresso1;
	}

	public String getTipoIngresso2() {
		return tipoIngresso2;
	}

	public void setTipoIngresso2(String tipoIngresso2) {
		this.tipoIngresso2 = tipoIngresso2;
	}
}