package com.a.platform.elasticsearch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 *
 * @author weixing.yang
 * @version 1.0
 * @date 2019/10/19 16:05
 */
@Configuration
public class EsConfig {

    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clusterName;

    @Value("${spring.data.elasticsearch.xpack.security.user:#{null}}")
    private String userPass;

    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String nodes;

    /**
     * 索引名称
     */
    @Value("${spring.data.elasticsearch.index-name}")
    private String indexName;

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
        EsTemplateBuilder esTemplateBuilder = new DefaultEsTemplateBuilder().setClusterName(clusterName).setClusterNodes(nodes).setUserPass(userPass);
        return esTemplateBuilder.build();
    }


}
