package urlshortener;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class UrlShortener {

    private final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private AtomicLong sequence = new AtomicLong(1);
    private ConcurrentHashMap<String, String> db = new ConcurrentHashMap<>();

    public String shortenUrl(String longUrl) {
        long id = sequence.getAndIncrement();
        String shortUrl = idToShortURL(id);

        db.put(shortUrl, longUrl);

        return shortUrl;
    }

    private String idToShortURL(long n) {
        StringBuilder shorturl = new StringBuilder();

        while (n > 0) {
            shorturl.append(characters.charAt((int) (n % 62)));
            n = n / 62;
        }

        return shorturl.reverse().toString();
    }

    public String expandUrl(String shortUrl) {
        return db.get(shortUrl);
    }
}

