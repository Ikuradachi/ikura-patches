package app.carbitlink.feature

import app.carbitlink.shared.COMPATIBILITY_CARBITLINK
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch

@Suppress("unused")
val webAndMirrorPatch = bytecodePatch(
    name = "Unlock Web Browser & Screen Mirroring",
    description = "Enables Web Browser tile, bypasses driving video motion masks, and forces screen mirroring support.",
    default = true,
) {
    compatibleWith(COMPATIBILITY_CARBITLINK)

    execute {
        val returnTrueSmali = """
            const/4 v0, 0x1
            return v0
        """.trimIndent()

        WebBrowserVisibilityFingerprint.method.addInstructions(0, returnTrueSmali)
        CancelDrivingMaskFingerprint.method.addInstructions(0, returnTrueSmali)
        ScreenMirroringSupportFingerprint.method.addInstructions(0, returnTrueSmali)
    }
}
