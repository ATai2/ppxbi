## elasticsearch

垂直搜索，站内搜索

全文检索，lucene  
倒排索引

### 搜索方式
* query string search

GET /goods/product/_search

> {
  "took" : 17,
  "timed_out" : false,
  "_shards" : {
    "total" : 5,
    "successful" : 5,
    "skipped" : 0,
    "failed" : 0
  },
  "hits" : {
    "total" : 1,
    "max_score" : 1.0,
    "hits" : [
      {
        "_index" : "goods",
        "_type" : "product",
        "_id" : "1",
        "_score" : 1.0,
        "_source" : {
          "name" : "gaolujie",
          "desc" : "1",
          "price" : 30
        }
      }
    ]
  }
}

hits 详细数据
score 匹配度

GET /goods/product/_search?q=name:yagao&sort=price:des

* query DSL
* query filter
* fill-text search
* highlight search