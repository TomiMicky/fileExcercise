package util;

import java.nio.file.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class FileHandler {
    private String directory;
    private String fileName;
    public static void main(String[] args) throws IOException {
        // Path to resources/info.txt
        Path path = Paths.get("Contacts", "ContactInfo.txt"); // files
        System.out.println(path.toAbsolutePath());

        if (!Files.exists(path.getParent())) {
            Files.createDirectory(path.getParent());
        }
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        List<String> myContacts = Files.readAllLines(path); // retrieve contact from myContacts

}}
