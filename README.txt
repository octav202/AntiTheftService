	Frameworks/base/core/java/android/antitheft/
		- created AntiTheftManager
		- created AntiTheftClient

	Frameworks/base/Android.mk
		- added core/java/android/antitheft/IAntiTheftService.aidl \


	Frameworks/base/services/java/com/android/server/SystemServer.java
		- add AntiTheftService to ServiceManager.
	
		        // Add AntiTheftService to ServiceManager.
        try {
            Slog.i(TAG, "Test Service");
            ServiceManager.addService(ANTI_THEFT_SERVICE_CLASS, new AntiTheftService(context));
        } catch (Throwable e) {
            Slog.e(TAG, "Failure starting AntiTheftService", e);
        }
