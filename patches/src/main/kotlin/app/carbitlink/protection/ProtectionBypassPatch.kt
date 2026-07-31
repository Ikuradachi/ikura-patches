package app.carbitlink.protection

import app.carbitlink.shared.COMPATIBILITY_CARBITLINK
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch

@Suppress("unused")
val protectionBypassPatch = bytecodePatch(
    name = "Bypass anti-debug",
    description = "Disables debugger detection and process tracer exit checks.",
    default = true,
) {
    compatibleWith(COMPATIBILITY_CARBITLINK)

    execute {
        val returnFalseSmali = """
            const/4 v0, 0x0
            return v0
        """.trimIndent()

        AntiDebugFingerprint.method.addInstructions(0, returnFalseSmali)
    }
}
