package cscd212tests.lab6;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

import org.junit.platform.suite.api.*;

@RunWith(JUnitPlatform.class)
@SelectPackages("cscd212tests.lab6")
@SelectClasses({CSCD212Lab6EnvironmentTests.class, CSCD212Lab6CellTests.class, CSCD212Lab6LifeFormTests.class})
public class CSCD212Lab6Tests {}