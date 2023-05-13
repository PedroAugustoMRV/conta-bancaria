import java.util.Scanner;
import java.io.IOException;


class Console 
{
	public static void clear(String... arg) throws IOException, InterruptedException 
	{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	}
}

class ContaBancaria 
{
    
  static double saldo;  
	
	public static void top()
	{    
		System.out.print("\n|----------------------------------------------------------------------------|\n");
		System.out.print("|-----------------------Bem vindo ao Banco Tudo Nosso------------------------|\n");
		System.out.print("|----------------------------------------------------------------------------|\n");
		System.out.print("************************Por favor selecione uma opcao:***********************|\n");
		System.out.print("|----------------------------------------------------------------------------|\n");
	}
  
	public static boolean validarSangria(double valor)
	{    
		if(valor> saldo)
		{
			return false;
		}
		
		return true;
	}
	
	public static void sangriaSaldo(double valor)
	{   
		saldo = saldo - valor;
	}
	
	public static void saque()  throws IOException, InterruptedException
	{
		Scanner teclado = new Scanner(System.in); 
		
		System.out.print("\nDigite o valor que deseja sacar\n\n");
		double number_1 = teclado.nextDouble();
		 
		if(validarSangria(number_1) == false)
		{
			System.out.print("\nSaldo invalido\n");
			menu();		  
		}
		
		sangriaSaldo(number_1);
		
		System.out.print("\nSAQUE EFETUADO COM SUCESSO!!!!");
		menu();
	}
	
	public static void refrocoSaldo(double valor) 
	{    
		saldo = saldo + valor;
	}
	
	public static void depositar()  throws IOException, InterruptedException
	{
		Scanner teclado = new Scanner(System.in); 
		top();
		System.out.print("\n|-----------------------Digite o valor que deseja depositar------------------------|\n");
		System.out.print(  "|----------------------------------------------------------------------------------|\n");
		double number_2 = teclado.nextDouble();
		refrocoSaldo(number_2);
		System.out.print("\n|-----------------------DEPOSITO EFETUADO COM SUCESSO!!!!--------------------------|\n");
		System.out.print(  "|----------------------------------------------------------------------------------|\n");
		menu();
	}
	
	public static void validarSaque(double valor) 
	{
		saldo = saldo - valor; 
    }
	
	//public static void enterMenu() throws IOException, InterruptedException
	//{
		//System.out.print("Precione enter para retorna ao menu");
		//System.in.read();
	//{
		
	public static void exibirSaldo() throws IOException, InterruptedException
	{
      
		System.out.printf("\n\nO seu saldo e de: " + saldo );
		
		System.in.read();
			
		menu();
	}
	
	public static void menu() throws IOException, InterruptedException
	{
		Scanner teclado = new Scanner(System.in);   
		Console console = new Console(); 
		console.clear();
		
		int opcao;
		
		top();
		
		System.out.print("| [1] - Depositar - [2] - Sacar - [3] - Exibir saldo - [4] - Sair do sistema |\n");
		System.out.print("|----------------------------------------------------------------------------|\n");
		
		opcao = teclado.nextInt();       
		
		switch (opcao) 
		{
		  case 1:
			depositar();
		  break;
			
		  case 2:
			saque();
		  break;

		  case 3:
		  exibirSaldo();
		  break;

		  case 4:
		  System.out.print("\nOBRIGADO POR USAR O NOSSO SISTEMA <3\n\n");
		  System.exit(0);
		  break;

		default:
		  System.out.printf("\nInsira uma opção válida");
		  main(null);
		}
	}
	
	public static void main(String args[]) throws IOException, InterruptedException
	{  
	
		Scanner teclado = new Scanner(System.in);  
		
		
		saldo = 0;

		menu();    
		
		System.out.print(saldo);
		
		System.exit(0);
		
	}
}