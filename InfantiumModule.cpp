//
// Created by Fedor Shubin on 7/1/13.
//


#include "InfantiumModule.h"
#include "NDKHelper.h"

USING_NS_CC;

#define EASY_NDK_METHOD "infantium_easyNDK"


void InfantiumModule::init(char const *apiUser, char const *apiKey, char const *contentAppUuid) {
    CCDictionary *params = CCDictionary::create();
    params->setObject(CCString::create("init"), "method");
    params->setObject(CCString::create(apiUser), "apiUser");
    params->setObject(CCString::create(apiKey), "apiKey");
    params->setObject(CCString::create(contentAppUuid), "contentAppUuid");
    callNative(params);
}

void InfantiumModule::createGameplay(char const *subContentUuid) {
    CCDictionary *params = CCDictionary::create();
    params->setObject(CCString::create("createGameplay"), "method");
    params->setObject(CCString::create(subContentUuid), "subContentUuid");
    callNative(params);
}

void InfantiumModule::startPlaying() {
    CCDictionary *params = CCDictionary::create();
    params->setObject(CCString::create("startPlaying"), "method");
    callNative(params);
}

void InfantiumModule::setSuccesses(int successes) {
    CCDictionary *params = CCDictionary::create();
    params->setObject(CCString::create("setSuccesses"), "method");
    params->setObject(CCInteger::create(successes), "successes");
    callNative(params);
}

void InfantiumModule::setFailures(int failures) {
    CCDictionary *params = CCDictionary::create();
    params->setObject(CCString::create("setFailures"), "method");
    params->setObject(CCInteger::create(failures), "failures");
    callNative(params);
}

void InfantiumModule::sendGameRawData() {
    CCDictionary *params = CCDictionary::create();
    params->setObject(CCString::create("sendGameRawData"), "method");
    callNative(params);
}

void InfantiumModule::closeGameplay() {
    CCDictionary *params = CCDictionary::create();
    params->setObject(CCString::create("closeGameplay"), "method");
    callNative(params);
}

CCObject *InfantiumModule::callNative(CCDictionary *pDictionary) {
    return NDKHelper::sendMessageWithParams(EASY_NDK_METHOD, pDictionary);
}

