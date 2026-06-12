// Document Interface - Base type for all document kinds

public interface Document {
    void open();
    void save();
    void close();
    String getDocumentType();
}
