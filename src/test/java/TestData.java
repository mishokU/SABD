import first.CesarShift;
import first.Data;
import first.XmlArticle;
import first.XmlHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestData {

    public Data result;
    public List<XmlArticle> articles;
    public CesarShift cesarShift;

    @BeforeEach
    void setUp() throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XmlHandler xmlHandler = new XmlHandler();
        saxParser.parse("src/main/java/test.xml", xmlHandler);

        result = xmlHandler.getWebsite();
        articles = result.getArticleList();
        cesarShift = new CesarShift();
    }

    @Test
    void testSize(){
        assertNotNull(articles);
        assertEquals(3, articles.size());
    }

    @Test
    void test(){
        List<XmlArticle> articles = result.getArticleList();
        XmlArticle articleOne = articles.get(0);
        assertEquals("Parsing an XML File Using SAX Parser", articleOne.getTitle());
        assertEquals("SAX Parser's Lorem ipsum...", articleOne.getContent());
    }

    @Test
    void test2(){
        XmlArticle articleTwo = articles.get(1);
        assertEquals("Parsing an XML File Using DOM Parser", articleTwo.getTitle());
        assertEquals("DOM Parser's Lorem ipsum...", articleTwo.getContent());

    }

    @Test
    void test3(){
        XmlArticle articleThree = articles.get(2);
        assertEquals("Parsing an XML File Using StAX Parser", articleThree.getTitle());
        assertEquals("StAX's Lorem ipsum...", articleThree.getContent());
    }

    @Test
    void test4(){
        XmlArticle article = articles.get(0);
        article.setTitle(cesarShift.encrypt(article.getTitle()));
        article.setTitle(cesarShift.decrypt(article.getTitle()));
        assertEquals("Parsing an XML File Using SAX Parser", article.getTitle());
    }
}
