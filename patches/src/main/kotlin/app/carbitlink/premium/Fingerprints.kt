package app.carbitlink.premium

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.methodCall
import app.morphe.patcher.string
import com.android.tools.smali.dexlib2.AccessFlags

object GoogleMapsEntitlementFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    parameters = emptyList(),
    filters = listOf(
        string("google_map_valid"),
        methodCall(smali = "Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z"),
    ),
)

object MapboxEntitlementFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    parameters = emptyList(),
    filters = listOf(
        string("mapbox_valid"),
        methodCall(smali = "Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z"),
    ),
)

object SpotifyEntitlementFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    parameters = emptyList(),
    filters = listOf(
        string("spotify_valid"),
        methodCall(smali = "Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z"),
    ),
)

object TwinSpaceEntitlementFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.STATIC),
    parameters = emptyList(),
    filters = listOf(
        string("twin_space_valid"),
        methodCall(smali = "Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z"),
    ),
)
