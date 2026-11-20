class Urna{
	// Trabalho Urna Eletrônica
	// Código realziado por Rael Fernando de Mello e Pietro Roldão Figueiró Info2M
	// Atributos colocados como privados
	private int votos55;
	private int votos51;
	private int votosBrancos;
	private int votosNulos;
	private int estado; // 0 para fechada , 1 para teste e 2 para aberta
	public Urna(int votos55, int votos51, int votosBrancos, int votosNulos, int estado){
		this.votos55 = 0;
		this.votos51 = 0;
		this.votosBrancos = 0;
		this.votosNulos = 0;
		setEstado(estado);
	}
	// Métodos getters e setters dos atributos que estão privados
	public int getEstado(){
		return estado;
	}
	public void setEstado(int estado){
		if (estado > 2 || estado < 0){
			System.out.println("Estado inválido");
			this.estado = 0;
		}
		else{
			// Quando trocar o estado para testes os votos serem zerados para não ocorrer fraude
			if (estado == 2 || estado == 1){
				votos51 = 0;
				votos55 = 0;
				votosBrancos = 0;
				votosNulos = 0;
				this.estado = 2;
			}
		}
		this.estado = estado;
	}
	// Métodos getters para cada atributo
	public int getVotos55(){
		return votos55;
	}
	public int getVotos51(){
		return votos51;
	}
	public int getVotosBrancos(){
		return votosBrancos;
	}
	public int getVotosNulos(){
		return votosNulos;
	}
	public void mostrarResultado(){
		if (estado == 0 || estado == 1){
			// Calculo das porcentagens :
			double porcentagem51 = 0d;
			double porcentagem55 = 0d;
			
			if (estado == 1){
				System.out.println("Resultados parciais");
			}
			// Analise dos votos para não ocorrer problema de divisão por zero
			if (votos55 == 0 && votos51 == 0){
				porcentagem51 = 0d;
				porcentagem55 = 0d;
			}else{
				if (votos51 == 0){
					porcentagem51 = 0d;
					porcentagem55 = 100d;
				}
				else{
					porcentagem51 = (double)votos51*100/(votos55+votos51);
				}
				if (votos55 == 0){
					porcentagem55=  0d;
					porcentagem51 = 100d;
				}
				else{
					porcentagem55 = (double)votos55*100/(votos55+votos51);
				}
			}
			// Resultado das eleições
			System.out.printf("Candidato 51 : %.2f%% dos votos\n",porcentagem51);
			System.out.printf("Candidato 55 : %.2f%% dos votos\n", porcentagem55);
			System.out.printf("Votos Brancos : %d votos\n", votosBrancos);
			System.out.printf("Votos Nulos : %d votos\n", votosNulos);
			System.out.printf("Votos Totais : %d votos\n\n", votos51+votos55);
			if (votos51 > votos55){
				System.out.println("O candidato 51 ganhou as eleições\n");
			}else if (votos55 > votos51){
				System.out.println("O candidato 55 ganhou as eleições\n");
			}else{
				System.out.println("A eleição terminou empatada\n");
			}
		}
		else{
			// Mensagem que a urna não pode mostrar resultados se o estado é aberta
			System.out.println("A Urna agora não pode exibir resultados estando aberta.");
		}
	}
	public void votar(int voto){
		// Contagem dos votos
		if (estado == 0){
			System.out.println("A Urna não pode receber mais votos.");
		}else{
			if (voto == 55){
				votos55++;
			}else if (voto == 51){
				votos51++;
			}else{
				if (voto == 0){
					votosBrancos++;
				}else{
					votosNulos++;
				}
			}
		}
		System.out.println("Voto contabilizado");		
	}
	public static void main(String args[]){
	}
}
