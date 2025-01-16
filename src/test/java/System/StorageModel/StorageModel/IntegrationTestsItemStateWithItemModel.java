package System.StorageModel.StorageModel;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class IntegrationTestsItemStateWithItemModel {

    private ItemState itemState;

    @BeforeEach
    void setUp() {
        itemState = ItemState.getInstance();
    }

    @Test
    void testSelectItemToDisplay() {
        // Given
        itemState.DisplayAll().clear(); // Ensure list is empty
        ItemModel item1 = itemState.CreateItem(1, 10);
        ItemModel item2 = itemState.CreateItem(2, 20);
        itemState.DisplayAll().add(item1);
        itemState.DisplayAll().add(item2);

        // When
        ArrayList<ItemModel> foundItems = itemState.SelectItemToDisplay(1);

        // Then
        assertEquals(1, foundItems.size());
        assertEquals(1, foundItems.get(0).GetPartID());
    }

    @Test
    void testUpdateItems() {
        // Given
        itemState.DisplayAll().clear(); // Ensure list is empty
        ItemModel item1 = itemState.CreateItem(1, 10);
        itemState.DisplayAll().add(item1);

        ArrayList<ItemModel> itemsToUpdate = new ArrayList<>();
        itemsToUpdate.add(new ItemModel(1, 30)); // Update quantity for partID 1
        itemsToUpdate.add(new ItemModel(2, 50)); // Add new item with partID 2

        // When
        boolean result = itemState.UpdateItems(itemsToUpdate);

        // Then
        assertTrue(result);
        assertEquals(2, itemState.DisplayAll().size());
        assertEquals(30, itemState.DisplayAll().get(0).GetQuantity());
        assertEquals(50, itemState.DisplayAll().get(1).GetQuantity());
    }

    @Test
    void testRecoverBackup() {
        // Given
        itemState.DisplayAll().clear();
        ArrayList<ItemModel> backup = new ArrayList<>();
        backup.add(new ItemModel(1, 10));
        backup.add(new ItemModel(2, 20));

        // When
        boolean result = itemState.RecoverBackup(backup);

        // Then
        assertTrue(result);
        assertEquals(2, itemState.DisplayAll().size());
        assertEquals(10, itemState.DisplayAll().get(0).GetQuantity());
        assertEquals(20, itemState.DisplayAll().get(1).GetQuantity());
    }

    @Test
    void testFilterDataGreaterThan() {
        // Given
        itemState.DisplayAll().clear();
        itemState.DisplayAll().add(new ItemModel(1, 10));
        itemState.DisplayAll().add(new ItemModel(2, 20));
        itemState.DisplayAll().add(new ItemModel(3, 30));

        // When
        ArrayList<ItemModel> filteredItems = itemState.FilterData(3, 15); // Filter by quantity > 15

        // Then
        assertEquals(2, filteredItems.size());
        assertEquals(2, filteredItems.get(0).GetPartID());
        assertEquals(3, filteredItems.get(1).GetPartID());
    }

    @Test
    void testFilterDataLessThan() {
        // Given
        itemState.DisplayAll().clear();
        itemState.DisplayAll().add(new ItemModel(1, 10));
        itemState.DisplayAll().add(new ItemModel(2, 20));
        itemState.DisplayAll().add(new ItemModel(3, 30));

        // When
        ArrayList<ItemModel> filteredItems = itemState.FilterData(4, 25); // Filter by quantity < 25

        // Then
        assertEquals(2, filteredItems.size());
        assertEquals(1, filteredItems.get(0).GetPartID());
        assertEquals(2, filteredItems.get(1).GetPartID());
    }
}