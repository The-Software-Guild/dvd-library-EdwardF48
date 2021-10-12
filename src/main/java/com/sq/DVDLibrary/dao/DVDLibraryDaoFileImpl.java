package com.sq.DVDLibrary.dao;

import com.sq.DVDLibrary.dto.DVD;

import java.io.*;
import java.util.*;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    private Map<String, DVD> dvds = new HashMap<>();
    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";


    private DVD unmarshallDVD(String dvdAsText){

        //title::releasedate::MPAARating::DirectorName::Studio::Note

        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String title = dvdTokens[0];

        DVD dvdFromFile = new DVD(title);

        dvdFromFile.setReleaseDate(dvdTokens[1]);

        dvdFromFile.setMPAARating(dvdTokens[2]);

        dvdFromFile.setDirectorsName(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setNote(dvdTokens[5]);

        return dvdFromFile;
    }

    private void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;
        DVD currentDVD;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }

    private String marshallDVD(DVD aDVD){

        String dvdAsText = aDVD.getTitle() + DELIMITER;

        dvdAsText += aDVD.getReleaseDate() + DELIMITER;

        dvdAsText += aDVD.getMPAARating() + DELIMITER;

        dvdAsText += aDVD.getDirectorsName() + DELIMITER;

        dvdAsText += aDVD.getStudio() + DELIMITER;

        dvdAsText += aDVD.getNote();

        return dvdAsText;
    }

    /**
     * Writes all dvds in the library out to a LIBRARY_FILE.  See loadLibrary
     * for file format.
     *
     * @throws DVDLibraryDaoException if an error occurs writing to the file
     */
    private void writeLibrary() throws DVDLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save dvd data.", e);
        }

        String dvdAsText;
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            dvdAsText = marshallDVD(currentDVD);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }


    @Override
    public DVD addDVD(String title, DVD dvd)
            throws DVDLibraryDaoException {
        loadLibrary();
        DVD newDVD = dvds.put(title, dvd);
        writeLibrary();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs()
            throws DVDLibraryDaoException {
        loadLibrary();
        return new ArrayList(dvds.values());
    }

    @Override
    public DVD getDVD(String title)
            throws DVDLibraryDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title)
            throws DVDLibraryDaoException {
        loadLibrary();
        DVD removedDVD = dvds.remove(title);
        writeLibrary();
        return removedDVD;
    }

}