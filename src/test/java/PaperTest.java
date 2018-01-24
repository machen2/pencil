import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaperTest {
    Paper paper;

    @Before
    public void setUp() {
        paper = new Paper();
    }

    @Test
    public void givenNewPaperPaperIsBlank() {
        assertEquals("", paper.getText());
    }

    @Test
    public void givenTextPaperContainsText() {
        paper.write("She sells sea shells");
        assertEquals("She sells sea shells", paper.getText());
    }

    @Test
    public void givenPaperWithTextWhenTextIsWrittenItShouldAppendText() {
        paper.write("She sells sea shells");
        paper.write(" by the sea shore");
        assertEquals("She sells sea shells by the sea shore", paper.getText());
    }

    @Test
    public void givenPaperWithDifferentTextWhenTextIsWrittenItShouldAppendText() {
        paper.write("Peter Piper picked a peck");
        paper.write(" of pickled peppers");
        assertEquals("Peter Piper picked a peck of pickled peppers", paper.getText());
    }

    @Test
    public void givenPaperWithASingleWordWhenTheWordIsErasedItIsReplacedWithSpaces() {
        paper.write("Peter");
        paper.erase("Peter");
        assertEquals("     ", paper.getText());
    }

    @Test
    public void givenPaperWithTwoDifferentWordsWeOnlyEraseTheGivenWord() {
        paper.write("Peter Simon");
        paper.erase("Peter");
        assertEquals("      Simon", paper.getText());
    }

    @Test
    public void givenPaperWithTheSameWordsAsAboveButInADifferentOrderWeOnlyEraseTheGivenWord() {
        paper.write("Simon Peter");
        paper.erase("Peter");
        assertEquals("Simon      ", paper.getText());
    }

    @Test
    public void givenPaperWithTheSameWordMultipleTimesWeWantToOnlyEraseTheLastInstanceOfTheWord() {
        paper.write("Peter Peter");
        paper.erase("Peter");
        assertEquals("Peter      ", paper.getText());
    }

    @Test
    public void givenPaperWithAFullSentenceWithTheSameWordTwiceConsecutiveErasesOccursTwice() {
        paper.write("How much wood would a woodchuck chuck if a woodchuck could chuck wood?");
        paper.erase("chuck");
        paper.erase("chuck");
        assertEquals("How much wood would a woodchuck chuck if a wood      could       wood?", paper.getText());
    }

    @Test
    public void givenASentenceWhenErasingAReplacementWordOfTheSameLengthCanBeInserted() {
        paper.write("An apple a day keeps the doctor away");
        paper.edit("apple", "onion");
        assertEquals("An onion a day keeps the doctor away", paper.getText());
    }

    @Test
    public void givenASentenceWhenErasingAReplacementWordOfTheShorterLengthCanBeInsertedWithExcessSpacesShouldRemain() {
        paper.write("An apple a day keeps the doctor away");
        paper.edit("apple", "egg");
        assertEquals("An egg   a day keeps the doctor away", paper.getText());
    }
}
