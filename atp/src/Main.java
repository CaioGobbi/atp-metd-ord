import java.util.*;

public class Main {
    public static void main(String[] args) {
        Graph library = new Graph();

        //adicionando alguns livros ao grafo
        Book harryPotter = new Book("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997);
        Book nineteenEightyFour = new Book("1984", "George Orwell", 1949);
        Book harryPotter2 = new Book("Harry Potter e a Câmara Secreta", "J.K. Rowling", 1998);
        Book leviataThomas = new Book("Leviatã", "Thomas Hobbes", 1651);
        Book oGuiaDoMochileiro = new Book("O Guia do Mochileiro das Galáxias", "Douglas Adams", 1979);
        Book olhosAgua = new Book("Olhos d'água", "Conceição Evaristo", 2014);
        Book aCulpa = new Book("A Culpa É das Estrelas", "John Green", 2012);
        Book cartaAoPai = new Book("Carta ao Pai", "Franz Kafka", 1919);
        Book metamorfose = new Book("A Metamorfose", "Franz Kafka", 1915);
        Book confieEmMim = new Book("Confie em Mim", "Harlan Coben", 2008);
        Book naoConteANinguem = new Book("Não Conte a Ninguém", "Harlan Coben", 2001);
        Book bibliotecaMeiaNoite = new Book("A Biblioteca da Meia-Noite", "Matt Haig", 2020);
        Book memoriasDeCubas = new Book("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881 );


        library.addBook(harryPotter);
        library.addBook(harryPotter2);
        library.addBook(leviataThomas);
        library.addBook(nineteenEightyFour);
        library.addBook(oGuiaDoMochileiro);
        library.addBook(olhosAgua);
        library.addBook(aCulpa);
        library.addBook(cartaAoPai);
        library.addBook(metamorfose);
        library.addBook(confieEmMim);
        library.addBook(naoConteANinguem);
        library.addBook(memoriasDeCubas);
        library.addBook(bibliotecaMeiaNoite);


        //estabelecendo conexões entre os livros
        library.addEdge(harryPotter, harryPotter2);
        library.addEdge(leviataThomas, nineteenEightyFour);
        library.addEdge(harryPotter2, oGuiaDoMochileiro);
        library.addEdge(oGuiaDoMochileiro, leviataThomas);
        library.addEdge(aCulpa, olhosAgua);
        library.addEdge(cartaAoPai, metamorfose);
        library.addEdge(confieEmMim, naoConteANinguem);
        library.addEdge(aCulpa, memoriasDeCubas);
        library.addEdge(bibliotecaMeiaNoite, cartaAoPai);

        //lista de livros lidos pelo usuário (simulada)
        Set<Book> userBooks = new HashSet<>();
        userBooks.add(harryPotter2);
        userBooks.add(metamorfose);
        userBooks.add(oGuiaDoMochileiro);

        //sugerindo livros com base nos livros lidos pelo usuário
        List<Book> suggestedBooks = library.suggestBooks(userBooks);
        System.out.println("Sugestões de livros:");
        for (Book book : suggestedBooks) {
            System.out.println(book.title);
        }
    }
}