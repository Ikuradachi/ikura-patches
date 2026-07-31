package app.carbitlink.feature

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.methodCall
import app.morphe.patcher.string
import com.android.tools.smali.dexlib2.AccessFlags

object TwinSpaceVisibilityFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    parameters = emptyList(),
    filters = listOf(
        string("is twinspace show not linked return false"),
        string("is twinspace show japanese return false"),
        string("is twinspace show other language check switch"),
    ),
)

object MapboxVisibilityFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    parameters = emptyList(),
    filters = listOf(
        string("isMapboxOpen, not linked return false"),
        string("isMapboxOpen, factory install: "),
        string("isMapboxOpen, japanese return false"),
        string("isMapboxOpen, other language return true"),
    ),
)

object MapboxDemoValidityFingerprint : Fingerprint(
    definingClass = "Lnet/easyconn/carman/common/httpapi/response/MapValidResponse;",
    name = "getIs_valid",
    returnType = "I",
    accessFlags = listOf(AccessFlags.PUBLIC),
    parameters = emptyList(),
)

object DashboardVipBadgeFingerprint : Fingerprint(
    definingClass = "Lnet/easyconn/carman/mirror/PalaceGridVIPItem;",
    name = "isVIP",
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PROTECTED),
    parameters = emptyList(),
)

object MemberCenterCardFingerprint : Fingerprint(
    returnType = "Lnet/easyconn/carman/common/view/IMirrorCard;",
    filters = listOf(
        methodCall(
            smali = "Lnet/easyconn/carman/mirror/MirrorMemberCenterCard;-><init>(Landroid/content/Context;)V",
        ),
        methodCall(smali = "Lnet/easyconn/carman/utils/Config;->isSdk()Z"),
    ),
)

object WebBrowserVisibilityFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    parameters = listOf("Landroid/content/Context;"),
    filters = listOf(
        string("sp_web_browser"),
    ),
)

object CancelDrivingMaskFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    parameters = listOf("Landroid/content/Context;"),
    filters = listOf(
        string("sp_cancel_mask"),
    ),
)

object ScreenMirroringSupportFingerprint : Fingerprint(
    returnType = "Z",
    filters = listOf(
        string("support_screen_mirroring"),
    ),
)

object AccountsLoginFingerprint : Fingerprint(
    definingClass = "Lnet/easyconn/carman/utils/Accounts;",
    name = "isLogin",
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    parameters = listOf("Landroid/content/Context;"),
)


