<script setup lang="ts">
import MyPicture from '@/assets/MyPicture2.jpg'
import CustomButton from '@/components/CustomButton.vue'
import ContactMeModal from '@/components/ContactMeModal.vue'
import CodeBrainiacCard from '@/components/InfoCards/Experience/CodeBrainiacCard.vue'
import CaciCard from '@/components/InfoCards/Experience/CaciCard.vue'
import CasCard from '@/components/InfoCards/Organizations/CasCard.vue'
import VTCard from '@/components/InfoCards/Education/VTCard.vue'
import FHSCard from '@/components/InfoCards/Education/FHSCard.vue'
import { IconLinkedin } from '@iconify-prerendered/vue-dashicons'
import { ref, watch } from 'vue'
import { useStatusStore } from '@/stores/statusStore'
import StatusPill from '@/components/StatusPill.vue'
import { IconHelpCircleOutline } from '@iconify-prerendered/vue-mdi'

const statusStore = useStatusStore()

// All button functions
function refreshPage() {
  location.reload()
}

function scrollToExperience() {
  const experienceSection = document.getElementById('experience-section')
  experienceSection?.scrollIntoView({ behavior: 'smooth', block: 'end', inline: 'nearest' })
}

function scrollToEducation() {
  const educationSection = document.getElementById('education-section')
  educationSection?.scrollIntoView({ behavior: 'smooth', block: 'end', inline: 'nearest' })
}

function scrollToOrganizations() {
  const organizationsSection = document.getElementById('organizations-section')
  organizationsSection?.scrollIntoView({ behavior: 'smooth', block: 'end', inline: 'nearest' })
}

function openLinkedIn() {
  const linkedinURL = 'https://www.linkedin.com/in/huan-n-tran/'
  window.open(linkedinURL, '_blank')
}

function openResume() {
  const resumeURL =
    'https://drive.google.com/file/d/1DY6GxblvwY8xqsRqieYelZ6TL6hcm5Mm/view?usp=sharing'
  window.open(resumeURL, '_blank')
}

const isContactMeOpen = ref(false)
function openContactMe() {
  isContactMeOpen.value = true
}

watch(
  () => statusStore.isSubmitted === true,
  () => {
    setTimeout(() => {
      statusStore.active = false
      setTimeout(() => {
        statusStore.isSubmitted = false
      }, 500)
    }, 2000)
  }
)
</script>

<template>
  <div class="container">
    <Transition name="status" appear>
      <StatusPill v-show="statusStore.active" />
    </Transition>
    <div class="top">
      <div class="left-buttons">
        <CustomButton primary class="contact-button" @click="openContactMe">
          Contact Me
        </CustomButton>
        <CustomButton primary class="resume-button" @click="openResume">Resume</CustomButton>
        <CustomButton class="linkedin-button" @click="openLinkedIn">
          <IconLinkedin />
        </CustomButton>
        <div class="icon">
          <IconHelpCircleOutline />
          <div class="tooltip-text">
            If submitting in the "Contact Me" section is taking too long to send, it means the
            server is idle. Please refresh and try again in a couple minutes.
          </div>
        </div>
      </div>
      <div class="right-buttons">
        <button class="Home" @click="refreshPage">Home</button>
        <button class="Experience" @click="scrollToExperience">Experience</button>
        <button class="Education" @click="scrollToEducation">Education</button>
        <button class="Organizations" @click="scrollToOrganizations">Organizations</button>
      </div>
    </div>
    <div class="middle">
      <div class="about-section">
        <img class="image" :src="MyPicture" />
        <div class="about">
          <div class="about-top">
            <div class="about-title">Hey, I'm</div>
            <div class="about-name">Huan Tran</div>
          </div>
          <div class="about-me">
            I am a graduate at
            <span style="color: rgb(150, 150, 250)">Virginia Tech</span> who majored in
            <span style="color: rgb(150, 150, 250)">Computer Science</span> and minored in
            <span style="color: rgb(150, 150, 250)">Mathematics</span>. I graduated in May 2024 with
            a <span style="color: rgb(150, 150, 250)">Bachelor's of Science.</span> I am very
            passionate about creating innovative applications through front-end and back-end
            technology.
          </div>
        </div>
      </div>
      <div class="experience-section" id="experience-section">
        <div class="experience">Experience</div>
        <div class="info-cards">
          <CodeBrainiacCard></CodeBrainiacCard>
          <CaciCard></CaciCard>
        </div>
      </div>
      <div class="education-section" id="education-section">
        <div class="education">Education</div>
        <div class="info-cards">
          <VTCard></VTCard>
          <FHSCard></FHSCard>
        </div>
      </div>
      <div class="organizations-section" id="organizations-section">
        <div class="organizations">Organizations</div>
        <div class="info-cards">
          <CasCard></CasCard>
        </div>
      </div>
    </div>
    <div class="bottom">Website developed by Huan Tran</div>
  </div>
  <ContactMeModal v-show="isContactMeOpen" @close-modal="isContactMeOpen = false" />
</template>

<style lang="scss" scoped>
@import '@/style/style.scss';

.container {
  height: 100vh;
  overflow-y: auto;

  .top {
    display: flex;
    justify-content: space-between;
    padding: 0 250px 0 20px;
    height: 65px;
    background-color: rgb(36, 36, 36);
    border-bottom: 4px solid rgb(230, 230, 230);
    position: fixed;
    width: 100%;
    z-index: 1;
    .left-buttons {
      display: flex;
      align-items: center;
      gap: 15px;
      .contact-button,
      .resume-button {
        width: 105px;
      }
      .linkedin-button {
        flex-shrink: 0;
        width: 35px;
        height: 35px;
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: rgb(125, 125, 250);
        border-radius: 20px;
        border-width: 2px;
        transition: all ease-in-out 0.1s;
        svg {
          height: 20px;
          width: 20px;
        }
        &:hover {
          cursor: pointer;
          border-color: rgb(200, 200, 200);
          color: white;
          background-color: rgb(140, 140, 250);
        }
      }
      .icon {
        svg {
          display: flex;
          justify-content: start;
          color: rgb(230, 230, 230);
          height: 25px;
          width: 25px;
          &:hover {
            color: rgb(125, 125, 250);
          }
        }
        .tooltip-text {
          transition: all ease-in-out 0.2s;
          transform: scale(0);
          opacity: 0;
          position: fixed;
          z-index: 1;
          color: black;
          background-color: rgb(230, 230, 230);
          padding: 12px;
          font-size: 13px;
          border-radius: 4px;
          border-width: 1px;
          width: 275px;
          max-height: 125px;
          pointer-events: none;
          overflow-y: hidden;
          margin-top: 10px;
        }
        &:hover .tooltip-text {
          transform: scale(1);
          opacity: 100%;
        }
      }
    }

    .right-buttons {
      display: flex;
      justify-content: center;
      align-items: end;
      gap: 40px;

      button {
        height: 30px;
        width: 160px;
        color: rgb(230, 230, 230);
        background-color: transparent;
        border-style: solid solid none solid;
        border-radius: 10px 10px 0px 0px;
        border-color: rgb(200, 200, 200);
        transition: ease-in-out 0.2s;
        font-weight: bold;

        &:hover {
          cursor: pointer;
          background-color: rgba(143, 143, 143, 0.171);
          border-color: white;
          transform: scale(1.05);
        }
      }
    }
  }

  .middle {
    height: 2100px;
    display: grid;
    justify-content: center;
    grid-template-rows: repeat(4, 1fr);
    padding-top: 65px;
    .about-section {
      display: flex;
      align-items: center;
      gap: 30px;
      padding: 50px 0px;
      width: 1125px;

      .image {
        width: 42%;
        display: flex;
        flex: 1;
        align-items: center;
        justify-content: center;
        border: 5px solid rgb(230, 230, 230);
        border-radius: 25%;
      }

      .about {
        display: flex;
        flex-direction: column;
        gap: 35px;
        flex: 1.5;
        color: white;
        .about-top {
          .about-title {
            font-size: 35px;
          }
          .about-name {
            font-size: 80px;
            color: rgb(125, 125, 250);
          }
        }
      }
    }

    .experience-section {
      display: flex;
      flex-direction: column;
      gap: 15px;
      .experience {
        color: white;
        font-size: 35px;
        user-select: none;
      }
      .info-cards {
        display: flex;
        gap: 25px;
      }
    }

    .education-section {
      display: flex;
      flex-direction: column;
      gap: 15px;
      .education {
        color: white;
        font-size: 35px;
        user-select: none;
      }
      .info-cards {
        display: flex;
        gap: 25px;
      }
    }

    .organizations-section {
      display: flex;
      flex-direction: column;
      gap: 15px;
      .organizations {
        color: white;
        font-size: 35px;
        user-select: none;
      }
      .info-cards {
        display: flex;
        gap: 25px;
      }
    }
  }

  .bottom {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 35px;
    background-color: #463b47;
    color: rgb(230, 230, 230);
    font-size: 14px;
  }
}

.status-leave-active {
  transition: opacity 0.5s;
}
.status-leave-to {
  opacity: 0;
}

@media (max-width: 960px) {
  .top {
    zoom: 70%;
    .left-buttons {
      width: 100%;
    }
    .right-buttons {
      visibility: hidden;
    }
  }
  .middle {
    zoom: 30%;
    margin-top: 100px;
  }
  .bottom {
    margin-top: 550px;
    zoom: 50%;
  }
  .modal-background {
    zoom: 40%;
  }
}
</style>
