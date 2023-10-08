<script setup lang="ts">
import HomeView from './views/HomeView.vue'
</script>

<template class="page">
  <link
    rel="stylesheet"
    href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
  />
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet" />
  <HomeView />
</template>

<style lang="scss">
@import '@/style/style.scss';

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;

  input {
    &:focus {
      outline: none;
    }
  }

  font-family: 'Open Sans', Roboto;
}

body,
#app {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  background-color: rgb(27, 27, 27);
}
</style>
