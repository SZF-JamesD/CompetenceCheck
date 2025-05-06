package utils;

public class TimeUtils {
    public static int parseDuration(String duration) throws NumberFormatException {
        if (duration.contains(":")) {
            String[] parts = duration.split(":");
            if (parts.length != 2) throw new NumberFormatException("Invalid format.");
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            if (seconds < 0 || seconds > 59) throw new NumberFormatException("Invalid format, Seconds must be between 0 and 59.");
            return (minutes * 60) + seconds;
        }
        return Integer.parseInt(duration);
    }

    public static String formatDuration(int totalSeconds) {
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
