//package urlshortener;
//
//public class UrlShortenerTest {
//    @Test
//    public void testShortenUrl() {
//        UrlShortener urlShortener = new UrlShortener();
//        String longUrl = "http://www.example.com";
//        String shortUrl = urlShortener.shortenUrl(longUrl);
//        // Check that shorten URL isn't empty
//        assertNotNull(shortUrl);
//        // Ensure that the short URL is actually shorter than the long URL
//        assertTrue(shortUrl.length() < longUrl.length());
//    }
//
//    @Test
//    public void testExpandUrl() {
//        UrlShortener urlShortener = new UrlShortener();
//        String longUrl = "http://www.example.com";
//        String shortUrl = urlShortener.shortenUrl(longUrl);
//        String expandedUrl = urlShortener.expandUrl(shortUrl);
//        // Check that the expanded URL matches the original long URL
//        assertEquals(longUrl, expandedUrl);
//    }
//}
//
//
