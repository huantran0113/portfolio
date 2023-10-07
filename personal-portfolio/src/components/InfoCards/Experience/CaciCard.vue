<script setup lang="ts">
import { ref } from 'vue'
import CustomButton from '../../CustomButton.vue'
import CACI from '@/assets/CACI.png'
import { IconBack } from '@iconify-prerendered/vue-ep'

const isFlipped = ref(false)

function openLink() {
  const link = 'https://www.caci.com/'
  window.open(link, '_blank')
}
</script>

<template>
  <div class="flip-card">
    <div class="flip-card-inner" :class="{ flipped: isFlipped }">
      <div class="card-front">
        <img class="image" :src="CACI" @click="openLink" />
        <div class="text">
          <div class="title-wrap">
            <div class="title">CACI International</div>
            <div class="description">
              <div class="desc">Software Engineer</div>
              <div class="desc2">Intern</div>
            </div>
          </div>
          <div class="details-button">
            <CustomButton primary @click="isFlipped = !isFlipped">DETAILS</CustomButton>
          </div>
          <div class="date">May 2023 - August 2023</div>
        </div>
      </div>
      <div class="card-back">
        <CustomButton class="back-button" @click="isFlipped = !isFlipped">
          <IconBack />
        </CustomButton>
        <div class="text">
          <div class="location">
            <span style="color: rgb(150, 150, 250)">Location: </span> Sterling, VA
          </div>
          <div class="details">
            <div class="details-title" style="color: rgb(150, 150, 250)">Details:</div>
            <div class="details-info">
              • Worked in a team of two to develop a web application designed for querying and
              filtering extensive datasets and creating/sending PIN data into the database<br />
              • Implemented REST API with CRUD logic using Java servlets and utilized MariaDB to
              manage user data<br /><br />
              <span style="color: rgb(150, 150, 250); font-size: 16px">Skills: </span><br />•
              Java<br />• JavaScript/TypeScript<br />• HTML<br />• CSS
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
      font-size: 16px;
    }
    .details {
      .details-title {
        user-select: none;
        color: white;
        font-size: 16px;
      }
      .details-info {
        user-select: none;
        color: white;
        font-size: 14px;
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
  height: 385px;
  width: 250px;
  background-color: rgb(53, 53, 53);
  border-style: solid;
  border-width: 1px;
  border-radius: 30px;
  border-color: white;
  transition: ease-in-out 0.2s;

  .image {
    position: absolute;
    width: 170px;
    height: auto;
    border-radius: 30px;
    top: 10%;
    left: 15.7%;
    transition: ease-in-out 0.2s;
    &:hover {
      box-shadow: 0 0 8px 4px rgb(0, 0, 0);
      cursor: pointer;
    }
  }
  .text {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    gap: 10px;
    padding-top: 185px;
    .title-wrap {
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
      gap: 5px;
      .title {
        color: rgb(230, 230, 230);
        user-select: none;
        font-size: 25px;
        font-weight: bold;
        transition: ease-in-out 0.3s;
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
        .desc2 {
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
          color: white;
        }
      }
    }
  }
}
</style>
