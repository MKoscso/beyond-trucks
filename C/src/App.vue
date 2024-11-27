<template>
  <div id="app">
    <Header />
    <div class="main-container">
      <Menu />
      <div class="content">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script>
import Header from './components/Header.vue';
import Menu from './components/Menu.vue';

export default {
  components: {
    Header,
    Menu,
  },
};
</script>

<style scoped>
.main-container {
  display: flex;
}
.content {
  flex: 1;
  padding: 20px;
  background-color: #f9f9f9;
}
</style>
