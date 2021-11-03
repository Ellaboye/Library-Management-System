package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BookShelf {
    private final Map<String, String> bookShelf = new HashMap<>();

    private void loadBooksFromTextFile() throws IOException {
        try (
                FileReader fileReader = new FileReader("src/books.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String textLine;
            while ((textLine = bufferedReader.readLine()) != null) {
                String[] strArr = textLine.split("=");
                bookShelf.put(strArr[0], strArr[1]);
            }

        } catch (IOException e) {
            System.out.println("An Error Occurred");
        }
    }

    public String getBook(String bookName) throws IOException {
        loadBooksFromTextFile();

        try {
            HashMap<Object, Object> books;
            if(!bookShelf.containsKey(bookName)){
//                System.out.println("Sorry book not Available");
                return "Sorry book not Available";
            }
            if(bookShelf.containsKey(bookName.toLowerCase())) {
                if(Integer.parseInt(bookShelf.get(bookName))  == 0) {
//                    System.out.println("All copies have been given out");
                    return "book taken";
                }else {
                    int numOfCopies = Integer.parseInt(bookShelf.get(bookName)) - 1;
                    bookShelf.put(bookName,String.valueOf(numOfCopies));
//                    System.out.println(bookShelf.get(bookName)+" still available");
                    return bookShelf.get(bookName)+" still available";
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
            return "error occured";
        }

        return "executed";
    }

}
