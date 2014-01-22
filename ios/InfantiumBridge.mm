//
// Created by Fedor Shubin on 7/1/13.
//

#import "InfantiumBridge.h"
#import "IOSNDKHelper.h"

@implementation InfantiumBridge {
}

+ (NSObject *)dispatchNDKCall:(NSDictionary *)parameters {
    NSMutableDictionary *retParameters = [NSMutableDictionary dictionary];
    return retParameters;
}

+ (void)dispatchNDKCallback:(NSString *)key withParameters:(NSDictionary *)parameters {
    [IOSNDKHelper sendMessage:key withParameters:parameters];
}

@end