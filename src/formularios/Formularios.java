package formularios;

/*
*   Interface que servirá como classe pai para os formulários.
*   Aqui ficará armazenado o nome do formulário.
*
*   Professor,
*   Antes estava como classe abstrata que apenas guardava o nome do formulario.
*   Percebi então que podia simplificar colocando o nome para um paramêtro do
*   método ao invés de ter uma classe somente para isto. Ainda consegui tirar
*   o método de cabecalho() que não precisa mais.
*/

public interface Formularios {
    
    public void formulario(String nome);
}
