package com.wedy.semcphone2;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class NotificationiconPatcher implements IXposedHookLoadPackage {


    	@Override
	public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {

		if (!lpparam.packageName.equals("com.sonymobile.superstamina"))
			return;

		try {
			XposedHelpers.findAndHookMethod(
					"com.sonymobile.superstamina.XperiaPowerService",
					lpparam.classLoader,
					"updateStatusbarIcon",
					XC_MethodReplacement.DO_NOTHING
			);
		} catch (Throwable t) {
			XposedBridge.log(t.getMessage());
		}

	};

}