package afd;

import java.util.Scanner;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	private static Estado[] q;
	private static String[] e;
	
	//TODO Grupo: Artur Segantini Guedes, Erick Patrick de Paula Morais Freitas, João Pedro Pereira Frutoso. 
	
	public static void main(String[] args) {
		setup();
		
		System.out.println("Insira uma cadeia formada pelos símbolos que você escolheu como parte do alfabeto do automato A: ");
		String cadeia = scan.nextLine();
		Estado estadoAtual = q[0];
		
		for (int i = 0; i < cadeia.length(); i++) {
			estadoAtual = estadoAtual.transicionar(cadeia.charAt(i));
		}
		
		if (estadoAtual.isEnd()) {
			System.out.println("Cadeia Aceita!!!");
		} else {
			System.out.println("Cadeia Negada");
		}
	}
	
	public static void setup() {
		//Setup de todos os símbolos
		E();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//Setup do N° de estados
		Q();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//Escolhe o estado final
		F();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//Cria função de transição
		D();
		scan.nextLine();
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	private static void E() {
		System.out.println("Quantos símbolos você deseja que seu alfabeto tenha?");
		int i = scan.nextInt();
		
		e = new String[i];
		
		for (int j = 0; j < i; j++) {
			System.out.print((j+1) + "° símbolo: ");
			e[j] = scan.next();
			System.out.println();
		} 
	}
	
	private static void Q() {
		System.out.println("Quantos estados você deseja que o autômato 'A' possua? Note que o primeiro "
				+ "será o estado inicial");
		int i = scan.nextInt();
		scan.nextLine();
		
		q = new Estado[i];
		
		for (int j = 0; j < i; j++) {
			q[j] = new Estado(e.length);
		}
		
		for (int j = 0; j < i; j++) {
			System.out.print("Nome do " + (j+1) + "° estado: ");
			String nome = scan.nextLine();
			q[j].setNome(nome);
			System.out.println();
		}
	}
	
	private static void F() {
		for (int i = 0; i < q.length; i++) {
			System.out.println((i + 1) + ". " + q[i].getNome());
		}
		
		System.out.println();
		System.out.println("Quantos estados você deseja selecionar como final?");
		int i = scan.nextInt();
		
		boolean continuar = true;
		
		while (continuar) {
			if (i <= q.length && i > 0) {
				for(int j = 0; j < i; j++) {
					System.out.println("Quais? Selecione por número");
					int k = scan.nextInt() - 1;
					
					if (!(k >= q.length && k > 0)) {
						q[k].turnEnd();
					} else {
						System.out.println("Estado Inválido, selecione um dos estados existentes");
						j--;
					}
				}
				
				continuar = false;
				
			} else {
				System.out.println("mais uma chance...");
				
				continuar = true;
			}
		}
	}
	
	private static void D() {
		for (int i = 0; i < q.length; i++) {
			
			for (int l = 0; l < q.length; l++) {
				System.out.println((l + 1) + ". " + q[l].getNome());
			}
			
			System.out.println("=========" + q[i].getNome() + "=========");
			for (int j = 0; j < e.length; j++) {
				System.out.println("Para o estado " + q[i].getNome() + ", o símbolo " + e[j] + " leva a qual estado? "
								+ "por número pela ordem acima");
				int k = scan.nextInt() - 1;
				
				if (!(k >= q.length || k < 0)) {
					q[i].criarTransicoes(j, e[j].charAt(0), q[k]);
					
				} else {
					System.out.println("Estado inválido, insira um dos estado que foram numerados");
					j--;
				}				
			}
			System.out.println();
		}
	}
}
