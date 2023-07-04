package net.socialhub.twitter.web.entity.request.timeline;

import net.socialhub.twitter.web.entity.request.GraphRequest;
import net.socialhub.twitter.web.entity.request.GraphTimelineRequest;

import java.util.HashMap;
import java.util.Map;

public class SearchTimelineRequest implements GraphTimelineRequest {

    private String rawQuery;
    private Integer count;
    private String cursor;
    private String querySource;
    private String product;

    @Override
    public Map<String, Object> params() {

        Map<String, Object> variables = new HashMap<>();
        put(variables, "rawQuery", getRawQuery());
        put(variables, "count", getCount());
        put(variables, "cursor", getCursor());
        put(variables, "querySource", getQuerySource());
        put(variables, "product", getProduct());

        Map<String, Object> params = new HashMap<>();
        put(params, "variables", getGson().toJson(variables));
        put(params, "features", getGson().toJson(getFeaturesMap()));
        put(params, "fieldToggles", getGson().toJson(getFieldTogglesMap()));
        return params;
    }

    // region
    public static SearchTimelineRequestBuilder builder() {
        return new SearchTimelineRequestBuilder();
    }

    public String getRawQuery() {
        return rawQuery;
    }

    public Integer getCount() {
        return count;
    }

    public String getCursor() {
        return cursor;
    }

    public String getQuerySource() {
        return querySource;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public static final class SearchTimelineRequestBuilder {
        private String rawQuery;
        private Integer count = 20;
        private String cursor;
        private String querySource = "typed_query";
        private String product;

        private SearchTimelineRequestBuilder() {
        }

        public static SearchTimelineRequestBuilder aSearchTimelineRequest() {
            return new SearchTimelineRequestBuilder();
        }

        public SearchTimelineRequestBuilder rawQuery(String rawQuery) {
            this.rawQuery = rawQuery;
            return this;
        }

        public SearchTimelineRequestBuilder count(Integer count) {
            this.count = count;
            return this;
        }

        public SearchTimelineRequestBuilder cursor(String cursor) {
            this.cursor = cursor;
            return this;
        }

        public SearchTimelineRequestBuilder querySource(String querySource) {
            this.querySource = querySource;
            return this;
        }

        public SearchTimelineRequestBuilder product(String product) {
            this.product = product;
            return this;
        }

        public SearchTimelineRequest build() {
            SearchTimelineRequest searchTimelineRequest = new SearchTimelineRequest();
            searchTimelineRequest.rawQuery = this.rawQuery;
            searchTimelineRequest.product = this.product;
            searchTimelineRequest.querySource = this.querySource;
            searchTimelineRequest.cursor = this.cursor;
            searchTimelineRequest.count = this.count;
            return searchTimelineRequest;
        }
    }
    // endregion
}
