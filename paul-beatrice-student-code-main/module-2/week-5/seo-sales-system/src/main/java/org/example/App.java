package org.example;

import config.DatabaseConnection;
import dao.JdbcClientDao;
import dao.JdbcOrdersDao;
import dao.JdbcPackageDao;
import model.Client;
import model.Order;
import model.Package;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main( String[] args ) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            System.err.println("Failed to connect to the database.");
            return;
        }

        System.out.println("Connected to the database successfully.");
        JdbcClientDao clientDao = new  JdbcClientDao();
        JdbcPackageDao packageDao = new  JdbcPackageDao();
        JdbcOrdersDao ordersDao =  new JdbcOrdersDao();


        initializePackages(packageDao);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewAllClients(clientDao);
                case 2 -> viewAllPackages(packageDao);
                case 3 -> viewAllOrders(ordersDao);
                case 4 -> addNewClient(clientDao, scanner);
                case 5 -> addNewOrder(ordersDao, clientDao, packageDao, scanner);
                case 6 -> {
                    System.out.println("Exiting the application. Goodbye.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== SEO SALES SYSTEM ===");
        System.out.println("1. View All Clients");
        System.out.println("2. View All Packages");
        System.out.println("3. View All Orders");
        System.out.println("4. Add New Client");
        System.out.println("5. Add New Order");
        System.out.println("6. Exit");
        System.out.println("Please enter your choice: ");
    }

    private  static void initializePackages(JdbcPackageDao packageDao) {
        packageDao.createPackage(new Package(0, "Starter SEO Package", "This package is designed for small businesses and includes keyword research, on-page SEO optimization, local SEO setup (i.e, google business listing, yelp, trip advisor, etc.) and also includes basic analytics reporting. It is a perfect fit for businesses looking to establish an online presence in their local market.", new BigDecimal("500.00")));
        packageDao.createPackage(new Package(0, "Growth SEO Package", "This package offers a comprehensive SEO approach, including competitive keyword research, on and off-page optimization, backlink building, a content optimization plan, and monthly analysis reports with actionable insights into the data.", new BigDecimal("1500.00")));
        packageDao.createPackage(new Package(0, "Enterprise SEO Advanced Package", "Designed for large companies who want to dominate their competitive industries. This package covers technical SEO audits, site architecture optimization, high-quality backlink acquisitions, a thorough content marketing strategy, international SEO (if applicable), real-time data reporting with an account manager.", new BigDecimal(5000.00)));
        packageDao.createPackage(new Package(0, "Creator Visibility Package", "This package is designed to increase the online visibility of content creators. It includes optimization for blog posts, Youtube videos, podcast episodes, etc., niche keyword research, metadata optimization, topic trends analysis, and performance reports.",new BigDecimal("700.00")));
        packageDao.createPackage(new Package(0, "Social Media SEO Amplifier", "Anyone who has an online presence realizes how important social media can be for a business or individual. This package focuses on optimizing social media profiles and content for discoverability. It includes hashtag research, platform-specific SEO (Instagram, Facebook, TikTok, X, etc.) It also links these strategies to help drive traffic to websites and give insights to trending topics, posts, and includes social keywords.", new BigDecimal("500.00")));
    }

    private static void viewAllClients(JdbcClientDao clientDao) {
        List<Client> clients = clientDao.getClients();
        if (clients.isEmpty()) {
            System.out.println("No clients found.");
        } else {
            for (Client client : clients) {
                System.out.println(client);
            }
        }
    }

    private static void viewAllPackages(JdbcPackageDao packageDao) {
        List<Package> packages = packageDao.getPackages();
        if (packages.isEmpty()) {
            System.out.println("No packages found.");
        } else {
            for (Package packageObj : packages) {
                System.out.println(packageObj);
            }
        }
    }
    private static void viewAllOrders(JdbcOrdersDao ordersDao) {
        List<Order> orders = ordersDao.getOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    private static void addNewClient(JdbcClientDao clientDao, Scanner scanner) {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter client email: ");
        String email = scanner.nextLine();
        System.out.print("Enter client phone: ");
        String phone = scanner.nextLine();

        Client client = new Client();
        client.setName(name);
        client.setEmail(email);
        client.setPhone(phone);

        clientDao.createClient(client);
        System.out.println("Client added successfully.");
    }

    private static void addNewOrder(JdbcOrdersDao ordersDao, JdbcClientDao clientDao, JdbcPackageDao packageDao, Scanner scanner) {
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        System.out.print("Enter package ID: ");
        int packageId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter order status: ");
        String status = scanner.nextLine();

        Order order = new Order();
        order.setClientId(clientId);
        order.setPackageId(packageId);
        order.setStatus(status);
        order.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        ordersDao.createOrder(order);
        System.out.println("Order added successfully.");
    }

}
