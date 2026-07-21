package app.paresh.patches.carbitlink.browser

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.methodCall
import com.android.tools.smali.dexlib2.AccessFlags

object BrowserAvailabilityFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC),
    parameters = emptyList(),
    filters = listOf(
        methodCall(
            definingClass = "Lnet/easyconn/carman/utils/Config;",
            name = "isSdk",
            parameters = emptyList(),
            returnType = "Z"
        ),
        methodCall(
            definingClass = "Lnet/easyconn/carman/utils/OverSeaHelper;",
            name = "isShowWebBrowser",
            parameters = listOf("Landroid/content/Context;"),
            returnType = "Z"
        )
    )
)
