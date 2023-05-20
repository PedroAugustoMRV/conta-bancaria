import java.util.Scanner;
import java.io.IOException;

class Console {

    public static void clear(String... arg) throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}


class ContaBancaria {
    
  static double saldo;  
  
  public static void topo() throws IOException, InterruptedException{ 
        
    Console console = new Console();

    console.clear();

    System.out.println("+------------------------------------------------------------------------------------------------------+");
    System.out.println("|------------------------------------------------------------------------------------------------------|");
    System.out.println("|------------------------------------------------------------------------------------------------------|");
    System.out.println("|-----------------------------------       BANCO DO PEDRO       ---------------------------------------|");
    System.out.println("|------------------------------------------------------------------------------------------------------|");
    System.out.println("|------------------------------------------------------------------------------------------------------|");
    System.out.println("+------------------------------------------------------------------------------------------------------+");
  }
  
  public static void pressioneParaMenu() throws IOException, InterruptedException{
    System.out.print("\n\n\nPressione enter para voltar ao menu principal");
    System.in.read();
  }
  
  public static void pressioneParaContinuar() throws IOException, InterruptedException{
    System.out.print("\n\n\nPressione enter para continuar");
    System.in.read();
  }
  
  public static void encerrarSistema() throws IOException, InterruptedException{
    topo();
      System.out.println("| Obrigado por usar o nosso sistema, ate a proxima                                                     |");
      System.out.println("+------------------------------------------------------------------------------------------------------+");   
      System.out.println("| Estamos encerrando as operacoes e sairemos automaticamente ao concluir                               |");
      System.out.println("+------------------------------------------------------------------------------------------------------+");    
      Thread.currentThread().sleep(10000);        
      System.exit(0);
  }
  
  public static boolean validarSangria(double valor){    
    
    if(valor > saldo){
      return false;
    }
    
    return true;
  }
  
  public static void reforcoSaldo(double valor){
    saldo = saldo + valor;
  }
  
  public static void sangriaSaldo(double valor){
    saldo = saldo - valor;
  }
    
  public static void depositar() throws IOException, InterruptedException{
    
      Scanner teclado = new Scanner(System.in);   
      
      double valor;
      
      topo();
      System.out.println("| O saldo atual e de:                                                                                  | ");
      System.out.printf("| R$ %.2f                                                                                             |\n ", saldo);
      System.out.println("+------------------------------------------------------------------------------------------------------+");
      System.out.println("| Qual o valor que voce deseja depositar?                                                              | ");
      System.out.println("+------------------------------------------------------------------------------------------------------+");   
     
      valor = teclado.nextDouble();
      
      reforcoSaldo(valor);  
      
      topo();
      System.out.println("| O saldo atual e de:                                                                                  | ");
      System.out.printf("| R$ %.2f                                                                                             |\n ", saldo);
      System.out.println("+------------------------------------------------------------------------------------------------------+");
      System.out.println("| Deposito realizado com sucesso                                                                       | ");
      System.out.println("+------------------------------------------------------------------------------------------------------+");   
      pressioneParaMenu();
      
      menu();      
      
  }
  
  public static double sacar() throws IOException, InterruptedException{
      
      Scanner teclado = new Scanner(System.in);   
      
      double valor;
      
      topo();
      System.out.println("| O saldo atual e de:                                                                                  | ");
      System.out.printf("| R$ %.2f                                                                                             |\n ", saldo);
      System.out.println("+------------------------------------------------------------------------------------------------------+");
      System.out.println("| Qual o valor que voce deseja sacar?                                                              | ");
      System.out.println("+------------------------------------------------------------------------------------------------------+");   
     
      valor = teclado.nextDouble();           
      
      if(validarSangria(valor) == false){
        topo();
        System.out.println("| O saldo atual e de:                                                                                  | ");
        System.out.printf("| R$ %.2f                                                                                             |\n ", saldo);
        System.out.println("+------------------------------------------------------------------------------------------------------+");
        System.out.println("| Saldo insuficiente, reinicie a operacao                                                              | ");
        System.out.println("+------------------------------------------------------------------------------------------------------+");   
        pressioneParaMenu();
        menu();
      }
      
      sangriaSaldo(valor);  
        
      topo();
      System.out.println("| O saldo atual e de:                                                                                  | ");
      System.out.printf("| R$ %.2f                                                                                             |\n ", saldo);
      System.out.println("+------------------------------------------------------------------------------------------------------+");
      System.out.println("| Saque realizado com sucesso                                                                          | ");
      System.out.println("+------------------------------------------------------------------------------------------------------+");   
      pressioneParaMenu();
      
    return saldo;
  } 
  
  public static double exibirSaldo() throws IOException, InterruptedException {
    
    topo();
    System.out.printf("| O seu saldo e de: R$ %.2f | gaste com sabedoria... ou nao...                                      |\n ", saldo);
    System.out.println("+------------------------------------------------------------------------------------------------------+");    
   
    pressioneParaMenu();
    
    return saldo;
  }
  
  public static void menu() throws IOException, InterruptedException{
    Scanner teclado = new Scanner(System.in);   

    int opcao;
    
    topo();
    System.out.println("| Selecione uma opcao e digite enter para continuar:                                                   | ");
    System.out.println("| [1] - Depositar   |  [2] - Sacar      |   [3] - Ver saldo |   [4] - Sair do Sistema                  | ");
    System.out.println("+------------------------------------------------------------------------------------------------------+");
    
    opcao = teclado.nextInt();       
    
    switch (opcao) {
      case 1:
      depositar();
      break;

      case 2:
      sacar();
      menu();
      break;

      case 3:
      exibirSaldo();
      menu();
      break;

      case 4:
      encerrarSistema();
      break;

    default:
      System.out.printf("Insira uma opção válida");
    }
    
  }
  

	public static void main(String args[]) throws IOException, InterruptedException{  

    saldo = 0;

    menu();    
       
    System.exit(0);
		
	}

}