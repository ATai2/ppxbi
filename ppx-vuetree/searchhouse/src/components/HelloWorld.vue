<template>
  <div class="hello">
    <h1>{{ msg }}</h1>

    <el-tree
            :data="data2"
            show-checkbox
            default-expand-all
            node-key="id"
            ref="tree"
            highlight-current
            :props="defaultProps">
    </el-tree>


    <div class="buttons">
      <el-button @click="getCheckedNodes">通过 node 获取</el-button>
      <el-button @click="getCheckedKeys">通过 key 获取</el-button>
      <el-button @click="setCheckedNodes">通过 node 设置</el-button>
      <el-button @click="setCheckedKeys">通过 key 设置</el-button>
      <el-button @click="resetChecked">清空</el-button>
    </div>
  </div>
</template>

<script>
    export default {
        name: 'HelloWorld',
        props: {
            msg: String,
        },
        mounted(){

            var jsonObj = this.$x2js.xml2js('<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" ' +
                'xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">' +
                '<soap:Body><ns1:getSDLengthByJMLXResponse xmlns:ns1="http://server.Gw">' +
                '<ns1:out>&lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;NODES&gt;&lt;NODE&gt;&lt;NAME&gt;方沟&lt;/NAME&gt;&lt;VALUE&gt;' +
                '337.9432807&lt;/VALUE&gt;&lt;/NODE&gt;&lt;NODE&gt;&lt;NAME&gt;砖混&lt;/NAME&gt;&lt;VALUE&gt;66.8424335&lt;/VALUE&gt;&lt;' +
                '/NODE&gt;&lt;NODE&gt;&lt;NAME&gt;盾构&lt;/NAME&gt;&lt;VALUE&gt;14.8955979&lt;/VALUE&gt;&lt;/NODE&gt;&lt;NODE&gt;&lt;' +
                'NAME&gt;暗挖&lt;/NAME&gt;&lt;VALUE&gt;48.1186321&lt;/VALUE&gt;&lt;/NODE&gt;&lt;NODE&gt;&lt;NAME&gt;顶管&lt;/NAME&gt;&lt;' +
                'VALUE&gt;2.9357091&lt;/VALUE&gt;&lt;/NODE&gt;&lt;NODE&gt;&lt;NAME&gt;总长度&lt;/NAME&gt;&lt;VALUE&gt;1272.8081174&lt;/VALUE&gt;' +
                '&lt;/NODE&gt;&lt;NODE&gt;&lt;NAME&gt;检查井总数&lt;/NAME&gt;&lt;VALUE&gt;94885&lt;/VALUE&gt;&lt;/NODE&gt;&lt;/NODES&gt;' +
                '</ns1:out></ns1:getSDLengthByJMLXResponse></soap:Body></soap:Envelope>')
            var newjsonObj = this.$x2js.xml2js(jsonObj.Envelope.Body.getSDLengthByJMLXResponse.out.__text)
            for(var i = 0;i<newjsonObj.NODES.NODE.length;i++){
                console.log(newjsonObj.NODES.NODE[i].NAME)
                console.log(newjsonObj.NODES.NODE[i].VALUE)
            }
        },
        methods: {
            getCheckedNodes() {
                console.log(this.$refs.tree.getCheckedNodes());
            },
            getCheckedKeys() {
                console.log(this.$refs.tree.getCheckedKeys());
            },
            setCheckedNodes() {
                this.$refs.tree.setCheckedNodes([{
                    id: 5,
                    label: '二级 2-1'
                }, {
                    id: 9,
                    label: '三级 1-1-1'
                }]);
            },
            setCheckedKeys() {
                this.$refs.tree.setCheckedKeys([3]);
            },
            resetChecked() {
                this.$refs.tree.setCheckedKeys([]);
            }
        },

        data() {
            return {
                data2: [{
                    id: 1,
                    label: '一级 1',
                    children: [{
                        id: 4,
                        label: '二级 1-1',
                        children: [{
                            id: 9,
                            label: '三级 1-1-1'
                        }, {
                            id: 10,
                            label: '三级 1-1-2'
                        }]
                    }]
                }, {
                    id: 2,
                    label: '一级 2',
                    children: [{
                        id: 5,
                        label: '二级 2-1'
                    }, {
                        id: 6,
                        label: '二级 2-2'
                    }]
                }, {
                    id: 3,
                    label: '一级 3',
                    children: [{
                        id: 7,
                        label: '二级 3-1'
                    }, {
                        id: 8,
                        label: '二级 3-2'
                    }]
                }],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }
            };
        }
    }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h3 {
    margin: 40px 0 0;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
