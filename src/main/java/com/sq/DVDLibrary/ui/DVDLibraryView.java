package com.sq.DVDLibrary.ui;

import com.sq.DVDLibrary.dto.DVD;

import java.util.List;

public class DVDLibraryView {

    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }
    public int printMenuAndGetSelection() {



        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. Create New DVD");
        io.print("3. View a DVD");
        io.print("4. Remove a DVD");
        io.print("5. Edit DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public DVD getNewDVDInfo() {
        String dvdtitle = io.readString("Please enter DVD title");
        String releaseDate = io.readString("Please enter release date");
        String MPAARating = io.readString("Please enter MPAA rating");
        String directorsName = io.readString("Please enter Director's Name");
        String studio = io.readString("Please enter Studio Name");
        String note = io.readString("Please enter rating/note");

        DVD currentDVD = new DVD(dvdtitle);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMPAARating(MPAARating);
        currentDVD.setDirectorsName(directorsName);
        currentDVD.setStudio(studio);
        currentDVD.setNote(note);
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "DVD successfully created.  Please hit enter to continue");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            String dvdInfo = String.format("%s",
                    currentDVD.getTitle()
                    );
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }
    public void displayDisplayDVDBanner () {
        io.print("=== Display DVD ===");
    }

    public String getDVDTitleChoice() {
        return io.readString("Please enter the DVD Title.");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            String dvdInfo = String.format("%s : %s, %s : %s, %s : %s",
                    dvd.getTitle(),
                    dvd.getReleaseDate(),
                    dvd.getMPAARating(),
                    dvd.getDirectorsName(),
                    dvd.getStudio(),
                    dvd.getNote()
            );
            io.print(dvdInfo);
            io.print("");
        } else {
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(DVD dvdRecord) {
        if(dvdRecord != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayEditDVDBanner () {
        io.print("=== Edit DVD ===");
    }

    public void displayEditResult(DVD dvdRecord) {
        if(dvdRecord != null){
            io.print("DVD successfully updated.");
        }else{
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayEditNewInfo(String title){
        io.print("Please enter the new information for "+ title);
    }
}