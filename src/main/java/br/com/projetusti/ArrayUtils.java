package br.com.projetusti;

import java.util.List;
import java.util.Objects;

public final class ArrayUtils {

    /*
     * EXERCÍCIOS:
     *
     * 1) Complete a função 'findMedian' onde é recebido uma lista com um número ímpar de elementos e retornada um inteiro que represente a mediana.
     * A mediana de uma lista de números é exatamente o elemento do meio após a ordenação.
     * Por exemplo: A mediana de arr = [1, 2, 3, 4, 5] é 3, o elemento do meio no array ordenado.
     *
     * 2) Escreva testes unitários na classe ArrayUtilsTest para cobrir as funções 'findAt' e 'exists'.
     *
     * 3) Implemente o método 'doOperation' e testes unitários para o mesmo. Ele recebe uma lista de inteiros e realiza uma opertação de acordo com os parametros passados.
     */
    private ArrayUtils() {
    }

    /**
     * Retorna um inteiro que represente a mediana de uma lista com um número ímpar de elementos.
     *
     * @param array lista com um número ímpar de elementos.
     * @return Inteiro que represente a mediana.
     */
    static int findMedian(final List<Integer> array) throws Exception {
        int size = array.size();
        if (size % 2 == 0)
            throw new Exception("A lista deve ter tamanho ímpar.");

        int medianPosition = (int) Math.ceil((double) size / 2);

        return medianPosition;
    }

    /**
     * Retorna o elemento na posição <code>index</code> da lista de números inteiros maior ou igual a 0.
     *
     * @param array Lista de números inteiros maior ou igual a 0.
     * @param index index a ser pesquisado.
     * @return O elemento da lista no index passado como parametro. Caso o índice seja inválido, retorna -1.
     */
    static int findAt(final List<Integer> array, final int index) {
        int result = -1;
        if (index >= 0 && index < array.size()) {
            result = array.get(index);
        }
        return result;
    }

    /**
     * Verifica se um elemento existe ou não em uma lista de inteiros.
     *
     * @param array Lista de números inteiors.
     * @param value Valor a ser pesquisado.
     * @return <code>true</code> caso o elemento existe na lista, ou <code>falsa</code>, caso contrário.
     */
    static boolean exists(final List<Integer> array, final Integer value) {
        return array.stream().anyMatch(it -> Objects.equals(it, value));
    }

    /**
     * Realiza uma operação no array e retorna se a operação foi realizada com sucesso.
     *
     * @param array     Lista de números inteiros.
     * @param operation Operação a ser realizada.
     * @param value     Valor a ser utilizado na operação.
     * @return A operação foi realizada com sucesso?
     */
    static boolean doOperation(final List<Integer> array, final Operation operation, final Integer value) {
        switch (operation) {
            case ADD:
                array.add(value);
                return true;

            case REMOVE:
                int index = findAt(array, value);
                array.remove(index);
                return true;

            case EXISTS:
                exists(array, value);
                return true;

            default:
                return false;
        }
    }

    /**
     * Enum com as operações possíveis.
     */
    enum Operation {
        /**
         * Adiciona o elemento na lista. Retorna true se o elemento foi adicionado com sucesso.
         */
        ADD,
        /**
         * Remove o elemento na lista. Retorna true se o elemento existe na lista e foi removido com sucesso.
         */
        REMOVE,
        /**
         * Verifica se o elemento existe na lista. Retorna true caso positivo.
         */
        EXISTS
    }
}
