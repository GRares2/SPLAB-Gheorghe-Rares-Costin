public class Main {
    public static void main(String[] args) {
        // Create book
        Book noapteBuna = new Book("Noapte buna, copii!");

        // Add author
        Author rpGheo = new Author("Radu Pavel Gheo");
        noapteBuna.addAuthor(rpGheo);

        // Create sections (chapters and subchapters)
        Section cap1 = new Section("Capitolul 1");
        Section cap11 = new Section("Capitolul 1.1");
        Section cap111 = new Section("Capitolul 1.1.1");
        Section cap1111 = new Section("Subchapter 1.1.1.1");

        // Add content to book
        noapteBuna.addContent(new Paragraph("Multumesc celor care ..."));
        noapteBuna.addContent(cap1);

        // Add content to cap1
        cap1.add(new Paragraph("Moto capitol"));
        cap1.add(cap11);

        // Add content to cap11
        cap11.add(new Paragraph("Text from subchapter 1.1"));
        cap11.add(cap111);

        // Add content to cap111
        cap111.add(new Paragraph("Text from subchapter 1.1.1"));
        cap111.add(cap1111);

        // Add content to cap1111
        cap1111.add(new Image("Image subchapter 1.1.1.1"));

        // Print the book
        noapteBuna.print();
    }
}