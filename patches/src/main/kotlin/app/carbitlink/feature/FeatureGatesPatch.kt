package app.carbitlink.feature

import app.carbitlink.shared.COMPATIBILITY_CARBITLINK
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.extensions.InstructionExtensions.getInstruction
import app.morphe.patcher.extensions.InstructionExtensions.replaceInstruction
import app.morphe.patcher.patch.bytecodePatch
import com.android.tools.smali.dexlib2.iface.instruction.OneRegisterInstruction

@Suppress("unused")
val featureGatesPatch = bytecodePatch(
    name = "Unlock feature gates",
    description = "Enables Twin Space, Mapbox visibility, Mapbox demo validity, dashboard VIP tile badges, and Member Center card.",
    default = true,
) {
    compatibleWith(COMPATIBILITY_CARBITLINK)

    execute {
        val returnTrueSmali = """
            const/4 v0, 0x1
            return v0
        """.trimIndent()

        val returnOneIntSmali = """
            const/4 v0, 0x1
            return v0
        """.trimIndent()

        TwinSpaceVisibilityFingerprint.method.addInstructions(0, returnTrueSmali)
        MapboxVisibilityFingerprint.method.addInstructions(0, returnTrueSmali)
        MapboxDemoValidityFingerprint.method.addInstructions(0, returnOneIntSmali)
        DashboardVipBadgeFingerprint.method.addInstructions(0, returnTrueSmali)

        MemberCenterCardFingerprint.method.apply {
            val index = MemberCenterCardFingerprint.instructionMatches.last().index
            val register = getInstruction<OneRegisterInstruction>(index + 1).registerA
            replaceInstruction(index + 1, "const/4 v$register, 0x0")
        }
    }
}
