package System.WorkerApiModelLayer.WorkersApiModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class WorkerStateTests implements TestExecutionExceptionHandler {

    private WorkerState workerState;

    static Stream<WorkerModel> workerProvider() {
        return Stream.of(
                new WorkerModel("John", "Doe", 50000, "Engineer", 1, true),
                new WorkerModel("Jane", "Smith", 60000, "Manager", 2, false),
                new WorkerModel("Alice", "Johnson", 45000, "Developer", 3, true),
                new WorkerModel("Bob", "Williams", 70000, "Designer", 4, false)
        );
    }

    static Stream<Integer> salaryProvider() {
        return Stream.of(-10, 0, 1, 999);
    }

    static Stream<Arguments> workerAndSalaryProvider() {
        return workerProvider().flatMap(worker ->
                salaryProvider().map(salary ->
                        Arguments.of(worker, salary)
                )
        );
    }

    @Mock
    private WorkerModel mockWorker;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        workerState = WorkerState.getInstance();
        workerState.Clear();
    }

    @Test
    void testSingletonInstance() {
        //When
        WorkerState instance1 = WorkerState.getInstance();
        WorkerState instance2 = WorkerState.getInstance();

        //Then
        assertSame(instance1, instance2, "WorkerState should be a singleton!");
    }

    @Test
    void testInsertWorker() {
        //Given
        Mockito.when(mockWorker.GetId()).thenReturn(0);

        //When
        boolean result = workerState.InsertWorker(mockWorker);

        //Then
        assertTrue(result, "Worker should be inserted successfully.");
        assertSame(mockWorker, workerState.GetWorkerById(0), "Inserted worker should be at index 0.");
    }

    @Test
    @Tag("Exception")
    public void testInsertWorkerThrowsException() {
        //Given
        Mockito.when(mockWorker.GetId()).thenReturn(-1);

        //When
        Exception exception = assertThrows(Exception.class, () -> workerState.InsertWorker(mockWorker));

        //Then
        assertEquals("Worker ID must be non-negative", exception.getMessage(), "Exception message should match.");
    }

    @ParameterizedTest
    @CsvSource({
            "-1, false",
            "0, true",
            "9999, true",
            "1, true"
    })
    @ExtendWith(WorkerStateTests.class)
    @Tag("Exception")
    public void testParametrizedWithExceptionsInsertWorker(int workerId, boolean expectedResult) throws Exception {
        //Given
        Mockito.when(mockWorker.GetId()).thenReturn(workerId);

        //When
        boolean result = workerState.InsertWorker(mockWorker);

        //Then
        assertEquals(result, expectedResult, "Worker insertion should match expected result.");
        assertSame(mockWorker, workerState.GetWorkerById(workerId), "Inserted worker should be at the correct position.");
    }

    @ParameterizedTest
    @MethodSource("workerAndSalaryProvider")
    @ExtendWith(WorkerStateTests.class)
    void testUpdateWorkerWithWorkerProvider(WorkerModel worker, Integer salary) {
        //Given
        WorkerState state = WorkerState.getInstance();
        state.InsertWorker(worker);

        //When
        worker.Salary = salary;
        state.UpdateWorker(worker);

        //Then
        WorkerModel workerAfterUpdate = (WorkerModel)state.GetWorkerById(worker.GetId());

        assertEquals(salary, workerAfterUpdate.GetSalary());
    }

    @Test
    void testDeleteWorker() throws Exception {
        //Given
        Mockito.when(mockWorker.GetId()).thenReturn(0);

        //When
        workerState.InsertWorker(mockWorker);
        WorkerModel deletedWorker = workerState.DeleteWorker(0);

        //Then
        assertNotNull(deletedWorker, "The deleted worker should not be null.");
        assertNull(workerState.GetWorkerById(0), "Worker with index 0 should be null after deletion.");
    }

    @Test
    @Tag("Exception")
    public void testDeleteWorkerThrowsException() {
        //Given
        Mockito.when(mockWorker.GetId()).thenReturn(1);

        //When
        workerState.InsertWorker(mockWorker);
        Exception exception = assertThrows(Exception.class, () ->  workerState.DeleteWorker(0));

        //Then
        assertEquals("Worker with given Id don't exist", exception.getMessage());
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        String testClassName = context.getRequiredTestMethod().getName();

        if (throwable instanceof IndexOutOfBoundsException) {
            if (testClassName.equals("testParametrizedInsertWorker")
                    || testClassName.equals("testParametrizedWithExceptionsInsertWorker"))
                assertEquals("Worker ID must be non-negative", throwable.getMessage());
        }
        else if (throwable instanceof IllegalArgumentException) {
            if (testClassName.equals("testUpdateWorkerWithWorkerProvider"))
                assertEquals("Salary cannot be negative.", throwable.getMessage());
        }
        else throw throwable;
    }
}
