/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.appium.java_client.ios.options.app;

import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.remote.options.CanSetCapability;
import org.openqa.selenium.Capabilities;

import java.util.Optional;

public interface SupportsAppInstallStrategyOption<T extends BaseOptions<T>> extends
        Capabilities, CanSetCapability<T> {
    String APP_INSTALL_STRATEGY_OPTION = "appInstallStrategy";

    /**
     * Select application installation strategy for real devices. The following
     * strategies are supported:
     * * serial (default) - pushes app files to the device in a sequential order;
     * this is the least performant strategy, although the most reliable;
     * * parallel - pushes app files simultaneously; this is usually the
     * most performant strategy, but sometimes could not be very stable;
     * * ios-deploy - tells the driver to use a third-party tool ios-deploy to
     * install the app; obviously the tool must be installed separately
     * first and must be present in PATH before it could be used.
     * @param strategy App installation strategy.
     * @return self instance for chaining.
     */
    default T setAppInstallStrategy(String strategy) {
        return amend(APP_INSTALL_STRATEGY_OPTION, strategy);
    }

    /**
     * Get the app install strategy.
     *
     * @return App installation strategy.
     */
    default Optional<String> getAppInstallStrategy() {
        return Optional.ofNullable((String) getCapability(APP_INSTALL_STRATEGY_OPTION));
    }
}
