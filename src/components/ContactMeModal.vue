<script setup lang="ts">
import { IconWindowClose } from '@iconify-prerendered/vue-mdi'
import CustomButton from '@/components/CustomButton.vue'
import { ref, watch } from 'vue'
import { useDebounceFn } from '@vueuse/core'
import axios from 'axios'

const emits = defineEmits<{ (e: 'closeModal'): void }>()

function exitModal() {
  emits('closeModal')
}

// To section
const toText = ref('')
const emailValid = ref(false)
const emailFormat = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
const debouncedFn = useDebounceFn(() => {
  if (emailFormat.test(toText.value)) {
    emailValid.value = true
  } else {
    emailValid.value = false
  }
}, 500)
watch(toText, () => {
  debouncedFn()
})

// Subject & Body Section
const subjectText = ref('')
const bodyText = ref('')

async function sendEmail() {
  const information = {
    email: toText.value,
    name: subjectText.value,
    message: bodyText.value
  }

  axios
    .post('http://localhost:8080/data', information)
    .then((response) => {
      console.log(response.data.message)
    })
    .catch((error) => {
      console.error('Error:', error)
    })

  exitModal()
  toText.value = ''
  subjectText.value = ''
  bodyText.value = ''
}

// Disables send button until values are correct
const disabledButton = ref(true)
watch([emailValid, subjectText], () => {
  if (emailValid.value && subjectText.value !== '') {
    disabledButton.value = false
  } else {
    disabledButton.value = true
  }
})
</script>

<template>
  <div class="modal-background">
    <div class="modal">
      <CustomButton class="exit-button" @click="exitModal">
        <IconWindowClose />
      </CustomButton>
      <div class="email-wrap">
        <div class="to-section">
          From:
          <input
            class="to-input"
            v-model="toText"
            spellcheck="false"
            placeholder="Your Email Address"
          />
          <div class="invalid-email" v-show="!emailValid && toText !== ``">
            Invalid email address
          </div>
        </div>
        <input
          class="subject-section"
          v-model="subjectText"
          placeholder="Your Name"
          spellcheck="false"
        />
        <textarea
          class="body-section"
          v-model="bodyText"
          placeholder="Your Message"
          spellcheck="true"
        />
      </div>
      <div class="send-wrap">
        <CustomButton
          class="send-button"
          @click="sendEmail"
          :class="{ disabled: disabledButton }"
          primary
          >Submit</CustomButton
        >
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/style/style.scss';
.modal-background {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 13px;
  background-color: #000000da;
  .modal {
    display: flex;
    flex-direction: column;
    position: relative;
    gap: 16px;
    background-color: rgb(36, 36, 36);
    height: 600px;
    width: 900px;
    padding: 20px;
    color: black;
    border-style: solid;
    border-color: rgb(200, 200, 200);
    border-width: 1px;
    border-radius: 10px;
    box-shadow: 0 4px 10px 2px rgb(0, 0, 0), 0 6px 20px 0 rgba(0, 0, 0, 0.212);
    .exit-button {
      position: absolute;
      top: 2px;
      right: 7px;
      width: 10px;
      height: 10px;
      border-style: none;
      background-color: transparent;
      transition: all ease 0.1s;
      svg {
        width: 15px;
        height: 15px;
        color: white;
        transition: all ease 0.1s;
        &:hover {
          color: #d13a3a;
        }
      }
      &:hover {
        cursor: pointer;
      }
    }
    .email-wrap {
      display: flex;
      flex-direction: column;
      height: 100%;
      gap: 5px;
      .to-section {
        display: flex;
        align-items: center;
        gap: 5px;
        height: 5%;
        color: white;
        font-size: 14px;
        .to-input {
          width: 300px;
          color: white;
          font-size: 14px;
          background: none;
          border-style: none none solid none;
          border-width: 1px;
          padding-top: 2px;
        }
        .invalid-email {
          color: #d13a3a;
          font-size: 14px;
        }
      }
      .subject-section {
        color: white;
        font-size: 14px;
        background: none;
        border-style: none;
        height: 5%;
      }
      .body-section {
        color: white;
        font-size: 16px;
        background: none;
        border-style: solid none solid none;
        height: 90%;
        outline: none;
        padding: 10px 0px;
        resize: none;
      }
    }
    .send-wrap {
      display: flex;
      align-items: center;
      justify-content: end;
      padding-right: 5px;
      .send-button {
        width: 85px;
        border-radius: 14px;
        &.disabled {
          background-color: grey;
          border-style: none;
          pointer-events: none;
        }
      }
    }
  }
}
</style>
