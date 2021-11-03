import java.io.IOException;

import Model.Person;
import utils.BookShelf;
import service.LibrarianService;
import service.LibraryUsersService;
import utils.RequestCatalogue;

public class Main {
    public static void main(String[] args) throws IOException {
        RequestCatalogue req = new RequestCatalogue();
//        System.out.println(req.requestEntrySheet());


        LibrarianService librarianService = new LibrarianService("jonathan","123");
       BookShelf bookShelf = new BookShelf();
        bookShelf.getBook("the hobbit");
       LibraryUsersService libraryUsersService = new LibraryUsersService("Junior student","Luke","3003",3,"the hobbit");
        libraryUsersService.getBookRequest();
        Person person = new Person("Peter", "2033");
        librarianService.lendBookFirstComeFirstServe();
        librarianService.lendBookByPriority();
    }
}
