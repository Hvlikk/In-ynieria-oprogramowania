package System.StorageModel.StorageModel;
import System.StorageModel.StorageModel.CustomTestExceptionHandler;
import System.StorageModel.StorageModel.ItemModel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Ustalamy kolejność wykonywania testów na podstawie @Order
@ExtendWith(CustomTestExceptionHandler.class) // Obsługa wyjątków
class NItemModelTests {

    static Stream<ItemModel> itemModelProvider() {
        return Stream.of(
                new ItemModel(1, 10),
                new ItemModel(2, 20),
                new ItemModel(3, 30),
                new ItemModel(4, 40)
        );
    }

    private ItemModel itemModel;

    @BeforeEach
    void setUp() {
        itemModel = new ItemModel(1, 10);
    }

    @ParameterizedTest
    @Order(1)
    @MethodSource("itemModelProvider")
    void testGetPartID(ItemModel model) {
        assertEquals(model.GetPartID(), model.GetPartID());
    }

    @Test
    @Order(2)
    void testGetQuantity() {
        assertEquals(10, itemModel.GetQuantity());
    }

    @Test
    @Order(3)
    void testSetPartID() {
        itemModel.SetPartID(2);
        assertEquals(2, itemModel.GetPartID());
    }

    @Test
    @Order(4)
    void testSetQuantity() {
        itemModel.SetQuantity(20);
        assertEquals(20, itemModel.GetQuantity());
    }

    @ParameterizedTest
    @Order(5)
    @CsvSource({
            "1, 10",
            "2, 20",
            "3, 30"
    })
    void testConstructorValid(int partID, int quantity) {
        ItemModel model = new ItemModel(partID, quantity);
        assertEquals(partID, model.GetPartID());
        assertEquals(quantity, model.GetQuantity());
    }

    @ParameterizedTest
    @Order(6)
    @CsvSource({
            "-1, 10",
            "1, -10",
            "-1, -10"
    })
    void testConstructorInvalid(int partID, int quantity) {
        assertThrows(IllegalArgumentException.class, () -> new ItemModel(partID, quantity));
    }

    @Test
    @Order(7)
    void testSetPartIDInvalid() {
        assertThrows(IllegalArgumentException.class, () -> itemModel.SetPartID(-1));
    }

    @Test
    @Order(8)
    void testSetQuantityInvalid() {
        assertThrows(IllegalArgumentException.class, () -> itemModel.SetQuantity(-1));
    }

    @Test
    @Order(9)
    void testConstructorWithNegativePartIDThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new ItemModel(-1, 10));
        assertEquals("partID cannot be negative", exception.getMessage());
    }

    @Test
    @Order(10)
    void testConstructorWithNegativeQuantityThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new ItemModel(1, -10));
        assertEquals("quantity cannot be negative", exception.getMessage());
    }

    @Test
    @Order(11)
    void testSetPartIDWithNegativeValueThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> itemModel.SetPartID(-1));
        assertEquals("partID cannot be negative", exception.getMessage());
    }

    @Test
    @Order(12)
    void testSetQuantityWithNegativeValueThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> itemModel.SetQuantity(-1));
        assertEquals("quantity cannot be negative", exception.getMessage());
    }

    @Test
    @Order(13)
    void testEqualityOfSameObjects() {
        ItemModel model1 = new ItemModel(1, 10);
        ItemModel model2 = new ItemModel(1, 10);
        assertEquals(model1.GetPartID(), model2.GetPartID(), "Obiekty z tymi samymi danymi powinny być równe.");
        assertEquals(model1.GetQuantity(), model2.GetQuantity(), "Obiekty z tymi samymi danymi powinny być równe.");
    }

    @ParameterizedTest
    @Order(14)
    @CsvSource({
            "0, 0",
            "1, 999999",
            "12345, 67890"
    })
    void testConstructorWithValidBoundaryValues(int partID, int quantity) {
        ItemModel model = new ItemModel(partID, quantity);
        assertEquals(partID, model.GetPartID());
        assertEquals(quantity, model.GetQuantity());
    }

    @ParameterizedTest
    @Order(15)
    @CsvSource({
            "1, -1",
            "-1, 1",
            "-1, -1"
    })
    void testInvalidConstructorWithBoundaryValues(int partID, int quantity) {
        assertThrows(IllegalArgumentException.class, () -> new ItemModel(partID, quantity));
    }

    @Test
    @Order(16)
    void testExtremeValues() {
        assertDoesNotThrow(() -> new ItemModel(Integer.MAX_VALUE, Integer.MAX_VALUE), "Konstruktor powinien obsłużyć maksymalne wartości.");
        assertThrows(IllegalArgumentException.class, () -> new ItemModel(Integer.MIN_VALUE, 1), "PartID nie może być ujemny.");
        assertThrows(IllegalArgumentException.class, () -> new ItemModel(1, Integer.MIN_VALUE), "Quantity nie może być ujemny.");
    }

    @Test
    @Order(17)
    void testSetExtremeValues() {
        itemModel.SetPartID(Integer.MAX_VALUE);
        itemModel.SetQuantity(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, itemModel.GetPartID());
        assertEquals(Integer.MAX_VALUE, itemModel.GetQuantity());
    }
}
