#! /usr/bin/env python
# -*- coding: utf-8 -*-

import random
import time


class WebLogGeneration(object):
    def __init__(self):
        self.user_agent_dist = {
            0.0: "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/22.0.1207.1 Safari/537.1",
            0.1: "Mozilla/5.0 (X11; CrOS i686 2268.111.0) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.57 Safari/536.11",
            0.2: "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.6 (KHTML, like Gecko) Chrome/20.0.1092.0 Safari/536.6",
            0.3: "Mozilla/5.0 (Windows NT 6.2) AppleWebKit/536.6 (KHTML, like Gecko) Chrome/20.0.1090.0 Safari/536.6",
            0.4: "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.1 (KHTML, like Gecko) Chrome/19.77.34.5 Safari/537.1",
            0.5: "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/536.5 (KHTML, like Gecko) Chrome/19.0.1084.9 Safari/536.5",
            0.6: "Mozilla/5.0 (Windows NT 6.0) AppleWebKit/536.5 (KHTML, like Gecko) Chrome/19.0.1084.36 Safari/536.5",
            0.7: "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1063.0 Safari/536.3",
            0.8: "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1063.0 Safari/536.3",
            0.9: "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SE 2.X MetaSr 1.0; SE 2.X MetaSr 1.0; .NET CLR 2.0.50727; SE 2.X MetaSr 1.0)",
            1: "Mozilla/5.0 (Windows NT 6.2) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1062.0 Safari/536.3",
            1.1: "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1062.0 Safari/536.3",
            1.2: "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)",
            1.3: "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.1 Safari/536.3",
            1.4: "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.1 Safari/536.3",
            1.5: "Mozilla/5.0 (Windows NT 6.2) AppleWebKit/536.3 (KHTML, like Gecko) Chrome/19.0.1061.0 Safari/536.3",
            1.6: "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.24 (KHTML, like Gecko) Chrome/19.0.1055.1 Safari/535.24",
            1.7: "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/535.24 (KHTML, like Gecko) Chrome/19.0.1055.1 Safari/535.24"
        }
        self.ip_slice_list = [10, 29, 30, 46, 55, 63, 72, 87, 98, 132, 156, 124, 187, 168, 190, 301, 202, 214, 215, 222]
        self.url_path_list = ["login.php", "view.php", "list.php", "upload.php", "admin/login.php", "edit.php",
                              "index.html"]
        self.http_refer = [
            "http://www.baidu.com/s?wd={query}",
            "http://www.google.com/search?q={query}",
            "http://www.sogou.com/web?wd={query}",
            "http://www.yahoo.com/s?p={query}",
            "http://cn.bing.com/s?wd={query}",
            "http://www.sohu.com/s?wd={query}"
        ]
        self.search_keyword = ["spark", "hadoop", "hive", "spark mlib", "spark sql"]

    def sample_ip(self):
        slice = random.sample(self.ip_slice_list, 4)
        return ".".join([str(item) for item in slice])

    def sample_url(self):
        return random.sample(self.url_path_list, 1)[0]

    def sample_user_agent(self):
        dist_uppon = random.uniform(0, 1)
        return self.user_agent_dist[float('%0.1f' % dist_uppon)]

    def sample_refer(self):
        if random.uniform(0, 1) > 0.2:
            return "-"
        refer_str = random.sample(self.http_refer, 1)
        query_str = random.sample(self.search_keyword, 1)
        return refer_str[0].format(query=query_str[0])

    def sample_one_log(self, count=3):
        time_str = time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
        while count > 1:
            query_log = "{ip} - - [{local_time}] \"GET /{url} HTTP/1.1 \" 200 0 \" {refer} \" \"{user_agent} \" -\"".format(
                ip=self.sample_ip(),
                local_time=time_str, url=self.sample_url(), refer=self.sample_refer(),
                user_agent=self.sample_user_agent())
            print(query_log)
            count = count - 1


if __name__ == '__main__':
    web_log_gene = WebLogGeneration()
    web_log_gene.sample_one_log(random.uniform(30000, 50000))
