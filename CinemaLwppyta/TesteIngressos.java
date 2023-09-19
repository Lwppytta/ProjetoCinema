package CinemaLwppyta;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

import Cinema.util.Cores;

public class TesteIngressos {
	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		int controFilme = 0;
		int controTipos1 = 0;
		int controTipos2 = 0;
		int controHorario = 0;
		int controMenu = 0;
		int controCartaz = -1;
		int controRevisao = 0;
		int contro2Ingressos = 0;
		int checaLista = 0;
		int i = -1, j = -1;

		Controle m = new Controle();

		List<Controle> lista = new ArrayList<Controle>();
		List<Controle> revi = new ArrayList<Controle>();

		System.out.println(Cores.TEXT_PURPLE_BOLD + "         ||CINEMA LWPPYTTA||       09/10/2023  12:41");
		System.out.println("                    Seja bem vinde!");
		System.out.println("\nEstamos com quatro filmes em cartaz atualmente, fique à vontade!!" + Cores.TEXT_RESET);

		while (i != 0) {
			try {
				Controle c1 = new Controle();
				c1.setPreçoBase(50f);

				System.out.println(Cores.TEXT_GREEN_BOLD + "\n1 - Filmes em cartaz" + Cores.TEXT_RESET + " | "
						+ Cores.TEXT_CYAN_BOLD + "2 - Preços" + Cores.TEXT_RESET + " | " + Cores.TEXT_BLUE_BOLD
						+ "3 - Comprar ingresso" + Cores.TEXT_RESET + " | " + Cores.TEXT_RED_BOLD
						+ "4 - Ver ingresso(s)" + Cores.TEXT_RESET + " | " + Cores.TEXT_YELLOW_BOLD + "0 - Sair"
						+ Cores.TEXT_RESET);
				controMenu = leia.nextInt();

				if (controMenu == 1) {
					c1.DescricaoFilme();
					do {
						try {
							System.out.println("\nEscolha uma opção:\nHórarios disponíveis: (1) | Voltar ao menu (0)");
							controCartaz = leia.nextInt();

							c1.DescricaoHorario1(controCartaz);
						} catch (InputMismatchException e) {
							leia.nextLine();
							System.out.println(Cores.TEXT_RED_UNDERLINED + "Por favor digite um único número válido."
									+ Cores.TEXT_RESET);
						} finally {
							System.out.println("................................................................");
						}
					} while (controCartaz != 0);
				} else if (controMenu == 2) {
					c1.DescricaoPreco();
				} else if (controMenu == 3) {
					if (lista.size() < 2) {
						j = 1;
						while (j != 0) {
							Controle c = new Controle();
							c.setPreçoBase(50f);
							do {
								try {
									System.out.println("Qual filme gostaria de assistir?");
									controFilme = leia.nextInt();

									c.escolhaFilme(controFilme);

								} catch (InputMismatchException e) {
									leia.nextLine();
									System.out.println(Cores.TEXT_RED_BOLD
											+ "Por favor digite um único número de 1 a 4." + Cores.TEXT_RESET);
								} catch (IndexOutOfBoundsException e) {
									leia.nextLine();
									System.out.println(Cores.TEXT_RED_BOLD
											+ "Por favor digite um único número de 1 a 4." + Cores.TEXT_RESET);
								} finally {
									System.out.println(
											"................................................................");
								}
							} while (controFilme < 1 || controFilme > 4);

							do {
								try {
									System.out.println("É 3D ou normal(1/2)?");
									controTipos1 = leia.nextInt();

									if (controTipos1 == 1) {
										c.setTipoIngresso1("3D");
									} else if (controTipos1 == 2) {
										c.setTipoIngresso1("Normal");
									} else {
										System.out.println(
												Cores.TEXT_RED_UNDERLINED + "Opção inválida." + Cores.TEXT_RESET);
									}

									c.TresD(controTipos1);
									c.Normal(controTipos1);
									if (controTipos1 == 1 || controTipos1 == 2) {
										do {
											try {
												System.out.println("Para o filme " + c.getNomeFilme() + ", na seção "
														+ c.getTipoIngresso1()
														+ " temos os seguintes horários disponíveis:");
												c.DescricaoHorario2(controFilme, controTipos1);
												System.out.println("\nDigite uma das opções abaixo:");
												System.out.println(
														"(1) Horário 1 | (2) Horário 2 | (3) Voltar a página anterior.");
												controHorario = leia.nextInt();

												c.DefinirHorario(controFilme, controTipos1, controHorario);

												if (controHorario == 3) {
													controTipos1 = 0;
												}
											} catch (InputMismatchException e) {
												leia.nextLine();
												System.out.println(
														Cores.TEXT_RED_BOLD + "Por favor digite um único número válido."
																+ Cores.TEXT_RESET);
											} finally {
												System.out.println(
														"................................................................");
											}
										} while (controHorario < 1 || controHorario > 3);
									}
								} catch (InputMismatchException e) {
									leia.nextLine();
									System.out.println(Cores.TEXT_RED_BOLD + "Por favor digite um único número(1 ou 2)."
											+ Cores.TEXT_RESET);
								} finally {
									System.out.println(
											"................................................................");
								}
							} while (controTipos1 < 1 || controTipos1 > 2);

							do {
								try {
									System.out.println("É meia ou inteira(1/2)?");
									controTipos2 = leia.nextInt();

									if (controTipos2 == 1) {
										c.setTipoIngresso2("Meia");
									} else if (controTipos2 == 2) {
										c.setTipoIngresso2("Inteira");
									} else {
										System.out.println(
												Cores.TEXT_RED_UNDERLINED + "Opção inválida." + Cores.TEXT_RESET);
									}

									c.Meia(controTipos2);
								} catch (InputMismatchException e) {
									leia.nextLine();
									System.out.println(Cores.TEXT_RED_BOLD + "Por favor digite um único número(1 ou 2)."
											+ Cores.TEXT_RESET);
								} finally {
									System.out.println(
											"................................................................");
								}
							} while (controTipos2 < 1 || controTipos2 > 2);

							revi.add(c);

							do {
								try {
									c.ImprimirRevisao(revi);
									System.out.println("Os dados estão corretos? ([1] Sim | [2] Refazer ingresso");
									controRevisao = leia.nextInt();

									if (controRevisao == 1) {
										lista.add(c);
										checaLista = 1;
										System.out.println("Dados salvos!");
									} else if (controRevisao == 2) {
										Optional<List<Controle>> checaNulo = Optional.ofNullable(revi);
										if (checaNulo.isPresent()) {
											for (int indice = 0; indice < revi.size(); indice++) {
												revi.remove(indice);
											}
										}
									} else {
										System.out.println(
												Cores.TEXT_RED_UNDERLINED + "Opção inválida." + Cores.TEXT_RESET);
									}

								} catch (InputMismatchException e) {
									leia.nextLine();
									System.out.println(Cores.TEXT_RED_BOLD + "Por favor digite um único número válido."
											+ Cores.TEXT_RESET);
								} catch (IndexOutOfBoundsException e) {
									leia.nextLine();
									System.out.println(Cores.TEXT_RED_BOLD + "Por favor digite um único número válido."
											+ Cores.TEXT_RESET);
								} finally {
									System.out.println(
											"................................................................");
								}
							} while (controRevisao < 1 || controRevisao > 2);

							if (lista.size() < 2) {
								while (controRevisao == 1) {
									try {

										System.out.println("Gostaria de um segundo ingresso? ([1] Sim | [2] Não)");
										contro2Ingressos = leia.nextInt();

										if (contro2Ingressos == 1) {
											controRevisao = 0;
										} else if (contro2Ingressos == 2) {
											j = 0;
											controRevisao = 0;
										} else {
											System.out.println(
													Cores.TEXT_RED_UNDERLINED + "Opção inválida." + Cores.TEXT_RESET);
										}
									} catch (InputMismatchException e) {
										leia.nextLine();
										System.out.println(Cores.TEXT_RED_BOLD
												+ "Por favor digite um único número válido." + Cores.TEXT_RESET);
									} finally {
										System.out.println(
												"................................................................");
									}
								}
							} else if (lista.size() == 2) {
								j = 0;
							}

							if (checaLista == 1) {
								Stream<Controle> streamLista = lista.stream();
								if (lista.size() == 1) {
									System.out.println("Prontinho, aqui esta o seu bilhete!");
								} else {
									System.out.println("Seu bilhete:");
								}
								c1.Imprimir(lista);
								System.out.println("Soma do(s) ingresso(s):  "
										+ streamLista.mapToDouble(p -> p.getPreçoIngresso()).sum());
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							} else {
								System.out.println("Nenhum ingresso adquirido ainda...!");
								System.out.println("................................................................");
							}
						}
					} else {
						System.out.println(
								Cores.TEXT_RED_UNDERLINED + "Limites de ingressos adquiridos." + Cores.TEXT_RESET);
					}
				} else if (controMenu == 4) {
					if (lista.size() == 0) {
						System.out.println("Nenhum ingresso adquirido ainda...!");
						System.out.println("................................................................");
					} else {
						m.Imprimir(lista);
					}

				} else if (controMenu == 0) {
					i = 0;
				} else {
					System.out.println(Cores.TEXT_RED_UNDERLINED + "Opção inválida." + Cores.TEXT_RESET);
				}

			} catch (InputMismatchException e) {
				leia.nextLine();
				System.out.println(Cores.TEXT_RED_BOLD + "Por favor digite um único número válido." + Cores.TEXT_RESET);
			} finally {
				System.out.println("................................................................");
			}
		}
	}
}