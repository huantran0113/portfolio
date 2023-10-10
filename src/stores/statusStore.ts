import { defineStore } from 'pinia'

export const useStatusStore = defineStore("statusStore", {
    state: () => ({
        isSubmitted: false,
        active: false,
    }),
    actions: {},
});
