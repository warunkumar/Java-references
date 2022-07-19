<template>
<div id="app">
  <!--<img alt="Vue logo" src="./assets/logo.png"> -->
  <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
  <PostList var1="thanks for click" data="Warun"/>
   <!-- <MyHome data="warun" msg="Is here"/>-->
  
</div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
//import MyHome from './components/MyHome.vue'
import PostList from './components/PostList.vue'
export default {
  
  name: 'App',
  components: {
    //HelloWorld,
    //MyHome
    PostList
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
