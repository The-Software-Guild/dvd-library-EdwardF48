package com.sq.DVDLibrary.dao;

import com.sq.DVDLibrary.dto.DVD;

import java.util.List;

public interface DVDLibraryDao {
    /**
     * Adds the given DVD to the library and associates it with the given
     * dvd title. If there is already a dvd associated with the given
     * dvd title it will return that dvd object, otherwise it will
     * return null.
     *
     * @param title title with which dvd is to be associated
     * @param dvd dvd to be added to the library
     * @return the DVD object previously associated with the given
     * dvd title if it exists, null otherwise
     * @throws DVDLibraryDaoException
     */
    DVD addDVD(String title, DVD dvd)
            throws DVDLibraryDaoException;

    /**
     * Returns a List of all DVDs on the library.
     *
     * @return DVD List containing all dvds on the library.
     * @throws DVDLibraryDaoException
     */
    List<DVD> getAllDVDs()
            throws DVDLibraryDaoException;

    /**
     * Returns the dvd object associated with the given dvd title.
     * Returns null if no such dvd exists
     *
     * @param title ID of the dvd to retrieve
     * @return the DVD object associated with the given dvd title,
     * null if no such dvd exists
     * @throws DVDLibraryDaoException
     */
    DVD getDVD(String title)
            throws DVDLibraryDaoException;

    /**
     * Removes from the library the dvd associated with the given title.
     * Returns the dvd object that is being removed or null if
     * there is no dvd associated with the given title
     *
     * @param title title of dvd to be removed
     * @return DVD object that was removed or null if no dvd
     * was associated with the given dvd title
     * @throws DVDLibraryDaoException
     */
    DVD removeDVD(String title)
            throws DVDLibraryDaoException;

}