package app.paresh.patches.carbitlink.brand

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.string
import com.android.tools.smali.dexlib2.AccessFlags

object BrandFlavorCheckFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PRIVATE, AccessFlags.STATIC),
    parameters = listOf("Ljava/lang/Integer;", "Ljava/lang/String;"),
    filters = listOf(
        string("checkFlavor flavorInt: "),
        string("checkFlavor packageName is null"),
        string("checkFlavor() packageName:%s with flavor:0x%s")
    )
)
