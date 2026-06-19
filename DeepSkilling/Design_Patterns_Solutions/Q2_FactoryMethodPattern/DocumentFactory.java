// Abstract Factory Class - DocumentFactory


public abstract class DocumentFactory {

    // Factory Method - to be overridden by concrete factories
    public abstract Document createDocument();

    // Template method: creates, opens, and returns a ready-to-use document
    public Document getDocument() {
        Document doc = createDocument();
        System.out.println("[Factory] Created: " + doc.getDocumentType());
        doc.open();
        return doc;
    }
}
