//
// Created by Fedor Shubin on 7/1/13.
//

#ifndef __HasAppModule_H_
#define __HasAppModule_H_

#include "cocos2d.h"

class InfantiumModule {
public:
    static void init(char const *apiUser, char const *apiKey, char const *contentAppUuid);
    static void createGameplay(char const *subContentUuid);
    static void startPlaying();
    static void setSuccesses(int successes);
    static void setFailures(int failures);
    static void sendGameRawData();
    static void closeGameplay();
private:
    static cocos2d::CCObject *callNative(cocos2d::CCDictionary *pDictionary);
};


#endif //__HasAppModule_H_
