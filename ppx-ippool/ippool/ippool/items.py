# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class IppoolItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    ip = scrapy.Field()
    port = scrapy.Field()
    hide = scrapy.Field()
    type = scrapy.Field()
    location = scrapy.Field()
    respSpeed = scrapy.Field()
    lastVeryfyTime = scrapy.Field()

