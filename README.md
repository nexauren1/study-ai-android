# DreamForge AI — Native Android prototype

A native Android app prototype for an AI image generator, built with Kotlin and Jetpack Compose.

## Current app UI
- Prompt entry field
- Visual style selection: Cinematic, Anime, Realistic, 3D, Illustration and Logo
- Aspect ratio selection: 1:1, 3:4, 9:16 and 16:9
- Create, Gallery and Settings navigation
- Dark, mobile-first interface

## Important: image generation is not connected yet
The current **Generate image** action is a placeholder. No image model or API has been connected, so the app does not generate real images yet. The next milestone is to choose an image-generation provider and connect it through a secure backend. Do not embed private API keys in the Android app.

## Build an APK
The GitHub Actions workflow in `.github/workflows/android.yml` attempts to build a debug APK on pushes and pull requests.

Once the workflow succeeds:
1. Open the repository's **Actions** tab.
2. Open the latest **Android build** run.
3. Download the generated APK artifact (we can add artifact upload to the workflow next if needed).

You can also open this project in Android Studio and run the `:app` configuration on an Android device or emulator.

## Build configuration
- Kotlin
- Jetpack Compose + Material 3
- Minimum Android version: Android 7.0 (API 24)
- Java 17
- No API key required for the current UI prototype

## Roadmap
- [ ] Confirm Android build succeeds and distribute a test APK
- [ ] Select an image-generation model/provider that fits the budget
- [ ] Add a secure backend so API keys stay private
- [ ] Generate, preview, save and share images
- [ ] Persist generation history locally
- [ ] Add usage limits and a sustainable monetization plan
- [ ] Choose and check a distinctive public brand name
