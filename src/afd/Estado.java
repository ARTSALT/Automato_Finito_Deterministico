package afd;

public class Estado {
	
	private class Transicao {
		char entrada;
		Estado saida;
		
		public Transicao(char entrada, Estado saida) {
			this.entrada = entrada;
			this.saida = saida;
		}
	}
	
	private String nome;
	private Transicao[] d;
	private boolean end = false;
	
	public Estado(int d) {
		this.d = new Transicao[d];
	}
	
	public void criarTransicoes(int index, char e, Estado q) {
			d[index] = new Transicao(e, q);
	}
	
	public Estado transicionar(char e) {
		
		for (int i = 0; i < this.d.length; i++) {
			if (d[i].entrada == e) {
				return d[i].saida;
			}
		}
		
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isEnd() {
		return end;
	}

	public void turnEnd() {
		this.end = true;
	}
}