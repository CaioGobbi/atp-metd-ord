import java.util.*;

class Book { //cria a lista encadeada
    String title;
    String author;
    int year;

    //método construtor da lista(cria um novo nó/livro(Node))
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}

class Graph { //criando o grafo
    Map<Book, List<Book>> adjacencyList;

    //Construtor
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    //método para adicionar um novo livro ao grafo
    public void addBook(Book book) {
        adjacencyList.put(book, new ArrayList<>());
    }

    //método para adicionar uma conexão entre dois livros (aresta)
    public void addEdge(Book from, Book to) {
        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from); //conexão bidirecional
    }

    //método para sugerir livros com base nos livros lidos pelo usuário
    public List<Book> suggestBooks(Set<Book> userBooks) {
        Set<Book> suggestedBooks = new HashSet<>();
        for (Book userBook : userBooks) {
            List<Book> connectedBooks = adjacencyList.get(userBook);
            if (connectedBooks != null) {
                suggestedBooks.addAll(connectedBooks);
            }
        }
        suggestedBooks.removeAll(userBooks); //remover livros já lidos pelo usuário
        return new ArrayList<>(suggestedBooks);
    }
}