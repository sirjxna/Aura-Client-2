# Aura Client 2

<img src="https://img.shields.io/static/v1?label=minecraft&message=1.8.9&color=brightgreen&style=for-the-badge"/>&nbsp;
<img src="https://img.shields.io/static/v1?label=license&message=GPLv3&color=blue&style=for-the-badge"/>&nbsp;
<img src="https://img.shields.io/static/v1?label=Contributions&message=Welcome&color=brightgreen&style=for-the-badge"/>&nbsp;

Aura Client 2 er en rebrandet og videreført versjon av Sol Client for Minecraft 1.8.9, distribuert under GPLv3. Prosjektet tar sikte på en enkel, åpen og brukervennlig PvP-klient med QoL-moduler.

Repo: https://github.com/sirjxna/Aura-Client-2

## Last ned
Gå til [releases](https://github.com/sirjxna/Aura-Client-2/releases) og last ned siste versjon for ditt OS. Dersom du får en sikkerhetsadvarsel skyldes det manglende signering – kildekoden er åpen.

## Lisens
Aura Client 2 er GPLv3. Dette er en rebrand/fork av Sol Client og beholder GPL og nødvendig attribution.

- Opprinnelig prosjekt: https://github.com/qewer33/Sol-Client
- Endringer: Navn, logo/branding, konfigurasjon og videre tilpasninger.

## Hvorfor?
Mange klienter er lukket kildekode. Aura Client 2 er åpen, slik at alle kan se hva den gjør, rapportere problemer og bidra.

## Funksjoner
- Ren HUD inspirert av moderne PvP-klienter
- Replay Mod-støtte (krever egen FFmpeg-installasjon)
- Freelook (deaktiveres automatisk på Hypixel)
- Toggle sprint
- Smooth zoom
- Motion blur
- 1.7-animasjoner
- Item physics
- Hypixel-tillegg
- OptiFine (lastes ned fra offisiell side)
- Crosshair-mod med tilpasninger
- Quick Play-mod (hurtig meny for spill)
- Tilpassbare launcher-servere
- Bedre item-tooltips
- Symbolplukker
- Chat-kanalvisning
- Popup-hendelser
- Tilpassbar font og fargetema
- Av/på inventory-logo
- Speedometer
- Chunk animator
- Bedwars-timere
- Resource pack-mapper

Foreslå funksjoner via Issues på GitHub-repoet.

## Sikkerhet
Klienten er åpen kildekode. Moduler som er i konflikt med enkelte servere kan deaktiveres – bruk skjønn og følg serverregler.

## Kreditering
- Sol Client (opprinnelig basis og inspirasjon) – GPLv3
- OptiFine – sp614x
- Hyperium – inspirasjon til rendering/launching
- ReplayMod – Johni0702, CrushedPixel (modifisert versjon i klienten)
- EntityCulling – tr7zw (modifisert)
- 1.7 Animations – OrangeMarshall
- QuickPlay servers – robere2
- Chunk Animator – lumien231

## IDE
### Eclipse
1. Importer som Gradle-prosjekt.
2. Velg game-mappen i repoet.

### IntelliJ IDEA
1. File > Open
2. Velg game-mappen i repoet.

## Byggeinstruksjoner
Sørg for Java JDK 8.

### Launcher
Krever Node.js og npm.

Installer avhengigheter:
`sh
npm i
`
Start launcher (dev):
`sh
npm run start
`
Bygg installer:
`sh
npm run make
`
Installer ligger i out.

### Game
Gå til spillmodulen:
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
Resultat: uild/libs/game.jar.
