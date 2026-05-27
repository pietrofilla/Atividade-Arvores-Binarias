import java.util.Stack;
public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore criada com sucesso");
    }

    public boolean estaVazia() {
        return this.raiz == null || this.raiz.getConteudo() == null;
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);
        if (estaVazia()) {
            this.raiz = novoNo;
        } else {
            No aux = this.raiz;
            while (true) {
                if (aux.getConteudo() > novoNo.getConteudo()) {
                    if (aux.getEsquerda() == null) {
                        aux.setEsquerda(novoNo);
                        return;
                    } else {
                        aux = aux.getEsquerda();
                    }
                } else if (aux.getConteudo() < novoNo.getConteudo()) {
                    if (aux.getDireita() == null) {
                        aux.setDireita(novoNo);
                        return;
                    } else {
                        aux = aux.getDireita();
                    }
                } else {
                    return; // Pra não insere repetido
                }
            }
        }
    }

    public void remover(Integer valor) {
        if (estaVazia()) return;

        No atual = this.raiz;
        No pai = null;

        // Pra procurar o Nó
        while (atual != null && !atual.getConteudo().equals(valor)) {
            pai = atual;
            if (valor < atual.getConteudo()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }

        // Se não achar o Nó
        if (atual == null) {
            System.out.println("Valor não encontrado.");
            return;
        }

        // Para os Nós com 2 filhos
        if (atual.getEsquerda() != null && atual.getDireita() != null) {
            No sucessorPai = atual;
            No sucessor = atual.getDireita();

            // Procura o menor nó da direita
            while (sucessor.getEsquerda() != null) {
                sucessorPai = sucessor;
                sucessor = sucessor.getEsquerda();
            }

            // Troca o valor do nó atual pelo valor do sucessor
            atual.setConteudo(sucessor.getConteudo());

            // Troca o Nó a ser removido, pelo sucessor
            atual = sucessor;
            pai = sucessorPai;
        }

        // Para Nós com 1 ou 0 filhos
        No filhoSubstituto;
        if (atual.getEsquerda() != null) {
            filhoSubstituto = atual.getEsquerda();
        } else {
            filhoSubstituto = atual.getDireita();
        }

        // 4. Junta o Nó filho ao Nó pai, ou na raiz
        if (pai == null) {
            // Se o pai é nulo, remove a raiz
            this.raiz = filhoSubstituto;
        } else {
            // Verifica se o nó atual era filho da esquerda ou da direita do pai
            if (pai.getEsquerda() == atual) {
                pai.setEsquerda(filhoSubstituto);
            } else {
                pai.setDireita(filhoSubstituto);
            }
        }

        System.out.println("Nó " + valor + " removido.");
    }

    public void percurso(String tipo) {
        if (estaVazia()) return;
        if (tipo.equals("Em")) {
            System.out.println("Executando em ordem:");
            emOrdem();
        }
    }

    private void emOrdem() {
        Stack<No> pilha = new Stack<>();
        No aux = this.raiz;

        while (aux != null || !pilha.isEmpty()) {
            // Vai para o ponto mais na esquerda
            while (aux != null) {
                pilha.push(aux);
                aux = aux.getEsquerda();
            }

            // Pega o nó da pilha e imprime
            aux = pilha.pop();
            System.out.print(aux.getConteudo() + " ");

            // Vai para a direita
            aux = aux.getDireita();
        }
        System.out.println();
    }
}