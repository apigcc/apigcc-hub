<template>
  <div id="app">
    <img src="../assets/logo.png">
    <div>
      <p>
        Site
        If Element is successfully added to this project, you'll see an
        <code v-text="'<el-button>'"></code>
        below
      </p>
      <el-button @click="authenticated = !authenticated">el-button</el-button>
    </div>
    <HelloWorld v-if="authenticated" msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
import HelloWorld from '../components/HelloWorld.vue'

export default {
    name: 'app',
    components: {
        HelloWorld
    },
    data(){
        return {
            authenticated: false
        }
    },
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
