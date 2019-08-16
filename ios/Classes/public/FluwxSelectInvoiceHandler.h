#import <Foundation/Foundation.h>
#import <Flutter/Flutter.h>
#import "FluwxPlugin.h"
#import "WXApiRequestHandler.h"
#import "WXApi.h"
@class StringUtil;


@interface FluwxSelectInvoiceHandler : NSObject
-(instancetype) initWithRegistrar:(NSObject<FlutterPluginRegistrar> *)registrar;
- (void)handleSelectInvoice:(FlutterMethodCall *)call result:(FlutterResult)result;
@end
