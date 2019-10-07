package com.redhat.rhjmc.containerjfr.net.internal.reports;

import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;

import com.redhat.rhjmc.containerjfr.core.sys.Environment;
import com.redhat.rhjmc.containerjfr.net.internal.reports.transformers.GrafanaLinkTransformer;

@Module
public abstract class ReportTransformerModule {

    @Provides @ElementsIntoSet
    static Set<ReportTransformer> provideReportTransformers(Environment env) {
        return Set.of(new GrafanaLinkTransformer(env));
    }
}
