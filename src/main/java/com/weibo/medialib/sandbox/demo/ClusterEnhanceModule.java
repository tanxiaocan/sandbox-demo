package com.weibo.medialib.sandbox.demo;

import com.alibaba.jvm.sandbox.api.Information;
import com.alibaba.jvm.sandbox.api.Module;
import com.alibaba.jvm.sandbox.api.ProcessController;
import com.alibaba.jvm.sandbox.api.annotation.Command;
import com.alibaba.jvm.sandbox.api.listener.ext.Advice;
import com.alibaba.jvm.sandbox.api.listener.ext.AdviceListener;
import com.alibaba.jvm.sandbox.api.listener.ext.EventWatchBuilder;
import com.alibaba.jvm.sandbox.api.resource.ModuleEventWatcher;
import org.kohsuke.MetaInfServices;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@MetaInfServices(Module.class)
@Information(id = "cluster-enhance")
public class ClusterEnhanceModule implements Module {
    @Resource
    private ModuleEventWatcher moduleEventWatcher;

    @Command("returnImmediately")
    public void returnImmediately() {
        new EventWatchBuilder(moduleEventWatcher)
                .onClass("com.weibo.media.service.impl.ClusterMediaServiceImpl")
                .onBehavior("getPagedMediaIdsByCursor")
                .onWatch(new AdviceListener() {
                    @Override
                    protected void before(Advice advice) throws Throwable {
                        List<Long> mockIds = new ArrayList<Long>();
                        mockIds.add(111111L);
                        ProcessController.returnImmediately(mockIds);
                    }
                });
    }

}
