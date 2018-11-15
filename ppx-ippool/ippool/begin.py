#! /usr/bin/env python
# -*- coding: utf-8 -*-
from scrapy import cmdline

spiderName = 'kuai'

# cmdline.execute(("scrapy crawl %s" % spiderName).split())
cmdline.execute(("scrapy crawl %s -o items.json" % spiderName).split())
