package cn.gaohank.idea.j2ee.es.dao;

import com.typesafe.config.ConfigFactory;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Repository;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Repository
public class EsDao {
    private String hostname = ConfigFactory.load().getString("es.hostname");
    private String port = ConfigFactory.load().getString("es.port");

    // 从一批fieldName中匹配文本
    public List<String> search(String index, Object text, String... fieldName) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(InetAddress.getByName(hostname), Integer.valueOf(port))));
        MultiMatchQueryBuilder qb = QueryBuilders.multiMatchQuery(text, fieldName);
        SearchSourceBuilder builder = new SearchSourceBuilder()
                .query(qb)
                .from(0)
                .size(50)
                .timeout(new TimeValue(60, TimeUnit.MINUTES));
        SearchRequest searchRequest = new SearchRequest(index).source(builder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = searchResponse.getHits();
        return Arrays.stream(hits.getHits()).map(SearchHit::getSourceAsString).collect(Collectors.toList());
    }

    // 单独匹配和批量匹配
    public List<String>combineSearch(String index, String key, String value, Object text, String... fieldName) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(InetAddress.getByName(hostname), Integer.valueOf(port))));
        MultiMatchQueryBuilder qb = QueryBuilders.multiMatchQuery(text, fieldName);
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.termQuery(key, value));
        SearchSourceBuilder builder = new SearchSourceBuilder().query(queryBuilder).from(0).size(50).timeout(new TimeValue(60, TimeUnit.MINUTES));
        SearchRequest searchRequest = new SearchRequest(index).source(builder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        SearchHits hits = searchResponse.getHits();
        return Arrays.stream(hits.getHits()).map(SearchHit::getSourceAsString).collect(Collectors.toList());
    }
}
