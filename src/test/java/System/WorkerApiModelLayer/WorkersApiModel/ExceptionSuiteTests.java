package System.WorkerApiModelLayer.WorkersApiModel;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("System.WorkerApiModelLayer.WorkersApiModel")
@IncludeTags("Exception")
@ExcludeTags("NotExpectedException")
public class ExceptionSuiteTests {
}
