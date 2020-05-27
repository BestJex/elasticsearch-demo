### elasticsearch-demo
springBoot 整合 elasticsearch 的 demo,继承 ElasticsearchRepository 即可，与 JpaRepository 用法相似，里面封装好了基本的CRUD操作方法。以及 findByContentLike() 也跟 JpaRepository 的用法相似。

测试代码在test文件夹内

#### 环境

java 1.8

springBoot 2.2.5.RELEASE

elasticsearch 7.7.0


#### 自定义分词器myanalyzer

http://127.0.0.1:9200/search_my_user/
```
{
	"settings": {
    	"analysis": {
    		"analyzer": {
        		"myanalyzer": {
        			"tokenizer": "mytokenizer"
        		}
    		},
    		"tokenizer": {
        		"mytokenizer": {
        		"type": "ngram",
        		"min_gram": 1,
        		"max_gram": 2,
        		"token_chars": [
            		"letter",
            		"digit",
            		"whitespace",
            		"punctuation",
            		"symbol"
        		]
        		}
    		}
    	}
	}
}
```


#### elasticsearch
https://www.newbe.pro/Mirrors/Mirrors-Elasticsearch/   Elasticsearch 国内加速下载

插件地址：
https://github.com/elastic/elasticsearch/tree/5.5.3

启动：../bin/elasticsearch.bat

#### elasticsearch-head

插件地址：
https://github.com/mobz/elasticsearch-head

启动：cd ../  grunt server &

访问：http://ip:9100/

#### elasticsearch-bigdesk

插件地址：
https://github.com/lukas-vlcek/bigdesk

安装命令：
./bin/elasticsearch-plugin install https://codeload.github.com/lukas-vlcek/bigdesk/zip/v2.5.0

启动：python -m http.server 9999

访问：http://ip:9999

#### elasticsearch-sql

插件地址：
https://github.com/NLPchina/elasticsearch-sql/tree/5.5.3.0

安装命令：
./bin/elasticsearch-plugin install https://github.com/NLPchina/elasticsearch-sql/releases/download/5.3.3.0/elasticsearch-sql-5.5.3.0.zip
#### elasticsearch-sql (可视化页面)
插件地址：
https://github.com/NLPchina/elasticsearch-sql/releases/download/5.4.1.0/es-sql-site-standalone.zip

下载完成后解压缩
cd site-server
npm install express --save
node node-server.js 

可视化页面访问地址
http://ip:8080/

#### Logstash 国内加速下载
https://www.newbe.pro/Mirrors/Mirrors-Logstash/       Logstash 国内加速下载

conf目录下新建 logstash.conf
```
input {
    file {
		type => "nginx_access"
        path => "D:\nginx\logs\access.log"
    }
}
output {
    elasticsearch {
        hosts => ["127.0.0.1:9200"]
        index => "access-%{+YYYY.MM.dd}"
    }
    stdout {
        codec => json_lines
    }
}
```

启动：logstash.bat -f  ../config/logstash.conf

启动：logstash.bat -f  ../config/jdbc.conf (mysql同步数据到logstash)

访问：http://localhost:9600/

#### Kibana 国内加速下载
https://www.newbe.pro/Mirrors/Mirrors-Kibana/  Kibana 国内加速下载

打开config路径下文件kibana.yml 。设置elasticsearch.url为启动的elasticsearch（http://localhost:9200/）

进入kibana的bin目录，双击kibana.bat

访问：http://localhost:5601/

guide：https://www.elastic.co/guide/cn/kibana/current/connect-to-elasticsearch.html
