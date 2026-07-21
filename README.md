# Ikura Patches

Custom Android app patches built with Morphe.

## Patches

<!-- Do not modify this section by hand. The release workflow generates it from patches-list.json. -->
<!-- PATCHES_START EXPANDED -->
> **[v1.0.1-dev.1](https://github.com/Ikuradachi/ikura-patches/releases/tag/v1.0.1-dev.1)**&nbsp;&nbsp;•&nbsp;&nbsp;`dev`&nbsp;&nbsp;•&nbsp;&nbsp;3 patches total
<details open>
<summary>📦 CarbitLink-EasyConnection&nbsp;&nbsp;•&nbsp;&nbsp;3 patches</summary>
<br>

**🎯 Supported versions:**

| 6.4.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Enable web browser](#enable-web-browser) | Enables the built-in web browser regardless of remote customer configuration. |  |
| [Remove brand restriction](#remove-brand-restriction) | Allows connections to head units with any brand flavor or channel. |  |
| [Unlock premium features](#unlock-premium-features) | Unlocks Mapbox, Google Maps, Spotify, and TwinSpace premium features. |  |

</details>

<!-- PATCHES_END -->

## Usage

[Add this patch source to Morphe](https://morphe.software/add-source?github=Ikuradachi/ikura-patches), or add this repository manually:

```text
https://github.com/Ikuradachi/ikura-patches
```

## Building

Follow the [Morphe development setup](https://github.com/MorpheApp/morphe-documentation/blob/main/docs/morphe-development/README.md), then run:

```bash
./gradlew buildAndroid
```

Output: `patches/build/libs/patches-<version>.mpp`

## License

Licensed under [GNU GPL v3.0](LICENSE).
