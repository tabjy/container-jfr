package com.redhat.rhjmc.containerjfr.net.internal.reports.transformers;

import com.redhat.rhjmc.containerjfr.core.sys.Environment;
import com.redhat.rhjmc.containerjfr.net.internal.reports.ReportTransformer;
import org.jsoup.select.Elements;

public class GrafanaLinkTransformer implements ReportTransformer {

    private static final String GRAFANA_DASHBOARD_ENV = "GRAFANA_DASHBOARD_URL";

    private final Environment env;

    public GrafanaLinkTransformer(Environment env) {
        this.env = env;
    }

    @Override
    public String selector() {
        return "#allignored";
    }

    @Override
    public void accept(Elements elements) {
        if (env.getEnv(GRAFANA_DASHBOARD_ENV, "").isEmpty()) {
            return;
        }

        elements.after("<div id=\"grafanalink\"><p class=\"grafanalink\"><a href=\""
                + env.getEnv(GRAFANA_DASHBOARD_ENV)
                + "\">View in Grafana</a></p></div>");
    }
}
