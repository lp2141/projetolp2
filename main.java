import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{

	private Scanner l;
	private boolean execute;
	private List<Dados> dados;

	public static void main(String[] args) {
		new Main();
	}

	private Main() {
		l = new Scanner(System.in);
		execute = true;
		dados = new ArrayList<Dados>();

		System.out.println("Projeto LP2.");

		while (execute) {
			String opcao = menu();

			if (opcao.equalsIgnoreCase("c")) {
				cadastrar();
			} 
			else if(opcao.equalsIgnoreCase("e")){
				loginSistema();
				}
			else if (opcao.equalsIgnoreCase("l")) {
				listarCadastros();
			} else if (opcao.equalsIgnoreCase("s")) {
				execute = false;
			} else {
				System.out.println("\n Opcao inexistente \n");
			}
		}
	}

	private String menu() {
		System.out.println("Selecione a opção:");
		System.out.println("Tecle C para um novo cadastro");
		System.out.println("L - Listar cadastros");
		System.out.println(" E - Entrar no sistema"); //ver isso
		System.out.println("Tecle S para sair");
		return l.nextLine();
	}

	private void cadastrar() {
		boolean cadastrando = true;

		while (cadastrando) {
			System.out.println("Cadastro de Usuário");
			Dados d = new Dados();
			d.setEmail(textInput("Email:"));
			d.setLogin(textInput("Login: "));
			d.setDicadesenha(textInput("Dica de senha: "));
			d.setSenha(textInput("Senha:   "));
			
			String cadastrar = textInput("Adicionar cadastro (S/N) ?");
			if (cadastrar.equalsIgnoreCase("s")) {
				System.out.println("Cadastro adicionado !!!");
				dados.add(d);
			} else if (cadastrar.equalsIgnoreCase("n")){
				System.out.println("Cadastro ignorado !!!");
			} else {
				System.out.println("\n Opcao Inexistente \n");
			}

			String continua = textInput("Continuar cadastrando (S/N) ?");
			if (continua.equalsIgnoreCase("N")) {
				cadastrando = false;
			} else if (continua.equalsIgnoreCase("s")){

			} else {
				System.out.println("\nOpção inválida seu noob, eu vou sair só porque você não colabora !!! \n");
				cadastrando = false;
			}
		}
	}
	private void loginSistema() {
		System.out.println("Teste");
		
		}
	private void listarCadastros() {
		if (dados.size() == 0) {
			System.out.println("\nNão existem cadastros !!!\n");
		} else {
			System.out.println("\nLista de Cadastros\n");
			for (int i = 0; i < dados.size(); i++) {
				Dados d = dados.get(i);
				System.out.println("Cadastro número: " + i);
				System.out.println("\tNome: " + d.getEmail());
				System.out.println("\tLogin: " + d.getLogin());
				System.out.println("\tDicadesenha: " + d.getDicadesenha() + "\n");
				System.out.println("\tSenha: " + d.getSenha() + "\n");

			}
			System.out.println("\nFim da lista\n");
		}
	}

	private String textInput(String label) {
		System.out.println(label);
		return l.nextLine();
	}
}
