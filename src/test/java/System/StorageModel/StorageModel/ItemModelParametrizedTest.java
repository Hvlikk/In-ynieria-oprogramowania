package System.StorageModel.StorageModel;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemModelParametrizedTest {

    @ParameterizedTest
    @CsvSource({
            "123, 50",
            "456, 100",
            "789, 200"
    })
    void testConstructorAndGetters(int partID, int quantity) {
        // When
        ItemModel item = new ItemModel(partID, quantity);

        // Then
        assertEquals(partID, item.GetPartID());
        assertEquals(quantity, item.GetQuantity());
    }

    @ParameterizedTest
    @CsvSource({
            "123, 456",
            "789, 101",
            "111, 999"
    })
    void testSetPartID(int initialPartID, int newPartID) {
        // Given
        ItemModel item = new ItemModel(initialPartID, 50);

        // When
        item.SetPartID(newPartID);

        // Then
        assertEquals(newPartID, item.GetPartID());
    }

    @ParameterizedTest
    @CsvSource({
            "50, 100",
            "200, 300",
            "400, 500"
    })
    void testSetQuantity(int initialQuantity, int newQuantity) {
        // Given
        ItemModel item = new ItemModel(123, initialQuantity);

        // When
        item.SetQuantity(newQuantity);

        // Then
        assertEquals(newQuantity, item.GetQuantity());
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 50",  // Negatywne partID
            "123, -10", // Negatywna ilość
            "-5, -15"  // Obydwa wartości negatywne
    })
    void testConstructorWithInvalidValues(int partID, int quantity) {
        // Expect
        assertThrows(IllegalArgumentException.class, () -> new ItemModel(partID, quantity));
    }

    @ParameterizedTest
    @CsvSource({
            "-1", // Negatywne partID
            "-50" // Kolejne negatywne partID
    })
    void testSetPartIDWithInvalidValues(int invalidPartID) {
        // Given
        ItemModel item = new ItemModel(123, 50);

        // Expect
        assertThrows(IllegalArgumentException.class, () -> item.SetPartID(invalidPartID));
    }

    @ParameterizedTest
    @CsvSource({
            "-10", // Negatywna ilość
            "-100" // Kolejne negatywne wartości
    })
    void testSetQuantityWithInvalidValues(int invalidQuantity) {
        // Given
        ItemModel item = new ItemModel(123, 50);

        // Expect
        assertThrows(IllegalArgumentException.class, () -> item.SetQuantity(invalidQuantity));
    }
}
