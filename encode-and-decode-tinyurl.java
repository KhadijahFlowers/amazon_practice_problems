public class Codec {
    String urls = "https://";
    String url = "http://";
    String original = "";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int index = 0;
        int slash = 0;
        while (slash != 2 && index < longUrl.length()) {
            if ("/".compareTo(longUrl.substring(index, index + 1)) == 0) {
                slash += 1;
            }
            index += 1;
        }
        original = longUrl.substring(0, index);
        String domain = longUrl.substring(index, longUrl.length());
        return url + domain;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = 0;
        int slash = 0;
        while (slash != 2 && index < shortUrl.length()) {
            if ("/".compareTo(shortUrl.substring(index, index + 1)) == 0) {
                slash += 1;
            }
            index += 1;
        }

        String domain = shortUrl.substring(index, shortUrl.length());
        return original + domain;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
