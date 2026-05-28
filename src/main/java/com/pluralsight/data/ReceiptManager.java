package com.pluralsight.data;

import com.pluralsight.models.MenuItem;
import com.pluralsight.models.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class ReceiptManager {
    public static void saveReceipt(Order order) {

        try {

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

            String fileName = "receipts/" + timestamp + ".txt";

            String receiptText = order.getItems().stream()
                    .map(MenuItem::toString)
                    .collect(Collectors.joining("\n"));

            receiptText += String.format(
                    "%n%nTOTAL: $%.2f",
                    order.getTotal()
            );

            Files.write(
                    Path.of(fileName),
                    receiptText.getBytes()
            );

            System.out.println("Receipt saved!");

        } catch (IOException e) {

            System.out.println("Error saving receipt.");
        }
    }
}
