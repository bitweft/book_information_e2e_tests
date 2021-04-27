package book_information;

import book_information.pages.BookDetailsPage;
import book_information.pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class BookDetailsTest extends BaseTest {
    @Test
    public void verifyBookSearchResults() {
        String bookName = "harry";
        BookDetailsPage bookDetailsPage = new HomePage()
                .searchBook(bookName)
                .selectBookAtPosition(0);

        assertTrue(bookDetailsPage.getTitle().toLowerCase().contains(bookName));

        int numberOfPages = Integer.parseInt(bookDetailsPage.getNumberOfPages());
        assertTrue(numberOfPages > 0);
    }
}
