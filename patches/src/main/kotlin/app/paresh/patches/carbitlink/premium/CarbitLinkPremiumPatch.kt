package app.paresh.patches.carbitlink.premium

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.paresh.patches.carbitlink.shared.Constants.COMPATIBILITY_CARBITLINK

@Suppress("unused")
val carbitLinkPremiumPatch = bytecodePatch(
    name = "Unlock premium features",
    description = "Unlocks Mapbox, Google Maps, Spotify, and TwinSpace premium features."
) {
    compatibleWith(COMPATIBILITY_CARBITLINK)

    execute {
        listOf(
            GoogleMapsVipFingerprint,
            MapboxVipFingerprint,
            SpotifyVipFingerprint,
            TwinSpaceVipFingerprint
        ).forEach { fingerprint ->
            fingerprint.method.addInstructions(
                0,
                """
                    const/4 v0, 0x1
                    return v0
                """
            )
        }
    }
}
