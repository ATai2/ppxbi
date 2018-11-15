# -*- coding: utf-8 -*-
import scrapy

from ippool.items import IppoolItem


class KuaiSpider(scrapy.Spider):
    name = 'kuai'
    allowed_domains = ['kuaidaili.com']
    start_urls = ['https://www.kuaidaili.com/free/inha/1/']
    # start_urls = ['http://kuaidaili.com/']

    def parse(self, response):
        filename = response.url.split("/")[-2]
        for sel in response.xpath('//tbody/tr'):
            item=IppoolItem()
            item['ip']=sel.xpath('td[@data-title="IP"]/text()').extract()[0]
            item['port']=sel.xpath('td[@data-title="PORT"]/text()').extract()[0]
            item['hide']=sel.xpath('td[@data-title="匿名度"]/text()').extract()[0]
            item['type']=sel.xpath('td[@data-title="类型"]/text()').extract()[0]
            item['location']=sel.xpath('td[@data-title="位置"]/text()').extract()[0]
            item['respSpeed']=sel.xpath('td[@data-title="响应速度"]/text()').extract()[0]
            item['lastVeryfyTime']=sel.xpath('td[@data-title="最后验证时间"]/text()').extract()[0]
            print(item)
            yield item

        # with open(filename, 'wb') as f:
        #     f.write(response.body)
