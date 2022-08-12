package document.assembler;

public class Tree {
	
	  private No root; // raiz

	  public Tree() { root=null; } // inicializa a árvore

	  public void insert(long v) {
	    No novo = new No(); // cria um novo Nó
	    
	    novo.item = v; // atribui o valor recebido ao item de dados do Nó
	    novo.dir = null;
	    novo.esq = null;

	    if (root == null) root = novo;
	    // se nao for a raiz
	    else  { 
	      No atual = root;
	      No anterior;
	      while(true) {
	        anterior = atual;
	        // ir para esquerda
	        if (v <= atual.item) { 
	          atual = atual.esq;
	          if (atual == null) {
	            anterior.esq = novo;
	            return;
	          } 
	        }  
	        // ir para direita
	        else { 
	           atual = atual.dir;
	           if (atual == null) {
	             anterior.dir = novo;
	             return;
	           }
	        } 
	      } 
	    } 

	  }

	  public No search(long chave) {
	    if (root == null) return null; // se árvore está vazia
	    No atual = root;  // busca desde o começo da raiz
	    while (atual.item != chave) { 
	      if(chave < atual.item ) atual = atual.esq; //vai para a esquerda
	      else atual = atual.dir; // vai para a direita
	      if (atual == null) return null; // encontrou uma folha -> sai
	    } 
	    return atual; 
	  }
	  
	  public boolean remove(long v) {
		    if (root == null) return false; 

		    No atual = root;
		    No pai = root;
		    boolean filho_esq = true;

		    // ------- Buscando o valor --------
		    while (atual.item != v) { 
		      pai = atual;
		      if(v < atual.item ) { 
		        atual = atual.esq;
		        filho_esq = true; 
		      }
		      else { 
		        atual = atual.dir; 
		        filho_esq = false; 
		      }
		      if (atual == null) return false; 
		    } 

		    if (atual.esq == null && atual.dir == null) {
		      if (atual == root ) root = null; 
		      else if (filho_esq) pai.esq = null; 
		           else pai.dir = null; 
		    }

		    else if (atual.dir == null) {
		       if (atual == root) root = atual.esq; 
		       else if (filho_esq) pai.esq = atual.esq; 
		            else pai.dir = atual.esq; 
		    }
		    
		    else if (atual.esq == null) {
		       if (atual == root) root = atual.dir; 
		       else if (filho_esq) pai.esq = atual.dir; 
		            else pai.dir = atual.dir; 
		    }

		    else {
		      No sucessor = no_sucessor(atual);
		   
		      if (atual == root) root = sucessor; 
		      else if(filho_esq) pai.esq = sucessor; 
		           else pai.dir = sucessor; 
		      sucessor.esq = atual.esq;   
		    }
		    return true;
		  }
	  
	  	public No no_sucessor(No apaga) { 
		     No paidosucessor = apaga;
		     No sucessor = apaga;
		     No atual = apaga.dir; 

		     while (atual != null) {
		       paidosucessor = sucessor;
		       sucessor = atual;
		       atual = atual.esq;
		     } 
		     if (sucessor != apaga.dir) { 
		       paidosucessor.esq = sucessor.dir; 
		       sucessor.dir = apaga.dir; 
		     }
		     return sucessor;
		  }
	  	
	  	 public void percorrer() {
	  	    System.out.print("\nExibindo em ordem: ");
	  	    inOrder(root);
	  	    System.out.print("\nExibindo em pos-ordem: ");
	  	    posOrder(root);
	  	    System.out.print("\nExibindo em pre-ordem: ");
	  	    preOrder(root);
	  	    System.out.print("\nAltura da arvore: " + altura(root));
	  	    System.out.print("\nQuantidade de folhas: " + folhas(root));
	  	    System.out.print("\nQuantidade de Nós: " + contarNos(root));
	  	    if (root != null ) {  
	  	       System.out.print("\n Valor minimo: " + min().item);
	  	       System.out.println("\n Valor maximo: " + max().item);
	  	    }
	  	  }

	  	  public void inOrder(No atual) {
	  	    if (atual != null) {
	  	      inOrder(atual.esq);
	  	      System.out.print(atual.item + " ");
	  	      inOrder(atual.dir);
	  	    }
	  	  }
	  	  
	  	  public void preOrder(No atual) {
	  	    if (atual != null) {
	  	      System.out.print(atual.item + " ");
	  	      preOrder(atual.esq);
	  	      preOrder(atual.dir);
	  	    }
	  	  }
	  	  
	  	  public void posOrder(No atual) {
	  	    if (atual != null) {
	  	      posOrder(atual.esq);
	  	      posOrder(atual.dir);
	  	      System.out.print(atual.item + " ");
	  	    }
	  	  }  
	  	  
	  	  public int altura(No atual) {
	  	     if(atual == null || (atual.esq == null && atual.dir == null))
	  	       return 0;
	  	     else {
	  	   	if (altura(atual.esq) > altura(atual.dir))
	  	   	   return ( 1 + altura(atual.esq) );
	  	   	else
	  		   return ( 1 + altura(atual.dir) );
	  	     }
	  	  }
	  	  
	  	  public int folhas(No atual) {
	  	    if(atual == null) return 0;
	  	    if(atual.esq == null && atual.dir == null) return 1;
	  	    return folhas(atual.esq) + folhas(atual.dir);
	  	  }
	  	  
	  	  public int contarNos(No atual) {
	  	   if(atual == null)  return 0;
	  	   else return ( 1 + contarNos(atual.esq) + contarNos(atual.dir));
	  	  }

	  	  public No min() {
	  	    No atual = root;
	  	    No anterior = null;
	  	    while (atual != null) {
	  	      anterior = atual;
	  	      atual = atual.esq;
	  	    }
	  	    return anterior;
	  	  }

	  	  public No max() {
	  	    No atual = root;
	  	    No anterior = null;
	  	    while (atual != null) {
	  	      anterior = atual;
	  	      atual = atual.dir;
	  	    }
	  	    return anterior;
	  	  }

	 }
