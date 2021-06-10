package br.com.projetusti;

public final class StringUtils {

    /*
     * EXERCÍCIOS:
     *
     * 1) Palíndrome é uma palavra, frase, número, ou outra sequência de caracteres que lido de trás para frente é a mesma coisa.
     * Por exemplo:
     * - Madam -> lido de trás pra frente -> madaM
     * - Madam I'm Adam -> lido de trás pra frente -> madA m'I madaM
     * Implemente o método 'isPalindrome'. Ele recebe uma String e verifica se a String informada é um palíndrome retorne TRUE ou FALSE
     *
     * 2) Implemente o método 'isEmpty'. Ele recebe uma String e verifica se a String informada é null ou vazia e retorna TRUE ou FALSE
     */
    private StringUtils() {
    }

    /**
     * Verifica se a String informada é palíndrome e retorna TRUE se for palíndrome e FALSE se não for.
     *
     * @param anything String
     * @return TRUE ou FALSE
     */
    static Boolean isPalindrome(final String anything) {

        String palindrome = getPalindrome(anything);

        if (anything
                .replaceAll(" ", "")
                .equalsIgnoreCase(palindrome))
            return true;

        return false;
    }

    /**
     * Retorna o palíndrome de uma String, sem espaços.
     *
     * @param anything String
     * @return A String de trás para frente.
     */
    static String getPalindrome(final String anything) {
        String palindrome = "";

        for (int i = anything.length() - 1; i >= 0; i--)
            palindrome += anything.charAt(i);

        palindrome = palindrome.replaceAll(" ", "");

        return palindrome;
    }

    /**
     * Verifica se a String informada é nula ou está vazia.
     *
     * @param anything String
     * @return TRUE ou FALSE
     */
    static Boolean isEmpty(final String anything) {

        if (anything == null || anything.trim().length() == 0)
            return true;

        return false;
    }
}
