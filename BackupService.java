package edu.ccrm.io;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackupService {

    private final String dataFolder;

    public BackupService(String dataFolder) { this.dataFolder = dataFolder; }

    public void backup() {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path backupDir = Paths.get(dataFolder, "backup_" + timestamp);
            Files.createDirectories(backupDir);

            // Copy all files in dataFolder to backupDir
            Files.walk(Paths.get(dataFolder))
                    .filter(Files::isRegularFile)
                    .forEach(src -> {
                        Path dest = backupDir.resolve(src.getFileName());
                        try { Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING); }
                        catch (IOException e) { System.out.println("Copy failed: " + src + " -> " + dest); }
                    });

            System.out.println("Backup completed at " + backupDir.toAbsolutePath());
            long totalSize = getFolderSize(backupDir);
            System.out.println("Total backup size: " + totalSize + " bytes");

        } catch (IOException e) { System.out.println("Backup failed: " + e.getMessage()); }
    }

    private long getFolderSize(Path folder) throws IOException {
        return Files.walk(folder).filter(Files::isRegularFile).mapToLong(f -> {
            try { return Files.size(f); } catch (IOException e) { return 0; }
        }).sum();
    }
}