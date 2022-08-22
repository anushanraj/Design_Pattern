package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.infy.exception.InfyAcademyException;

import application.PasswordValidator;

public class PasswordValidatorTest {

	static PasswordValidator passwordValidator;

	private static Stream<Arguments> passwords() {
		return Stream.of(Arguments.of("Qwerty", false), Arguments.of("Qwerty1234", true),
				Arguments.of("QwertyAsdfZxcvVcxzFdsaRewq", false), Arguments.of("Zxcvb54321", true));
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		passwordValidator = new PasswordValidator();
	}

	@Test
	public void validatePasswordValidPassword() throws InfyAcademyException {
		assertTrue(passwordValidator.validatePassword("Asdf1234"));
	}

	@Test
	public void validatePasswordInvalidPassword() throws InfyAcademyException {
		assertFalse(passwordValidator.validatePassword("asdf"));

	}

	@Test
	public void validatePasswordInvalidPasswordException() throws InfyAcademyException {
		assertThrows(InfyAcademyException.class, () -> passwordValidator.validatePassword(null));
	}

	@ParameterizedTest
	@MethodSource("passwords")
	@Test
	public void validatePasswordParameterizedPassword(String password, boolean expected) throws InfyAcademyException {
		assertEquals(expected, passwordValidator.validatePassword(password));
	}
}