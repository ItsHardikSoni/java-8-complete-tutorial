interface Printable {
    void print();
}

interface Saveable {
    void save();
}

class Document implements Printable, Saveable {
    public void print() {
        System.out.println("Document printed.");
    }

    public void save() {
        System.out.println("Document saved.");
    }
}

class MultipleInheritance {
    public static void main(String[] args) {
        Document document = new Document();
        document.print();
        document.save();
    }
}
