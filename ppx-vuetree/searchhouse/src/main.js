import Vue from 'vue';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import App from './App.vue';
import x2js from 'x2js' //xml数据处理插件

Vue.prototype.$x2js = new x2js() //创建x2js对象，挂到vue原型上
Vue.config.productionTip = false
//
// new Vue({
//   render: h => h(App),
// }).$mount('#app')

Vue.use(ElementUI);

new Vue({
    el: '#app',
    render: h => h(App)
});
