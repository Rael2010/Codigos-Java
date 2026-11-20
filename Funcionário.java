public class Funcionário{
	String nome;
	String cargo;
	float salario;
	String cpf;
	public void mostrar() {
		System.out.printf("Exibindo o funcionário \n");
		if (nome != null)
			System.out.printf("Nome: %s \n", nome);
		else
		    System.out.printf("Nome: Não foi informado corretamente \n");
		System.out.printf("Cargo: %s \n", cargo);
		System.out.printf("CPF: %s      Salário: R$ %.2f \n",
			cpf, salario);
	}
	public Funcionário (String nome, String cargo, float salario, String cpf) {
		if (nome.trim().length() >=5 ){
			this.nome = nome;
		} else {
			System.out.printf("Nome inválido \n");

			this.nome = "Não informado - inicializado no método construtor";
		}
		if (cargo.trim().length() >=5) {
			this.cargo = cargo;

		} else {
			System.out.printf("Cargo inválido \n");
			this.cargo = "Assistente em administração";
		}
		if (salario >= 1621f){
			this.salario = salario;

		} else {
			System.out.printf("Salário inválido. Definindo ele como R$ 1621,00 \n");
			this.salario = 1621f;
		}
		this.cpf = cpf;		
	}
	public static void main (String args[]) {
		Funcionário f1 = new Funcionário("Miguel", "Jogador de e-sports", 500f, "122.345.556-69"); 
		f1.mostrar();
		Funcionário f2 = new Funcionário("Zé", "adm", 3435.76f, "098.123.564-45");
		f2.mostrar();
	
	}

}