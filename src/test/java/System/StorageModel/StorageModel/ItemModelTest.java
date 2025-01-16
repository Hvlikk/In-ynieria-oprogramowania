package System.StorageModel.StorageModel;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ItemModelTest {

    @Test
    void testConstructorAndGetters() {
        // Given
        int expectedPartID = 123;
        int expectedQuantity = 50;

        // When
        ItemModel item = new ItemModel(expectedPartID, expectedQuantity);

        // Then
        assertEquals(expectedPartID, item.GetPartID()); // `null` bo metoda przyjmuje parametr, chociaż nie jest potrzebny
        assertEquals(expectedQuantity, item.GetQuantity()); // jak wyżej
    }

    @Test
    void testSetPartID() {
        // Given
        ItemModel item = new ItemModel(123, 50);
        int newPartID = 456;

        // When
        item.SetPartID(newPartID);

        // Then
        assertEquals(newPartID, item.GetPartID());
    }

    @Test
    void testSetQuantity() {
        // Given
        ItemModel item = new ItemModel(123, 50);
        int newQuantity = 100;

        // When
        item.SetQuantity(newQuantity);

        // Then
        assertEquals(newQuantity, item.GetQuantity());
    }
}