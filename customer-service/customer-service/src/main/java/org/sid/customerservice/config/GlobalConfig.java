package org.sid.customerservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "global.params")
@RefreshScope
@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class GlobalConfig {
    int p1;int p2;

}
