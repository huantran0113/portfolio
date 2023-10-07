<script setup lang="ts">
import { ref } from 'vue'
import CustomButton from '../../CustomButton.vue'
import VirginiaTech from '@/assets/VirginiaTech.png'
import { IconBack } from '@iconify-prerendered/vue-ep'

const isFlipped = ref(false)

function openLink() {
  const link = 'https://www.vt.edu/'
  window.open(link, '_blank')
}
</script>

<template>
  <div class="flip-card">
    <div class="flip-card-inner" :class="{ flipped: isFlipped }">
      <div class="card-front">
        <img class="image" :src="VirginiaTech" @click="openLink" />
        <div class="text">
          <div class="title-wrap">
            <div class="title">Virginia Tech</div>
            <div class="description">
              <div class="desc">Computer Science</div>
              <div class="desc2">Student</div>
            </div>
          </div>
          <div class="details-button">
            <CustomButton primary @click="isFlipped = !isFlipped">DETAILS</CustomButton>
          </div>
          <div class="date">August 2020 - Present</div>
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
              College of Engineering:<br />
              • Major: Computer Science<br />
              • Minor: Mathematics<br />
              • Overall GPA: 3.44/4.00<br />
              • In-Major GPA: 3.66/4.00<br /><br />
              • Relevant Courses:<br />
              - Softw Design & Data Structures<br />
              - Computer Organization<br />
              - Data Structures & Algorithms<br />
              - Computer Systems<br /><br />
              <span style="display: flex; justify-content: center">Expected May 2024</span>
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
        font-size: 15px;
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
    border-radius: 25px;
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
        color: rgb(230, 230, 230);
        user-select: none;
        font-size: 30px;
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
