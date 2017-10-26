### ElasticSearch RestfulAPI 使用

* 1.新建library索引
```
PUT http://127.0.0.1:9200/library
{
  "settings": {
    "index": {
      "number_of_shards":5,
      "number_of_replicas":1
    }
  }
}
//result
{"acknowledged":true}
 ```
 * 2.查看索引基本信息
 ```
 GET /library/_settings
 //result
 {
    "library": {
       "settings": {
          "index": {
             "number_of_shards": "5",
             "number_of_replicas": "1",
             "version": {
                "created": "1000099"
             },
             "uuid": "GER8QStVS4iC7fcLQ44-Yw"
          }
       }
    }
 }
 //同时获取两个索引信息 用逗号隔开
 GET /library,library2/_settings
 //查询所有索引信息
 
 GET /_all/_settings
 
  ```
  
 * 3.创建一个索引文档
  ```
  //指定id(put)
  PUT /library/book/1
  {
    "title":"ElasticSearch Guide",
    "name":{
      "firstname":"hao",
      "lastname":"peng"
    },
    "publish_date":"2017-10-26",
    "price":"49.99"
    
  }
  //result
  {
     "_index": "library",
     "_type": "book",
     "_id": "1",
     "_version": 1,
     "created": true
  }
  //不指定id 自动生成(post)
  POST /library/book/
  {
    "title":"Redis 实战",
    "name":{
      "firstname":"youBatis",
      "lastname":"Mcgrady"
    },
    "publish_date":"2017-10-27",
    "price":"99.99"
    
  }
  
  //result
  {
     "_index": "library",
     "_type": "book",
     "_id": "txAeQjdmRU2TsnoEeXa_pA",
     "_version": 1,
     "created": true
  }
  ```
  
  * 4.查询指定id文档
  ```
  GET /library/book/1
  GET /library/book/2
  GET /library/book/txAeQjdmRU2TsnoEeXa_pA
  
  //result
  {
     "_index": "library",
     "_type": "book",
     "_id": "txAeQjdmRU2TsnoEeXa_pA",
     "_version": 1,
     "found": true,
     "_source": {
        "title": "Redis 实战",
        "name": {
           "firstname": "youBatis",
           "lastname": "Mcgrady"
        },
        "publish_date": "2017-10-27",
        "price": "99.99"
     }
  }
  ```
  
  * 5.通过_source获取指定字段
  ```
  GET /library/book/1?_source=title
  GET /library/book/1?_source=title,price
  GET /library/book/1?_source
  //result
  {
     "_index": "library",
     "_type": "book",
     "_id": "1",
     "_version": 5,
     "found": true,
     "_source": {
        "price": "99.99",
        "title": "ElasticSearch Guide"
     }
  }
  
  ```
  
  * 6.更新文档 -- put方法 要输入每个字段
  ```
  PUT /library/book/1
  {
   "title":"ElasticSearch Guide",
    "name":{
      "firstname":"hao",
      "lastname":"peng"
    },
    "publish_date":"2017-10-22",
    "price":"99.99"
  }
  //result
  {
     "_index": "library",
     "_type": "book",
     "_id": "1",
     "_version": 5,
     "created": false
  }
  
  ```
 * 7.更新文档 --_update 根据需求更新个别字段 (推荐)
 ```
  POST /library/book/1/_update
  {
    "doc":{
      "price":"13.11"
    }
  }
  //result
  {
     "_index": "library",
     "_type": "book",
     "_id": "1",
     "_version": 6
  }
  
  ```
  
  