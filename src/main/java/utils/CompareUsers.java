package utils;

import service.LibraryUsersService;

import java.util.Comparator;

public class CompareUsers implements Comparator<LibraryUsersService> {
    @Override
    public int compare(LibraryUsersService o1, LibraryUsersService o2) {
         return Integer.compare(o1.getRank(),o2.getRank());

    }

}
//
//public class CompareUsers implements Comparable<LibraryUsersService> {
////    @Override
////    public int compareTo(LibraryUsersService o1, LibraryUsersService o2) {
////        return Integer.compare(o1.getRank(),o2.getRank());
//
////
////    }
//
//
//    @Override
//    public int compareTo(LibraryUsersService o) {
//        return  o.getRank() ? 1 : -1;
//    }
//}
