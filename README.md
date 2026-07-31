# Ikura Patches

Custom Android app patches built with Morphe.

## Patches

<!-- Do not modify this section by hand. The release workflow generates it from patches-list.json. -->
<!-- PATCHES_START EXPANDED -->
> **[v1.1.0-dev.1](https://github.com/Ikuradachi/ikura-patches/releases/tag/v1.1.0-dev.1)**&nbsp;&nbsp;•&nbsp;&nbsp;`dev`&nbsp;&nbsp;•&nbsp;&nbsp;6 patches total
<details open>
<summary>📦 CarbitLink&nbsp;&nbsp;•&nbsp;&nbsp;6 patches</summary>
<br>

**🎯 Supported versions:**

| 6.4.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Bypass anti-debug](#bypass-anti-debug) | Disables debugger detection and process tracer exit checks. |  |
| [Bypass local account login requirement](#bypass-local-account-login-requirement) | Forces Accounts.isLogin() to return true, enabling account-gated cards and feature tiles without signing in. |  |
| [MicroG / GmsCore support for Google login](#microg-gmscore-support-for-google-login) | Redirects Google Play Services authorization calls to MicroG (app.revanced.android.gms) to fix Google login failure. |  |
| [Premium bypass](#premium-bypass) | Unlocks Google Maps, Mapbox, Spotify, and Twin Space features. |  |
| [Unlock Web Browser & Screen Mirroring](#unlock-web-browser-screen-mirroring) | Enables Web Browser tile, bypasses driving video motion masks, and forces screen mirroring support. |  |
| [Unlock feature gates](#unlock-feature-gates) | Enables Twin Space, Mapbox visibility, Mapbox demo validity, dashboard VIP tile badges, and Member Center card. |  |

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
