/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

/**

Perform a DFS traversal
    do a hostname extraction - split("/")[2]

    getUrls() return List<String> can do a parallelStream() 
    
    use a ConcurrentHashMap.newKeySet(); // concurrent set 
 */
class Solution {
    private Set<String> set;
    private String host;
    private HtmlParser htmlParser;

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        this.set = ConcurrentHashMap.newKeySet();
        this.host = getHost(startUrl);
        this.htmlParser = htmlParser;
        recursiveCrawl(startUrl);
        return new ArrayList(this.set);

    }

    private void recursiveCrawl(String url) {

        if (this.set.contains(url) || !getHost(url).equals(this.host)) {
            return;
        }

        set.add(url);
        this.htmlParser.getUrls(url)
                       .parallelStream()
                       .forEach(this::recursiveCrawl);


    }

    private static String getHost(String url) {
        return url.split("/")[2];
        // int end = url.indexOf('/', 7);
        // return url.substring(7, end == -1 ? url.length() : end);
    }
}