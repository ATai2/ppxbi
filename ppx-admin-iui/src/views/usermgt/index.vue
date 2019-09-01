<template>
  <div class="dashboard-container">
    <el-card class="box-card">
      <div v-for="o in list" :key="o" class="text item">
        <!-- {{'列表内容 ' + o }} -->
        <div style="padding: 14px;">
          <span>用户名：{{o.userName}}</span>
          <div class="bottom clearfix">
            <time class="time">{{ currentDate }}</time>
            <el-button type="text" class="button">操作按钮</el-button>
          </div>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import { getUsers } from "@/api/user";
export default {
  data() {
    return {
      currentDate: new Date(),
      list: []
    };
  },
  mounted() {
    this.getUsersdemo();

  },
  methods: {
    getUsersdemo() {
      getUsers().then(response => {
        console.log(response);
        this.list=response.data
      });
    }
  },
  name: "User",
  computed: {
    ...mapGetters(["name", "roles"])
  }
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>

.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}

.box-card {
  width: 180px;
}
</style>
