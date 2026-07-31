package app.carbitlink.shared

import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

val COMPATIBILITY_CARBITLINK = Compatibility(
    name = "CarbitLink",
    packageName = "net.easyconn.carman.wws",
    targets = listOf(
        AppTarget(version = "6.4.0"),
    ),
)
