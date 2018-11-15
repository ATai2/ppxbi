# -*- coding: utf-8 -*-
import scrapy
from scrapy.spiders import Rule, CrawlSpider
from scrapy.linkextractors import LinkExtractor

from ippool.items import IppoolItem


class KuaiSpider(CrawlSpider):
    name = 'kuai'
    allowed_domains = ['kuaidaili.com']
    start_urls = ['https://www.kuaidaili.com/free/inha/2/']
    rules = (Rule(LinkExtractor(allow=('/free/inha/\d+/'),deny=('/tel:4000580638')), callback='parse_test', follow=True),)

    def parse_test(self, response):
        print(response.url)
        for sel in response.xpath('//tbody/tr'):
            item = IppoolItem()
            item['ip'] = sel.xpath('td[@data-title="IP"]/text()').extract()[0]
            item['port'] = sel.xpath('td[@data-title="PORT"]/text()').extract()[0]
            item['hide'] = sel.xpath('td[@data-title="匿名度"]/text()').extract()[0]
            item['type'] = sel.xpath('td[@data-title="类型"]/text()').extract()[0]
            item['location'] = sel.xpath('td[@data-title="位置"]/text()').extract()[0]
            item['respSpeed'] = sel.xpath('td[@data-title="响应速度"]/text()').extract()[0]
            item['lastVeryfyTime'] = sel.xpath('td[@data-title="最后验证时间"]/text()').extract()[0]
            # print(item)
            yield item

    def parse_link(self, response):
        for sel in response.xpath('//tbody/tr'):
            item = IppoolItem()
            item['ip'] = sel.xpath('td[@data-title="IP"]/text()').extract()[0]
            item['port'] = sel.xpath('td[@data-title="PORT"]/text()').extract()[0]
            item['hide'] = sel.xpath('td[@data-title="匿名度"]/text()').extract()[0]
            item['type'] = sel.xpath('td[@data-title="类型"]/text()').extract()[0]
            item['location'] = sel.xpath('td[@data-title="位置"]/text()').extract()[0]
            item['respSpeed'] = sel.xpath('td[@data-title="响应速度"]/text()').extract()[0]
            item['lastVeryfyTime'] = sel.xpath('td[@data-title="最后验证时间"]/text()').extract()[0]
            # print(item)
            yield item
