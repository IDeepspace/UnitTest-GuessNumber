package tw.core;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Before;
import org.junit.Test;
import tw.core.model.Record;

public class AnswerTest {
  private Answer answer;

  @Before
  public void init() throws Exception {
    answer = Answer.createAnswer("1 2 3 4");
  }

  @Test
  public void should_return_0A0B_when_no_number_is_correct() {
    String inputAnswerStr = "5 6 7 8";
    String expectValue = "0A0B";
    validateInputAnswerStr(inputAnswerStr,expectValue);
  }

  @Test
  public void should_return_4A0B_when_all_numbers_are_correct() {
    String inputAnswerStr = "1 2 3 4";
    String expectValue = "4A0B";
    validateInputAnswerStr(inputAnswerStr,expectValue);
  }

  @Test
  public void should_return_0A4B_when_all_numbers_are_include_() {
    String inputAnswerStr = "5 6 7 8";
    String expectValue = "0A0B";
    validateInputAnswerStr(inputAnswerStr,expectValue);
  }

  @Test
  public void should_return_1A1B_when_1_number_correct_and_1_number_include() {
    String inputAnswerStr = "1 3 5 6";
    String expectValue = "1A1B";
    validateInputAnswerStr(inputAnswerStr,expectValue);
  }

  private void validateInputAnswerStr(String inputAnswerStr,String expectValue) {
    Answer inputAnswer = Answer.createAnswer(inputAnswerStr);
    Record result = answer.check(inputAnswer);
    int[] existRecord = result.getValue();
    String s = String.format("%1$sA%2$sB", existRecord[0], existRecord[1]);
    assertThat(s, is(expectValue));
  }
}