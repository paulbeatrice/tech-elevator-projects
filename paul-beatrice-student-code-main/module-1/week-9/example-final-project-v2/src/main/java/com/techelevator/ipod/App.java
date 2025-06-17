package com.techelevator.ipod;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App {

    private List<Listenable> mySongs = new ArrayList<>();
    private List<Listenable> myPodcasts = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello World!");
        App myApplication = new App();
        myApplication.run();
    }

    public void run() {
        File songFile = new File("songs.txt");
        File podcastFile = new File("Podcasts.csv");

        FileIO fileWorker = new FileIO();
        mySongs = fileWorker.loadListenablesFromFile(songFile, true);
        myPodcasts = fileWorker.loadListenablesFromFile(podcastFile, false);

        IPodUI ui = new IPodUI();
        String nameOfPlaylist = ui.welcomeScreen();
        Playlist myPlaylist = new Playlist(nameOfPlaylist);

        int choice = -1;

        while (true) {
            ui.mainMenu();
            choice = ui.promptForChoiceNumber(0, 4);

            switch (choice) {
                case 1:
                    ui.displayListenableOptions(mySongs);
                    break;
                case 2:
                    ui.displayListenableOptions(myPodcasts);
                    break;
                case 3:
                    // improve this -- assumes only songs
                    ui.displayListenableOptions(mySongs);
                    int songIndex = ui.promptForChoiceNumber(1, mySongs.size()) - 1;

                    Listenable aboutToEnqueue = mySongs.get(songIndex);
                    System.out.println("Enqueueing " + aboutToEnqueue);
                    myPlaylist.enqueue(aboutToEnqueue);
                    break;
                case 4:
                    try {
                        System.out.println("Playing: " + myPlaylist.play());
                    } catch (EmptyPlaylistException e) {
                        System.out.println("No songs in the Playlist!");
                    }
                    break;
                case 0:
                    System.out.println("Finished!");
                    System.exit(0);
            }
        }
    }

}
