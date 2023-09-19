package CinemaLwppyta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Cinema.util.Cores;

public class Controle extends Ingressos implements Calculos, Opcoes {

	public Controle(float preçoBase, float preçoIngreso, String nomeFilme, String horario, String tipoIngresso1,
			String tipoIngresso2) {
		super(preçoBase, preçoIngreso, nomeFilme, horario, tipoIngresso1, tipoIngresso2);
	}

	public Controle() {
		super();
	}

	public void escolhaFilme(int controFilme) {
		List<String> listaFilmes = new ArrayList<String>();
		listaFilmes.add("O Castelo Animado");
		listaFilmes.add("A Viagem de Chihiro");
		listaFilmes.add("Vidas ao Vento");
		listaFilmes.add("Ponyo - Um Mar de Aventuras");

		if (controFilme >= 1 || controFilme <= 4) {
			for (int indice = 0; indice <= listaFilmes.size(); indice++) {
				if ((indice+1) == controFilme) {
					setNomeFilme(listaFilmes.get(indice));
				}
			}
		} else {
			System.out.println(Cores.TEXT_RED_UNDERLINED+"Opção inválida."+Cores.TEXT_RESET);
		}
	}

	@Override
	public void DescricaoFilme() {
		System.out.println("\n"+Cores.TEXT_GREEN_UNDERLINED+"1"+Cores.TEXT_RESET+" O Castelo Animado  "+Cores.TEXT_GREEN_UNDERLINED+"2"+Cores.TEXT_RESET+" A Viagem de Chihiro  "+Cores.TEXT_GREEN_UNDERLINED+"3"+Cores.TEXT_RESET+" Vidas ao Vento  "+Cores.TEXT_GREEN_UNDERLINED+"4"+Cores.TEXT_RESET+" Ponyo");
	}

	@Override
	public void DescricaoHorario1(int controCartaz) {
		Scanner leia = new Scanner(System.in);
		
		if (controCartaz == 1) {
			System.out.println("\n De qual filme gostaria de ver os horários diponíveis?");
			System.out.println("(1) O Castelo Animado | (2) A Viagem de Chihiro | (3) Vidas ao Vento | (4) Ponyo | (5) Ver todos | (0) Voltar ao menu");
			controCartaz = leia.nextInt();

			switch (controCartaz) {
			case 1:
				System.out.println("\n"+Cores.TEXT_GREEN_BOLD_BRIGHT+"3D"+Cores.TEXT_RESET+": Sabado 19:40 e Domingo 17:40 | "+Cores.TEXT_GREEN_BOLD_BRIGHT+"Normal"+Cores.TEXT_RESET+": Sabado 15:00 e Domingo 13:00");
				System.out.println("................................................................");
				break;
			case 2:
				System.out.println("\n"+Cores.TEXT_GREEN_BOLD_BRIGHT+"3D"+Cores.TEXT_RESET+": Sabado 17:20 e Domingo 15:20 | "+Cores.TEXT_GREEN_BOLD_BRIGHT+"Normal"+Cores.TEXT_RESET+": Sabado 12:40 e Domingo 20:00");
				System.out.println("................................................................");
				break;
			case 3:
				System.out.println("\n"+Cores.TEXT_GREEN_BOLD_BRIGHT+"3D"+Cores.TEXT_RESET+": Sabado 15:00 e Domingo 13:00 | "+Cores.TEXT_GREEN_BOLD_BRIGHT+"Normal"+Cores.TEXT_RESET+": Sabado 19:40 e Domingo 17:40");
				System.out.println("................................................................");
				break;
			case 4:
				System.out.println("\n"+Cores.TEXT_GREEN_BOLD_BRIGHT+"3D"+Cores.TEXT_RESET+": Sabado 12:40 e Domingo 20:00 | "+Cores.TEXT_GREEN_BOLD_BRIGHT+"Normal"+Cores.TEXT_RESET+": Sabado 17:20 e Domingo 15:20");
				System.out.println("................................................................");
				break;
			case 5:
				System.out.println("\n                 3D                           Normal");
				System.out.println("(1) Sabado 19:40 e Domingo 17:40 | Sabado 15:00 e Domingo 13:00");
				System.out.println("(2) Sabado 17:20 e Domingo 15:20 | Sabado 12:40 e Domingo 20:00");
				System.out.println("(3) Sabado 15:00 e Domingo 13:00 | Sabado 19:40 e Domingo 17:40");
				System.out.println("(4) Sabado 12:40 e Domingo 20:00 | Sabado 17:20 | Domingo 15:20");
				System.out.println("................................................................");
				break;
			}
		} else if (controCartaz != 1 && controCartaz != 0) {
			System.out.println(Cores.TEXT_RED_UNDERLINED+"Opção inválida."+Cores.TEXT_RESET);
		}

	}

	@Override
	public void DescricaoPreco() {
		System.out.println(Cores.TEXT_CYAN+"Preço base R$50,00 | 3D R$60,00 | Meia R$25,00 | Meia-3D R$30,00"+Cores.TEXT_RESET);

	}

	@Override
	public void DescricaoHorario2(int controFilme, int controTipos1) {
		if (controFilme == 1 && controTipos1 == 1) {
			System.out.println("Sabado 19:40 | Domingo 17:40");
		} else if (controFilme == 1 && controTipos1 == 2) {
			System.out.println("Sabado 15:00 | Domingo 13:00");
		} else if (controFilme == 2 && controTipos1 == 1) {
			System.out.println("Sabado 17:20 | Domingo 15:20");
		} else if (controFilme == 2 && controTipos1 == 2) {
			System.out.println("Sabado 12:40 | Domingo 20:00");
		} else if (controFilme == 3 && controTipos1 == 1) {
			System.out.println("Sabado 15:00 | Domingo 13:00");
		} else if (controFilme == 3 && controTipos1 == 2) {
			System.out.println("Sabado 19:40 | Domingo 17:40");
		} else if (controFilme == 4 && controTipos1 == 1) {
			System.out.println("Sabado 12:40 | Domingo 20:00");
		} else if (controFilme == 4 && controTipos1 == 2) {
			System.out.println("Sabado 17:20 | Domingo 15:20");
		}
	}

	@Override
	public void DefinirHorario(int controFilme, int controTipos1, int controHorario) {
		if (controHorario == 1) {
			if (controTipos1 == 1) {
				if (controFilme == 1) {
					setHorario("Sabado 19:40");
				} else if (controFilme == 2) {
					setHorario("Sabado 17:20");
				} else if (controFilme == 3) {
					setHorario("Sabado 15:00");
				} else if (controFilme == 4) {
					setHorario("Sabado 12:40");
				}
			} else if (controTipos1 == 2) {
				if (controFilme == 1) {
					setHorario("Sabado 15:00");
				} else if (controFilme == 2) {
					setHorario("Sabado 12:40");
				} else if (controFilme == 3) {
					setHorario("Sabado 19:40");
				} else if (controFilme == 4) {
					setHorario("Sabado 17:20");
				}
			} else {
				System.out.println("Opção inválida.");
			}
		} else if (controHorario == 2) {
			if (controTipos1 == 1) {
				if (controFilme == 1) {
					setHorario("Domingo 17:40");
				} else if (controFilme == 2 && controTipos1 == 1) {
					setHorario("Domingo 15:20");
				} else if (controFilme == 3 && controTipos1 == 1) {
					setHorario("Domingo 13:00");
				} else if (controFilme == 4 && controTipos1 == 1) {
					setHorario("Domingo 20:00");
				}
			} else if (controTipos1 == 2) {
				if (controFilme == 1) {
					setHorario("Domingo 13:00");
				} else if (controFilme == 2) {
					setHorario("Domingo 20:00");
				} else if (controFilme == 3) {
					setHorario("Domingo 17:40");
				} else if (controFilme == 4) {
					setHorario("Domingo 15:20");
				}
			}
		}
	}

	@Override
	public void TresD(int controTipos1) {
		if (controTipos1 == 1) {
			setPreçoIngresso(getPreçoBase() + 10);
		}
	}

	@Override
	public void Normal(int controTipos2) {
		if (controTipos2 == 2) {
			setPreçoIngresso(getPreçoBase());
		}
	}

	@Override
	public void Meia(int controTipos2) {
		if (controTipos2 == 1) {
			setPreçoIngresso(getPreçoIngresso() / 2);
		}
	}
}