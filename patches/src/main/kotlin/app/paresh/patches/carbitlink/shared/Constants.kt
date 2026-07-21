package app.paresh.patches.carbitlink.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

object Constants {
    val COMPATIBILITY_CARBITLINK = Compatibility(
        name = "CarbitLink-EasyConnection",
        packageName = "net.easyconn.carman.wws",
        apkFileType = ApkFileType.APK,
        appIconColor = 0x168CFF,
        targets = listOf(
            AppTarget(version = "6.4.0")
        )
    )
}
