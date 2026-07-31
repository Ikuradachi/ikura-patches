package app.carbitlink.premium

import app.carbitlink.shared.COMPATIBILITY_CARBITLINK
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch

@Suppress("unused")
val premiumBypassPatch = bytecodePatch(
    name = "Premium bypass",
    description = "Unlocks Google Maps, Mapbox, Spotify, and Twin Space features.",
    default = true,
) {
    compatibleWith(COMPATIBILITY_CARBITLINK)

    execute {
        val returnTrueSmali = """
            const/4 v0, 0x1
            return v0
        """.trimIndent()

        GoogleMapsEntitlementFingerprint.method.addInstructions(0, returnTrueSmali)
        MapboxEntitlementFingerprint.method.addInstructions(0, returnTrueSmali)
        SpotifyEntitlementFingerprint.method.addInstructions(0, returnTrueSmali)
        TwinSpaceEntitlementFingerprint.method.addInstructions(0, returnTrueSmali)
    }
}
