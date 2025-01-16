package System.StorageModel.StorageModel;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

class ItemStateExceptionTest {

    private ItemState itemState;
    private ItemModel itemModel;

    @BeforeEach
    void setUp() {
        itemState = ItemState.getInstance();
        itemState.DisplayAll().clear(); // Czyszczenie listy przed każdym testem
    }

    @Test
    void testSelectItemToDisplayWithNullList() {
        // Given
        itemState.DisplayAll().clear();

        // When & Then
        // Powinna zwrócić pustą listę, ale nie wyjątek
        ArrayList<ItemModel> result = itemState.SelectItemToDisplay(1);
        assert result.isEmpty();
    }

    @Test
    void testUpdateItemsWithNullArgument() {
        // When & Then
        assertThrows(NullPointerException.class, () -> itemState.UpdateItems(null));
    }

    @Test
    void testUpdateItemsWithInvalidItemUsingMock() {
        // Given
        ArrayList<ItemModel> invalidItems = new ArrayList<>();
        invalidItems.add(new ItemModel(1, 10));
        invalidItems.add(new ItemModel(2, 20));

        // Mockowanie metod (symulacja nieprawidłowego zachowania)
        ItemModel mockItem1 = mock(ItemModel.class);
        when(mockItem1.GetPartID()).thenReturn(-1); // Ujemny partID
        when(mockItem1.GetQuantity()).thenReturn(10);

        invalidItems.set(0, mockItem1);

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> itemState.UpdateItems(invalidItems));
    }

    @Test
    void testRecoverBackupWithNull() {
        // When & Then
        assertThrows(NullPointerException.class, () -> itemState.RecoverBackup(null));
    }

    @Test
    void testFilterDataWithInvalidFilter() {
        // Given
        itemState.DisplayAll().add(new ItemModel(1, 10));

        // When & Then
        // Wywołanie z nieprawidłowym typem filtra powinno zakończyć się błędem
        assertThrows(IllegalArgumentException.class, () -> itemState.FilterData(99, 15)); // 99 to nieprawidłowy typ filtra
    }

    @Test
    void testCreateItemWithNegativeValues() {
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> itemState.CreateItem(-1, 10)); // Ujemny partID
        assertThrows(IllegalArgumentException.class, () -> itemState.CreateItem(1, -10)); // Ujemna ilość
    }
}
