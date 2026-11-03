package com.leema.web;

import org.springframework.core.io.ClassPathResource;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** Site data and helpers – a direct port of the constants and functions in the original page script. */
public final class Site {
    private Site() {}

    /* Number changed at the owner's request: the original site used 6362405907. */
    public static final String PHONE = "918296497253";
    public static final String TEL = "tel:+918296497253";
    public static final String DISPLAY = "+91 82964 97253";
    public static final String NAV_DISPLAY = "82964 97253";
    public static final String FOLDER = "image/";
    public static final List<String> EXTS = List.of("jpg", "jpeg", "png", "webp", "JPG", "JPEG", "PNG", "WEBP");
    public static final String BOOK_MSG = "Hello The Velorr, I would like to book a room. Dates: ";

    /** n = name, img = image base name in /image, d = description, p = price per night (0 = no price). */
    public record Room(String n, String img, String d, int p) {}

    /* image names must match the files in the image folder */
    public static final List<Room> ROOMS = List.of(
            new Room("AC room", "AC bed room", "Air-conditioned comfort.", 1799),
            new Room("Non-AC room", "non AC bed room", "Simple and comfortable.", 1299),
            new Room("Triple bed room", "triple bed room", "Sleeps 3.", 1699),
            new Room("4 bed room", "four bed room", "Sleeps 4, ideal for family.", 2499),
            new Room("Hall", "hall", "Space for groups.", 2499),
            new Room("Homestay", "home stay", "A home-style stay.", 1299),
            new Room("Budget room", "Budget room", "Easy on the pocket.", 999));

    public static final List<String> GALLERY = List.of("AC bed room", "non AC bed room", "triple bed room", "four bed room",
            "hall", "home stay", "Budget room", "parking place");

    /** Rooms plus the parking section, exactly like `all` in the original. */
    public static List<Room> all() {
        List<Room> a = new ArrayList<>(ROOMS);
        a.add(new Room("Parking", "parking place", "A place to park your vehicle at the lodge.", 0));
        return a;
    }

    /** encodeURIComponent-compatible encoding. */
    public static String encComponent(String s) {
        return URLEncoder.encode(s, StandardCharsets.UTF_8).replace("+", "%20")
                .replace("%21", "!").replace("%27", "'").replace("%28", "(").replace("%29", ")").replace("%7E", "~").replace("%2A", "*");
    }

    public static String wa(String text) { return "https://wa.me/" + PHONE + "?text=" + encComponent(text); }

    private static final Map<String, String> CACHE = new ConcurrentHashMap<>();

    /**
     * Server-side version of probe(): finds the first existing file for a base name, trying each
     * extension in order, and returns its URL (encodeURI style) or null when there is no image.
     */
    public static String probe(String base) {
        String hit = CACHE.computeIfAbsent(base, b -> {
            for (String e : EXTS) {
                if (new ClassPathResource(FOLDER + b + "." + e).exists())
                    return URI.create("/" + FOLDER + b.replace(" ", "%20") + "." + e).toString();
            }
            return "";
        });
        return hit.isEmpty() ? null : hit;
    }

    /** Indian digit grouping (toLocaleString("en-IN")). */
    public static String inGroup(long n) {
        String s = Long.toString(n);
        if (s.length() <= 3) return s;
        String last3 = s.substring(s.length() - 3), rest = s.substring(0, s.length() - 3);
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < rest.length(); i++) {
            b.append(rest.charAt(i));
            int remaining = rest.length() - i - 1;
            if (remaining > 0 && remaining % 2 == 0) b.append(',');
        }
        return b + "," + last3;
    }

    public static String pad(int n) { return n < 10 ? "0" + n : String.valueOf(n); }

    public static String esc(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }
}
