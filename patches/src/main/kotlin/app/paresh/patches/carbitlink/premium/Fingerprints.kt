package app.paresh.patches.carbitlink.premium

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.methodCall
import app.morphe.patcher.string
import com.android.tools.smali.dexlib2.AccessFlags

object GoogleMapsVipFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    parameters = emptyList(),
    filters = listOf(
        string("google_map_valid"),
        string("isFactoryInstall google map valid: ")
    )
)

object MapboxVipFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    parameters = emptyList(),
    filters = listOf(
        string("mapbox_valid"),
        string("isFactoryInstall mapbox valid: ")
    )
)

object SpotifyVipFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    parameters = emptyList(),
    filters = listOf(
        string("spotify_valid")
    )
)

object TwinSpaceVipFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    parameters = emptyList(),
    filters = listOf(
        string("twin_space_valid")
    )
)

object VipSettingsVisibilityFingerprint : Fingerprint(
    returnType = "V",
    accessFlags = listOf(AccessFlags.PRIVATE),
    parameters = emptyList(),
    filters = listOf(
        methodCall(
            definingClass = "Lnet/easyconn/carman/utils/Config;",
            name = "isSdk",
            parameters = emptyList(),
            returnType = "Z"
        ),
        methodCall(
            definingClass = "Lnet/easyconn/carman/bridge/GoogleNaviBridge;",
            name = "getImpl",
            parameters = emptyList(),
            returnType = "Lnet/easyconn/carman/bridge/GoogleNaviBridgeInterface;"
        ),
        methodCall(
            definingClass = "Lnet/easyconn/carman/bridge/GoogleNaviBridgeInterface;",
            name = "isGoogleNaviVisible",
            parameters = emptyList(),
            returnType = "Z"
        )
    )
)
