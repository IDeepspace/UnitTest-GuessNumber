package tw.core;

import org.junit.Test;
import tw.validator.InputValidator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class InputValidatorTest {

  @Test
  public void should_return_true_when_input_right_num() throws Exception {

    InputValidator inputValidator = new InputValidator();

    String num = "1 2 3 4";

    Boolean result = inputValidator.validate(num);

    assertThat(result, is(true));
  }

  @Test
  public void should_return_false_when_input_fault_num_for_two_repetition_digit() throws Exception {
    InputValidator inputValidator = new InputValidator();

    String num = "1 1 2 3";

    Boolean result = inputValidator.validate(num);

    assertThat(result, is(false));
  }

  @Test
  public void should_return_false_when_input_fault_num_for_less_four_digit() throws Exception {
    InputValidator inputValidator = new InputValidator();

    String num = "1 2 3";

    Boolean result = inputValidator.validate(num);

    assertThat(result, is(false));
  }

  @Test
  public void should_return_false_when_input_fault_num_for_a_digit_more_than_9() throws Exception {
    InputValidator inputValidator = new InputValidator();

    String num = "1 2 3 10";

    Boolean result = inputValidator.validate(num);

    assertThat(result, is(false));
  }
}
