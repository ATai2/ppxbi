#! /usr/bin/env python
# -*- coding: utf-8 -*-
import requests, random, re
from ippool.settings import USER_AGENT_LIST


class Utils(object):
    def get_random_header(self):
        headers = {'User-Agent': random.choice(USER_AGENT_LIST),
                   'Accept': "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
                   'Accept-Encoding': 'gzip'}
        return headers

    def test_ip(self, ip, test_url='http://2017.ip138.com/ic.asp', time_out=3):
        proxies = {'http': ip[0] + ':' + ip[1]}
        try_ip = ip[0]
        # print(try_ip)
        try:
            r = requests.get(test_url, headers=self.get_random_header(), proxies=proxies, timeout=time_out)
            if r.status_code == 200:
                r.encoding = 'gbk'
                result = re.search('\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}', r.text)
                result = result.group()
                if result[:9] == try_ip[:9]:
                    print(r.text)
                    print('测试通过')
                    return True
                else:
                    print('%s:%s 携带代理失败,使用了本地IP' % (ip[0], ip[1]))
                    return False
            else:
                print('%s:%s 请求码不是200' % (ip[0], ip[1]))
                return False
        except:
            print('%s:%s 请求过程错误' % (ip[0], ip[1]))
            return False


