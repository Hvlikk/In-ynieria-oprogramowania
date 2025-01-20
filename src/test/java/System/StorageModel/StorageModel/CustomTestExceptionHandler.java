package System.StorageModel.StorageModel;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class CustomTestExceptionHandler implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (throwable instanceof IllegalArgumentException) {
            System.out.println("Caught IllegalArgumentException during test execution: " + throwable.getMessage());
        } else {
            throw throwable; // Przekazujemy dalej inne wyjątki
        }
    }
}