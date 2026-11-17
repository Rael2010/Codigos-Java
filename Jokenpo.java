import java.util.Scanner;
import java.util.Random;

class Jokenpo{
	int escolha;
	public Jokenpo(int escolha){
		this.escolha = escolha;
	}
	public static String jogo(int p1, int maquina, String[] escolhas){
		String resultado = "\n";
		if (p1 == maquina){
			resultado += escolhas[p1] + " VS "+escolhas[maquina] + "\nEmpate";
		}
		else{
			if (p1 == 1 && maquina == 0){
				resultado += escolhas[p1] + " VS " + escolhas[maquina] + "\nVocê ganhou\n";				
			}
			else if (p1 == 0 && maquina == 1){
				resultado += escolhas[p1] + " VS " + escolhas[maquina] + "\nA máquina ganhou\n";				
			}
			else if (p1 == 0 && maquina == 2){
				resultado += escolhas[p1] + " VS " + escolhas[maquina] + "\nVocê ganhou\n";				
			}
			else if(p1 == 2 && maquina == 0){
				resultado += escolhas[p1] + " VS " + escolhas[maquina] + "\nA máquina ganhou\n";				
			}
			else if(p1 == 1 && maquina == 2){
				resultado += escolhas[p1] + " VS " + escolhas[maquina] + "\nA máquina ganhou";				
			}
			else if(p1 == 2 && maquina == 1){
				resultado += escolhas[p1] + " VS " + escolhas[maquina] + "\nVocê ganhou";				
			}
		}
		return resultado;
	}
	public static void main(String args[]){
		String[] escolhas = {"Pedra",  "Papel", "Tesoura"};
		Scanner sc  = new Scanner(System.in);
		Random gerador = new Random();
		System.out.println("Escolhas\n0 : Pedra\n1 : Papel\n2 : Tesoura\nDigite aqui: ");
		int escolha = sc.nextInt();
		while(escolha > 2 || escolha < 0){
			System.out.println("Digite uma opção válida: ");
			escolha = sc.nextInt();
		}
		Jokenpo p1 = new Jokenpo(escolha);
		Jokenpo maquina = new Jokenpo(gerador.nextInt(3));
		System.out.println(jogo(p1.escolha, maquina.escolha, escolhas));
	}
}
