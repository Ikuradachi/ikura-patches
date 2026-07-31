package app.carbitlink.protection

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.methodCall
import app.morphe.patcher.string
import com.android.tools.smali.dexlib2.AccessFlags

object AntiDebugFingerprint : Fingerprint(
    returnType = "Z",
    accessFlags = listOf(AccessFlags.PRIVATE, AccessFlags.STATIC),
    parameters = emptyList(),
    filters = listOf(
        string("DebugManager"),
        methodCall(smali = "Landroid/os/Debug;->isDebuggerConnected()Z"),
    ),
)
