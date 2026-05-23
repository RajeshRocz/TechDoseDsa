package dsa_aug_25.noog;

import java.util.*;

class LogMessage {
    String sourceFile;
    String message;

    LogMessage(String sourceFile, String message) {
        this.sourceFile = sourceFile;
        this.message = message;
    }
}

public class LogTruncator {

    public static List<LogMessage> truncateLogMessages(
            List<LogMessage> messages, int maxLogMessages) {

        // Group messages by source file
        Map<String, List<LogMessage>> grouped = new HashMap<>();
        for (LogMessage msg : messages) {
            grouped.computeIfAbsent(msg.sourceFile, k -> new ArrayList<>()).add(msg);
        }

        // Binary search for best X
        int low = 0, high = messages.size(), bestX = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            long total = 0;
            for (List<LogMessage> logs : grouped.values()) {
                total += Math.min(logs.size(), mid);
            }
            if (total <= maxLogMessages) {
                bestX = mid;
                low = mid + 1; // try larger X
            } else {
                high = mid - 1; // shrink X
            }
        }

        // Collect truncated logs
        List<LogMessage> result = new ArrayList<>();
        for (List<LogMessage> logs : grouped.values()) {
            int keep = Math.min(logs.size(), bestX);
            result.addAll(logs.subList(0, keep));
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        List<LogMessage> logs = Arrays.asList(
                new LogMessage("fileA.cpp", "msg1"),
                new LogMessage("fileA.cpp", "msg2"),
                new LogMessage("fileB.cpp", "msg3"),
                new LogMessage("fileB.cpp", "msg4"),
                new LogMessage("fileB.cpp", "msg5")
        );

        List<LogMessage> truncated = truncateLogMessages(logs, 3);
        for (LogMessage lm : truncated) {
            System.out.println(lm.sourceFile + ": " + lm.message);
        }
    }
}

