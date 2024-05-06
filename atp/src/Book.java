import java.util.*;

class Book {
    String title;
    String author;
    int year;

    // Construtor
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Métodos getters para acessar os atributos
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}

class TreeNode {
    String author;
    List<Book> books;
    TreeNode left;
    TreeNode right;

    // Construtor
    public TreeNode(String author) {
        this.author = author;
        this.books = new ArrayList<>();
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    private TreeNode root;

    // Construtor
    public BinarySearchTree() {
        this.root = null;
    }

    // Método para inserir um livro na árvore
    public void insert(Book book) {
        root = insertRecursive(root, book);
    }

    // Método auxiliar para inserir um livro recursivamente
    private TreeNode insertRecursive(TreeNode root, Book book) {
        if (root == null) {
            root = new TreeNode(book.getAuthor());
            root.books.add(book);
            return root;
        }

        int compareResult = book.getAuthor().compareTo(root.author);
        if (compareResult < 0) {
            root.left = insertRecursive(root.left, book);
        } else if (compareResult > 0) {
            root.right = insertRecursive(root.right, book);
        } else {
            root.books.add(book);
        }

        return root;
    }

    // Método para buscar livros de um determinado autor na árvore
    public List<Book> searchByAuthor(String author) {
        TreeNode node = searchRecursive(root, author);
        if (node != null) {
            return node.books;
        } else {
            return null;
        }
    }

    // Método auxiliar para buscar um autor na árvore recursivamente
    private TreeNode searchRecursive(TreeNode root, String author) {
        if (root == null || root.author.equals(author)) {
            return root;
        }

        int compareResult = author.compareTo(root.author);
        if (compareResult < 0) {
            return searchRecursive(root.left, author);
        } else {
            return searchRecursive(root.right, author);
        }
    }

    // Método para realizar a busca em profundidade (DFS) na árvore
    public void depthFirstSearch(TreeNode node, Set<Book> visitedBooks) {
        if (node != null) {
            for (Book book : node.books) {
                if (!visitedBooks.contains(book)) {
                    // Aqui você pode fazer qualquer operação desejada com o livro, como adicionar à lista de recomendações
                    System.out.println("Recomendação: " + book.getTitle() + " por " + book.getAuthor());
                    visitedBooks.add(book);
                }
            }
            depthFirstSearch(node.left, visitedBooks);
            depthFirstSearch(node.right, visitedBooks);
        }
    }
}

class Graph {
    Map<Book, List<Book>> adjacencyList;
    BinarySearchTree authorTree;

    // Construtor
    public Graph() {
        adjacencyList = new HashMap<>();
        authorTree = new BinarySearchTree();
    }

    // Método para adicionar um novo livro ao grafo e à árvore binária de busca
    public void addBook(Book book) {
        // Adiciona o livro ao grafo
        adjacencyList.put(book, new ArrayList<>());

        // Adiciona o livro à árvore binária de busca
        authorTree.insert(book);
    }

    // Método para adicionar uma conexão entre dois livros (aresta)
    public void addEdge(Book from, Book to) {
        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from); // Se a conexão for bidirecional
    }

    // Método para buscar livros de um determinado autor no grafo
    public List<Book> searchByAuthor(String author) {
        return authorTree.searchByAuthor(author);
    }

    // Método para realizar a busca em profundidade (DFS) na árvore binária de busca
    public void depthFirstSearch(TreeNode node, Set<Book> visitedBooks) {
        if (node != null) {
            for (Book book : node.books) {
                if (!visitedBooks.contains(book)) {
                    // Aqui você pode fazer qualquer operação desejada com o livro, como adicionar à lista de recomendações
                    System.out.println("Recomendação: " + book.getTitle() + " por " + book.getAuthor());
                    visitedBooks.add(book);
                }
            }
            depthFirstSearch(node.left, visitedBooks);
            depthFirstSearch(node.right, visitedBooks);
        }
    }

    // Método para recomendar caminho mais curto ou mais relevante entre dois livros usando Dijkstra
    public List<Book> recommendPath(Book source, Book destination) {
        Map<Book, Double> distances = new HashMap<>();
        Map<Book, Book> previous = new HashMap<>();
        PriorityQueue<Book> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        // Inicialização
        for (Book book : adjacencyList.keySet()) {
            distances.put(book, Double.POSITIVE_INFINITY);
            previous.put(book, null);
        }
        distances.put(source, 0.0);

        // Adiciona o nó de origem à fila de prioridade
        queue.add(source);

        while (!queue.isEmpty()) {
            Book current = queue.poll();
            for (Book neighbor : adjacencyList.get(current)) {
                double newDistance = distances.get(current) + calculateEdgeWeight(current, neighbor);
                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        // Reconstruir o caminho a partir do destino até a origem
        List<Book> path = new ArrayList<>();
        Book current = destination;
        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }
        Collections.reverse(path);

        return path;
    }

    // Método auxiliar para calcular o peso de uma aresta entre dois livros
    private double calculateEdgeWeight(Book source, Book destination) {
        return 1.0;
    }

    // Bubble Sort para ordenar uma lista de livros por título
    public void bubbleSortByTitle(List<Book> books) {
        int n = books.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (books.get(j).getTitle().compareTo(books.get(j + 1).getTitle()) > 0) {
                    // Swap books[j] with books[j+1]
                    Book temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
    }

    // Merge Sort para ordenar uma lista de livros por ano
    public void mergeSortByYear(List<Book> books) {
        if (books.size() <= 1) {
            return;
        }
        int mid = books.size() / 2;
        List<Book> left = new ArrayList<>(books.subList(0, mid));
        List<Book> right = new ArrayList<>(books.subList(mid, books.size()));
        mergeSortByYear(left);
        mergeSortByYear(right);
        merge(books, left, right);
    }

    // Método auxiliar para mesclar duas listas ordenadas
    private void merge(List<Book> books, List<Book> left, List<Book> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getYear() < right.get(j).getYear()) {
                books.set(k++, left.get(i++));
            } else {
                books.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            books.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            books.set(k++, right.get(j++));
        }
    }
}