package com.pluralsight.data;

import com.pluralsight.models.MenuItem;
import com.pluralsight.models.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class ReceiptManager {

    private static final Path RECEIPT_DIR = Path.of("receipts");
    private static final Path RECEIPT_FILE = RECEIPT_DIR.resolve("all-receipts.txt");

    public static void saveReceipt(Order order) {

        try {
            // Ensure directory exists
            Files.createDirectories(RECEIPT_DIR);

            // Timestamp
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            // Build item list
            String items = order.getItems().stream()
                    .map(MenuItem::toString)
                    .collect(Collectors.joining("\n"));

            // Format full receipt
            String formattedReceipt = """
                    
                    ====================================
                               RECEIPT
                    ====================================
                    Date: %s
                    
                    Items:
                    %s
                    
                    TOTAL: $%.2f
                    ====================================
                    
                    """.formatted(
                    timestamp,
                    items,
                    order.getTotal()
            );

            // Write to file (create if needed, append always)
            Files.writeString(
                    RECEIPT_FILE,
                    formattedReceipt,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            System.out.println("Receipt saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving receipt.");
            e.printStackTrace();
        }
    }
}
