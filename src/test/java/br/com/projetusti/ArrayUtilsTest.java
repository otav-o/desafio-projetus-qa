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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

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
     * Teste Case 3: Lista de tamanho par
     */
    private static final String TEST_CASE_3 = "test_case_3.txt";

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

    @Test
    public void throwExceptionWhenLengthIsEven() {
        Assertions.assertThrows(Exception.class, () -> {
            ArrayUtils.findMedian(getListInt(TEST_CASE_3));
        });
    }

    @Test
    public void findAtCase1Test() throws Exception {

        List<Integer> list = getListInt(TEST_CASE_1);

        Assert.assertEquals(8, ArrayUtils.findAt(list, 2));
        Assert.assertEquals(0, ArrayUtils.findAt(list, 10));
        Assert.assertEquals(10, ArrayUtils.findAt(list, 0));
        Assert.assertEquals(-1, ArrayUtils.findAt(list, 11));
        Assert.assertEquals(-1, ArrayUtils.findAt(list, -1));
    }

    @Test
    public void findAtCase3Test() throws Exception {

        List<Integer> list = getListInt(TEST_CASE_3);

        Assert.assertEquals(5, ArrayUtils.findAt(list, 0));
        Assert.assertEquals(-1, ArrayUtils.findAt(list, 10));
        Assert.assertEquals(70, ArrayUtils.findAt(list, 3));
        Assert.assertEquals(4, ArrayUtils.findAt(list, 1));
    }

    @DisplayName("Returns false when value does not exist")
    @ParameterizedTest
    @ValueSource(ints = {15, 25, -1, 12, -5, 100, 75, -124})
    public void existsTestFalse(int value) throws Exception {

        List<Integer> list = getListInt(TEST_CASE_1);

        Assertions.assertFalse(ArrayUtils.exists(list, value));
    }

    @DisplayName("Returns true when value exists")
    @ParameterizedTest
    @ValueSource(ints = {5, 4, 3, 70})
    public void existsTestTrue(int value) throws Exception {

        List<Integer> list = getListInt(TEST_CASE_3);

        Assertions.assertTrue(ArrayUtils.exists(list, value));
    }
}