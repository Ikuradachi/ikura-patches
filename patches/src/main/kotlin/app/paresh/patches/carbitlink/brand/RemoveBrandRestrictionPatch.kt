package app.paresh.patches.carbitlink.brand

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.paresh.patches.carbitlink.shared.Constants.COMPATIBILITY_CARBITLINK

@Suppress("unused")
val removeCarbitLinkBrandRestrictionPatch = bytecodePatch(
    name = "Remove brand restriction",
    description = "Allows connections to head units with any brand flavor or channel."
) {
    compatibleWith(COMPATIBILITY_CARBITLINK)

    execute {
        BrandFlavorCheckFingerprint.method.addInstructions(
            0,
            """
                const/4 v0, 0x1
                return v0
            """
        )
    }
}
