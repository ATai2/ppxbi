<template>
  <div class="act-form">
    <iframe id="oIframe"
      :src="src"
      ref="iframe"
      style="width:100%;height:100%;"
      frameborder="0"
      onload="this.height=this.contentWindow.document.documentElement.scrollHeight"
    ></iframe>
  </div>
</template>

<script>
export default {
  data() {
    return {
      src: "http://localhost:8761/"
    };
  },
  mounted() {
    // 这里就拿到了iframe的对象
    console.log(this.$refs.iframe);
    // 这里就拿到了iframe的window对象
    console.log(this.$refs.iframe.contentWindow);
 
            const oIframe = document.getElementById('bdIframe');
            const deviceWidth = document.documentElement.clientWidth;
            const deviceHeight = document.documentElement.clientHeight;
            oIframe.style.width = (Number(deviceWidth)-220) + 'px'; //数字是页面布局宽度差值
            oIframe.style.height = (Number(deviceHeight)-120) + 'px'; //数字是页面布局高度差
 
  }
};
</script>
<style  scoped>
.act-form {
  width: 100%;
  width: 100%;
  height: 100% !important;
}

iframe {
  width: 100%;
  height: 100%;
  position: absolute; 
  
}
</style>