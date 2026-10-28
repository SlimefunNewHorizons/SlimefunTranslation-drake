<div align="center">

  <img src="https://raw.githubusercontent.com/SlimefunNewHorizons/SlimefunTranslation-drake/main/banner.svg" alt="SlimefunTranslation banner" width="920" />

# SlimefunTranslation · Drake edition

**A Slimefun4 addon that translates Slimefun items (and addon items) into the player's language.**

<p>
  <a href="https://github.com/SlimefunNewHorizons/SlimefunTranslation-drake"><img src="https://img.shields.io/badge/GitHub-SlimefunTranslation-drake-181717?style=for-the-badge&logo=github" alt="GitHub"/></a>
  <img src="https://img.shields.io/badge/Slimefun4-Drake_Edition-22C55E?style=for-the-badge" alt="Slimefun4"/>
  <img src="https://img.shields.io/badge/Paper-1.21.11-38BDF8?style=for-the-badge&logo=minecraft&logoColor=white" alt="Paper 1.21.11"/>
  <img src="https://img.shields.io/badge/Java-21-F89820?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 21"/>
  <img src="https://img.shields.io/badge/License-GPL--3.0-blue?style=for-the-badge" alt="GPL-3.0"/>
</p>

</div>

> ### 🏰 Join the official DrakesCraft community
> * 🎮 **Server IP**: `mc.drakescraft.cl` *(Java 1.21.11 & Bedrock)*
> * 💬 **Discord**: [discord.gg/drakescraft](https://discord.gg/rv3vtXZTk7)
> * 🌐 **Website & guides**: [web.drakescraft.cl](https://web.drakescraft.cl)

## What is it

A Slimefun4 addon that translates Slimefun items (and addon items) into the player's language.

## Status in DrakesCraft

- Not loaded on Dallas (the server uses DrakesTranslate). Kept for reference.
- Extracted from the legacy `drakes-slimefun-labs` monorepo (October 2026) into its own repository, with the full source tree.
- The CI of the organization (verify + security) runs on every push: see the reusable workflows in
  [`SlimefunNewHorizons/.github`](https://github.com/SlimefunNewHorizons/.github).

## Build

```bash
./gradlew build
```

Java 21 is required. Place the resulting jar in the server's `plugins/` folder next to the Slimefun core
([Slimefun4-Drake](https://github.com/SlimefunNewHorizons/Slimefun4-Drake)).

Dependencies are resolved from the Drake Maven repository, <https://maven.drakescraft.cl> (GitHub Pages of
[`SlimefunNewHorizons/maven-repo`](https://github.com/SlimefunNewHorizons/maven-repo)):

| Line | Core | Java |
|---|---|---|
| 1.21.11 (production) | `slimefun-core 11.0-Drake-1.21.11-SNAPSHOT` | 21 |
| Universal 26.x (Paper 26.2) | `slimefun-core 11.0-Universal-26.x-SNAPSHOT` + `dough-core 1.3.1-Universal-26.x-SNAPSHOT` | 25 |

To use an already built jar on the 26.x line, port it with `scripts/portar_addons.py <input> <output>` from `ai-hub`
(relocates the Dallas fork package to the universal one and raises `api-version` to 1.21).

### Running on 26.x (Paper 26.2, Java 25)

No separate build is needed: the 1.21.1 jar (`./gradlew build`) is ported as-is with
`python3 scripts/portar_addons.py <input-dir> <output-dir> --solo SlimefunTranslation`, then dropped into `plugins/`.
The translator is English-only (no `es` package). Requires Slimefun `11.0-Universal-26.x-SNAPSHOT`, PlaceholderAPI and
ProtocolLib 5.4.0 (it loads on Paper 26.2 with an "untested version" warning; packet hooks stay on ProtocolLib, no
packetevents port). Status: the ported jar passes static checks (no unresolved core classes except an unused GuizhanLib
helper); runtime on 26.x still has to be confirmed on a live server.

## Upstream & license

Original work by ybw0014 and the GuizhanCraft community.
Original project: <https://github.com/GuizhanCraft/SlimefunTranslation>.
This fork is distributed under the same **GPL-3.0** (see [`LICENSE`](LICENSE)); upstream authorship is
preserved in [`docs/UPSTREAM_ATTRIBUTION.md`](docs/UPSTREAM_ATTRIBUTION.md). Maintained by
[JackStar6677-1](https://github.com/JackStar6677-1) under [DrakesCraft Labs](https://github.com/SlimefunNewHorizons).

---

## Original README

# SlimefunTranslation

A [Slimefun4](https://github.com/Slimefun/Slimefun4) addon that translates Slimefun items (also supports addons).

## Download / Documents / Wiki

For download, usage, configuration and more information, please visit our [Wiki](https://docs.ybw0014.dev/slimefun-translation/).
