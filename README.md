# Aura Client 2

<img src="https://img.shields.io/static/v1?label=minecraft&message=1.8.9&color=brightgreen&style=for-the-badge"/>&nbsp;
<img src="https://img.shields.io/static/v1?label=license&message=GPLv3&color=blue&style=for-the-badge"/>&nbsp;
<img src="https://img.shields.io/static/v1?label=Contributions&message=Welcome&color=brightgreen&style=for-the-badge"/>&nbsp;

Aura Client 2 is a rebranded and continued version of the open‑source Sol Client for Minecraft 1.8.9, distributed under GPLv3. The goal is a simple, open, PvP‑friendly client with quality‑of‑life modules.

Repo: https://github.com/sirjxna/Aura-Client-2

## Download
Go to [releases](https://github.com/sirjxna/Aura-Client-2/releases) and grab the latest version for your OS. If you see a security warning, it’s due to missing code‑signing; the code is open source.

## License
Aura Client 2 is GPLv3. This is a rebrand/fork of Sol Client and retains GPL and required attribution.

- Upstream project: https://github.com/qewer33/Sol-Client
- Changes: name, branding, configuration and further adjustments.

## Why?
Many clients are closed source. Aura Client 2 is open so anyone can inspect behavior, report issues and contribute.

## Features
- Clean HUD inspired by modern PvP clients
- Replay Mod support (requires your own FFmpeg installation)
- Freelook (auto‑disabled on Hypixel)
- Toggle sprint
- Smooth zoom
- Motion blur
- 1.7 animations
- Item physics
- Hypixel additions
- OptiFine (downloaded from the official site)
- Crosshair mod with customization
- Quick Play mod (fast game menu)
- Customizable launcher servers
- Better item tooltips
- Symbol picker
- Chat channel display
- Pop‑up events
- Customizable font and color scheme
- Toggle inventory logo
- Speedometer
- Chunk animator
- Bedwars timers
- Resource pack folders

Suggest features via GitHub Issues.

## Safety
The client is open source. Modules that conflict with some servers can be disabled—use discretion and follow server rules.


## IDE
### Eclipse
1. Import as Gradle project.
2. Choose the game directory in the repo.

### IntelliJ IDEA
1. File > Open
2. Choose the game directory in the repo.

## Build Instructions
Ensure Java JDK 8.

### Launcher
Requires Node.js and npm.

Install deps:
`sh
npm i
`
Start (dev):
`sh
npm run start
`
Build installer:
`sh
npm run make
`
The installer is output to out.

### Game
Move to the game module:
`sh
cd game
`
Setup:
`sh
./gradlew setupDecompWorkspace
`
Build:
`sh
./gradlew build
`
Result: uild/libs/game.jar.
