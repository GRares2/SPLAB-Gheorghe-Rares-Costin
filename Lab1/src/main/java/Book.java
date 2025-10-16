import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private TableOfContents tableOfContents;
    private List<Element> content;

    public Book(String title) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.content = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void setTableOfContents(TableOfContents toc) {
        this.tableOfContents = toc;
    }

    public void addContent(Element element) {
        content.add(element);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println();

        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        System.out.println();

        // Print content elements
        for (Element element : content) {
            element.print();
        }
    }
}