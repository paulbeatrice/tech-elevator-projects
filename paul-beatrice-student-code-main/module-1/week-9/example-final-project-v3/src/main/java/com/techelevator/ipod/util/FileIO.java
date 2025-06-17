package com.techelevator.ipod.util;

import com.techelevator.ipod.model.Listenable;
import com.techelevator.ipod.model.Podcast;
import com.techelevator.ipod.model.Song;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class FileIO {

    public FileIO() { }

    public void log(String message) {
        try {
            FileOutputStream fos = new FileOutputStream("log.txt", true);
            PrintWriter pw = new PrintWriter(fos);

            String timestamp = LocalDateTime.now().toString();
            pw.println(timestamp + ": " + message);
        } catch (FileNotFoundException e) {
            System.out.println("Tried to log, couldn't find file -- " + e.getMessage());
        }
    }

    public List<Listenable> loadListenablesFromFile(File songFile, boolean isSong) {
        List<Listenable> output = new ArrayList<>();

        // Try/Catch because the Scanner constructor could throw a FileNotFoundException
        try (Scanner streamer = new Scanner(songFile)) {
            while (streamer.hasNextLine()) {
                String line = streamer.nextLine();

                String[] pieces = line.split(",");
                String title = pieces[0].trim();
                String artist = pieces[1].trim();
                LocalDate releaseDate = LocalDate.parse(pieces[2].trim());
                String genre = pieces[3].trim();

                Listenable newListenable;
                if (isSong) {
                    newListenable = new Song(title, artist, releaseDate, genre);
                } else {
                    newListenable = new Podcast(title, artist, releaseDate, genre);
                }

                output.add(newListenable);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find song file! -- " + e.getMessage());
        }

        return output;
    }

}
