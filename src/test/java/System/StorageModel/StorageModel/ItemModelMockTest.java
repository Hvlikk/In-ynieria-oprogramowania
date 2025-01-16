package System.StorageModel.StorageModel;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemModelMockTest {

    @Test
    void testMockGetPartID() {
        // Given: A mocked instance of ItemModel
        ItemModel mockItem = mock(ItemModel.class);
        when(mockItem.GetPartID()).thenReturn(123);

        // When: Calling the mocked method
        int partID = mockItem.GetPartID();

        // Then: Verify the behavior
        assertEquals(123, partID);
        verify(mockItem, times(1)).GetPartID();
    }

    @Test
    void testMockGetQuantity() {
        // Given: A mocked instance of ItemModel
        ItemModel mockItem = mock(ItemModel.class);
        when(mockItem.GetQuantity()).thenReturn(50);

        // When: Calling the mocked method
        int quantity = mockItem.GetQuantity();

        // Then: Verify the behavior
        assertEquals(50, quantity);
        verify(mockItem, times(1)).GetQuantity();
    }

    @Test
    void testMockSetPartID() {
        // Given: A mocked instance of ItemModel
        ItemModel mockItem = mock(ItemModel.class);

        // When: Setting a value
        mockItem.SetPartID(456);

        // Then: Verify that the method was called with the correct argument
        verify(mockItem, times(1)).SetPartID(456);
    }

    @Test
    void testMockSetQuantity() {
        // Given: A mocked instance of ItemModel
        ItemModel mockItem = mock(ItemModel.class);

        // When: Setting a value
        mockItem.SetQuantity(100);

        // Then: Verify that the method was called with the correct argument
        verify(mockItem, times(1)).SetQuantity(100);
    }

    @Test
    void testBehaviorWithMockInteraction() {
        // Given: A mocked instance of ItemModel
        ItemModel mockItem = mock(ItemModel.class);
        when(mockItem.GetPartID()).thenReturn(123);
        when(mockItem.GetQuantity()).thenReturn(50);

        // When: Interacting with the mock
        int partID = mockItem.GetPartID();
        int quantity = mockItem.GetQuantity();

        // Then: Validate interactions and values
        assertEquals(123, partID);
        assertEquals(50, quantity);
        verify(mockItem, times(1)).GetPartID();
        verify(mockItem, times(1)).GetQuantity();
    }
}
