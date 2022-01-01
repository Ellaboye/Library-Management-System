package service;

import Model.Person;
import org.w3c.dom.ls.LSOutput;
import utils.BookShelf;
import utils.CompareUsers;
import utils.RequestCatalogue;

import java.io.IOException;
import java.util.*;

public class LibrarianService extends Person implements LendByPriority, LendByFirstComeFirstServe {
        //    The Librarian class processes book request from the requestCatalogue and processes
    //    request based on two implemented interface methods ie: LendBookByPriority and
    //    lendBookFirstComeFirstServe
    public LibrarianService(String name, String libraryCardId) {
        super(name, libraryCardId);
    }

    //    The lendBookByPriority method picks book request entry of the highest priority regardless
    //    of insertion order this is for a case when users are asking for the same book;
    //    The lendBookByPriority method call bookshelf to get the book request

    @Override
    public String lendBookByPriority() throws IOException {
        String result = "";
        try {
            RequestCatalogue request = new RequestCatalogue();
            PriorityQueue<LibraryUsersService> priorityQueue = new PriorityQueue<>(11, new CompareUsers());
            request.requestEntrySheet();
            priorityQueue.addAll(request.getCatalogue2());

            Iterator<LibraryUsersService> users = priorityQueue.iterator();
//Apply a Declarative Approach here
             while(users.hasNext()){
                LibraryUsersService user = priorityQueue.poll();
                String book = Objects.requireNonNull(user).getBookRequest();

                BookShelf bookShelf = new BookShelf();

                if(bookShelf.getBook(book).indexOf("still available") != -1){
                    System.out.println("BOOK titled, "+book+" is borrowed by "+user.getName());

                    result = "book available";
                }else{
                    System.out.println("book not available "+user.getName());
                    result = "book not available";
                }
            }
            return result;

            //Declarative Approach
           // priorityQueue.stream().filter(users -> users >)
        } catch (Exception ex) {
            System.err.println("book does not exist");
            return "book does not exist";
        }
    }


        //    The lendBookFirstComeFirstServe method picks book request first request regardless of users priority
        //    this is for a case where users are asking for different books
        //    The lendBookFirstComeFirstServe method call bookshelf to get the book request
    @Override
    public String lendBookFirstComeFirstServe() throws IOException {
        String result = "";
        try {
            RequestCatalogue request = new RequestCatalogue();

            Queue<LibraryUsersService> queues = new LinkedList<>(request.getCatalogue3());

            request.requestEntrySheet();

            queues.addAll(request.getCatalogue3());

            Iterator<LibraryUsersService> users = queues.iterator();
//Apply Declarative Approach
            while(users.hasNext()){
                LibraryUsersService user = queues.poll();
                String book = Objects.requireNonNull(user).getBookRequest();

                BookShelf bookShelf = new BookShelf();

                if(bookShelf.getBook(book).indexOf("still available") != -1){
                    System.out.println("BOOK Titled, "+book+" is borrowed by "+user.getName());

                    result = "book available";
                }else{
                    System.out.println(bookShelf.getBook(book));
                    result = "book not available";
                }
            }

            return result;
        } catch (Exception ex) {
            System.err.println("No such book");
            return "book does not exist";
        }

    }
}
