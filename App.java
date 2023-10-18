public class App {

    public static void main(String[] args) {

        LinkedListOfIntegerDetalhes lista = new LinkedListOfIntegerDetalhes();

        lista.add(10);
        lista.add(8);
        lista.add(9);
        lista.add(20);
        lista.add(5);

        System.out.println(lista);

        //Reordenacao crescente da lista usando o metodo BubbleSort
        lista.bubbleSortCre(lista);
        System.out.println(lista);

        //Reordenacao decrescente da lista usando o metodo BubbleSort
        lista.bubbleSortDec(lista);
        System.out.println(lista);





    }
}
