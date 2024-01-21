package avers66.restinmemory.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * SessionIdHolder
 *
 * @Author Tretyakov Alexandr
 */

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionIdHolder extends AbstractIdHolder {
    @Override
    String holderType() {
        return "Session";
    }
}
