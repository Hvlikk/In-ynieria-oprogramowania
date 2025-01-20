package System.WorkerApiModelLayer.WorkersApiModel;

import System.WorkersApiPresenterLayer.WorkersApiPresenter.WorkersController;
import System.WorkersApiPresenterLayer.WorkersApiPresenter.WorkersService;
import System.WorkersApiPresenterLayer.WorkersApiPresenter.WorkerAvailabilityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.lang.reflect.Field;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WorkerControllerTests implements TestExecutionExceptionHandler {

    private WorkersController mockWorkersController;

    @Mock
    private WorkersService mockWorkerService;
    @Mock
    private WorkerAvailabilityService mockWorkerAvailabilityService;
    @Mock
    private WorkerModel mockWorker;
    @Mock
    private AvailabilityModel mockAvailability;

    static Stream<WorkerModel> workerProvider() {
        return Stream.of(
                new WorkerModel("John", "Doe", 50000, "Engineer", 1, true),
                new WorkerModel("Jane", "Smith", 60000, "Manager", 2, false),
                new WorkerModel("Alice", "Johnson", 45000, "Developer", 3, true),
                new WorkerModel("Bob", "Williams", 70000, "Designer", 4, false)
        );
    }

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        mockWorkersController = new WorkersController();
        injectMocks(mockWorkersController);
    }

    private void injectMocks(Object target) throws Exception {
        Field workerServiceField = WorkersController.class.getDeclaredField("workerService");
        Field workerAvailabilityServiceField = WorkersController.class.getDeclaredField("workerAvailabilityService");

        workerServiceField.setAccessible(true);
        workerAvailabilityServiceField.setAccessible(true);

        workerServiceField.set(target, mockWorkerService);
        workerAvailabilityServiceField.set(target, mockWorkerAvailabilityService);
    }

    @Test
    @Order(5)
    void testCreateNewWorker() {
        // Given
        WorkerModel newWorker = mockWorker;
        when(mockWorkerService.CreateNewWorker(newWorker)).thenReturn(mockWorker);

        // When
        WorkerModel result = (WorkerModel) mockWorkersController.CreateNewWorker(newWorker);

        // Then
        assertNotNull(result, "Created worker should not be null.");
        assertSame(mockWorker, result, "Returned worker should be the same as the mock worker.");
        verify(mockWorkerService, times(1)).CreateNewWorker(newWorker);
    }

    @Test
    @Order(4)
    void testChangeAvailability() {
        // Given
        int workerId = 1;
        when(mockWorker.GetId()).thenReturn(workerId);
        when(mockWorkerAvailabilityService.ChangeAvailability(workerId, mockAvailability)).thenReturn(true);

        // When
        boolean result = mockWorkersController.ChangeAvailability(mockWorker, mockAvailability);

        // Then
        assertTrue(result, "Availability should be changed successfully.");
        verify(mockWorkerAvailabilityService, times(1)).ChangeAvailability(workerId, mockAvailability);
    }

    @Test
    @Order(3)
    void testGetWorker() {
        // Given
        int workerId = 1;
        when(mockWorkerService.GetWorker(workerId)).thenReturn(mockWorker);

        // When
        IWorkerModel result = mockWorkersController.GetWorker(workerId);

        // Then
        assertNotNull(result, "Returned worker should not be null.");
        assertSame(mockWorker, result, "Returned worker should be the same as the mock worker.");
        verify(mockWorkerService, times(1)).GetWorker(workerId);
    }

    @ParameterizedTest
    @MethodSource("workerProvider")
    @Order(2)
    @ExtendWith(WorkerControllerTests.class)
    void testAvailabilityChangeWithProvider(WorkerModel worker) {
        //Given
        WorkersController controller = new WorkersController();

        //When
        boolean result = mockWorkersController.ChangeAvailability(worker, mockAvailability);
        WorkerModel changedWorker = (WorkerModel) controller.GetWorker(worker.GetId());

        //Then
        if (worker.IsBusy()) {
            assertFalse(result, "Worker should not change job");
        }else {
            assertTrue(changedWorker.IsBusy(), "Worker should have job");
        }
    }

    @ParameterizedTest
    @Order(1)
    @MethodSource("workerProvider")
    @ExtendWith(WorkerControllerTests.class)
    void testWorkerCreateWithProvider(WorkerModel worker) {
        //Given
        WorkersController controller = new WorkersController();

        //When
        WorkerModel insertedWorker = (WorkerModel) controller.CreateNewWorker(worker);

        //Then
        assertEquals(insertedWorker, worker);
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {

    }
}
