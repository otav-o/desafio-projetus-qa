package br.com.projetusti;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {

    /**
     * Teste Case 1: Lista com os elementos de 0 a 10 em ordem decrescente.
     */
    private static final String TEST_CASE_1 = "test_case_1.txt";

    /**
     * Teste Case 2: Lista com os elementos de 1 a 1001 em ordem aleatória.
     */
    private static final String TEST_CASE_2 = "test_case_2.txt";

    /**
     * Dado o nome do arquivo, retorna a lista de inteiros nesse arquivo. O números devem estar separados por vírgula.
     *
     * @param fileName Nome do Arquivo.
     * @return Lista de inteiros presentes no arquivo.
     */
    private List<Integer> getListInt(final String fileName) throws URISyntaxException, IOException {
        final Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        final String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        return Arrays.stream(content.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    @Test
    public void findMedianCase1Test() throws Exception {
        Assert.assertEquals(5, ArrayUtils.findMedian(getListInt(TEST_CASE_1)));
    }

    @Test
    public void findMedianCase2Test() throws Exception {
        Assert.assertEquals(501, ArrayUtils.findMedian(getListInt(TEST_CASE_2)));
    }
}