import { fileURLToPath, URL } from 'node:url'
import dns from 'node:dns'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

dns.setDefaultResultOrder('ipv4first')

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  define: {
    // quiet warning about value not being explicitly defined
    __VUE_PROD_HYDRATION_MISMATCH_DETAILS__: 'false'
  },
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }
})
