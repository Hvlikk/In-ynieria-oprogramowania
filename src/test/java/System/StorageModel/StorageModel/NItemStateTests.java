package System.StorageModel.StorageModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Ustalamy kolejność wykonywania testów na podstawie @Order
@ExtendWith(CustomTestExceptionHandler.class) // Obsługa wyjątków
public class NItemStateTests {

    static Stream<ItemModel> itemModelProvider() {
        return Stream.of(
                new ItemModel(1, 10),
                new ItemModel(2, 20),
                new ItemModel(3, 30),
                new ItemModel(4, 40)
        );
    }

    private ItemState itemState;

    @BeforeEach
    void setUp() {
        itemState = ItemState.getInstance();
        itemState.DisplayAll().clear();
    }

    @Test
    @Order(1)
    void testGetInstance() {
        assertNotNull(itemState);
    }

    @ParameterizedTest
    @MethodSource("itemModelProvider")
    @Order(2)
    void testSelectItemToDisplay(ItemModel model) {
        ArrayList<ItemModel> result = itemState.SelectItemToDisplay(1);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(model.GetPartID(), result.get(i).GetPartID());
            assertEquals(model.GetPartID(), result.get(i).GetQuantity());
        }
    }

    @Test
    @Order(3)
    void testUpdateItems() {
        ItemModel item1 = new ItemModel(1, 10);
        ArrayList<ItemModel> itemsToUpdate = new ArrayList<>();
        itemsToUpdate.add(item1);

        boolean result = itemState.UpdateItems(itemsToUpdate);
        assertTrue(result);
        assertEquals(1, itemState.DisplayAll().size());
        assertEquals(10, itemState.DisplayAll().get(0).GetQuantity());
    }

    @Test
    @Order(4)
    void testUpdateItemsInvalid() {
        ArrayList<ItemModel> itemsToUpdate = new ArrayList<>();
        ItemModel mockedItem = Mockito.mock(ItemModel.class);

        // Konfigurujemy mock, aby zwracał nieprawidłowe dane
        when(mockedItem.GetPartID()).thenReturn(-1);
        when(mockedItem.GetQuantity()).thenReturn(10);

        itemsToUpdate.add(mockedItem);
        assertThrows(IllegalArgumentException.class, () -> itemState.UpdateItems(itemsToUpdate));
    }

    @Test
    @Order(5)
    void testRecoverBackup() {
        ArrayList<ItemModel> backup = new ArrayList<>();
        backup.add(new ItemModel(1, 10));

        boolean result = itemState.RecoverBackup(backup);
        assertTrue(result);
        assertEquals(1, itemState.DisplayAll().size());
    }

    @Test
    @Order(6)
    void testRecoverBackupNull() {
        assertThrows(NullPointerException.class, () -> itemState.RecoverBackup(null));
    }

    @ParameterizedTest
    @Order(7)
    @CsvSource({
            "1, 10, 10",
            "2, 20, 20"
    })
    void testCreateItem(int partID, int quantity, int expectedQuantity) {
        ItemModel item = itemState.CreateItem(partID, quantity);
        assertEquals(partID, item.GetPartID());
        assertEquals(expectedQuantity, item.GetQuantity());
    }

    @Test
    @Order(8)
    void testCreateItemInvalid() {
        assertThrows(IllegalArgumentException.class, () -> itemState.CreateItem(-1, 10));
    }

    @Test
    @Order(9)
    void testFilterData() {
        ItemModel item1 = new ItemModel(1, 10);
        ItemModel item2 = new ItemModel(2, 20);
        itemState.DisplayAll().add(item1);
        itemState.DisplayAll().add(item2);

        ArrayList<ItemModel> filtered = itemState.FilterData(1, 1);
        assertEquals(1, filtered.size());
        assertEquals(20, filtered.get(0).GetQuantity());
    }

    @Test
    @Order(10)
    void testUpdateItemsWithNullListThrowsException() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> itemState.UpdateItems(null));
        assertEquals("itemsToUpdate cannot be null", exception.getMessage());
    }

    @Test
    @Order(11)
    void testUpdateItemsWithNegativePartIDThrowsException() {
        ItemModel mockedItem = Mockito.mock(ItemModel.class);

        when(mockedItem.GetPartID()).thenReturn(-1);
        when(mockedItem.GetQuantity()).thenReturn(10);

        ArrayList<ItemModel> itemsToUpdate = new ArrayList<>();
        itemsToUpdate.add(mockedItem);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> itemState.UpdateItems(itemsToUpdate));
        assertEquals("partID and quantity cannot be negative", exception.getMessage());
    }

    @Test
    @Order(12)
    void testUpdateItemsWithNegativeQuantityThrowsException() {
        ArrayList<ItemModel> itemsToUpdate = new ArrayList<>();
        ItemModel mockedItem = Mockito.mock(ItemModel.class);

        when(mockedItem.GetPartID()).thenReturn(1);
        when(mockedItem.GetQuantity()).thenReturn(-10);
        itemsToUpdate.add(mockedItem);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> itemState.UpdateItems(itemsToUpdate));
        assertEquals("partID and quantity cannot be negative", exception.getMessage());
    }

    @Test
    @Order(13)
    void testRecoverBackupWithNullListThrowsException() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> itemState.RecoverBackup(null));
        assertEquals("Backup cannot be null", exception.getMessage());
    }

    @Test
    @Order(14)
    void testCreateItemWithNegativePartIDThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> itemState.CreateItem(-1, 10));
        assertEquals("partID and quantity cannot be negative", exception.getMessage());
    }

    @Test
    @Order(15)
    void testCreateItemWithNegativeQuantityThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> itemState.CreateItem(1, -10));
        assertEquals("partID and quantity cannot be negative", exception.getMessage());
    }

    @Test
    @Order(16)
    void testFilterDataWithInvalidFilterThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> itemState.FilterData(5, 10));
        assertEquals("Invalid filter type", exception.getMessage());
    }

    @ParameterizedTest
    @Order(17)
    @CsvSource({
            "1, 10, true",
            "-1, 10, false",
            "1, -10, false"
    })
    void testUpdateItemsParameterizedWithCustomExceptionHandling(int partID, int quantity, boolean expectedResult) {
        ItemModel mockedItem = Mockito.mock(ItemModel.class);

        when(mockedItem.GetPartID()).thenReturn(partID);
        when(mockedItem.GetQuantity()).thenReturn(quantity);

        ArrayList<ItemModel> itemsToUpdate = new ArrayList<>();
        itemsToUpdate.add(mockedItem);

        if (expectedResult) {
            assertTrue(itemState.UpdateItems(itemsToUpdate));
        } else {
            assertThrows(IllegalArgumentException.class, () -> itemState.UpdateItems(itemsToUpdate));
        }
    }

    @Test
    @Order(18)
    void testFilterDataWithInvalidFilterThrowsExceptionHandled() {
        assertThrows(IllegalArgumentException.class, () -> itemState.FilterData(5, 10));
    }
}
