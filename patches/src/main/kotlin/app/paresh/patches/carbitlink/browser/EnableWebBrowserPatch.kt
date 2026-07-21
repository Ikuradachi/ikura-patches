package app.paresh.patches.carbitlink.browser

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.paresh.patches.carbitlink.shared.Constants.COMPATIBILITY_CARBITLINK

@Suppress("unused")
val enableWebBrowserPatch = bytecodePatch(
    name = "Enable web browser",
    description = "Enables the built-in web browser regardless of remote customer configuration."
) {
    compatibleWith(COMPATIBILITY_CARBITLINK)

    execute {
        BrowserAvailabilityFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """
        )
    }
}
