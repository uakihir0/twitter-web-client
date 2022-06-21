package net.socialhub.twitter.web.entity.request;

import net.socialhub.twitter.web.entity.Request;

import java.util.HashMap;
import java.util.Map;

public class SearchRequest implements Request {

    private String querySource = "typed_query";
    private Integer spellingCorrections = 1;
    private Integer pc = 1;

    private String tweetSearchMode;
    private String resultFilter;

    /** Query */
    private String query;
    /** Max 20 */
    private Integer count;
    /** Cursor */
    private String cursor;

    @Override
    public Map<String, String> params() {

        Map<String, String> params = new HashMap<>();

        put(params, "q", query);
        put(params, "count", count);
        put(params, "cursor", cursor);
        put(params, "result_filter", resultFilter);
        put(params, "tweet_search_mode", tweetSearchMode);

        put(params, "query_source", querySource);
        put(params, "spelling_corrections", spellingCorrections);
        put(params, "pc", pc);

        return params;
    }

    // region
    public String getQuerySource() {
        return querySource;
    }

    public void setQuerySource(String querySource) {
        this.querySource = querySource;
    }

    public Integer getSpellingCorrections() {
        return spellingCorrections;
    }

    public void setSpellingCorrections(Integer spellingCorrections) {
        this.spellingCorrections = spellingCorrections;
    }

    public Integer getPc() {
        return pc;
    }

    public void setPc(Integer pc) {
        this.pc = pc;
    }

    public String getTweetSearchMode() {
        return tweetSearchMode;
    }

    public void setTweetSearchMode(String tweetSearchMode) {
        this.tweetSearchMode = tweetSearchMode;
    }

    public String getResultFilter() {
        return resultFilter;
    }

    public void setResultFilter(String resultFilter) {
        this.resultFilter = resultFilter;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    // endregion
}
