package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.infy.exception.InfyAcademyException;

import application.EmailValidator;

public class EmailValidatorTest {

	EmailValidator emailValidator;

	private static Stream<Arguments> emailList() {
		return Stream.of(Arguments.of("Sirius_Black", false), Arguments.of("Lily_Evans@Hoggy.in", true),
				Arguments.of("Remus_Lups", false), Arguments.of("NymphieTonks@magic.com", true));
	}

	@BeforeEach
	void setUp() throws Exception {
		emailValidator = new EmailValidator();
	}

	@AfterEach
	void tearDown() throws Exception {
		emailValidator = null;
	}

	@Test
	public void validateEmailIdValidEmailId() throws InfyAcademyException {
		assertTrue(emailValidator.validateEmailId("James_Potter@infy.com"));
	}

	@Test
	public void validateEmailIdInvalidEmailId() throws InfyAcademyException {
		assertFalse(emailValidator.validateEmailId("James_Potter@infy.org"));

	}

	@Test
	public void validateEmailIdInvalidEmailIdException() throws InfyAcademyException {
		Assertions.assertThrows(InfyAcademyException.class, () -> emailValidator.validateEmailId(null));
	}

	@ParameterizedTest
	@MethodSource("emailList")
	@Test
	public void validateEmailIdParamterizedEmailId(String email, boolean expected) throws InfyAcademyException {
	    assertEquals(expected, emailValidator.validateEmailId(email));

	}
}
