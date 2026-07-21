package app.paresh.patches.carbitlink.premium

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.extensions.InstructionExtensions.getInstruction
import app.morphe.patcher.patch.bytecodePatch
import app.paresh.patches.carbitlink.shared.Constants.COMPATIBILITY_CARBITLINK
import com.android.tools.smali.dexlib2.iface.instruction.OneRegisterInstruction

@Suppress("unused")
val carbitLinkPremiumPatch = bytecodePatch(
    name = "Unlock premium features",
    description = "Unlocks Mapbox, Google Maps, Spotify, and TwinSpace premium features and displays the VIP settings item."
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

        VipSettingsVisibilityFingerprint.apply {
            val mutableMethod = method
            val sdkResultIndex = instructionMatches[0].index + 1
            val googleNaviResultIndex = instructionMatches[2].index + 1
            val sdkResultRegister =
                mutableMethod.getInstruction<OneRegisterInstruction>(sdkResultIndex).registerA
            val googleNaviResultRegister =
                mutableMethod.getInstruction<OneRegisterInstruction>(googleNaviResultIndex).registerA

            // Process later instruction first so earlier insertion cannot shift its index.
            mutableMethod.addInstructions(
                googleNaviResultIndex + 1,
                "const/4 v$googleNaviResultRegister, 0x1"
            )
            mutableMethod.addInstructions(
                sdkResultIndex + 1,
                "const/4 v$sdkResultRegister, 0x0"
            )
        }
    }
}
