package first.example.spring5webapp.bootstrap;
import  first.example.spring5webapp.model.Author;
import first.example.spring5webapp.model.Book;
import first.example.spring5webapp.repositories.AuthorRepository;
import first.example.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd=new Book( "Model Driven", "1234", "PHI");
        eric.getBoks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);



        Author rod=new Author("Rod","Johnson");
        Book noEJB=new Book("j2ee development","2344","Worx");
        rod.getBoks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }


}
