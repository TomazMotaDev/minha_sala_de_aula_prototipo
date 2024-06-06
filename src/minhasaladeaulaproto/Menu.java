package minhasaladeaulaproto;

/*
*   Como o menu será utilizado com frequência, resolvi criar uma classe para ele
*   e sempre que for necessário instancia-lo. O usuário não tem acesso a ela.
*   Serve como uma forma de padronizar a escrita do código e facilitar a criação
*   de um Menu novo.
*/

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //ATRIBUTOS
    private String nomeMenu;
    private List<String> menu = new ArrayList();
    
    //CONSTRUTOR COM SEU NOME
    public Menu(String nomeMenu){
        this.nomeMenu = nomeMenu;
    }
    //GETTERS AND SETTERS
    public String getNomeMenu(){
        return nomeMenu;
    }
    
    public void setNomeMenu(String nomeMenu){
        this.nomeMenu = nomeMenu;
    }
    
    //ADICIONAR UMA NOVA STRING NA LISTA DE ITENS DO MENU
    public void addItemMenu(String itemMenu){
        menu.add(itemMenu);        
    }
    
    //METÓDO PARA EXIBIR OS ITENS DA LISTA
    public void mostrarMenu(){
        System.out.println("\n=========="+nomeMenu+"==========");
        int i = 1;
        for(String itemMenu : menu){
            System.out.println(" -> "+i+"- "+itemMenu);
            i++;
        }
    }
    
}
