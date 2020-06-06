package book_information;

import book_information.pages.HomePage;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class SearchResultsTest extends BaseTest {
    @Test
    public void verifyBookSearchResults() {
        String bookName = "harry";
        List<String> bookTitles = new HomePage()
                .searchBook(bookName)
                .getBookTitles();

        assertTrue(bookTitles.stream().allMatch(title -> title.toLowerCase().contains(bookName)));
    }
}
