package document.assembler;

import java.util.Scanner;

/***
 * 
 * @author LunaRibeiro
 * 
 * **/
public class DocumentAssemblerApplication {

	  public static void main(String[] args) {
		    Scanner sc = new Scanner(System.in);
		    Tree arv = new Tree();
		    int opcao;
		    long x;
		    System.out.print("\n Programa Arvore binaria");
		    do {
		    System.out.print("\n***********************************");
		    System.out.print("\nEntre com a opcao:");
			System.out.print("\n ----1: Inserir");
			System.out.print("\n ----2: Excluir");
			System.out.print("\n ----3: Pesquisar");
			System.out.print("\n ----4: Exibir");
			System.out.print("\n ----5: Sair do programa");
			System.out.print("\n***********************************");
			System.out.print("\n-> ");
			opcao = sc.nextInt();
			switch(opcao) {
			 	case 1: {
				       System.out.print("\n Informe um valor -> ");
				       x = sc.nextLong();
				       arv.insert(x);
				       break;
				}
				case 2: {
				       System.out.print("\n Informe um valor-> ");
				       x = sc.nextLong();
				       if ( !arv.remove(x) )
		                          System.out.print("\n Valor nao encontrado!");;
				       break;
				}
				case 3: {
				       System.out.print("\n Informe o valor-> ");
		                       x = sc.nextLong();
			      	       if( arv.search(x) != null )
				          System.out.print("\n Valor Encontrado");
				       else 
				          System.out.print("\n Valor nao encontrado!");
				       break;
				}	 
				case 4: {
				      arv.percorrer();
				      break; 
				}
		    } 
		    } while(opcao != 5);

		  }
}
