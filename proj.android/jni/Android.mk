LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := infantium_static

LOCAL_MODULE_FILENAME := libinfantium

LOCAL_SRC_FILES := ../../InfantiumModule.cpp

LOCAL_C_INCLUDES := $(LOCAL_PATH)/../../Classes

LOCAL_WHOLE_STATIC_LIBRARIES += cocos2dx_static
LOCAL_WHOLE_STATIC_LIBRARIES += easyndk_static

LOCAL_EXPORT_C_INCLUDES := $(LOCAL_PATH)/../..
LOCAL_EXPORT_C_INCLUDES += $(LOCAL_PATH)/../../..

include $(BUILD_STATIC_LIBRARY)
