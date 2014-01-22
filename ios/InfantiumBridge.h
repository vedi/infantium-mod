//
// Created by Fedor Shubin on 7/1/13.
//


#import <Foundation/Foundation.h>


@interface InfantiumBridge : NSObject

+ (NSObject *)dispatchNDKCall:(NSDictionary *)parameters;
+ (void)dispatchNDKCallback:(NSString *)string withParameters:(NSDictionary *)parameters;
@end