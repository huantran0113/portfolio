<script setup lang="ts">
import { IconLoading, IconCheck } from '@iconify-prerendered/vue-mdi'
import { useStatusStore } from '@/stores/statusStore'

const statusStore = useStatusStore()
</script>

<template>
  <div class="pill">
    <div class="loading" v-if="!statusStore.isSubmitted">
      Sending
      <IconLoading class="loading-icon" />
    </div>
    <div class="submitted" v-if="statusStore.isSubmitted">
      Submitted
      <IconCheck class="submitted-icon" />
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/style/style.scss';

.pill {
  z-index: 2;
  position: fixed;
  top: 75px;
  left: 73px;
  transform: translate(-50%, 0);
  width: 110px;
  height: 32px;
  padding: 10px;
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 7px;
  user-select: none;
  border-radius: 20px;
  background-color: white;
  font-size: 13px;
  font-weight: bold;
  border-width: 1px;
  border-style: solid;
  border-color: var(--accent);
  box-shadow: 0 0 10px 0px black;
  .loading {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 13px;
    .loading-icon {
      width: 15px;
      height: 15px;
    }
  }
  .submitted {
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 3px;
    .submitted-icon {
      width: 15px;
      height: 15px;
    }
  }
  .loading-icon {
    animation: spinner 1s linear infinite;
    @keyframes spinner {
      to {
        transform: rotate(360deg);
      }
    }
  }
}
</style>
