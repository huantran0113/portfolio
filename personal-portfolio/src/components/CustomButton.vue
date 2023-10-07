<script setup lang="ts">
const props = defineProps({
  primary: {
    type: Boolean
  },
  secondary: {
    type: Boolean
  },
  tertiary: {
    type: Boolean
  },
  icons: {
    type: Object
  }
})
</script>

<template>
  <button
    class="custom-button"
    :class="{
      'custom-button-primary': props.primary,
      'custom-button-secondary': props.secondary,
      'custom-button-tertiary': props.tertiary
    }"
  >
    <slot></slot>
  </button>
</template>

<style lang="scss" scoped>
@import '@/style/style.scss';

.custom-button {
  width: 7rem;
  height: 30px;
  color: rgb(230, 230, 230);
  border-radius: 20px;
  border-style: solid;
  border-color: transparent;
  border-width: 2px;
  font-size: 14px;
  font-weight: bold;
  transition: background-color ease-in-out 0.1s;
  user-select: none;
  transition: all ease-in-out 0.1s;
  &.custom-button-primary {
    background-color: rgb(125, 125, 250);
    &:hover {
      cursor: pointer;
      color: white;
      background-color: rgb(140, 140, 250);
      border-color: rgb(200, 200, 200);
    }
  }

  &.custom-button-secondary {
    background-color: transparent;
    border-color: var(--text-more-subtle);
    &:hover {
      cursor: pointer;
    }
  }
  &.custom-button-tertiary {
    border-style: none;
    background-color: transparent;
    text-decoration: underline;
    color: var(--accent);

    &:hover {
      cursor: pointer;
      color: var(--accent-light);
    }
  }
}

svg {
  width: 100%;
  height: 100%;
  transition: all ease 0.2s;
  &:hover {
    cursor: pointer;
  }
}
</style>
