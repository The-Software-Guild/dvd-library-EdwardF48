package com.sq.DVDLibrary;

import com.sq.DVDLibrary.controller.DVDLibraryController;
import com.sq.DVDLibrary.dao.DVDLibraryDao;
import com.sq.DVDLibrary.dao.DVDLibraryDaoFileImpl;
import com.sq.DVDLibrary.ui.DVDLibraryView;
import com.sq.DVDLibrary.ui.UserIO;
import com.sq.DVDLibrary.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(myIo);
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller =
                new DVDLibraryController(myDao, myView);
        controller.run();
    }
}