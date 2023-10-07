<script setup lang="ts">
import { ref } from 'vue'
import CustomButton from '../../CustomButton.vue'
import CAS from '@/assets/CAS.png'
import { IconBack } from '@iconify-prerendered/vue-ep'

const isFlipped = ref(false)

function openLink() {
  const link = 'https://linktr.ee/vt.cas'
  window.open(link, '_blank')
}
</script>

<template>
  <div class="flip-card">
    <div class="flip-card-inner" :class="{ flipped: isFlipped }">
      <div class="card-front">
        <img class="image" :src="CAS" @click="openLink" />
        <div class="text">
          <div class="title-wrap">
            <div class="title">
              <div class="title1">Chinese American</div>
              <div class="title2">Society @ VT</div>
            </div>
            <div class="description">
              <div class="desc">Videographer</div>
            </div>
          </div>
          <div class="details-button">
            <CustomButton primary @click="isFlipped = !isFlipped">DETAILS</CustomButton>
          </div>
          <div class="date">May 2021 - May 2022</div>
        </div>
      </div>
      <div class="card-back">
        <CustomButton class="back-button" @click="isFlipped = !isFlipped">
          <IconBack />
        </CustomButton>
        <div class="text">
          <div class="location">
            <span style="color: rgb(150, 150, 250)">Location: </span> Blacksburg, VA
          </div>
          <div class="details">
            <div class="details-title" style="color: rgb(150, 150, 250)">Details:</div>
            <div class="details-info">
              • Promoted and organized Chinese culture with the use of video editing over social
              media and general body meetings to introduce the organization to all students<br /><br />
              Videos:<br />
              <a
                href="https://www.youtube.com/watch?v=3BcfsFQUjKI&t=40s&ab_channel=VTCAS"
                target="_blank"
              >
                <span style="color: rgb(150, 150, 250); text-decoration: underline"
                  >Semester Recap Video</span
                >
              </a>
              <br />
              <a
                href="https://www.youtube.com/watch?v=wgVRfQNqEck&t=120s&ab_channel=VTCAS"
                target="_blank"
              >
                <span style="color: rgb(150, 150, 250); text-decoration: underline"
                  >Senior Video</span
                >
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import '@/style/style.scss';

.flip-card {
  width: 250px;
  .flip-card-inner {
    transition: transform 0.6s;
    transform-style: preserve-3d;
    &.flipped {
      transform: rotateY(180deg);
    }
  }
}
.card-front,
.card-back {
  position: absolute;
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
}
.card-back {
  display: flex;
  justify-content: start;
  align-items: start;
  flex-direction: column;
  padding-top: 35px;
  padding-left: 10px;
  padding-right: 5px;
  height: 385px;
  width: 250px;
  background-color: rgb(53, 53, 53);
  border-style: solid;
  border-width: 1px;
  border-radius: 30px;
  border-color: white;
  transition: ease-in-out 0.2s;
  transform: rotateY(180deg);
  .back-button {
    width: 10px;
    height: 10px;
    background-color: transparent;
    transition: all ease-in-out 0.1s;
    color: white;
    position: absolute;
    top: 10px;
    left: 10px;
    svg {
      height: 20px;
      width: 20px;
    }
    &:hover {
      cursor: pointer;
      color: rgb(125, 125, 250);
    }
  }
  .text {
    display: flex;
    flex-direction: column;
    gap: 20px;
    .location {
      user-select: none;
      color: white;
      font-size: 18px;
    }
    .details {
      .details-title {
        user-select: none;
        color: white;
        font-size: 20px;
      }
      .details-info {
        user-select: none;
        color: white;
        font-size: 16px;
      }
    }
  }
  &:hover {
    box-shadow: 0 0 5px 1px white;
  }
}

.card-front {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  gap: 10px;
  height: 385px;
  width: 250px;
  background-color: rgb(53, 53, 53);
  border-style: solid;
  border-width: 1px;
  border-radius: 30px;
  border-color: white;
  transition: ease-in-out 0.2s;
  .image {
    width: 170px;
    height: auto;
    border-radius: 50px;
    transition: ease-in-out 0.2s;
    &:hover {
      box-shadow: 0 0 8px 2px rgb(0, 0, 0);
      cursor: pointer;
    }
  }
  .text {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    gap: 10px;
    .title-wrap {
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      gap: 5px;
      .title {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        .title1 {
          color: rgb(230, 230, 230);
          user-select: none;
          font-size: 21px;
          font-weight: bold;
          transition: ease-in-out 0.3s;
        }
        .title2 {
          color: rgb(230, 230, 230);
          user-select: none;
          font-size: 21px;
          font-weight: bold;
          transition: ease-in-out 0.3s;
        }
      }
      .description {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        .desc {
          color: rgb(175, 175, 175);
          user-select: none;
          font-size: 15px;
        }
      }
    }
    .details-button {
      padding-top: 10px;
      padding-bottom: 10px;
    }
    .date {
      color: rgb(175, 175, 175);
      user-select: none;
      font-size: 15px;
    }
  }
  &:hover {
    box-shadow: 0 0 5px 1px white;
    transform: scale(1.04);
    .text {
      .title-wrap {
        .title {
          .title1,
          .title2 {
            color: white;
          }
        }
      }
    }
  }
}
</style>
