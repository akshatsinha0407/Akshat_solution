// Test class to demonstrate Factory Method Pattern
// Shows creation of different document types via their respective factories

public class DocumentTest {

    public static void main(String[] args) {

        System.out.println("===== Factory Method Pattern Demo =====\n");

        // --- Word Document ---
        System.out.println("--- Word Document Factory ---");
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.getDocument();
        wordDoc.save();
        wordDoc.close();

        System.out.println();

        // --- PDF Document ---
        System.out.println("--- PDF Document Factory ---");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.getDocument();
        pdfDoc.save();
        pdfDoc.close();

        System.out.println();

        // --- Excel Document ---
        System.out.println("--- Excel Document Factory ---");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.getDocument();
        excelDoc.save();
        excelDoc.close();

        System.out.println("\n===== All documents created successfully via Factory Method! =====");
    }
}
