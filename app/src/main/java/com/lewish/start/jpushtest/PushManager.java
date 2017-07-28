package com.lewish.start.jpushtest;

import android.app.Application;
import android.content.Context;
import android.support.annotation.Nullable;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * author: sundong
 * created at 2017/7/27 9:43
 */
public class PushManager {
    private static final boolean isEnableDebug = true;//正式版的时候设置false，关闭调试

    private PushManager() {
    }

    private static class SingletonHolder {
        private static final PushManager INSTANCE = new PushManager();
    }

    public static PushManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Application application) {
        //初始化sdk
        JPushInterface.setDebugMode(isEnableDebug);
        JPushInterface.init(application);
    }

    /**
     * 设置标签
     * @param context
     * @param tag
     * @param callback
     */
    public void setTags(Context context, String tag, @Nullable TagAliasCallback callback) {
        Set<String> set = new HashSet<>();
        set.add(tag);//名字任意，可多添加几个
        //设置Tag前过滤一下
        JPushInterface.setTags(context.getApplicationContext(), JPushInterface.filterValidTags(set), callback);//设置标签
    }

    /**
     * 停止推送服务。
     * 调用了本 API 后，JPush 推送服务完全被停止。具体表现为：
     * 收不到推送消息
     * 极光推送所有的其他 API 调用都无效,不能通过 JPushInterface.init 恢复，需要调用resumePush恢复。
     *
     * @param context
     */
    public static void stopReceivePush(Context context) {
        JPushInterface.stopPush(context.getApplicationContext());
    }

    /**
     * 恢复推送服务。
     * 调用了此 API 后，极光推送完全恢复正常工作。
     *
     * @param context
     */
    public static void resumeReceivePush(Context context) {
        JPushInterface.resumePush(context.getApplicationContext());
    }

    public static void clearAllNotifications(Context context){
        JPushInterface.clearAllNotifications(context.getApplicationContext());
    }
    public static void clearNotificationById(Context context, int notificationId){
        JPushInterface.clearNotificationById(context.getApplicationContext(),notificationId);
    }
    /**
     * 检查 Push Service 是否已经被停止
     *
     * @param context
     * @return
     */
    public static boolean isPushStopped(Context context) {
        return JPushInterface.isPushStopped(context.getApplicationContext());
    }


    public void onResume(Context context) {
        JPushInterface.onResume(context);
    }

    public void onPause(Context context) {
        JPushInterface.onPause(context);
    }
}
