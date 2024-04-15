public class Main {
    public static void main(String[] args) {
        LinkedList livraria = new LinkedList();

        livraria.addNode("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997);
        livraria.addNode("1984", "George Orwell", 1949);
        livraria.addNode("Leviatã", "Thomas Hobbes", 1651);
        livraria.addNode("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881 );
        livraria.addNode("Confie em Mim", "Harlan Coben", 2008);
        livraria.addNode("A Biblioteca da Meia-Noite", "Matt Haig", 2020);
        livraria.addNode("A Metamorfose", "Franz Kafka", 1915);
        livraria.addNode("O Guia do Mochileiro das Galáxias", "Douglas Adams", 1979);
        livraria.addNode("Olhos d'água", "Conceição Evaristo", 2014);
        livraria.addNode("A Culpa É das Estrelas", "John Green", 2012);

        livraria.display();
    }
}