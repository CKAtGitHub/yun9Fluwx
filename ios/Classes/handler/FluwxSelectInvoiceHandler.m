#import "FluwxSelectInvoiceHandler.h"
#import "ThumbnailHelper.h"
#import "NSStringWrapper.h"
#import "CallResults.h"

#import "FluwxKeys.h"
#import "StringToWeChatScene.h"
#import "FluwxMethods.h"

@implementation FluwxSelectInvoiceHandler

- (instancetype)initWithRegistrar:(NSObject <FlutterPluginRegistrar> *)registrar {
    self = [super init];
    return self;
}

- (void)handleSelectInvoice:(FlutterMethodCall *)call result:(FlutterResult)result {

    if (!isWeChatRegistered) {
        result([FlutterError errorWithCode:resultErrorNeedWeChat message:resultMessageNeedWeChat details:nil]);
        return;
    }
    NSNumber * timestamp =  call.arguments[@"timeStamp"];
    NSString *cardSign = call.arguments[@"cardSign"];
    NSString *nonceStr = call.arguments[@"nonceStr"];
    NSString *signType = call.arguments[@"signType"];
    UInt32 timeStamp = [timestamp unsignedIntValue];
    BOOL done = [WXApiRequestHandler chooseInvoice:call.arguments[@"appId"]
                                       cardSign:cardSign
                                        nonceStr:nonceStr
                                        signType:signType
                                        timestamp:timeStamp];
    result(@{fluwxKeyPlatform: fluwxKeyIOS, fluwxKeyResult: @(done)});

}
@end
