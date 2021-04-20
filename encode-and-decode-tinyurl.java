public class Codec {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String url = "http://";
        String domain = longUrl.substring(7, longUrl.length());
        String shortUrl = url + domain;
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String url = "https://";
        String domain = shortUrl.substring(8, shortUrl.length());
        String longUrl = url + domain;
        return longUrl;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
