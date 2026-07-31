package app.carbitlink.premium

import app.carbitlink.feature.AccountsLoginFingerprint
import app.carbitlink.shared.COMPATIBILITY_CARBITLINK
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch

@Suppress("unused")
val accountsLoginPatch = bytecodePatch(
    name = "Bypass local account login requirement",
    description = "Forces Accounts.isLogin() to return true, enabling account-gated cards and feature tiles without signing in.",
    default = true,
) {
    compatibleWith(COMPATIBILITY_CARBITLINK)

    execute {
        val returnTrueSmali = """
            const/4 v0, 0x1
            return v0
        """.trimIndent()

        AccountsLoginFingerprint.method.addInstructions(0, returnTrueSmali)
    }
}
