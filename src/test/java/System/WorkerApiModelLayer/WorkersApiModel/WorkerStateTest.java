package System.WorkerApiModelLayer.WorkersApiModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.sql.Connection;

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
        // Get two instances of WorkerState
        WorkerState instance1 = WorkerState.getInstance();
        WorkerState instance2 = WorkerState.getInstance();

        // Verify that both instances are the same
        assertSame(instance1, instance2, "WorkerState should be a singleton!");
    }

    @Test
    void testGetInstanceAfterMultipleCalls() {
        // First call to getInstance
        WorkerState firstCall = WorkerState.getInstance();

        // Mocking another call to getInstance
        WorkerState secondCall = WorkerState.getInstance();

        // Verify the same instance is returned
        assertSame(firstCall, secondCall, "Subsequent calls to getInstance should return the same instance.");
    }

    @Test
    void testInsertWorker() {
        // Create a mock WorkerModel
        Mockito.when(mockWorker.GetId()).thenReturn(0); // Assume we insert at index 0

        // Insert the worker into WorkerState
        boolean result = workerState.InsertWorker(mockWorker);

        // Verify the result
        assertTrue(result, "Worker should be inserted successfully.");

        // Verify that the worker was inserted at the correct position
        assertSame(mockWorker, workerState.GetWorkerById(0), "Inserted worker should be at index 0.");
    }

    @ParameterizedTest
    @CsvSource({
            "-1, false",
            "0, false",
            "1, true"
    })
    void testParametrizedInsertWorker(int workerId, boolean expectedResult) {
        // Set up the mock WorkerModel
        Mockito.when(mockWorker.GetId()).thenReturn(workerId);

        // Insert the worker into WorkerState
        boolean result = workerState.InsertWorker(mockWorker);

        // Verify the result
        assertTrue(result == expectedResult, "Worker insertion should match expected result.");

        // Verify that the worker was inserted at the correct position
        assertSame(mockWorker, workerState.GetWorkerById(workerId), "Inserted worker should be at the correct position.");
    }

    @Test
    void testDeleteWorker() {
        // Create a mock WorkerModel
        Mockito.when(mockWorker.GetId()).thenReturn(0); // Assume we delete worker at index 0

        // Insert the worker into WorkerState
        workerState.InsertWorker(mockWorker);

        // Now delete the worker
        WorkerModel deletedWorker = workerState.DeleteWorker(0);

        // Verify that the worker is correctly deleted
        assertNotNull(deletedWorker, "The deleted worker should not be null.");
        assertNull(workerState.GetWorkerById(0), "Worker at index 0 should be null after deletion.");
    }
}
