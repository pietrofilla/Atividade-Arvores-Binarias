public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(15);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(7);
        arvoreBinaria.inserir(12);
        arvoreBinaria.inserir(18);

        System.out.println("\nEm ordem:");
        arvoreBinaria.percurso("Em");

        System.out.println("\nRemovendo nó folha:");
        arvoreBinaria.remover(3);
        arvoreBinaria.percurso("Em");

        System.out.println("\nRemovendo nó com um filho:");
        arvoreBinaria.remover(5);
        arvoreBinaria.percurso("Em");

        System.out.println("\nRemovendo nó com dois filhos:");
        arvoreBinaria.remover(15);
        arvoreBinaria.percurso("Em");

        System.out.println("\nRemovendo a raiz:");
        arvoreBinaria.remover(10);
        arvoreBinaria.percurso("Em");

    }
}