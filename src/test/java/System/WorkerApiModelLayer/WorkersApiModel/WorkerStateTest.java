package System.WorkerApiModelLayer.WorkersApiModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class WorkerStateTest {

    private WorkerState workerState;

    @Mock
    private WorkerModel mockWorker;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        workerState = WorkerState.getInstance();
    }

    @Test
    void testSingletonInstance() {
        WorkerState instance1 = WorkerState.getInstance();
        WorkerState instance2 = WorkerState.getInstance();

        assertSame(instance1, instance2, "WorkerState should be a singleton!");
    }

    @Test
    void testGetInstanceAfterMultipleCalls() {
        WorkerState firstCall = WorkerState.getInstance();

        WorkerState secondCall = WorkerState.getInstance();

        assertSame(firstCall, secondCall, "Subsequent calls to getInstance should return the same instance.");
    }

    @Test
    void testInsertWorker() throws Exception {
        Mockito.when(mockWorker.GetId()).thenReturn(0); // Assume we insert at index 0

        boolean result = workerState.InsertWorker(mockWorker);

        assertTrue(result, "Worker should be inserted successfully.");

        assertSame(mockWorker, workerState.GetWorkerById(0), "Inserted worker should be at index 0.");
    }

    @ParameterizedTest
    @CsvSource({
            "-1, false",
            "0, false",
            "1, true"
    })
    void testParametrizedInsertWorker(int workerId, boolean expectedResult) throws Exception {
        Mockito.when(mockWorker.GetId()).thenReturn(workerId);

        boolean result = workerState.InsertWorker(mockWorker);

        assertTrue(result == expectedResult, "Worker insertion should match expected result.");

        assertSame(mockWorker, workerState.GetWorkerById(workerId), "Inserted worker should be at the correct position.");
    }

    @Test
    void testThrowExceptionInsertWorker() {
        // Arrange: Set up a mock worker with a negative ID
        Mockito.when(mockWorker.GetId()).thenReturn(-1);

        // Act & Assert: Verify that inserting a worker with a negative ID throws an exception
        Exception exception = assertThrows(Exception.class, () -> {
            workerState.InsertWorker(mockWorker);
        });

        // Optional: Verify the exception message
        assertEquals("Worker ID must be non-negative", exception.getMessage());
    }

    @Test
    void testDeleteWorker() throws Exception {
        Mockito.when(mockWorker.GetId()).thenReturn(0); // Assume we delete worker at index 0

        workerState.InsertWorker(mockWorker);

        WorkerModel deletedWorker = workerState.DeleteWorker(0);

        assertNotNull(deletedWorker, "The deleted worker should not be null.");
        assertNull(workerState.GetWorkerById(0), "Worker at index 0 should be null after deletion.");
    }
}
