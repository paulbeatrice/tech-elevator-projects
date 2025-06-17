package com.techelevator;

import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class App {

    // The regex string to split the Strings in the dataset.
    private static final String FIELD_DELIMITER = "\\|";

    private static final int TITLE_FIELD = 0;
    private static final int AUTHOR_FIELD = 1;
    private static final int PUBLISHED_YEAR_FIELD = 2;
    private static final int PRICE_FIELD = 3;

    private final Scanner keyboard = new Scanner(System.in);

    private List<String> titles = new ArrayList<>();
    private List<String> authors = new ArrayList<>();
    private List<Integer> publishedYears = new ArrayList<>();
    private List<BigDecimal> prices = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();
        app.loadData();
        app.run();

    }

    private void loadData() {

        String[] dataset = Dataset.load();

        /*
         Requirement: 1
         Populate the instance variables `titles`, `authors`, `publishedYears`,
         and `prices` by splitting each string in the `dataset` array and adding
         the individual fields to the appropriate list.
         See README for additional details.
         */


        for ( String record : dataset ) {
            String[] parts = record.split( FIELD_DELIMITER); // Split the record using commas

            // add each part to the appropriate list
            titles.add(parts[0]);
            authors.add(parts[1]);
            publishedYears.add(Integer.parseInt(parts[2]));
            prices.add(new BigDecimal(parts[3]));

        }

    }


    private void run() {

        while (true) {
            // Main menu loop
            printMainMenu();
            int mainMenuSelection = promptForMenuSelection("Please choose an option: ");
            if (mainMenuSelection == 1) {
                // Display data and subsets loop
                while (true) {
                    printDataAndSubsetsMenu();
                    int dataAndSubsetsMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (dataAndSubsetsMenuSelection == 1) {
                        displayDataset(Dataset.load());
                    } else if (dataAndSubsetsMenuSelection == 2) {
                        displayTitlesList(titles);
                    } else if (dataAndSubsetsMenuSelection == 3) {
                        displayAuthorsList(authors);
                    } else if (dataAndSubsetsMenuSelection == 4) {
                        displayPublishedYearsList(publishedYears);
                    } else if (dataAndSubsetsMenuSelection == 5) {
                        displayPricesList(prices);
                    } else if (dataAndSubsetsMenuSelection == 0) {
                        break;
                    }
                }
            }
            else if (mainMenuSelection == 2) {
                while (true) {
                    printSearchBooksMenu();
                    int searchBooksMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (searchBooksMenuSelection == 1) {
                        // Search by title
                        String filterTitle = promptForString("Enter title: ");
                        /*
                         Requirement: 3b
                         Replace `displayTitlesList(titles)` with calls to the
                         `filterByTitle()` and `displaySearchResults()` methods.
                         */


                        displaySearchResults(filterByTitle(filterTitle));
                    } else if (searchBooksMenuSelection == 2) {
                        // Search by author
                        String filterAuthor = promptForString("Enter author: ");
                        /*
                         Requirement: 4b
                         Replace `displayAuthorsList(authors)` with calls to the
                         `filterByAuthor()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(filterByAuthor(filterAuthor));

                    } else if (searchBooksMenuSelection == 3) {
                        // Search by published year
                        int filterYear = promptForPublishedYear("Enter date (YYYY): ");
                        /*
                         Requirement: 5b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYear()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(filterByPublishedYear(filterYear));
                    } else if (searchBooksMenuSelection == 4) {
                        // Search by published year range
                        int filterFromYear = promptForPublishedYear("Enter \"from\" date (YYYY): ");
                        int filterToYear = promptForPublishedYear("Enter \"to\" date (YYYY): ");
                        /*
                         Requirement: 6b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYearRange()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(filterByPublishedYearRange(filterFromYear, filterToYear));
                    } else if (searchBooksMenuSelection == 5) {
                        // Find the most recent books
                        /*
                         Requirement: 7b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `findMostRecentBooks()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(findMostRecentBooks());
                    } else if (searchBooksMenuSelection == 6) {
                        // Search by price
                        double filterPrice = promptForPrice("Enter price: ");
                        /*
                         Requirement: 8b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPrice()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(filterByPrice(filterPrice));
                    } else if (searchBooksMenuSelection == 7) {
                        // Search by price range
                        double filterFromPrice= promptForPrice("Enter \"from\" price: ");
                        double filterToPrice = promptForPrice("Enter \"to\" price: ");
                        /*
                         Requirement: 9b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPriceRange()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(filterByPriceRange(filterFromPrice, filterToPrice));
                    } else if (searchBooksMenuSelection == 8) {
                        // Find the least expensive books
                        /*
                         Requirement: 10b
                         Replace `displayPricesList(prices)` with calls to the
                         `findLeastExpensiveBooks()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(findLeastExpensiveBooks());
                    } else if (searchBooksMenuSelection == 0) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 0) {
                break;
            }
        }

    }

    /*
     Requirement: 2
     Write the displaySearchResults(List<Integer> indexes) method.
     See README for additional details.
     */
    private void displaySearchResults(List<Integer> indexes) {
        for (Integer index : indexes) {
            System.out.println("Match Found:");
            System.out.println("Title: " + titles.get(index));
            System.out.println("Author: " + authors.get(index));
            System.out.println("Year: " + publishedYears.get(index));
            System.out.println("Price: " + prices.get(index));
            System.out.println("--------------------");
        }
    }

    /*
     Requirement: 3a
     Complete the `filterByTitle()` method.
     See README for additional details.
     */
    private List<Integer> filterByTitle(String filterTitle) {

        List<Integer> filterByTitle = new ArrayList<>();
        //iterate over the list of titles
        for (int i = 0; i < titles.size() ; i++) {
            //convert both the filterTitle and title at index i to lowercase to make the search case insensitive
            if(titles.get(i).toLowerCase().contains(filterTitle.toLowerCase())) {
                // add the index to the list if there's a match
                filterByTitle.add(i);
            }

        }
        //return list of matching indexes
        return filterByTitle;
    }

    /*
     Requirement: 4a
     Complete the `filterByAuthor()` method.
     See README for additional details.
     */
    private List<Integer> filterByAuthor(String filterAuthor) {

        List<Integer> filterByAuthor = new ArrayList<>();
        //iterate over the list of authors
        for (int i = 0; i < authors.size() ; i++) {
            if (authors.get(i).toLowerCase().contains(filterAuthor.toLowerCase())) {
                //add the index to the list if there's a match
                filterByAuthor.add(i);
            }

        }
        return filterByAuthor;
    }

    /*
     Requirement: 5a
     Complete the `filterByPublishedYear()` method.
     See README for additional details.
     */
    private List<Integer> filterByPublishedYear(int filterYear) {

        List<Integer> filterByPublishedYear = new ArrayList<>();
        for (int i = 0; i < publishedYears.size() ; i++) {
            if (publishedYears.get(i) == filterYear) {
                filterByPublishedYear.add(i);
            }

        }
        return publishedYears;
    }

    /*
     Requirement: 6a
     Complete the `filterByPublishedYearRange()` method.
     See README for additional details.
     */
    private List<Integer> filterByPublishedYearRange(int filterFromYear, int filterToYear) {

        List<Integer> filterByPublishedYearRange = new ArrayList<>();

        for (int i = 0; i < publishedYears.size() ; i++) {
            int year = publishedYears.get(i);
            // check if the year is within the range
            if (year >= filterFromYear && year <= filterToYear) {
                filterByPublishedYearRange.add(i); // add the index to the list if the year is within range
            }

        }
        return filterByPublishedYearRange;
    }

    /*
     Requirement: 7a
     Add the `private List<Integer> findMostRecentBooks()` method.
     See README for additional details.
     */
    private List<Integer> findMostRecentBooks() {
        List<Integer> findMostRecentBooks = new ArrayList<>();

        //Step 1: Find the Most Recent Year
        int mostRecentYear = Integer.MIN_VALUE; // Initialize to a very low value
        for (int year : publishedYears) {
            if (year > mostRecentYear) {
                mostRecentYear = year;
            }
        }

            //Step 2: Collect the Indexes of all books published in the most recent year
            for (int i = 0; i < publishedYears.size() ; i++) {
                if (publishedYears.get(i) == mostRecentYear) {
                    findMostRecentBooks.add(i);
                }

            }

            return findMostRecentBooks;


    }

    /*
     Requirement: 8a
     Complete the `filterByPrice()` method.
     See README for additional details.
     */
    private List<Integer> filterByPrice(double filterPrice) {

        List<Integer> filterByPriceIndexes = new ArrayList<>();


        BigDecimal filterPriceBigDecimal = BigDecimal.valueOf(filterPrice);

            for (int i = 0; i < prices.size() ; i++) {

                if(prices.get(i).compareTo(filterPriceBigDecimal) <= 0) {
                    filterByPriceIndexes.add(i);
                }

            }

        return filterByPriceIndexes;
    }

    /*
     Requirement: 9a
     Complete the `filterByPriceRange()` method.
     See README for additional details.
     */
    private List<Integer> filterByPriceRange(double filterFromPrice, double filterToPrice) {
        List<Integer> priceRangeIndexes = new ArrayList<>();

        BigDecimal fromPrice = BigDecimal.valueOf(filterFromPrice);
        BigDecimal toPrice = BigDecimal.valueOf(filterToPrice);

        for (int i = 0; i < prices.size() ; i++) {
            BigDecimal bookPrice = prices.get(i);

            //check if price is between filterFromPrice & filterToPrice
            if (bookPrice.compareTo(fromPrice) >= 0 && bookPrice.compareTo(toPrice) <= 0) {
                priceRangeIndexes.add(i); // add index to the list if the price is within the range
            }



        }
        return priceRangeIndexes;
    }

    /*
     Requirement: 10a
     Add the `private List<Integer> findLeastExpensiveBooks()` method.
     See README for additional details.
     */

    // check to see if there are any books
    private List<Integer> findLeastExpensiveBooks() {
        List<Integer> leastExpensiveBooks = new ArrayList<>();

        if (prices.isEmpty()) {
            return leastExpensiveBooks;
        }

        // Step 1: find the lowest price in the list

        BigDecimal lowestPrice = prices.get(0); // assume the first price is the lowest
        for (BigDecimal price : prices) {
            if (price.compareTo(lowestPrice) < 0) {
                lowestPrice = price; // Update the lowest price if a smaller value is found
            }
        }

        // Step 2: Find the Indexes of the books with the lowest price
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).compareTo(lowestPrice) == 0) {
                leastExpensiveBooks.add(i); // add the index if the price matches the lowest price
            }

        }

        return leastExpensiveBooks;

    }


    // UI methods

    private void printMainMenu() {
        System.out.println("1: Display data and subsets");
        System.out.println("2: Search books");
        System.out.println("0: Exit");
        System.out.println();
    }

    private void printDataAndSubsetsMenu() {
        System.out.println("1: Display dataset");
        System.out.println("2: Display titles");
        System.out.println("3: Display authors");
        System.out.println("4: Display published years");
        System.out.println("5: Display prices");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void printSearchBooksMenu() {
        System.out.println("1: Search by title");
        System.out.println("2: Search by author");
        System.out.println("3: Search by published year");
        System.out.println("4: Search by published year range");
        System.out.println("5: Find most recent books");
        System.out.println("6: Search by price");
        System.out.println("7: Search by price range");
        System.out.println("8: Find least expensive books");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void displayDataset(String[] dataset) {
        System.out.println("Dataset");
        System.out.println("-------");
        for (String data : dataset) {
            System.out.println(data);
        }
        System.out.println();
        promptForReturn();
    }

    private void displayTitlesList(List<String> titles) {
        System.out.println("Titles");
        System.out.println("-------");
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(i + ": " + titles.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayAuthorsList(List<String> authors) {
        System.out.println("Authors");
        System.out.println("-------");
        for (int i = 0; i < authors.size(); i++) {
            System.out.println(i + ": " + authors.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPublishedYearsList(List<Integer> publishedYears) {
        System.out.println("Published Years");
        System.out.println("---------------");
        for (int i = 0; i < publishedYears.size(); i++) {
            System.out.println(i + ": " + publishedYears.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPricesList(List<BigDecimal> prices) {
        System.out.println("Prices");
        System.out.println("------");
        for (int i = 0; i < prices.size(); i++) {
            System.out.println(i + ": " + prices.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private int promptForMenuSelection(String prompt) {
        System.out.print(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    private String promptForString(String prompt) {
        System.out.print(prompt);
        return keyboard.nextLine();
    }

    private int promptForPublishedYear(String prompt) {
        int year;
        while (true) {
            System.out.println(prompt);
            try {
                year = Integer.parseInt(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The year provided is not well-formed. It must be YYYY.");
            }
        }
        return year;
    }

    private double promptForPrice(String prompt) {
        double price;
        while (true) {
            System.out.println(prompt);
            try {
                price = Double.parseDouble(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The price provided is not a valid monetary value.");
            }
        }
        return price;
    }

    private void promptForReturn() {
        System.out.println("Press RETURN to continue.");
        keyboard.nextLine();
    }
}
