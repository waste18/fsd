import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
public class XMLValidator {
    public static void main(String[] args) {
        validateWithDTD("bookstore.xml");
        validateWithXSD("bookstore.xml", "bookstore.xsd");
    }
    private static void validateWithDTD(String xmlFile) {
        try (InputStream xmlStream = new FileInputStream(new File(xmlFile))) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(new SimpleErrorHandler()); // Optional: Implement an error handler
            Document document = builder.parse(xmlStream);
            System.out.println("Validation with DTD successful.");
        } catch (SAXException e) {
            System.out.println("Validation with DTD failed. Reason: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException | ParserConfigurationException e) {
            System.out.println("Error occurred. Reason: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static void validateWithXSD(String xmlFile, String xsdFile) {
        try (InputStream xmlStream = new FileInputStream(new File(xmlFile));
             InputStream xsdStream = new FileInputStream(new File(xsdFile))) {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new StreamSource(xsdStream));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlStream));
            System.out.println("Validation with XSD successful.");
        } catch (SAXException e) {
            System.out.println("Validation with XSD failed. Reason: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("I/O error occurred. Reason: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static class SimpleErrorHandler implements org.xml.sax.ErrorHandler {
        @Override
        public void warning(SAXParseException exception) throws SAXException {
            System.out.println("Warning: " + exception.getMessage());
        }
        @Override
        public void error(SAXParseException exception) throws SAXException {
            System.out.println("Error: " + exception.getMessage());
        }
        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
            System.out.println("Fatal error: " + exception.getMessage());
        }
    }
}
