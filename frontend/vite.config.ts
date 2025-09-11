// frontend/vite.config.ts
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  server: {
    port: 3000,
    host: true, // This allows external connections
    strictPort: true, // This will fail if port 3000 is busy
    open: true // This will automatically open browser
  }
})