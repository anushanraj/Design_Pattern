package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ PasswordValidatorTest.class, EmailValidatorTest.class })
public class TestSuite {

}