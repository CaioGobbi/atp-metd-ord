import java.util.ArrayList;
import java.util.List;

class Node { //cria a lista encadeada
    String titulo;
    String autor;
    int ano;
    Node next;

    //método construtor da lista(cria um novo nó/livro(Node))
    public Node(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.next = null; //indica que este nó é o último
    }
}

class LinkedList {
    private Node head; //indica o primeiro nó da lista (início)

    //método que adiciona um novo nó à lista
    public void addNode(String titulo, String autor, int ano) {
        Node newNode = new Node(titulo, autor, ano);
        if (head == null) {
            head = newNode;
        }else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }   
    }

    //método que exibe todos os livros da lista
    public void display() {
        Node temp = head;
        while (temp != null) { //percorre a lista até que encontre um nó null
            System.out.println("Título: " + temp.titulo + ", Autor: " + temp.autor + ", Ano: " + temp.ano);
            temp = temp.next;
        }
    }

    //método para sugerir livros baseado nos livros lidos pelo usuário
    public List<String> livrosSugeridos(List<String> userBooks) { //nova lista com os livros sugeridos
        List<String> sugestao = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            if (userBooks.contains(temp.autor)) {
                sugestao.add(temp.titulo);
            }
            temp = temp.next;
        }
        return sugestao;
    }

}
