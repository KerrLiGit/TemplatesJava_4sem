package ru.mirea.ikbo1020.prac12.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class FileReader {
    @Value("#{springApplicationArguments.nonOptionArgs[0]}")
    private String inputFilePath;

    @Value("#{springApplicationArguments.nonOptionArgs[1]}")
    private String hashFilePath;

    Logger logger = LoggerFactory.getLogger(FileReader.class);

    @PostConstruct
    private void saveHash() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            FileWriter fileWriter = new FileWriter(hashFilePath, false);

            try {
                md.update(Files.readAllBytes(Path.of(inputFilePath)));
                fileWriter.write(Converter.fromByteArrayToHex(md.digest()));
                logger.info("Hash has been written to " + hashFilePath);
            } catch (NoSuchFileException e) {
                fileWriter.write("null\n");
                logger.info("File " + inputFilePath + " don't exists");
            } finally {
                fileWriter.flush();
            }

        } catch (NoSuchAlgorithmException | IOException e) {
            logger.error(e.getMessage());
        }
    }

    @PreDestroy
    private void deleteInputFile() {
        if (Files.exists(Path.of(inputFilePath))) {
            try {
                Files.delete(Path.of(inputFilePath));
                logger.info("File " + inputFilePath + " deleted");
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
