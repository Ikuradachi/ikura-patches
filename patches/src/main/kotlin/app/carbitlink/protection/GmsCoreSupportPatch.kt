package app.carbitlink.protection

import app.carbitlink.shared.COMPATIBILITY_CARBITLINK
import app.morphe.patcher.Fingerprint
import app.morphe.patcher.extensions.InstructionExtensions.replaceInstruction
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patcher.string
import com.android.tools.smali.dexlib2.Opcode
import com.android.tools.smali.dexlib2.builder.instruction.BuilderInstruction21c
import com.android.tools.smali.dexlib2.iface.instruction.formats.Instruction21c
import com.android.tools.smali.dexlib2.immutable.reference.ImmutableStringReference

object GoogleGmsServiceFingerprint : Fingerprint(
    filters = listOf(
        string("com.google.android.gms"),
    ),
)

@Suppress("unused")
val gmsCoreSupportPatch = bytecodePatch(
    name = "MicroG / GmsCore support for Google login",
    description = "Redirects Google Play Services authorization calls to MicroG (app.revanced.android.gms) to fix Google login failure.",
    default = true,
) {
    compatibleWith(COMPATIBILITY_CARBITLINK)

    execute {
        GoogleGmsServiceFingerprint.instructionMatches.forEach { match ->
            val index = match.index
            val instruction = match.instruction as? Instruction21c ?: return@forEach
            val register = instruction.registerA
            GoogleGmsServiceFingerprint.method.replaceInstruction(
                index,
                BuilderInstruction21c(
                    Opcode.CONST_STRING,
                    register,
                    ImmutableStringReference("app.revanced.android.gms")
                )
            )
        }
    }
}
