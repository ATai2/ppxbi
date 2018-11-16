<template>
  <el-table
    :data="tableData"
    style="width: 100%">
    <el-table-column
      prop="ip"
      label="ip"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="address"
      label="地址">
    </el-table-column>
  </el-table>
</template>

<script>
  export default {
    name: 'ippool'
  }
</script>

<style scoped>

</style>
