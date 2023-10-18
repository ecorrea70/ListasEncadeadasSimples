/**
 * CLASSE LinkedListOfInteger
 * Trabalhando com estruturas lineares em formato de listas encadeadas
 * */

public class LinkedListOfIntegerDetalhes {

    // Referência para o primeiro elemento da lista encadeada.
    private Node head;
    // Referência para o último elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;

    // Construtor padrão da classe
    public LinkedListOfIntegerDetalhes() {
        head = null;
        tail = null;
        count = 0;
    }

    /**********************************************************************************
    /*** CREATE | Operações de inserção de dados na lista encadeada
    /**********************************************************************************

    /**
     * Método add()
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element)  {

        System.out.println("\n--------- INSERINDO NOVO ELEMENTO AO FINAL DA LISTA --------- ");

        Node n = new Node(element);
        System.out.println("Criando novo NODE [" + n.element + "]");

        if (head == null) {
            head = n;
            System.out.println("HEAD recebe NODE [" + head.element + "]");
        } else {
            tail.next = n;
            System.out.println("NEXT do TAIL recebeu o NODE...");
        }
        tail = n;
        System.out.println("TAIL recebeu NODE [" + tail.element + "] na posição " + count);
        count++;
        System.out.println("COUNT incrementado: " + count);
    }

    /**
     * Método add() para determinada posição
     * Insere um elemento em uma determinada posicao da lista.
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) {

        System.out.println("\n--------- INSERINDO NOVO ELEMENTO EM POSICAO ESPECIFICA --------- ");

        // Primeiro verifica se index eh valido
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        // Cria o nodo
        Node n = new Node(element);
        System.out.println("Criando novo NODE [" + n.element + "] para ser inserido na posição " + index);

        // Encadear o nodo na lista
        if (index == 0) { // se insercao no inicio
            if (count == 0) { // se a lista estava vazia
                tail = n;
                System.out.println("Lista vazia! TAIL recebe NODE [" + n.element + "] na primeira posição " + index);
            }
            else {
                n.next = head;
                System.out.println("NEXT do NODE recebe HEAD [" + head.element + "]");
            }
            head = n;
            System.out.println("HEAD recebe NODE [" + n.element + "] na posição " + index);
        }
        else if (index == count) { // se insercao no fiim
            tail.next = n;
            tail = n;
            System.out.println("Final da lista! TAIL recebe NODE [" + n.element + "] na posição " + index);
        }
        else { // se insercao no meio
            Node ant = head;
            System.out.println("ANT armazena HEAD [" + head.element + "]");
            for (int i=0; i<index-1; i++) {
                ant = ant.next;
                System.out.println("ANT recebe NEXT DO ANT [" + ant.element + "]");
            }
            n.next = ant.next;
            System.out.println("NEXT do NODE recebe NEXT do ANT [" + ant.element + "]");
            ant.next = n;
            System.out.println("NEXT do ANT recebe NODE [" + n.element + "] na posição " + index);
        }

        // Atualiza o count
        count++;
        System.out.println("COUNT incrementado: " + count);
    }


    /**********************************************************************************
    /*** READ | Operações de leitura de dados na lista encadeada
    /**********************************************************************************

    /**
     * Método get()
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posição da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {

        // Avalia se o índice está na faixa aceita (maior que 0 e menor ou igual ao tamanho da lista
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }

        System.out.println("\n--------- RECUPERANDO O VALOR EM POSICAO ESPECIFICA --------- ");

        // Se o índica selecionado é o do último elemento, retorna tail
        if (index == count-1) {
            System.out.println("Valor na posição " + index + " é [" + tail.element + "]");
            return tail.element;
        }

        System.out.println("Percorre a lista até chegar no índice especificado...");
        // Cria um auxiliar com o valor de head
        Node aux = head;
        int c = 0;
        // percorre todos os elementos até chegar o índice determinado
        while (c < index) {
            // associa ao próximo node
            System.out.println("[" + aux.element + "]");
            aux = aux.next;
            c++;
        }
        System.out.println("Valor na posição " + index + " é [" + aux.element + "]");
        return aux.element;
    }


     /**********************************************************************************
     /*** UPDATE | Operações de substituição de dados na lista encadeada
     /**********************************************************************************

     /**
     * Método set()
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer set(int index, Integer element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }

        System.out.println("\n--------- ATUALIZANDO VALOR EM POSICAO ESPECIFICA --------- ");

        if (index == count-1) {
            Integer auxElem = tail.element;
            tail.element = element;
            System.out.println("Troca do valor [" + auxElem + "] por [" + element + "] no índice " + index);
            return auxElem;
        }

        System.out.println("Percorre a lista até chegar no índice especificado...");
        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            System.out.println("AUX recebe NEXT DO ANT [" + aux.element + "]");
            c++;
        }
        Integer auxElem = aux.element;
        aux.element = element;
        System.out.println("Troca do valor [" + auxElem + "] por [" + element + "] no índice " + index);

        return auxElem;
    }

    /**********************************************************************************
    /*** DELETE | Operações de remoção de dados na lista encadeada
    /**********************************************************************************

    /**
     * Método remove()
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente.
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */   
    public boolean remove(Integer element) {
        // Se a lista esta vazia
        if (count == 0)
            return false;

        System.out.println("\n--------- REMOVENDO VALOR DA LISTA --------- ");

        System.out.println("Remover o valor [" + element + "]");
        // Se remocao do primeiro elemento da lista
        if (element.equals(head.element)) {
            if (count == 1) { // se tem apenas um elemento na lista
                tail = null;
                System.out.println("Apenas um elemento na list! TAIL recebe null");
            }
            head = head.next;
            System.out.println("HEAD recebe NEXT do HEAD");
            count--;
            System.out.println("Decrementa o count: " + count);
            return true;
        }

        Node ant = head; // referencia aponta para o anterior
        System.out.println("ANT recebe HEAD [" + head.element + "]");
        Node aux = head.next; // referencia aponta para o elemento que esta sendo verificado
        System.out.println("AUX recebe NEXT DO HEAD...");

        System.out.println("Percorre a lista até encontrar o elemento requisitado...");
        for (int i=1; i<count; i++) {
            System.out.println("[" + aux.element + "]");
            if (aux.element.equals(element)) { // se achou o elemento a ser removido
                System.out.println("Encontrado! ");
                if (aux == tail) { // se remocao do ultimo
                    tail = ant;
                    tail.next = null;
                    System.out.println("TAIL recebe ANT e NEXT do TAIL recebe null");
                }
                else { // se remocao do meio
                    ant.next = aux.next;
                    System.out.println("NEXT do ANT recebe NEXT do AUX");
                }
                count--; // atualiza cont
                System.out.println("Decrementa o count: " + count);
                return true;
            }
            aux = aux.next;
            System.out.println("AUX recebe NEXT de AUX [" + aux.element + "]");
            ant = ant.next;
            System.out.println("ANT recebe NEXT de ANT [" + ant.element + "]");
        }   
        // Se nao removeu
        return false;
    }

    /**
     * Método removeByIndex()
     * Remove o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        System.out.println("\n--------- REMOVENDO VALOR EM POSICAO ESPECIFICA --------- ");

        System.out.println("Remover o valor da posição: " + index );

        // Se remocao do primeiro
        if (index == 0) {
            Integer elemRemovido = head.element;
            head = head.next;
            if (count == 1) {// se tinha apenas um elemento na lista
                tail = null;
            }
            count--;
            return elemRemovido;
        }

        Node ant = head;

        System.out.println("Percorre a lista até encontrar o índice requisitado...");
        for (int i = 0; i < index - 1; i++) {
            ant = ant.next;
        }
        Integer elemRemovido = ant.next.element;
        if (index == count - 1) { // se remocao do ultimo
            tail = ant;
            tail.next = null;
        } else { // se remocao do meio
            ant.next = ant.next.next;
            // Alternativa para o comando acima
            // Node aux = ant.next;
            // ant.next = aux.next;
        }
        count--;
        System.out.println("Decrementa o count: " + count);
        return elemRemovido;
    }


    /**********************************************************************************
    /*** OUTRAS OPERAÇÕES
    /**********************************************************************************

    /**
     * Método contains()
     * Retorna true se a lista contem o elemento especificado.
     * @param element o elemento a ser testado
     * @return true se a lista contem o elemento especificado
     */
    public boolean contains(Integer element) {

        System.out.println("\n--------- VERIFICA SE VALOR ESTA CONTIDO NA LISTA --------- ");
        System.out.println("Valor a ser buscado [" + element + "]");

        System.out.println("Percorre a lista até encontrar o índice requisitado...");
        Node aux = head;
        while(aux != null) {
            if (aux.element.equals(element)) {
                System.out.println("Valor encontrado na lista!");
                return true;
            }
            aux = aux.next;
        }
        System.out.println("Valor encontrado não encontrado lista!");
        return false;
    }

    /**
     * Método indexOf()
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista nao contem o elemento.
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista nao contem o elemento
     */
    public int indexOf(Integer element) {

        System.out.println("\n--------- APRESENTA O INDICE DE UM VALOR DA LISTA --------- ");
        System.out.println("Valor a ser buscado [" + element + "]");

        System.out.println("Percorre a lista até encontrar o índice requisitado...");
        Node aux = head;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                System.out.println("Valor encontrado na lista no índice: " + i);
                return i;
            }
            aux = aux.next;
        }
        System.out.println("Valor não existe na lista!");
        return -1;
    }

    /**
     * Método isEmpty()
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Método size()
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Método clear()
     * Esvazia a lista
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Método toString()
     * Sobrescrita do método toString padrão para a impressão em formato específico
     */
    @Override
    public String toString() {

        int i = 0, c = 0;
        StringBuilder s = new StringBuilder();

        Node aux = head;
        while (aux != null) {
            s.append(aux.element.toString());
            s.append(" | ");
            aux = aux.next;
            i++;
        }
        return s.toString();
    }

    //Ordenacao usando o metodo BubbleSort
    public static void bubbleSort(LinkedListOfIntegerDetalhes lista) {
        int i, j, aux, n = lista.size();
        for(i=0; i<(n-1); i++) {
            for (j=0; j<(n-i-1); j++) {
                if (lista.get(j) > lista.get(j+1)) {
                    aux = lista.get(j);
                    lista.set(j, lista.get(j+1));
                    lista.set(j+1,aux);
                }
            }
        }
    }

     /**********************************************************************************
     /*** ATIVIDADES PRATICAS
     /**********************************************************************************


      /**
      * Método int[] subList(int fromIndex, int toIndex)
      * Cria um novo arranjo de valores inteiros a partir de um escopo definido da lista original
      * @param fromIndex o índice inicial do escopo (incluído)
      * @param toIndex o índice final do escopo (não incluído)
      * @return retorna um arranjo com os elementos da lista original
      */



    /**
     * Método reverse()
     * inverte a lista encadeada
     */



     /**
      * Método int countOccurrences(int element)
      * Conta a quantidade de ocorrência de um elemento na lista encadeada
      * @param element valor inteiro correspondente ao dado a ser verificado
      * @return quantidade de vezes que o valor foi encontrado
      */







}
