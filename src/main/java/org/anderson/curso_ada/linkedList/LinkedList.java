package org.anderson.curso_ada.linkedList;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        private String data;

        private Node next;

        Node(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }

    public LinkedList(String data) {
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public void getHead() {
        if(head == null) {
            System.err.println("List is empty");
        } else {
            System.out.println("Head: " + head.data);
        }
    }

    public void getTail() {
        if(tail == null) {
            System.err.println("List is empty");
        } else {
            System.out.println("Tail: " + tail.data);
        }
    }

    public void getLength() {
        System.out.println("Length: " + this.length);
    }

    // Método para esvaziar a lista
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void print() {
        Node temp = this.head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void append(String data) {
        // Criando um novo nó com os dados fornecidos
        Node newNode = new Node(data);

        if(this.length == 0) {
            // Se a lista estiver vazia, tanto o head quanto o tail apontam para o novo nó
            this.head = newNode;
            this.tail = newNode;
        } else {
            // Caso contrário, o próximo nó do tail atual é o novo nó e atualizamos o tail
            this.tail.next = newNode;
            tail = newNode;
        }
        // Incrementa o tamanho da lista
        length++;
    }

    public Node removeLast() {
        // Se a lista estiver vazia, retorna null
        if( this.length == 0) return null;

        // Começa do head da lista
        Node pre = this.head;

        // Percorre a lista para encontrar o nó imediatamente anterior ao tail
        while (pre.next != this.tail) {
            pre = pre.next;
        }

        // Armazena o tail atual para retorná-lo depois
        Node temp  = pre.next;

        // Atualiza o tail para o penúltimo nó
        this.tail = pre;

        // Remove o último nó definindo o próximo do novo tail como null
        this.tail.next = null;

        // Decrementa o tamanho da lista
        this.length--;

        if (this.length == 0) {
            // Se a lista ficar vazia, define head e tail como null
            this.head = null;
            this.tail = null;
        }

        return temp;
    }

    public void prepend(String data) {
        // Criando um novo nó com os dados fornecidos
        Node newNode = new Node(data);

        if(this.length == 0) {
            // Se a lista estiver vazia, tanto o head quanto o tail apontam para o novo nó
            this.head = newNode;
            this.tail = newNode;
        } else {
            // Caso contrário, define o próximo nó do novo nó como o head atual e atualiza o head
            newNode.next = this.head;
            this.head = newNode;
        }
        // Incrementa o tamanho da lista
        length++;
    }

    public Node removeFirst() {
        // Se a lista estiver vazia, retorna null
        if(this.length == 0) return null;

        // Nó a ser removido
        Node pre = this.head;

        if(pre.next == null) {
            // Se a lista tiver apenas um elemento, esvazia a lista
            this.makeEmpty();
        }

        // guardando o nó a ser removido para retornar no método
        Node temp = head;

        // nó head se tornando o próximo nó
        this.head = pre.next;

        // decrementa o tamanho da lista
        this.length--;

        return temp;
    }

    public Node get(int index) {
        // Se o índice for inválido (menor que 0 ou maior ou igual ao comprimento da lista), retorna null
        if(index < 0 || index > this.length) return null;

        // Inicia a busca a partir do head da lista
        Node temp = this.head;

        // Percorre a lista até chegar ao índice desejado
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, String data) {
        // Obtém o nó na posição especificada
        Node temp = this.get(index);

        // Se o nó não existir (índice inválido), retorna false
        if(temp == null ) return false;

        // Atualiza os dados do nó
        temp.data = data;
        return true;
    }

    public boolean insert(int index, String data)  {
        if(index < 0 || index > this.length) return false;

        // Se o índice for 0, insere no início da lista
        if(index == 0) {
            this.prepend(data);
            return true;
        }

        // Se o índice for igual ao comprimento da lista, insere no final da lista
        if(index == this.length) {
            this.append(data);
            return true;
        }

        // Cria um novo nó com os dados fornecidos
        Node newNode = new Node(data);

        // Obtém o nó na posição anterior ao índice especificado
        Node temp = this.get(index - 1);

        // Ajusta os ponteiros para inserir o novo nó na posição correta
        newNode.next = temp.next;
        temp.next = newNode;

        return true;
    }
}
