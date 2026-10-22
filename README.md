# Study AI — Learn smarter

A mobile-first study app prototype designed to start at **€0**, built as a Progressive Web App (PWA) so it can run on Android without an app-store release.

## Current MVP
- Mobile-first dark interface
- Paste and save study notes in local browser storage
- Create a quick extractive summary (not an AI-generated answer)
- Turn lines from your notes into review flashcards
- Flashcard navigation and a local library
- Basic offline caching via a service worker

## Run it
Open `index.html` in a browser, or publish the repository with GitHub Pages and open the resulting HTTPS URL on your Android phone. For installation, open the site in Chrome and choose **Install app** or **Add to Home screen** if offered.

## Publish with GitHub Pages
1. Open **Settings → Pages** in this repository.
2. Under **Build and deployment**, choose **Deploy from a branch**.
3. Select branch `main` and folder `/(root)`, then save.
4. Wait for deployment and open the site URL shown there.

GitHub's official instructions: https://docs.github.com/en/pages/getting-started-with-github-pages/creating-a-github-pages-site

## Roadmap
- [ ] Distinctive product name and identity
- [ ] AI provider integration through a secure backend (never put API keys in client-side code)
- [ ] Quiz generation and progress tracking
- [ ] Export/import and data backup
- [ ] Accessibility, localization, and automated tests

## Important
This is an early prototype. The summary feature selects sentences from the user's text; it does not call an AI model. Notes and cards are stored locally in the browser and may be lost if site data is cleared. No API key or backend is configured yet.
